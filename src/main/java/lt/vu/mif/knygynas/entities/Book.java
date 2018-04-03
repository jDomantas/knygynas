package lt.vu.mif.knygynas.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "select a from Book as a"),
})
@Table(name = "BOOK")
public class Book {
    @Id
    @Column(name = "ISBN")
    private String isbn;

    @Size(max = 100)
    @Column(name = "TITLE")
    private String title;

    @ManyToMany
    @JoinTable(
            name="AUTHORS_BOOKS",
            joinColumns=@JoinColumn(name="BOOK_ID", referencedColumnName="ISBN"),
            inverseJoinColumns=@JoinColumn(name="AUTHOR_ID", referencedColumnName="ID"))
    private List<Author> authors;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PUBLISHER_ID")
    private Publisher publisher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
