package util;

import model.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileReader {

    public static final String CATEGORY_FILE_PATH = "src/main/resources/categories.txt";
    public static final String BOOKS_FILE_PATH = "src/main/resources/books.txt";

    private static FileReader instance;

    public static FileReader getInstance() {
        if (instance == null) {
            instance = new FileReader();
        }
        return instance;
    }

    public Map<Integer, String> readCategories(String filePath) {
        Map<Integer, String> categories = new HashMap<Integer, String>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(";");
                if (parts.length != 2) {
                    continue;
                }
                int category = Integer.parseInt(parts[0]);
                String name = parts[1].trim();
                categories.put(category, name);

            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return categories;
    }

    public Book[] readBook(String filePath) {
        int counter = countLinesInFile(filePath);
        Book[] books = new Book[counter];
        int index = 0;

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(";");
                if (parts.length != 6) {
                    continue;
                }
                int categoryNumber = Integer.parseInt(parts[0]);
                String author = parts[1].trim();
                String title = parts[2].trim();
                String publisher = parts[3].trim();
                String publishedDate = parts[4].trim();
                String isbn = parts[5].trim();

                Book book = new Book(categoryNumber, author, title, publisher, publishedDate, isbn);
                books[index] = book;
                index++;

            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return books;
    }

    private int countLinesInFile(String filePath) {
        int counter = 0;
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    counter++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return counter;
    }

    private FileReader() {
    }
}
