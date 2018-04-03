package lt.vu.mif.knygynas.usecases;

import lt.vu.mif.knygynas.entities.Publisher;
import lt.vu.mif.knygynas.persistence.PublishersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Publishers {
    @Inject
    private PublishersDAO publishersDAO;

    private List<Publisher> allPublishers;
    private Publisher newPublisher = new Publisher();

    @PostConstruct
    public void init() {
        this.loadPublishers();
    }

    private void loadPublishers() {
        allPublishers = publishersDAO.loadAll();
    }

    public List<Publisher> getAllPublishers() {
        return allPublishers;
    }

    @Transactional
    public String createNewPublisher() {
        publishersDAO.save(newPublisher);
        return "index?faces-redirect=true";
    }

    public Publisher getNewPublisher() {
        return newPublisher;
    }

    public void setNewPublisher(Publisher newPublisher) {
        this.newPublisher = newPublisher;
    }
}
