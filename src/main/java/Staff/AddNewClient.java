package Staff;

import Accounts.Account;
import DataBase.LibraryQuery;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddNewClient {
    public static void Add() {

        System.out.println("Введите email");

        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern isEmailCorrect = Pattern.compile(regex);
        Matcher matchEmail = isEmailCorrect.matcher(email);

        if (matchEmail.find()){


            System.out.println("Введите пароль");
            System.out.println("Пароль должен:" );
            System.out.println(" Содержать как минимум 8 символов.");
            System.out.println(" Включать как минимум одну заглавную букву." );
            System.out.println(" Включать как минимум одну строчную букву." );
            System.out.println(" Включать как минимум одну цифру." );
            System.out.println(" Включать как минимум один специальный символ (например, !@#$%^&*).");
            String password = sc.nextLine();
            Pattern isPasswordDiff = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])" +
                    "[A-Za-z\\d!@#$%^&*]{8,}$");
            Matcher diffPass = isPasswordDiff.matcher(password);
if (diffPass.find()){

    System.out.println("Введите имя пользователя");
    String name = sc.nextLine();
    System.out.println("Введите отчество пользователя");
    String secondName = sc.nextLine();
    System.out.println("Введите фамилию пользователя");
    String surName = sc.nextLine();
    System.out.println("Введите дату рождения пользователя (в формате дд.MM.гггг):");


    String dateString = sc.nextLine();
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    Date dateOfBirth= null;

    try {
        dateOfBirth = format.parse(dateString);
    }catch (ParseException e ){
        System.out.println("Ошибка: неверный формат даты. Пожалуйста, введите дату в формате дд.MM.гггг.");
    }


    Account account = new Account(email, password,name, secondName,surName, dateOfBirth);

    LibraryQuery libraryQuery = new LibraryQuery();

    try {
        libraryQuery.addNewAccount(account);
        System.out.println("Аккаунт успешно добавлен.");
    } catch (SQLException e) {
        System.out.println("Ошибка при добавлении аккаунта: " + e.getMessage());
    }







}else {
    System.out.println("Пароль не соответсвует требованиям");
}




        }else {

            System.out.println("Email введён некорректно, попробуйте ещё раз.");
        }



    }









    }







