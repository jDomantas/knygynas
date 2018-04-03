package lt.vu.mif.knygynas.usecases;

import lt.vu.mif.knygynas.entities.Author;
import lt.vu.mif.knygynas.entities.Book;
import lt.vu.mif.knygynas.entities.Publisher;
import lt.vu.mif.knygynas.persistence.AuthorsDAO;
import lt.vu.mif.knygynas.persistence.BooksDAO;
import lt.vu.mif.knygynas.persistence.PublishersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;
import java.util.List;

@Model
public class Books {
    public static class NewBook {
        private String isbn, title, publisher;

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getPublisher() {
            return publisher;
        }

        public String getTitle() {
            return title;
        }
    }

    @Inject
    private BooksDAO booksDAO;
    @Inject
    private PublishersDAO publishersDAO;

    private List<Book> allBooks;
    private NewBook newBook = new NewBook();

    @PostConstruct
    public void init() {
        this.loadBooks();
    }

    private void loadBooks() {
        allBooks = booksDAO.loadAll();
    }

    public List<Book> getAllBooks() {
        return allBooks;
    }

    @Transactional
    public String createNewBook() {
        Publisher publisher = publishersDAO.findByName(newBook.publisher);
        if (publisher == null) {
            throw new ValidatorException(new FacesMessage("Publisher does not exist"));
        }
        Book book = new Book();
        book.setIsbn(newBook.isbn);
        book.setTitle(newBook.title);
        book.setPublisher(publisher);
        booksDAO.save(book);
        return "index?faces-redirect=true";
    }

    public NewBook getNewBook() {
        return newBook;
    }

    public void setNewBook(NewBook newBook) {
        this.newBook = newBook;
    }
}
