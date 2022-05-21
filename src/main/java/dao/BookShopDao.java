package dao;

import dto.Book;

import java.util.List;

public interface BookShopDao {

    Book addBook(String bookId, Book book);

    List<Book> getAllBooks();

    Book getBook(String bookId);

    Book removeBook(String bookId);

}
