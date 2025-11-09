import java.io.*;
import java.util.*;

public class LowStockAlert {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\srith\\OneDrive\\Documents\\java program\\inventory.txt";
        String outputFile = "C:\\Users\\srith\\OneDrive\\Documents\\java program\\low_stock_alert.txt";

        try {
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);

            String line;
            bw.write("====== LOW STOCK ALERT REPORT ======\n");
            bw.write(String.format("%-15s %-10s %-10s\n", "Product", "Stock", "Price"));
            bw.write("------------------------------------\n");

            while ((line = br.readLine()) != null) {
                // Split the line by comma
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String product = parts[0].trim();
                    int stock = Integer.parseInt(parts[1].trim());
                    double price = Double.parseDouble(parts[2].trim());

                    // Check for low stock
                    if (stock < 5) {
                        bw.write(String.format("%-15s %-10d %-10.2f\n", product, stock, price));
                    }
                }
            }

            bw.write("------------------------------------\n");
            bw.write("End of Report.\n");

            br.close();
            bw.close();

            System.out.println("✅ Low stock alert report generated successfully in " + outputFile);

        } catch (FileNotFoundException e) {
            File f = new File(inputFile);
            System.out.println("Error: Input file not found at " + f.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error: Problem reading or writing file!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid data format in file!");
        }
    }
}
