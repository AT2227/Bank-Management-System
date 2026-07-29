package pkgfinal.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import static pkgfinal.project.SearchAccountsJFrame.filepath;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transaction {

    LocalDateTime currentTime = LocalDateTime.now();
    static String filepath = "transactionHistory.txt";

    public static int createAccountFile(String accountNumber) {
        String filename = accountNumber + ".txt";
        File file = new File(filename);
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("File Created: " + file.getName());
                    return 1;
                } else {
                    System.out.println("Can't create file !");
                    return 0;
                }
            } else {
                System.out.println("File already exists !");
                return 1;
            }
        } catch (IOException e) {
            System.out.println("Error while processing file");
        }
        return 0;
    }

    // this function is used to withdraw add balance make transaction (operations)
    public static void AddTransactionInfo(String type, String amount, String accNo, String DateOfOperation) {
        String[] lineDetails = {"", "", "", "", ""};
        switch (type) {
            case "deposit":
                lineDetails[1] = "Deposit";
                break;
            case "withdraw":
                lineDetails[1] = "Withdraw";
                break;
            case "transfersender":
                lineDetails[1] = "Transfer Sender";
                break;
            case "transferreceiver":
                lineDetails[1] = "Transfer Receiver";
                break;
            default:
                System.out.println("no such operation");
        }
        lineDetails[0] = accNo;
        if (type.equals("transfersender")||type.equals("withdraw")) {
            lineDetails[2] = "-" + amount;
        } else {
            lineDetails[2] = "+" + amount;
        }
        lineDetails[3] = DateOfOperation;
        lineDetails[4] = type + " " + lineDetails[2];
        String transactionDetials = String.join(",", lineDetails);
        if (createAccountFile(accNo) == 1) {
            try {
                String filename = accNo + ".txt";
                File file = new File(filename);
                List<String> linesFromFile = Files.readAllLines(Path.of(filename));
                linesFromFile.add(transactionDetials);
                Files.write(Path.of(filename), linesFromFile, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

            } catch (IOException e) {
                System.out.println("Error while writting to file");
            }

        } else {
            System.out.println("Error while creating file");
        }
    }

    public static void DispalyTransactionHistory(String accountnumbe) {
        String fileName = accountnumbe + ".txt";
        List<String> linesfromFile = new ArrayList<>();
        try {
            linesfromFile = Files.readAllLines(Path.of(fileName)); //read lines from transaction history
        } catch (IOException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        TransactionHistoryJFrame transactionHistoryJFrame = new TransactionHistoryJFrame();
        DefaultTableModel model = (DefaultTableModel) transactionHistoryJFrame.getTransactionHistoryjTable().getModel();
        for (String line : linesfromFile) {
            String lineDetails[] = line.split(",");
            String accNo = lineDetails[0];
            String transactionType = lineDetails[1];
            String Amount = lineDetails[2];
            String Date = lineDetails[3];
            String Description = lineDetails[4];
            model.addRow(new Object[]{accNo, transactionType, Amount, Date, Description});
        }
        transactionHistoryJFrame.setVisible(true);
    }

}
