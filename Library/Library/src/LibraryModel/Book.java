package LibraryModel;

public class Book {
    private int ID;
    private  String title;
    private  String author;
    private  int year = 0; // год издания
    private  boolean isAvailable = true;

    private static int nextID = 0;


    public Book (String title, String author){
        this.ID = ++nextID;
        this.title = title;
        this.author = author;
    }

    public Book (String title, String author, int year){
        this.ID = ++nextID;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getID() {
        return ID;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYear(){
        return year;
    }

    public boolean getIsAvailable(){
        return isAvailable;
    }

    public void setYear(int year){
        if(year < 0){
            throw new IllegalArgumentException("Некорректное значение поля");
        }
        this.year = year;
    }

    public void changeAvailability(){
        this.isAvailable = !this.isAvailable;
    }

    public  void printInfo(){
        System.out.println(
                "ID: " + ID +
                        " | \"" + title + "\"" +
                        " | " + author +
                        " | " + year +
                        " | " + (isAvailable ? "доступна" : "выдана")
        );
    }
}
