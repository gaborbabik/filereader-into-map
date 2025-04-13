import model.Book;
import model.SortedBook;
import util.FileReader;
import util.Sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FileReaderApp {

    public static void main(String[] args) {

        Map<Integer, String> categories = new HashMap<>();
        categories = FileReader.getInstance().readCategories(FileReader.CATEGORY_FILE_PATH);
        Book[] books = FileReader.getInstance().readBook(FileReader.BOOKS_FILE_PATH);
        Map<String, ArrayList<SortedBook>> bookMap = new HashMap<>();
        bookMap = Sorter.sort(categories, books);
        for (Map.Entry<String, ArrayList<SortedBook>> entry : bookMap.entrySet()) {
            System.out.println(entry.getKey() + " : ");
            for (SortedBook book : entry.getValue()) {
                System.out.println(book.toString());
            }
        }
    }
}
