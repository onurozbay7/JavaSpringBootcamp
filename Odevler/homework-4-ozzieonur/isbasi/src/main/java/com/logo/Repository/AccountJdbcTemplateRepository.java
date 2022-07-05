package com.logo.Repository;

import com.logo.Model.Account;
import com.logo.Model.enums.CurrencyType;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountJdbcTemplateRepository implements IDao<Account,Integer> {

    private static int i=1;
    @Autowired
    JdbcTemplate jdbcTemplate;



    @Override
    public Account save(Account account) {
        String sql = "Insert INTO account (id,account_name,account_number,balance,iban) VALUES(?,?,?,?,?)";
        account.setId(i++);

        jdbcTemplate.update(sql , account.getId(), account.getAccountName(), account.getAccountNumber(), account.getBalance(),account.getIban());

        return account;
    }

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query("SELECT * FROM account", BeanPropertyRowMapper.newInstance(Account.class));
    }

    @Override
    public Account findById(int id) {
        try {
            Account account = jdbcTemplate.queryForObject("SELECT * FROM account WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Account.class), id);
            return account;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public Account update(int id, Account account) {
        String sql = "Update account set account_name = ? , account_number = ?, iban = ?, balance = ? where id = ?";

        jdbcTemplate.update(sql, account.getAccountName(),account.getAccountNumber(),account.getIban(),account.getBalance(), id);
        account.setId(id);
        return account;
    }

    @Override
    public String deleteById(int id) {
        String sql = "DELETE FROM account WHERE id = ?";
        jdbcTemplate.update(sql, id);

        return id + " id'li hesap silindi.";
    }


}
