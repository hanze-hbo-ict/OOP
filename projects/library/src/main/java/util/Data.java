package util;

import java.util.List;
import java.util.ArrayList;

import library.LibraryBook;
import library.ReferenceBook;
import library.CirculatingBook;

public class Data {

    /**
     * Return a collection of sample library books
     *
     * @return A collection of reference and circulating books
     */
    public static List<LibraryBook> readBooks() {
        List<List<String>> records = CsvReader.read("books.csv", true);

        List<LibraryBook> books = new ArrayList<>();

        for (List<String> entry : records) {
            String author = entry.get(0);
            String title = entry.get(1);
            String isbn = entry.get(2);
            String callNum = entry.get(3);
            String collection = entry.get(4);
            boolean circulate = Boolean.parseBoolean(entry.get(5));

            if (circulate) {
                books.add(new CirculatingBook(author, title, isbn, callNum));
            } else {
                books.add(new ReferenceBook(author, title, isbn, callNum, collection));
            }
        }

        return books;
    }
}
