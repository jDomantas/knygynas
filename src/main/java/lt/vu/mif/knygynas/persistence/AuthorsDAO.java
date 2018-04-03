package lt.vu.mif.knygynas.persistence;
import lt.vu.mif.knygynas.entities.Author;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class AuthorsDAO {
    @Inject
    private EntityManager em;

    public List<Author> loadAll() {
        return em.createNamedQuery("Author.findAll", Author.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void save(Author author) {
        this.em.persist(author);
    }

    public Author load(Integer id) {
        return em.find(Author.class, id);
    }

    public Author findByName(String name) {
        List<Author> authors = em
                .createNamedQuery("Author.findByName", Author.class)
                .setParameter("name", name)
                .setMaxResults(1)
                .getResultList();
        if (authors.size() > 0) {
            return authors.get(0);
        } else {
            return null;
        }
    }
}
