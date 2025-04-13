package util;

import model.Book;
import model.SortedBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sorter {

    public static Map<String, ArrayList<SortedBook>> sort(Map<Integer, String> categories, Book[] books) {
        Map<String, ArrayList<SortedBook>> categoryMap = new HashMap<String, ArrayList<SortedBook>>();

        for (Map.Entry<Integer, String> entry : categories.entrySet()) {
            ArrayList<SortedBook> list = new ArrayList<SortedBook>();

            for (Book book : books) {
                if (book.getCategoryNumber() == entry.getKey()) {
                    String author = book.getAuthor();
                    String title = book.getTitle();
                    String publisher = book.getPublisher();
                    String publishedDate = book.getPublishedDate();
                    String isbn = book.getIsbn();
                    list.add(new SortedBook(author, title, publisher, publishedDate, isbn));
                }
            }
            categoryMap.putIfAbsent(entry.getValue(), list);
        }

        return categoryMap;
    }

    private Sorter() {
    }
}
