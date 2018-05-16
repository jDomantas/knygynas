package lt.vu.mif.knygynas.rest;

import lt.vu.mif.knygynas.entities.Author;
import lt.vu.mif.knygynas.persistence.AuthorsDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@ApplicationScoped
@Path("/authors")
public class AuthorsController {
    @Inject
    private AuthorsDAO authorsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Author getById(@PathParam("id") final Integer id) {
        return authorsDAO.load(id);
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer authorId,
            Author authorData
    ) {
        try {
            Author existingAuthor = authorsDAO.load(authorId);
            if (existingAuthor == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingAuthor.setName(authorData.getName());
            authorsDAO.update(existingAuthor);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(
            Author authorData
    ) {
        try {
            authorData.setBooks(new ArrayList<>());
            authorsDAO.save(authorData);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}