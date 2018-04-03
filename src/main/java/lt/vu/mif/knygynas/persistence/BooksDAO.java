package lt.vu.mif.knygynas.persistence;

import lt.vu.mif.knygynas.entities.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class BooksDAO {
    @Inject
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void save(Book book) {
        this.em.persist(book);
    }

    public void delete(Book book) {
        em.remove(book);
    }
}
