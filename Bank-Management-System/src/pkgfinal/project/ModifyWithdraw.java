package pkgfinal.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static pkgfinal.project.Account.createRandomAccountNumber;

public class ModifyWithdraw {

 
    public static void WithdrawCurrent(String amountWithdrawed, String accnum) throws FileNotFoundException, IOException {

        ArrayList<String> allAccounts = new ArrayList<String>();
        File f = new File("accounts.txt");
        Scanner scan = new Scanner(f);
        int i = 0;
        int index = 0;
        while (scan.hasNextLine()) {
            allAccounts.add(scan.nextLine());
        }

        for (i = 0; i < allAccounts.size(); i++) {
            String[] accountDetails = allAccounts.get(i).split(",");
            String accountNumberFromFile = accountDetails[0];
            String accountTypeFromFile = accountDetails[6];
            String current = "[Current]";
            System.out.println("accountNumberFromFile = " + accountNumberFromFile);
           
            System.out.println("before if");
   
            System.out.println("accountNumber = " + accnum);
            
            System.out.println("current = " + current);
          
            if ( (accountNumberFromFile.equals(accnum)) && ( accountTypeFromFile.compareTo(current) == 1 )  ) {
                
                System.out.println("Inside if current");
                
                double total = Double.parseDouble(accountDetails[3]) - Double.parseDouble(amountWithdrawed) - 10.0;

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
    
    
    
    
    public static void WithdrawSavings(String amountWithdrawed, String accnum) throws FileNotFoundException, IOException {

        ArrayList<String> allAccounts = new ArrayList<String>();
        File f = new File("accounts.txt");
        Scanner scan = new Scanner(f);
        int i = 0;
        int index = 0;
        while (scan.hasNextLine()) {
            allAccounts.add(scan.nextLine());
        }

        for (i = 0; i < allAccounts.size(); i++) {
            String[] accountDetails = allAccounts.get(i).split(",");
            String accountNumberFromFile = accountDetails[0];
            String accountTypeFromFile = accountDetails[6];
            String current = "[Current]";
            
            System.out.println("accountNumberFromFile = " + accountNumberFromFile);
           
            System.out.println("before if");
   
            System.out.println("accountNumber = " + accnum);
            
            System.out.println("current = " + current);
          
            if ( (accountNumberFromFile.equals(accnum)) && ( accountTypeFromFile.compareTo(current) == 1 )  ) {
                
                System.out.println("Inside if savings");
                
                double total = Double.parseDouble(accountDetails[3]) - Double.parseDouble(amountWithdrawed);

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
