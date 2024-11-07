package Client;

import Accounts.Account;
import DataBase.LibraryQuery;

import java.util.Scanner;

public class EnterTheClientAccount {

    String email;



int resultX;

    public int getResult() {
        return resultX;
    }

    public void setResult(int result) {
        this.resultX = result;
    }

    public int enterTheClientAccount (){


        int result;




        Scanner sc = new Scanner(System.in);
        System.out.println("Введите email ");
        email = sc.nextLine();
        String password;



        LibraryQuery libraryQuery = new LibraryQuery();




        boolean userEmailFind =  libraryQuery.findByEmail(email);
        int i =0;

        while (userEmailFind==false){
            System.out.println("Введите email повторно");
            email= sc.nextLine();
            userEmailFind = libraryQuery.findByEmail(email);
            i++;
            if (i==10){

                System.out.println("Превышен лимит попыток ввода email");
                System.exit(0);
            }
        }
        if (userEmailFind==true){
            result = 1;
        }else{
            result =0;
        }
        if (result==1){
            System.out.println("Введите пароль");
            password = sc.nextLine();


           boolean userPassFind = libraryQuery.findPassword(email,password);
           int x = 0;
           while (userPassFind==false){
               System.out.println("Введите пароль");
               password = sc.nextLine();


               userPassFind = libraryQuery.findPassword(email,password);
           }
            if (userPassFind==true){
                System.out.println("Вход выполнен успешно");


                Account account = libraryQuery.getAccountFromSql(email);


                System.out.println("Вывод информации о пользователе - 1 ");
                System.out.println("Изменить данные аккаунта - 2 ");
                int answer4= sc.nextInt();

                if (answer4==1){


                    System.out.println(account.getEmail());
                    System.out.println(account.getName());
                    System.out.println(account.getSecondName());
                    System.out.println(account.getSurName());
                    System.out.println(account.getDateOfBirth());

                }else {

                    System.out.println("Аккаунт не найден");

                }




                result = 1;
                resultX = result;

            }else{
                result =0;
            }







        }
        return result;

    }







    public static void main(String[] args) {
        EnterTheClientAccount enterTheClientAccount = new EnterTheClientAccount();
        enterTheClientAccount.enterTheClientAccount();
    }






}
