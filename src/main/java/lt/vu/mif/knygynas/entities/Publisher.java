package lt.vu.mif.knygynas.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NamedQueries({
    @NamedQuery(name = "Publisher.findAll", query = "select p from Publisher as p"),
    @NamedQuery(name = "Publisher.findByName", query = "select p from Publisher as p where p.name = :name"),
})
@Table(name = "PUBLISHER")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    public Publisher() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
