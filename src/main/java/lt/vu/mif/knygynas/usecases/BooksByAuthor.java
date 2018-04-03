package lt.vu.mif.knygynas.usecases;

import lt.vu.mif.knygynas.entities.Author;
import lt.vu.mif.knygynas.entities.Book;
import lt.vu.mif.knygynas.persistence.AuthorsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class BooksByAuthor {
    @Inject
    private AuthorsDAO authorsDAO;

    private Author author;

    @PostConstruct
    public void init() {
        this.loadAuthor();
    }

    private void loadAuthor() {
        Map<String, String> params = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
        Integer id = Integer.parseInt(params.get("id"));
        this.author = authorsDAO.load(id);
    }

    public Author getAuthor() {
        return author;
    }
}
