package pkgfinal.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginVerification 
{

    public static boolean verifyUsername(String username, String password) throws Exception {
        File f = new File("users.txt");
        Scanner scan = new Scanner(f);
        int i = 0;
        String[] users = new String[5];
        while (scan.hasNextLine()) {
            users[i] = scan.nextLine();
            i++;
        }
        String[] usernameAndPasswords1 = users[0].split(" ");
        String[] usernameAndPasswords2 = users[1].split(" ");
        String[] usernameAndPasswords3 = users[2].split(" ");
        String[] usernameAndPasswords4 = users[3].split(" ");
        String[] usernameAndPasswords5 = users[4].split(" ");
        String[] allUsersAndPasswords = {usernameAndPasswords1[0], usernameAndPasswords1[1],
                                         usernameAndPasswords2[0], usernameAndPasswords2[1],
                                         usernameAndPasswords3[0], usernameAndPasswords3[1],
                                         usernameAndPasswords4[0], usernameAndPasswords4[1],
                                         usernameAndPasswords5[0], usernameAndPasswords5[1]};

        for (i = 0; i < 10; i += 2) {
            if (username.equalsIgnoreCase(allUsersAndPasswords[i]) && password.equals(allUsersAndPasswords[i + 1])) {
                HomeScreenJFrame homeScreenJFrame = new HomeScreenJFrame();
                homeScreenJFrame.setVisible(true);
                return true;
            }
        }
        return false;
    }

    public static void login() 
    {
        try 
        {
            List<String> usersCredentials = Files.readAllLines(Paths.get("users.txt"));
            for (String usernamePassword : usersCredentials) 
            {
                String[] data = usernamePassword.split(" ");
                if (data.length == 2) {
                    String username = data[0];
                    String password = data[1];
                  
                }
            }
        } catch (IOException e) 
        {
            System.out.println("File not found");
        }
    }
}
