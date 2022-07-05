package com.logo.Repository;
import com.logo.Model.Account;
import com.logo.Model.enums.CurrencyType;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AccountJdbcRepository implements IDao<Account, Integer> {
    private static int i=1;

    PreparedStatement preparedStatement = null;


    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/isbasi", "postgres", "123456");
            System.out.println("Connected to the PostgreSQL server successfully.");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return conn;

    }

    @Override
    public Account save(Account account) {
        account.setId(i++);
        try (Connection con = connect()) {

            String sql = "Insert INTO account (id,account_name,account_number,balance,iban) VALUES(?,?,?,?,?)";

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setString(2, account.getAccountName());
            preparedStatement.setString(3, account.getAccountNumber());
            preparedStatement.setDouble(4, account.getBalance());
            preparedStatement.setString(5, account.getIban());

            preparedStatement.executeUpdate();
            preparedStatement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return account;
    }

    @Override
    public List<Account> findAll() {
        String sql = "SELECT * FROM account";
        List<Account> accountList = new ArrayList<>();


        try (Connection con = connect()) {

            preparedStatement = con.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                accountList.add( new Account(
                        resultSet.getInt("id"),
                        resultSet.getString("account_name"),
                        resultSet.getString("account_number"),
                        resultSet.getString("iban"),
                        (CurrencyType) resultSet.getObject("currency_type"),
                        resultSet.getDouble("balance")
                ));


            }

            resultSet.close();
            preparedStatement.close();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return accountList;
    }

    @Override
    public Account findById(int id) {

        String sql = "SELECT * FROM account WHERE id = ?";
        Account account = null;

        try (Connection con = connect()) {

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                account = new Account(
                        resultSet.getInt("id"),
                        resultSet.getString("account_name"),
                        resultSet.getString("account_number"),
                        resultSet.getString("iban"),
                        (CurrencyType) resultSet.getObject("currency_type"),
                        resultSet.getDouble("balance")
                );

                resultSet.close();
                preparedStatement.close();
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return account;
    }

    @Override
    public Account update(int id, Account account) {

        try (Connection con = connect()) {

            String sql = "Update account set account_name = ? , account_number = ?, iban = ?, balance = ? where id = ?";


            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, account.getAccountName());
            preparedStatement.setString(2, account.getAccountNumber());
            preparedStatement.setString(3, account.getIban());
            preparedStatement.setDouble(4, account.getBalance());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        account.setId(id);
        return account;
    }


    @Override
    public String deleteById(int id) {

        try (Connection con = connect()) {

            String sql = "DELETE FROM account WHERE id = ?";


            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,id);



            preparedStatement.executeUpdate();
            preparedStatement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return id + " id'li hesap silindi.";

    }
}
