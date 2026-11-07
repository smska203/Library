package LibraryModel;

import LibraryUtil.Constants;

public class Library {
    private Book[] books = new Book[Constants.MAX_BOOK];
    private Reader[] readers;
    private int bookCount = 0;
    private int readerCount = 0;

    public Library() {
       this.books = new Book[Constants.MAX_BOOK];
       this.readers = new Reader[Constants.MAX_READERS];
       this.bookCount = bookCount;
       this.readerCount = readerCount;
    }

    public boolean addBook(Book book) {
        if (bookCount >= Constants.MAX_BOOK) {
            return false;
        }

        books[bookCount] = book;
        bookCount++;
        return true;
    }

    public Reader registerReader(String name) {
        if (readerCount >= Constants.MAX_READERS) {
            System.out.println("Достигнут лимит читателей.");
            return null;
        }

        Reader reader = new Reader(name);
        readers[readerCount] = reader;
        readerCount++;
        return reader;
    }

    public Book findBookByID(int ID){
        for (int i = 0; i < bookCount; i++){
            if (ID == books[i].getID()){
                return books[i];
            }
        }
        return null;
    }

    public Book findBookByTitle(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Reader findReaderByID(int id) {
        for (int i = 0; i < readerCount; i++) {
            if (readers[i].getID() == id) {
                return readers[i];
            }
        }
        return null;
    }

    public void printAllBooks() {
        if (bookCount == 0) {
            System.out.println("В библиотеке пока нет книг.");
            return;
        }

        System.out.println("Все книги библиотеки:");
        for (int i = 0; i < bookCount; i++) {
            books[i].printInfo();
        }
    }
    public void printAvailableBooks() {
        if (bookCount == 0) {
            System.out.println("В библиотеке пока нет книг.");
            return;
        }

        System.out.println("Доступные книги:");
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsAvailable()) {
                books[i].printInfo();
            }
        }
    }
    public void printStatistics() {
        if (bookCount == 0 && readerCount == 0) {
            System.out.println("Библиотека пуста.");
            return;
        }

        int availableCount = 0;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsAvailable()) {
                availableCount++;
            }
        }
        int lentCount = bookCount - availableCount;

        System.out.println("=== СТАТИСТИКА ===");
        System.out.println("Всего книг:      " + bookCount);
        System.out.println("Доступных книг:  " + availableCount);
        System.out.println("Выданных книг:   " + lentCount);
        System.out.println("Всего читателей: " + readerCount);
    }
    public boolean lendBook(int bookId, int readerId) {
        Book book = findBookByID(bookId);
        if (book == null) {
            return false;
        }

        Reader reader = findReaderByID(readerId);
        if (reader == null) {
            return false;
        }

        return reader.takeBook(book);
    }
    public boolean acceptReturn(int bookId, int readerId) {
        Book book = findBookByID(bookId);
        if (book == null) {
            return false;
        }

        Reader reader = findReaderByID(readerId);
        if (reader == null) {
            return false;
        }

        return reader.returnBook(book);
    }

    public void printAllReaders() {
        if (readerCount == 0) {
            System.out.println("В библиотеке пока нет читателей.");
            return;
        }

        System.out.println("Читатели библиотеки:");
        for (int i = 0; i < readerCount; i++) {
            System.out.println("---");
            System.out.println("ID: " + readers[i].getID() + ", имя: " + readers[i].getName());
            readers[i].printBorrowedBooks();
        }
    }

}

