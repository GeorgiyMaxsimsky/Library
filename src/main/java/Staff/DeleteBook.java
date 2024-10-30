package Staff;

import DataBase.LibraryQuery;

import java.util.Scanner;

public class DeleteBook {


    public void deleteBook(){
        Scanner scanner = new Scanner(System.in);
try {

    System.out.println("Введите название книги");
    String name = scanner.nextLine();
        System.out.println("Введите имя автора");
        String author = scanner.nextLine();



    LibraryQuery libraryQuery = new LibraryQuery();

    libraryQuery.deleteFromBooks(name, author);


        }catch (Exception e ){
    System.out.println("Ощибка при удалении книги");
        }finally {
    scanner.close();
        }




    }

    public static void main(String[] args) {
        DeleteBook deleteBook = new DeleteBook();

        deleteBook.deleteBook();



    }



}
