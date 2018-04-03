package lt.vu.mif.knygynas.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "select a from Author as a"),
    @NamedQuery(name = "Author.findByName", query = "select a from Author as a where a.name = :name"),
})
@Table(name = "AUTHOR")
public class Author implements Serializable {
    public Author() {}

    public Author(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @ManyToMany
    @JoinTable(
            name="AUTHORS_BOOKS",
            joinColumns=@JoinColumn(name="AUTHOR_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="BOOK_ID", referencedColumnName="ISBN"))
    private List<Book> books;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}