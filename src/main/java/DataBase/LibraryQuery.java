package DataBase;

import Accounts.Account;
import Book.Books;
import DataBase.Util.ConnectionManager;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryQuery {


    private static final String GET_ACCOUNT_CLIENT = """
            SELECT
            accounts.id,
            accounts.email,
            accounts.password,
            clients.name,
            clients.secondname,
            clients.surname,
            clients.date_Of_birth
            FROM
            clients
            JOIN
                accounts ON clients.account_id = accounts.id
            		WHERE email = ?
            """;


    /*  private static String ADD_MONEY = """
              UPDATE accounts
              SET money = money + ?
              WHERE id = ?


              """;*/
    private static final String ADD_NEW_BOOK = """
            INSERT INTO BOOKS (isbn, name, author,quantity)
            VALUES (?,?,?,?)
                        
                        
            """;


    private static final String ADD_NEW_ACCOUNT = """
            INSERT INTO accounts (email,password)
            VALUES (?,?)
                        
                        
            """;

    private static final String ADD_NEW_CLIENT = """
            INSERT INTO clients (account_id, name,surname,secondname,date_of_birth) 
            VALUES (?,?,?,?,?)
                    
                            """;


    private static final String DELETE_ACCOUNT = """
                        
            DELETE FROM accounts
            where email = ?        
                        
            """;

    private static final String DELETE_BOOK = """
                        
            DELETE FROM books
            where name = ? and author = ? 
                        
            """;


    private static final String FIND_BOOK_BY_AUTHOR = """
            SELECT * FROM books
            WHERE author = ? 
                        
            """;

  /*  private static final String FIND_BOOK_BY_NAME = """
            SELECT * FROM books
            WHERE name = ? 
                        
            """;*/


    private static final String FIND_EMAIL = """
            SELECT email FROM accounts
            WHERE email = ?
                        
            """;

    private static final String FIND_PASS = """
            SELECT password FROM accounts
            WHERE email = ? and password = ?
                        
            """;


//      public void TakeMonneyToAccount(int sumOfMoney,Account account){
//       try(
//    Connection connection = ConnectionManager.open())
//
//    {
//        PreparedStatement preparedStatement = connection.prepareStatement(ADD_MONEY);
//        preparedStatement.setString(sumOfMoney, account.);
//
//
//    } catch(
//    SQLException e)
//
//    {
//        throw new RuntimeException(e);
//    }
//
//
//}


    public Account getAccountFromSql(String email) {




        try (Connection connection = ConnectionManager.open()) {

            PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNT_CLIENT);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                int accountId = resultSet.getInt("id");
                String emailx = resultSet.getString("email");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String secondname = resultSet.getString("secondname");
                String surname = resultSet.getString("surname");
                String dateOfBirth = resultSet.getString("date_Of_birth");


                Account account =new Account(accountId, emailx, password, name, secondname, surname, dateOfBirth);
return account;


            } else {
                System.out.println("Аккаунт не был найден");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);

            } catch (Exception e) {
                e.printStackTrace();
            }


        return null;
    }






public boolean findByEmail(String email){

    boolean userFound = false;

    try (Connection connection = ConnectionManager.open()){
        PreparedStatement pst = connection.prepareStatement(FIND_EMAIL);
        pst.setString(1, email);
        ResultSet resultSet = pst.executeQuery();

if (resultSet.next()){
    userFound=true;
}


    } catch (SQLException e) {
        System.out.println("Ошибка при попытке найти пользователя с email: " + email);
        e.printStackTrace();
    }

    if (!userFound) {

        System.out.println("Пользователь с email: " + email + " не найден");
    }
    return userFound;
}





    public boolean findPassword(String email, String pass){

        boolean passFound = false;

        try (Connection connection = ConnectionManager.open()){
            PreparedStatement pst = connection.prepareStatement(FIND_PASS);
            pst.setString(1, email);
            pst.setString(2, pass);
            ResultSet resultSet = pst.executeQuery();


if (resultSet.next()){
    passFound=true;
}

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (!passFound) {

            System.out.println("Пароль неверный");
        }


        return passFound;
    }













    public List<Books> findBookByAuthor(String author){

        List <Books> books = new ArrayList<>();


        try (Connection connection = ConnectionManager.open()){

            PreparedStatement pst = connection.prepareStatement(FIND_BOOK_BY_AUTHOR);
            pst.setString(1, author);

            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()){
                long isbn = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int quantity = resultSet.getInt(4);



                Books book = new Books(isbn,name,author,quantity );

                books.add(book);

            }

          // for (int i = 0; i<books.size(); i++){
         //       System.out.println(books.get(i));

           // }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return books;
    }




    public void deleteFromBooks (String name, String author) throws SQLException {

        try (Connection connection = ConnectionManager.open()) {

            PreparedStatement pst = connection.prepareStatement(DELETE_BOOK);
            pst.setString(1,name );
            pst.setString(2,author );


            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {

                System.out.println("Книга была успешно удалена .");
            } else {
                System.out.println("Не удалось удалить книгу.");
            }

        }
    }

   public void deleteFromAccount (String email) throws SQLException {

       try (Connection connection = ConnectionManager.open()) {

           PreparedStatement pst = connection.prepareStatement(DELETE_ACCOUNT);
           pst.setString(1, email);


           int rowsAffected = pst.executeUpdate();
       if (rowsAffected > 0) {

           System.out.println("Аккаунт был удален успешно.");
       } else {
           System.out.println("Не удалось удалить аккаунт.");
       }

   }


   }
    public void addNewAccount(Account account) throws SQLException {


        try (Connection connection = ConnectionManager.open()) {

            PreparedStatement pst = connection.prepareStatement(ADD_NEW_ACCOUNT ,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, account.getEmail());
            pst.setString(2, account.getPassword());



            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()){
                    long generatedID = generatedKeys.getLong(1);

                System.out.println("Запрос на добавление аккаунта выполнен успешно.");


            PreparedStatement pst2 = connection.prepareStatement(ADD_NEW_CLIENT);
            pst2.setLong(1,  generatedID  );

            pst2.setString(2, account.getName());
            pst2.setString(3, account.getSecondName());
            pst2.setString(4, account.getSurName());


            Date sqlDateOfBirth = new Date(account.getDateOfBirth().getTime());

            pst2.setDate(5, sqlDateOfBirth);



            int rowsAffected2 = pst2.executeUpdate();
            if (rowsAffected2 > 0) {
                System.out.println("Запрос на добавление клиента выполнен успешно.");
            } else {
                deleteFromAccount(account.getEmail());

                System.out.println("Не удалось добавить клиента.");

            }
                } else {
                    System.out.println("Не удалось добавить аккаунт.");
                    }

            }
        } catch (SQLException e) {
            e.printStackTrace();


        }


    }

    public void addNewBook (Books book) throws SQLException {
        try(Connection connection = ConnectionManager.open()){

            PreparedStatement pst = connection.prepareStatement(ADD_NEW_BOOK);
            pst.setLong(1, book.getIsbn());
            pst.setString(2, book.getName());
            pst.setString(3,book.getAuthor() );
            pst.setInt(4,book.getQuantity());




            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {

                System.out.println("Книга была добавлена успешно.");
            } else {
                System.out.println("Не удалось добавить книгу.");
            }

        }






    }






}



