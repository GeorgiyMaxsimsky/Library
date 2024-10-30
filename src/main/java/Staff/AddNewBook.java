package Staff;

import Book.Books;
import DataBase.LibraryQuery;

import java.sql.SQLException;
import java.util.Scanner;

public class AddNewBook {

    public static void Add()  {
        Scanner sc = new Scanner(System.in);

       try {



           System.out.println("Введите ISBN");
           long isbn = sc.nextLong();
           sc.nextLine();

           System.out.println("Введите название книги");
           String name = sc.nextLine();

           System.out.println("Введите автора");
           String author = sc.nextLine();

           System.out.println("Введите количество доступное для бронирования");
           int quantity = sc.nextInt();

           // Создание экземпляра книги
           Books book = new Books(isbn, name, author, quantity);

           LibraryQuery libraryQuery = new LibraryQuery();

           // Добавление книги в библиотеку
           libraryQuery.addNewBook(book);

       } catch (SQLException e) {
           System.out.println("Ошибка при добавлении книги: " + e.getMessage());
       } catch (Exception e) {
           System.out.println("Ошибка ввода: " + e.getMessage());
       } finally {
           sc.close();
       }




        }







    public static void main(String[] args) {
        AddNewBook addNewBook = new AddNewBook();
        addNewBook.Add();
    }





}
