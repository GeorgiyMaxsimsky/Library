package Staff;

import Book.Books;
import DataBase.LibraryQuery;

import java.util.List;
import java.util.Scanner;

public class FindBook {

    Scanner scanner = new Scanner(System.in);

    public Books findByAuthor(){

        System.out.println("Введите имя автора");
String author = scanner.nextLine();


        LibraryQuery libraryQuery = new LibraryQuery();


        List<Books> books = libraryQuery.findBookByAuthor(author);



        if (books.isEmpty()){
            System.out.println("Книги по автору "+author+" не найдены");

        }else {

            System.out.println("Найдены следующие книги по автору "+author);
            for (Books book:books){
                System.out.println(book);
            }

        }


        return (Books) books;

    }






}
