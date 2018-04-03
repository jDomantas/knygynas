package lt.vu.mif.knygynas.usecases;

import lt.vu.mif.knygynas.entities.Author;
import lt.vu.mif.knygynas.entities.Book;
import lt.vu.mif.knygynas.persistence.AuthorsDAO;
import lt.vu.mif.knygynas.persistence.BooksDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class BooksByAuthor {
    @Inject
    private AuthorsDAO authorsDAO;
    @Inject
    private BooksDAO booksDAO;

    private Author author;
    private Book newBook = new Book();

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

    public Book getNewBook() {
        return newBook;
    }

    public void setNewBook(Book newBook) {
        this.newBook = newBook;
    }

    @Transactional
    public String saveNewBook() {
        newBook.setAuthor(author);
        booksDAO.save(newBook);
        return "author?faces-redirect=true&id=" + author.getId();

    }
}
