package view;

import dto.Book;

import java.util.List;

public class BookShopView {

    private UserIO io;

    public BookShopView(UserIO io) {
        this.io = io;
    }

    public int printMenu() {
        io.print("Main Menu");
        io.print("1. List all books");
        io.print("2. Create new book entry");
        io.print("3. View a book");
        io.print("4. Remove a book");
        io.print("5. Exit program");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    public Book getNewBookInfo() {
        String bookId = io.readString("Please enter book ID");
        String bookName = io.readString("Please enter book name");
        String bookAuthor = io.readString("Please enter book's author");
        String publisher = io.readString("Please enter book publisher");
        String note = io.readString("Enter your notes here");

        Book currentBook = new Book(bookId);
        currentBook.setBookName(bookName);
        currentBook.setAuthorName(bookAuthor);
        currentBook.setPublisher(publisher);
        currentBook.setNotes(note);

        return currentBook;
    }

    public void printAllBooks(List<Book> allBooks) {
        for (Book book : allBooks) {
            String booksInfo = String.format("=== [%s] === \nTITLE: [%s] \nAuthor: [%s] \nPublisher: [%s] \nNotes: [%s] \n",
                    book.getBookId(),
                    book.getBookName(),
                    book.getAuthorName(),
                    book.getPublisher(),
                    book.getNotes());

            io.print(booksInfo);
        }
    }

    public String getBookId() {
        return io.readString("Please enter a valid book ID");
    }

    public void printBook(Book book) {
        if (book != null) {
            io.print(String.format("=== [%s] === \nTITLE: [%s] \nAuthor: [%s] \nPublisher: [%s] \nNotes: [%s] \n === === ===",
                    book.getBookId(),
                    book.getBookName(),
                    book.getAuthorName(),
                    book.getPublisher(),
                    book.getNotes()));
        } else {
            io.print("No book associated with that ID");
        }
    }


    //BANNERS

    public void displayAddBookBanner() {
        io.print("=== ADD A BOOK ===");
    }

    public void displaySuccessBanner() {
        io.print("=== OPERATION SUCCESSFUL! ===");
    }

    public void displayDeleteBanner(Book book) {
        io.print(String.format("===SUCCESSFULLY DELETED=== \n%s: %s",
                book.getBookId(),
                book.getBookName()
                ));
    }

    public void displayUnknownEntryMessage() {
        io.print("=== UNKNOWN COMMAND! ===");
    }

    public void displayByeMessage() {
        io.print("=== GOOD BYE, GOOD USER! ===");
    }
}
