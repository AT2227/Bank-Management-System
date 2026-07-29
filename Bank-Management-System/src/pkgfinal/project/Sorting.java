package pkgfinal.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Sorting {

    static String filepath = "accounts.txt";

    private int number;

    Sorting(int number) {
        this.number = number;
    }

    public static List<String> sortingByNames() {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(filepath));
            Collections.sort(lines, new Comparator<String>() {
                @Override
                public int compare(String line1, String line2) {
                    String[] details1 = line1.split(",");
                    String[] details2 = line2.split(",");
                    return details1[1].compareTo(details2[1]);
                }
            });

        } catch (IOException e) {
            System.out.println("Error occured while reading file");
        }
        return lines;
    }

    public static List<String> sortingByBalance() {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(filepath));
            Collections.sort(lines, new Comparator<String>() {
                @Override
                public int compare(String line1, String line2) {
                    String[] details1 = line1.split(",");
                    String[] details2 = line2.split(",");
                    double balance1 = Double.parseDouble(details1[3]);
                    double balance2 = Double.parseDouble(details2[3]);
                    return Double.compare(balance1, balance2);
                }
            });
        } catch (IOException e) {
            System.out.println("Error occured while reading file");
        }
        return lines;
    }

    public static List<String> sortingByDateOpened() {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(filepath));
            Collections.sort(lines, new Comparator<String>() {
                @Override
                public int compare(String line1, String line2) {
                    String[] details1 = line1.split(",");
                    String[] details2 = line2.split(",");
                    String date1 = details1[5];
                    String date2 = details2[5];
                    return date1.compareTo(date2);
                }
            });

        } catch (IOException e) {
            System.out.println("Error occured while reading file");
        }
        return lines;
    }

}
