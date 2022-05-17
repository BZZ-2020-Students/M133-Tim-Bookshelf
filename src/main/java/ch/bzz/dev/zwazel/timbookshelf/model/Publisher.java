package ch.bzz.dev.zwazel.timbookshelf.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Publisher {
    private String publisherUUID;
    private String publisher;
    private List<Book> bookList;
}
