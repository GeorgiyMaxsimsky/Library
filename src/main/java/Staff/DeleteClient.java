package Staff;

import DataBase.LibraryQuery;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteClient {

    public static void Delete() throws SQLException {
        System.out.println("Введите email");
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();

        System.out.println("Для подтверждения действия введите 1234");
        int a = sc.nextInt();
LibraryQuery libraryQuery = new LibraryQuery();
        if (a==1234){


            libraryQuery.deleteFromAccount(email);



        }else{

            System.out.println("Введен неверный код");

        }





    }



}
