package pkgfinal.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static pkgfinal.project.Account.createRandomAccountNumber;

public class ModifyTransfer {

    public static void Transfer(String amountToBeTransfered, String SenderAccNum, String ReciverAccNum) throws FileNotFoundException, IOException {

        ArrayList<String> allAccounts = new ArrayList<String>();
        File f = new File("accounts.txt");
        Scanner scan = new Scanner(f);
        int i = 0;
        int index = 0;
        while (scan.hasNextLine()) {
            allAccounts.add(scan.nextLine());
        }

//--------------------------Sender-----------------------------      
        for (i = 0; i < allAccounts.size(); i++) {
            String[] accountDetails = allAccounts.get(i).split(",");
            String SenderAccountNumberFromFile = accountDetails[0];
            String accountTypeFromFile = accountDetails[6];
            String current = "[Current]";

            System.out.println("accountNumberFromFile sender = " + SenderAccountNumberFromFile);
            System.out.println("accountNumberFromFile reciver = " + ReciverAccNum);

            System.out.println("before if");

            System.out.println("Sender accountNumber = " + SenderAccNum);
            System.out.println("reciver accountNumber = " + ReciverAccNum);

            System.out.println("current = " + current);

            if ((SenderAccountNumberFromFile.equals(SenderAccNum))) {

                System.out.println("Inside if");

                if (accountTypeFromFile.compareTo(current) == 1) {
                    double total = Double.parseDouble(accountDetails[3]) - Double.parseDouble(amountToBeTransfered) - 10.0;
                    System.out.println("total = " + total);
                    accountDetails[3] = String.valueOf(total);

                } else {
                    double total = Double.parseDouble(accountDetails[3]) - Double.parseDouble(amountToBeTransfered);
                    System.out.println("total = " + total);
                    accountDetails[3] = String.valueOf(total);
                }

                String modifyedAcc = accountDetails[0] + "," + accountDetails[1]
                        + "," + accountDetails[2] + "," + accountDetails[3]
                        + "," + accountDetails[4] + "," + accountDetails[5]
                        + "," + accountDetails[6];
                allAccounts.set(index, modifyedAcc);
                break;
            }
            index++;

            System.out.println("Outside if, index = " + index);
        }

//-----------------------------Reciver-------------------------------      
        index = 0;
        for (i = 0; i < allAccounts.size(); i++) {
            String[] accountDetails = allAccounts.get(i).split(",");
            String ReciverAccountNumberFromFile = accountDetails[0];
            String accountTypeFromFile = accountDetails[6];

            System.out.println("accountNumberFromFile sender = " + ReciverAccountNumberFromFile);
            System.out.println("accountNumberFromFile reciver = " + ReciverAccNum);

            System.out.println("before if");

            System.out.println("Sender accountNumber = " + SenderAccNum);
            System.out.println("reciver accountNumber = " + ReciverAccNum);

            if ((ReciverAccountNumberFromFile.equals(ReciverAccNum))) {

                System.out.println("Inside if");

                double total = Double.parseDouble(accountDetails[3]) + Double.parseDouble(amountToBeTransfered);
                System.out.println("total = " + total);
                accountDetails[3] = String.valueOf(total);

                String modifyedAcc = accountDetails[0] + "," + accountDetails[1]
                        + "," + accountDetails[2] + "," + accountDetails[3]
                        + "," + accountDetails[4] + "," + accountDetails[5]
                        + "," + accountDetails[6];
                allAccounts.set(index, modifyedAcc);
                break;
            }
            index++;

            System.out.println("Outside if, index = " + index);

        }
        FileWriter writer = new FileWriter("accounts.txt");
        for (i = 0; i < allAccounts.size(); i++) {
            writer.write(allAccounts.get(i) + "\n");
        }
        writer.close();
    }
}
