package util;

import model.Book;
import model.BookBasic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sorter {

    public static Map<String, ArrayList<BookBasic>> sort(Map<Integer, String> categories, Book[] books) {
        Map<String, ArrayList<BookBasic>> categoryMap = new HashMap<String, ArrayList<BookBasic>>();

        for (Map.Entry<Integer, String> entry : categories.entrySet()) {
            ArrayList<BookBasic> list = new ArrayList<BookBasic>();

            for (Book book : books) {
                if (book.getCategoryNumber() == entry.getKey()) {
                    String author = book.getAuthor();
                    String title = book.getTitle();
                    String publisher = book.getPublisher();
                    String publishedDate = book.getPublishedDate();
                    String isbn = book.getIsbn();
                    list.add(new BookBasic(author, title, publisher, publishedDate, isbn));
                }
            }
            categoryMap.putIfAbsent(entry.getValue(), list);
        }

        return categoryMap;
    }

    private Sorter() {
    }
}
