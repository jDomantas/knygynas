package lt.vu.mif.knygynas.usecases;

import lt.vu.mif.knygynas.entities.Author;
import lt.vu.mif.knygynas.entities.Book;
import lt.vu.mif.knygynas.entities.Publisher;
import lt.vu.mif.knygynas.persistence.AuthorsDAO;
import lt.vu.mif.knygynas.persistence.BooksDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class BookInfo {
    @Inject
    private BooksDAO booksDAO;
    @Inject
    private AuthorsDAO authorsDAO;

    private Book book;
    private String addedAuthor;

    @PostConstruct
    public void init() {
        this.loadBook();
    }

    private void loadBook() {
        Map<String, String> params = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
        String isbn = params.get("isbn");
        this.book = booksDAO.load(isbn);
    }

    public Book getBook() {
        return book;
    }

    public String getAddedAuthor() {
        return addedAuthor;
    }

    public void setAddedAuthor(String addedAuthor) {
        this.addedAuthor = addedAuthor;
    }

    @Transactional
    public String addAuthorToBook() {
        Author author = authorsDAO.findByName(addedAuthor);
        if (author == null) {
            throw new ValidatorException(new FacesMessage("Author does not exist"));
        }
        book.getAuthors().add(author);
        booksDAO.save(book);
        return "books?faces-redirect=true&isbn=" + book.getIsbn();
    }
}
