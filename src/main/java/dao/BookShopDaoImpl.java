package dao;

import dto.Book;

import java.io.*;
import java.util.*;

public class BookShopDaoImpl implements BookShopDao {

    public static final String BOOK_FILE = "myData.txt";
    public static final String DELIMITER = "::";

    private Book unmarshallBooks(String bookAsText) {
        String[] bookIndex = bookAsText.split(DELIMITER);
        String bookId = bookIndex[0];
        Book UnmarshalledBook = new Book(bookId);

        UnmarshalledBook.setBookId(bookId);
        UnmarshalledBook.setBookName(bookIndex[1]);
        UnmarshalledBook.setAuthorName(bookIndex[2]);
        UnmarshalledBook.setPublisher(bookIndex[3]);
        UnmarshalledBook.setNotes(bookIndex[4]);

        return UnmarshalledBook;
    }

    private String marshallBooks(Book book) {
        String bookAsText = book.getBookId() + DELIMITER;

        bookAsText += book.getBookName() + DELIMITER;
        bookAsText += book.getAuthorName();
        bookAsText += book.getPublisher();
        bookAsText += book.getNotes();

        return bookAsText;
    }

    private void readFile() throws FileNotFoundException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(BOOK_FILE)));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("FILE NOT FOUND");
        }

        String currentLine;
        Book book;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            book = unmarshallBooks(currentLine);
            books.put(book.getBookId(), book);
        }
        scanner.close();
    }

    private void writeFile() throws IOException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(BOOK_FILE));
        } catch (IOException e) {
            throw new IOException("AN EXCEPTION");
        }

        String bookAsText;
        List<Book> BookList = this.getAllBooks();
        for (Book book : BookList) {
            bookAsText = marshallBooks(book);
            out.println(bookAsText);
            out.flush();
        }
        out.close();
    }

    private Map<String, Book> books = new HashMap<>();

    @Override
    public Book addBook(String bookId, Book book) {
        return books.put(bookId, book);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book getBook(String bookId) {
        return books.get(bookId);
    }

    @Override
    public Book removeBook(String bookId) {
        return books.remove(bookId);

    }
}
