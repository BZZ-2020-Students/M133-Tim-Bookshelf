package ch.bzz.dev.zwazel.timbookshelf.model;

import ch.bzz.dev.zwazel.timbookshelf.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Book {
    @JsonIgnore
    private Publisher publisher;

    private String bookUUID;

    private String title;

    private String author;

    private BigDecimal price;

    private String isbn;

    public String getPublisherUUID() {
        return getPublisher().getPublisherUUID();
    }

    public void setPublisherUUID(String publisherUUID) {
        DataHandler<Publisher> publisherDataHandler = new DataHandler<>(Publisher.class);
        try {
            setPublisher(publisherDataHandler.getSingleFromJsonArray("publisherJsonFile", "publisherUUID", publisherUUID));
        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}



