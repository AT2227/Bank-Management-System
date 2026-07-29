/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgfinal.project;


public class NewAccount 
{
    private String NewAccountNumber;
    private String NewAccountName;
    private String NewAccountMobile;
    private String NewAccountEmail;
    private double NewAccountBalance = 0;
    private String NewAccountOpenedDate;
    private String NewAccountType;
   
    
    public NewAccount(String NewAccountNumber, String NewAccountName, String NewAccountMobile, String NewAccountEmail, String NewAccountOpenedDate, String NewAccountType) {
        this.NewAccountNumber = NewAccountNumber;
        this.NewAccountName = NewAccountName;
        this.NewAccountMobile = NewAccountMobile;
        this.NewAccountEmail = NewAccountEmail;
        this.NewAccountOpenedDate = NewAccountOpenedDate;
        this.NewAccountType = NewAccountType;
    }

//----------------------Getters-----------------------------------    
    
    public String getNewAccountNumber() {
        return NewAccountNumber;
    }

    public String getNewAccountName() {
        return NewAccountName;
    }

    public String getNewAccountMobile() {
        return NewAccountMobile;
    }

    public String getNewAccountEmail() {
        return NewAccountEmail;
    }

    public double getNewAccountBalance() {
        return NewAccountBalance;
    }

    public String getNewAccountOpenedDate() {
        return NewAccountOpenedDate;
    }

    public String getNewAccountType() {
        return NewAccountType;
    }

    
//----------------------Setters-----------------------------------
    
    public void setNewAccountNumber(String NewAccountNumber) {
        this.NewAccountNumber = NewAccountNumber;
    }

    public void setNewAccountName(String NewAccountName) {
        this.NewAccountName = NewAccountName;
    }

    public void setNewAccountMobile(String NewAccountMobile) {
        this.NewAccountMobile = NewAccountMobile;
    }

    public void setNewAccountEmail(String NewAccountEmail) {
        this.NewAccountEmail = NewAccountEmail;
    }

    public void setNewAccountBalance(double NewAccountBalance) {
        this.NewAccountBalance = NewAccountBalance;
    }

    public void setNewAccountOpenedDate(String NewAccountOpenedDate) {
        this.NewAccountOpenedDate = NewAccountOpenedDate;
    }

    public void setNewAccountType(String NewAccountType) {
        this.NewAccountType = NewAccountType;
    }
    
    
    
    
    
}

