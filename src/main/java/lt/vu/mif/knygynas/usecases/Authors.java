package lt.vu.mif.knygynas.usecases;

import lt.vu.mif.knygynas.entities.Author;
import lt.vu.mif.knygynas.persistence.AuthorsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Model
public class Authors {
    @Inject
    private AuthorsDAO authorsDAO;

    private List<Author> allAuthors;
    private Author newAuthor = new Author();

    @PostConstruct
    public void init() {
        this.loadAuthors();
    }

    private void loadAuthors() {
        allAuthors = authorsDAO.loadAll();
    }

    public List<Author> getAllAuthors() {
        return allAuthors;
    }

    @Transactional
    public String createNewAuthor() {
        authorsDAO.save(newAuthor);
        return "index?faces-redirect=true";
    }

    public Author getNewAuthor() {
        return newAuthor;
    }

    public void setNewAuthor(Author newAuthor) {
        this.newAuthor = newAuthor;
    }
}