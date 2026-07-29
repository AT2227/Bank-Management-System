 package pkgfinal.project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class ViewAccounts 
{

    static String filepath = "accounts.txtG";

    public static void viewAccountsWithScanner() 
    {
        try (Scanner scanner = new Scanner(new File(filepath))) 
        {
            while (scanner.hasNextLine()) 
            {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) 
        {
            System.out.println("File not found !");
        }
    }

    /* Learing part 
    
    Key Features of DefaultTableModel
    Data Storage:

    It stores the data in a 2D array (rows and columns), making it easy to set and retrieve data for the table.
    Column Names:

    You can define column names as an array of strings, which will be displayed as the headers in the JTable.
    Modifying Data:

    You can add, remove, or modify data within the DefaultTableModel using methods like addRow(), removeRow(), and setValueAt(). These changes are automatically reflected in the JTable.
    Editable/Non-Editable:

    By default, DefaultTableModel allows editing of cells in the table, but you can customize it to make the table non-editable if needed
    
    Methods of DefaultTableModel
        addRow(Object[] rowData): Adds a new row of data to the table.
        removeRow(int row): Removes a row from the model.
        setValueAt(Object aValue, int row, int column): Updates a specific cell in the table.
        getValueAt(int row, int column): Retrieves the value of a specific cell in the table 
     */
    public static void viewAccountsList() 
    {
        try 
        {
            //It reads all lines from a file and returns them as a List<String>. 
            //Each element in the list represents a single line from the file. The lines are read in sequence
            //, starting from the first line.
            List<String> lines = Files.readAllLines(Paths.get(filepath));
            for (String line : lines) 
            {
                String accountDetails[] = line.split(",");
                String accNo = accountDetails[0];
                String name= accountDetails[1];           
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error occured while reading file");
        }

    }

}
