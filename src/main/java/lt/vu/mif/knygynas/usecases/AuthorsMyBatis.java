package lt.vu.mif.knygynas.usecases;

import lt.vu.mif.knygynas.mybatis.dao.AuthorMapper;
import lt.vu.mif.knygynas.mybatis.model.Author;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class AuthorsMyBatis {
    @Inject
    private AuthorMapper authorsDAO;

    private List<Author> allAuthors;
    private Author newAuthor = new Author();

    @PostConstruct
    public void init() {
        this.loadAuthors();
    }

    private void loadAuthors() {
        allAuthors = authorsDAO.selectAll();
    }

    public List<Author> getAllAuthors() {
        return allAuthors;
    }

    @Transactional
    public String createNewAuthor() {
        authorsDAO.insert(newAuthor);
        return "/mybatis/authors?faces-redirect=true";
    }

    public Author getNewAuthor() {
        return newAuthor;
    }

    public void setNewAuthor(Author newAuthor) {
        this.newAuthor = newAuthor;
    }
}
