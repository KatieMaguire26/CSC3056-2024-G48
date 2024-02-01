package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Account;

public class AccountTest {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse("01-02-2024");

        Account testAccount = new Account("45", "mike", "Standard", date);

        System.out.println(testAccount);
    }
}
