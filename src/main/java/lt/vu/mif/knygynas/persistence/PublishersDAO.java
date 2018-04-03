package lt.vu.mif.knygynas.persistence;

import lt.vu.mif.knygynas.entities.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PublishersDAO {
    @Inject
    private EntityManager em;

    public List<Publisher> loadAll() {
        return em.createNamedQuery("Publisher.findAll", Publisher.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void save(Publisher publisher) {
        this.em.persist(publisher);
    }

    public Publisher load(Integer id) {
        return em.find(Publisher.class, id);
    }

    public Publisher findByName(String publisher) {
        List<Publisher> publishers = em
                .createNamedQuery("Publisher.findByName", Publisher.class)
                .setParameter("name", publisher)
                .setMaxResults(1)
                .getResultList();
        if (publishers.size() > 0) {
            return publishers.get(0);
        } else {
            return null;
        }
    }
}
