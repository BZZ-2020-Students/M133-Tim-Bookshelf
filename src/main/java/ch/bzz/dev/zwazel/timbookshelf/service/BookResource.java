package ch.bzz.dev.zwazel.timbookshelf.service;

import ch.bzz.dev.zwazel.timbookshelf.data.DataHandler;
import ch.bzz.dev.zwazel.timbookshelf.model.Book;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.util.ArrayList;

@Path("/book")
public class BookResource {
    @GET
    @Path("/all")
    public Response getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        DataHandler<Book> dataHandler = new DataHandler<>(Book.class);
        try {
            books = dataHandler.getArrayFromJson("bookJsonFile");

            System.out.println("books = " + books);

            return Response.status(200).entity(books).build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Response.status(500).build();
    }
}
