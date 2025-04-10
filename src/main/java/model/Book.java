package model;

public class Book {

    private String category;
    private String author;
    private String title;
    private String publisher;
    private String publishedDate;
    private String isbn;

    public Book() {
    }

    public Book(String category, String author, String title, String publisher, String publishedDate, String isbn) {
        this.category = category;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
