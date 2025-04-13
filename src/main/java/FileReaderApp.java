import model.Book;
import model.BookBasic;
import util.FileReader;
import util.Sorter;

import java.util.ArrayList;
import java.util.Map;

public class FileReaderApp {

    public static void main(String[] args) {

        Map<Integer, String> categories = FileReader.getInstance().readCategories(FileReader.CATEGORY_FILE_PATH);
        Book[] books = FileReader.getInstance().readBook(FileReader.BOOKS_FILE_PATH);
        Map<String, ArrayList<BookBasic>> bookMap = Sorter.sort(categories, books);

        for (Map.Entry<String, ArrayList<BookBasic>> entry : bookMap.entrySet()) {
            System.out.println(entry.getKey() + " : ");
            for (BookBasic book : entry.getValue()) {
                System.out.println(book.toString());
            }
        }
    }
}
