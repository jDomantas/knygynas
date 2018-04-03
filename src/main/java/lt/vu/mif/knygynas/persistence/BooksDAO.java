package lt.vu.mif.knygynas.persistence;

import lt.vu.mif.knygynas.entities.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BooksDAO {
    @Inject
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void save(Book book) {
        em.persist(book);
    }

    public List<Book> loadAll() {
        return em.createNamedQuery("Books.findAll", Book.class).getResultList();
    }

    public Book load(String isbn) {
        return em.find(Book.class, isbn);
    }
}
