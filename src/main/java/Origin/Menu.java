package Origin;

import Client.EnterTheClientAccount;
import Staff.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws SQLException {
        System.out.println("Введите 1 -------------- для отображения меню пользователя");
        System.out.println("Введите 2 -------------- для отображения меню сотрудника");



        Scanner scanner = new Scanner(System.in);
        int answer1 = scanner.nextInt();

        if (answer1 ==1) {

            EnterTheClientAccount enterTheClientAccount = new EnterTheClientAccount();
            enterTheClientAccount.enterTheClientAccount();
            int i = enterTheClientAccount.getResult();
            if (i==1){
                System.out.println("Вход выполнен (Заменить на строку меню пользователя)");


            }else {
                System.out.println("Перезагрузите программу");
            }


        }else if (answer1 ==2){


            System.out.println("Нажмите 1 --------- для действий с книгами ");
            System.out.println("Нажмите 2 --------- для действий с аккаунтом");

            int answer2 = scanner.nextInt();


            if (answer2==1){

                System.out.println("Нажмите 1 --------- чтобы добавить книгу");
                System.out.println("Нажмите 2 --------- чтобы найти книгу");
                System.out.println("Нажмите 3 --------- чтобы удалить книгу");

                int bookAnswer = scanner.nextInt();


                if (bookAnswer==1) {
                    AddNewBook addNewBook = new AddNewBook();
                    addNewBook.Add();

                } else if (bookAnswer==2) {
                    FindBook findBook = new FindBook();
                    findBook.findByAuthor();


                }else if (bookAnswer==3) {
                    DeleteBook deleteBook = new DeleteBook();
                    deleteBook.deleteBook();

                }


            } else if (answer2==2) {

                System.out.println("Нажмите 1 --------- чтобы создать аккаунт");
                System.out.println("Нажмите 2 --------- чтобы удалить аккаунт");


                int staffAnswer = scanner.nextInt();
                if (staffAnswer==1){
                    AddNewClient addNewClient = new AddNewClient();
                    addNewClient.Add();

                } else if (staffAnswer==2) {
                    DeleteClient deleteClient = new DeleteClient();
                    deleteClient.Delete();


                }else {
                    System.exit(0);
                }


            }
            else {
                System.out.println("Всего доброго!");
                System.exit(0);

            }


        }

            }


    }





