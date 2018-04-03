package lt.vu.mif.knygynas.usecases;

import lt.vu.mif.knygynas.mybatis.model.Author;
import lt.vu.mif.knygynas.mybatis.dao.AuthorMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class BooksByAuthorMyBatis {
    @Inject
    private AuthorMapper authorsDAO;

    private Author author;

    @PostConstruct
    public void init() {
        this.loadAuthor();
    }

    private void loadAuthor() {
        Map<String, String> params = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
        Integer id = Integer.parseInt(params.get("id"));
        this.author = authorsDAO.selectByPrimaryKey(id);
    }

    public Author getAuthor() {
        return author;
    }
}
