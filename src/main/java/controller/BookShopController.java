package controller;

import dao.BookShopDao;
import dao.BookShopDaoImpl;
import dto.Book;
import view.BookShopView;
import view.UserIO;
import view.UserIOConsoleImpl;

import java.util.List;

public class BookShopController {

    private BookShopDao dao;
    private BookShopView view;

    public BookShopController(BookShopDao dao, BookShopView view) {
        this.dao = dao;
        this.view = view;
    };

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {

            menuSelection = view.printMenu();

            switch (menuSelection) {
                case 1:
                    viewAll();
                    break;
                case 2:
                    displayBook();
                    break;
                case 3:
                    viewBook();
                    break;
                case 4:
                    removeBook();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    view.displayUnknownEntryMessage();
            }
        }
        view.displayByeMessage();
    }

    public void displayBook() {
        view.displayAddBookBanner();
        Book newBook = view.getNewBookInfo();
        dao.addBook(newBook.getBookId(), newBook);
        view.displaySuccessBanner();
    }

    public void viewAll() {
        view.printAllBooks(dao.getAllBooks());
    }

    public void viewBook() {
        view.printBook(dao.getBook(view.getBookId()));
    }

    public void removeBook() {
        view.displayDeleteBanner(dao.removeBook(view.getBookId()));

    }
}
