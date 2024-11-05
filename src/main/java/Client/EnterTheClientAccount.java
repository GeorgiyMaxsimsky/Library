package Client;

import DataBase.LibraryQuery;

import java.util.Scanner;

public class EnterTheClientAccount {
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

        String email;
        String password;



        LibraryQuery libraryQuery = new LibraryQuery();



        System.out.println("Введите email");
        email= sc.nextLine();

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
