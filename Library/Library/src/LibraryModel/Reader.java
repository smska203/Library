package LibraryModel;

import LibraryUtil.Constants;

import java.sql.SQLOutput;

public class Reader {
    private int ID;
    private String name;
    private Book[] borrowedBooks;
    private int borrowedCount;

    private static int nextID = 0;

    public Reader(String name) {
        this.ID = nextID++;
        this.name = name;
        this.borrowedBooks = new Book[Constants.MAX_BOOKS_PER_READER];
        this.borrowedCount = 0;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public boolean takeBook(Book book) {
        if (borrowedCount >= Constants.MAX_BOOKS_PER_READER) {
            return false;                    // у читателя нет места
        }
        if (!book.getIsAvailable()) {
            return false;                    // книга уже выдана кому-то
        }

        borrowedBooks[borrowedCount] = book;
        borrowedCount++;
        book.changeAvailability();
        return true;
    }

    public boolean returnBook(Book book) {
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i] == book) {

                for (int j = i; j < borrowedCount - 1; j++) {
                    borrowedBooks[j] = borrowedBooks[j + 1];
                }

                borrowedBooks[borrowedCount - 1] = null;
                borrowedCount--;

                book.changeAvailability();
                return true;
            }
        }
        return false;
    }
    public void printBorrowedBooks() {
        if (borrowedCount == 0) {
            System.out.println("Выданные книги отсутствуют");
            return;
        }
        System.out.println("Книги читателя " + name + ":");
        for (int i = 0; i < borrowedCount; i++) {
            borrowedBooks[i].printInfo();
        }
    }
}

