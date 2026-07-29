package pkgfinal.project;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplyInterest {

    public static void doApplyInterest() throws Exception {
        ArrayList<String> allAccounts = new ArrayList<>();
        File f = new File("accounts.txt");
        Scanner scan = new Scanner(f);

        // Read all accounts from the file
        while (scan.hasNextLine()) {
            allAccounts.add(scan.nextLine());
        }
        scan.close();

        // Current date to compare with account creation date
        LocalDate currentDate = LocalDate.now();

        // Loop through each account
        for (int index = 0; index < allAccounts.size(); index++) {
            String[] accountDetails = allAccounts.get(index).split(",");

            // Extract account details
            String accountType = accountDetails[6].trim();
            String accountCreationDateString = accountDetails[5].trim();
            double accountBalance = Double.parseDouble(accountDetails[3].trim());

            // Parse account creation date
            String[] accountDateParts = accountCreationDateString.split("-");
            int accountYear = Integer.parseInt(accountDateParts[0]);
            int accountMonth = Integer.parseInt(accountDateParts[1]);

            LocalDate accountCreationDate = LocalDate.of(accountYear, accountMonth, 1);

            // Only apply interest to Savings accounts older than 4 months
            if (accountType.equals("[Savings]")) {
                long monthsDifference = ChronoUnit.MONTHS.between(accountCreationDate, currentDate);
                if (monthsDifference >= 4) {
                    // Apply 5% interest
                    double interest = accountBalance * 0.05;
                    double newBalance = accountBalance + interest;

                    // Update account balance
                    accountDetails[3] = String.valueOf(newBalance);

                    // Reconstruct the modified account string
                    String modifiedAccount = String.join(",", accountDetails);
                    allAccounts.set(index, modifiedAccount);

                    // Print logs for debugging
                    System.out.println("Account: " + accountDetails[1]);
                    System.out.println("Old Balance: " + accountBalance);
                    System.out.println("New Balance: " + newBalance);
                }
            }
        }

        // Write the updated account details back to the file
        try (FileWriter writer = new FileWriter("accounts.txt")) {
            for (String account : allAccounts) {
                writer.write(account + "\n");
            }
        }
    }
}
