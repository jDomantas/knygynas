package lt.vu.mif.knygynas.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@LoggedInvocation
public class MethodLogger implements Serializable{
    @AroundInvoke
    public Object logMethodInvocation(InvocationContext context) throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("Called: ");
        builder.append(context.getMethod().getName());
        builder.append("(");
        boolean first = true;
        for (int i = 0; i < context.getParameters().length; i++) {
            if (!first) builder.append(", ");
            builder.append(context.getParameters()[i]);
            first = false;
        }
        builder.append(")");
        System.out.println(builder.toString());
        System.out.println("Called: " + context.getMethod().getName());
        return context.proceed();
    }
}
