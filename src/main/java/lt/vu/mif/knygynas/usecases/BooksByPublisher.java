package lt.vu.mif.knygynas.usecases;

import lt.vu.mif.knygynas.entities.Publisher;
import lt.vu.mif.knygynas.persistence.PublishersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class BooksByPublisher {
    @Inject
    private PublishersDAO publishersDAO;

    private Publisher publisher;

    @PostConstruct
    public void init() {
        this.loadPublisher();
    }

    private void loadPublisher() {
        Map<String, String> params = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
        Integer id = Integer.parseInt(params.get("id"));
        this.publisher = publishersDAO.load(id);
    }

    public Publisher getPublisher() {
        return publisher;
    }
}
