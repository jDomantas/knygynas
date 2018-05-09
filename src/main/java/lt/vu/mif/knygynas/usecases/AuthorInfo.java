package lt.vu.mif.knygynas.usecases;

import lt.vu.mif.knygynas.entities.Author;
import lt.vu.mif.knygynas.persistence.AuthorsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class AuthorInfo {
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

    @Transactional
    public String updateName() {
        try {
            authorsDAO.update(author);
            return "author?faces-redirect=true&id=" + author.getId();
        } catch (OptimisticLockException e) {
            return "author?faces-redirect=true&id=" + author.getId() + "&error=optimistic-lock-exception";
        }
    }

    public Author getAuthor() {
        return author;
    }
}