package pkgfinal.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CloseAccount {

    public static int CloseAccount(String accnum) throws FileNotFoundException, IOException {

        ArrayList<String> allAccounts = new ArrayList<String>();
        File f = new File("accounts.txt");
        Scanner scan = new Scanner(f);
        int i = 0;
        int index = 0;
        int flag = 0;
        while (scan.hasNextLine()) {
            allAccounts.add(scan.nextLine());
        }

        for (i = 0; i < allAccounts.size(); i++) {
            String[] accountDetails = allAccounts.get(i).split(",");
            String accountNumberFromFile = accountDetails[0];
            String AccountBalanceFromFile = accountDetails[3];

            double Balance = Double.parseDouble(AccountBalanceFromFile);

            if (accountNumberFromFile.equals(accnum) && (Balance == 0)) {
                flag = 1;
                allAccounts.remove(index);
                break;
            }
            index++;
        }

        FileWriter writer = new FileWriter("accounts.txt");
        for (i = 0; i < allAccounts.size(); i++) {
            writer.write(allAccounts.get(i) + "\n");
        }
        writer.close();
        if(flag == 1)
            return 1;
        else 
            return 0;
    }
}

