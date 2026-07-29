package pkgfinal.project;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Account 
{
    private String accountNumber;
    private String accountName;
    private String accountMobile;
    private String accountEmail;
    private double accountBalance;
    private String accountOpenedDate;
    private String accountType;

    public Account(String accountNumber,String accountName,String accountMobile,String accountEmail,double accountBalance,String accountOpenedDate,String accountType) 
    {
        setAccountNumber(accountNumber);
        setAccountName(accountName);
        setAccountMobile(accountMobile);
        setAccountEmail(accountEmail);
        setAccountBalance(accountBalance);
        setAccountBalance(accountBalance);
        setAccountOpenedDate(accountOpenedDate);
        setAccountType(accountType);
    }
    //----------------------------------------Setters----------------------------------------//
    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber=accountNumber;
    }
    public void setAccountName(String accountName)
    {
        this.accountName=accountName;
    }
    public void setAccountMobile(String accountMobile)
    {
        this.accountMobile=accountMobile;
    }
    public void setAccountEmail(String accountEmail)
    {
        this.accountEmail=accountEmail;
    }
    public void setAccountBalance(double accountBalance)
    {
        this.accountBalance=accountBalance;
    }
    public void setAccountOpenedDate(String accountOpenedDate)
    {
        this.accountOpenedDate=accountOpenedDate;
    }
    public void setAccountType(String accountType)
    {
        this.accountType=accountType;
    }
    //----------------------------------------Getters----------------------------------------//
    public String getAccountNumber()
    {
        return this.accountNumber;
    }
    public String getAccountName()
    {
        return this.accountName;
    }
    public String getAccountMobile()
    {
        return this.accountMobile;
    }
    public String getAccountEmail()
    {
        return this.accountEmail;
    }
    public double getAccountBalance()
    {
        return this.accountBalance;
    }
    public String getAccountOpenedDate()
    {
        return this.accountOpenedDate;
    }
    public String getAccountType()
    {
        return this.accountType;
    }
    //-------------------------------------Creating an Account-------------------------------------//
    public static String createRandomAccountNumber()
    {
        Random random=new Random(); //creating a random number
        StringBuilder tempAccountNumber=new StringBuilder();
        for(int i=0;i<10;i++) 
        {
            tempAccountNumber.append(random.nextInt(10)); 
            //TODO: check with database that all numbers unique
        }
        return tempAccountNumber.toString();
    }
    public static void createAccount()
    {
        String tempAccountNumber=createRandomAccountNumber();
        //System.out.println(tempAccountNumber);
    }
    //----------------------------------------------------------------------------------------------//
    public static boolean validateAccountExcistance(String accountNumber) throws Exception
    {
        ArrayList<String> allAccounts=new ArrayList<String>();
        File f=new File("accounts.txt");
        Scanner scan= new Scanner(f);
        int i=0;
        
        while(scan.hasNextLine())
        {
            allAccounts.add(scan.nextLine());
        }
        String[] temp=new String[allAccounts.size()];

        for(i=0;i<allAccounts.size();i++)
        {
            String[] accountDetails = allAccounts.get(i).split(",");
            String accountNumberFromFile = accountDetails[0].trim(); 
            
            if (accountNumberFromFile.equals(accountNumber)) 
            {
                return true;
            }         
        }
       
        System.out.println(allAccounts.get(0));
        System.out.println(allAccounts.get(1));
        System.out.println(allAccounts.get(2));
        System.out.println(allAccounts.get(3));
       
        return false;
    }
}
