package pkgfinal.project;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static pkgfinal.project.Account.createRandomAccountNumber;

public class AddNewAccount {

    public static void AddNewAccount(String name, String email, String PhoneNum, String s) throws Exception {
        LocalDate currentdate = LocalDate.now(); // format YY-MM-DD
        LocalDateTime currentTime = LocalDateTime.now();

        ArrayList<String> database = new ArrayList<String>();

        File f = new File("accounts.txt");
        Scanner reader = new Scanner(f);
        while (reader.hasNextLine()) {
            database.add(reader.nextLine());
        }

        database.add(createRandomAccountNumber() + ","
                + name + ","
                + email + ","
                + 0 + ","
                + PhoneNum + ","
                + currentdate + ","
                + s);

        reader.close();

        FileWriter writer = new FileWriter("accounts.txt");
        for (int i = 0; i < database.size(); i++) {
            writer.write(database.get(i) + "\n");
        }

        writer.close();

    }
}
