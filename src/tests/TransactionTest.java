package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Transaction;

public class TransactionTest {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse("01-02-2024");
        
        Transaction testTransaction = new Transaction("45", 100, date);

        System.out.println(testTransaction);
    }
    
}
