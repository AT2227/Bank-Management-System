/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgfinal.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static pkgfinal.project.Account.createRandomAccountNumber;


public class ModifyAccount 
{
    public static String accountNumber;
    
    public static void accountnumber(String accNumber){
        accountNumber = accNumber;
        System.out.println(accountNumber);
    }
    
        public static void ModifyAccount(String accName, String email, String phoneNum) throws FileNotFoundException, IOException
    {
        
        ArrayList<String> allAccounts = new ArrayList<String>();
        File f = new File("accounts.txt");
        Scanner scan = new Scanner(f);
        int i = 0;
        int index = 0;
        while(scan.hasNextLine())
        {
            allAccounts.add(scan.nextLine());
        }
        
        for(i = 0; i < allAccounts.size(); i++)
        {
            String[] accountDetails = allAccounts.get(i).split(",");
            String accountNumberFromFile = accountDetails[0]; 
            
            if (accountNumberFromFile.equals(accountNumber)) 
            {
            accountDetails[1] = accName;
            accountDetails[2] = email;
            accountDetails[4] = phoneNum; 
            String modifyedAcc = accountDetails[0] + "," + accountDetails[1] 
                    + "," + accountDetails[2] + "," + accountDetails[3]
                    + "," + accountDetails[4] + "," + accountDetails[5]
                    + "," + accountDetails[6]; 
            allAccounts.set(index, modifyedAcc);     
            break;  
            }
            index++; 
        } 
     
        FileWriter writer = new FileWriter("accounts.txt");
        for (i = 0; i < allAccounts.size(); i++) 
        { 
             writer.write(allAccounts.get(i) + "\n");
        }
        writer.close();
    }  
}
  
        