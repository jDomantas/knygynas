package lt.vu.mif.knygynas.usecases;

import lt.vu.mif.knygynas.interceptors.LoggedInvocation;
import lt.vu.mif.knygynas.services.NameGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SessionScoped
@Named
public class GenerateName implements Serializable {
    @Inject
    NameGenerator nameGenerator;

    private Future<String> nnameGenerationTask = null;

    public String generateNewName() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        nnameGenerationTask = nameGenerator.generateNickname();
        return  "/author.xhtml?faces-redirect=true&id=" + requestParameters.get("id");
    }

    public boolean isNameGenerationRunning() {
        return nnameGenerationTask != null && !nnameGenerationTask.isDone();
    }

    public String getNameGenerationStatus() throws ExecutionException, InterruptedException {
        if (nnameGenerationTask == null) {
            return null;
        } else if (isNameGenerationRunning()) {
            return "Name generation in progress";
        }
        return "Suggested name: " + nnameGenerationTask.get();
    }
}
