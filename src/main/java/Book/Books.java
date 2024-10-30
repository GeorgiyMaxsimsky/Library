package Book;

public class Books {


    long isbn;
    String name;
    String author;
    int quantity;

    public Books(long isbn, String name, String author, int quantity) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
    }


    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Книга : {" +
                "isbn=" + isbn +
                ", Название : ='" + name + '\'' +
                ", Автор : ='" + author + '\'' +
                ", Доступное количество := " + quantity +
                '}';
    }
}
