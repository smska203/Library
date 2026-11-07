package LibraryApp;

import LibraryModel.Book;
import LibraryModel.Library;
import LibraryModel.Reader;
import LibraryUtil.Constants;
import LibraryUtil.InputHelper;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        // Предзаполняем библиотеку книгами
        library.addBook(new Book("Война и мир", "Л. Толстой", 1869));
        library.addBook(new Book("1984", "Дж. Оруэлл", 1949));
        library.addBook(new Book("Мастер и Маргарита", "М. Булгаков", 1967));
        library.addBook(new Book("Преступление и наказание", "Ф. Достоевский", 1866));

        boolean running = true;
        while (running) {
            printMenu();
            int choice = InputHelper.readInt("Ваш выбор: ", 0, 8);

            switch (choice) {
                case 1:
                    library.printAllBooks();
                    break;
                case 2:
                    library.printAvailableBooks();
                    break;
                case 3:
                    addBook(library);
                    break;
                case 4:
                    registerReader(library);
                    break;
                case 5:
                    lendBook(library);
                    break;
                case 6:
                    acceptReturn(library);
                    break;
                case 7:
                    library.printAllReaders();
                    break;
                case 8:
                    library.printStatistics();
                    break;
                case 0:
                    System.out.println("До свидания!");
                    running = false;
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("=== БИБЛИОТЕКА ===");
        System.out.println("1. Показать все книги");
        System.out.println("2. Показать доступные книги");
        System.out.println("3. Добавить книгу");
        System.out.println("4. Зарегистрировать читателя");
        System.out.println("5. Выдать книгу");
        System.out.println("6. Принять возврат");
        System.out.println("7. Показать читателей и их книги");
        System.out.println("8. Статистика");
        System.out.println("0. Выход");
    }

    private static void addBook(Library library) {
        String title = InputHelper.readString("Название: ");
        String author = InputHelper.readString("Автор: ");
        int year = InputHelper.readInt("Год издания: ", 0, 2026);

        Book book = new Book(title, author, year);

        if (library.addBook(book)) {
            System.out.println("Книга добавлена.");
        } else {
            System.out.println("Не удалось добавить: библиотека заполнена.");
        }
    }

    private static void registerReader(Library library) {
        String name = InputHelper.readString("Имя читателя: ");
        Reader reader = library.registerReader(name);

        if (reader != null) {
            System.out.println("Читатель зарегистрирован. ID = " + reader.getID());
        } else {
            System.out.println("Не удалось зарегистрировать: достигнут лимит читателей.");
        }
    }

    private static void lendBook(Library library) {
        int bookId = InputHelper.readInt("ID книги: ", 0, Constants.MAX_BOOK);
        int readerId = InputHelper.readInt("ID читателя: ", 0, Constants.MAX_READERS);

        if (library.lendBook(bookId, readerId)) {
            System.out.println("Книга выдана.");
        } else {
            System.out.println("Не удалось выдать книгу.");
        }
    }

    private static void acceptReturn(Library library) {
        int bookId = InputHelper.readInt("ID книги: ", 0, Constants.MAX_BOOK);
        int readerId = InputHelper.readInt("ID читателя: ", 0, Constants.MAX_READERS);

        if (library.acceptReturn(bookId, readerId)) {
            System.out.println("Книга принята.");
        } else {
            System.out.println("Не удалось принять книгу.");
        }
    }
}