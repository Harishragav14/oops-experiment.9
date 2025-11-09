import java.io.File;
import java.io.IOException; import java.util.Scanner;

public class Question_1 {

public static void main(String[] args) { Scanner sc = new Scanner(System.in); int choice;

do {
System.out.println("\n----- FILE HANDLING OPERATIONS	");
System.out.println("1. Create a new file"); System.out.println("2. Rename a file"); System.out.println("3. Delete a file"); System.out.println("4. Create a directory"); System.out.println("5. Find absolute path of a file");
System.out.println("6. Display all file names of a directory"); System.out.println("7. Exit");
System.out.print("Enter your choice: ");
while (!sc.hasNextInt()) { sc.next(); System.out.print("Enter a number: "); }
choice = sc.nextInt(); sc.nextLine(); 

switch (choice) {
case 1: { 
File f = new File(name); try {
if (f.createNewFile()) {
System.out.println("File created: " + f.getName());
} else {
System.out.println("File already exists.");
 e.getMessage()); 
}
} catch (IOException e) { System.out.println("Error creating file: " +
 
}
break;
 
}
case 2: { // Rename file
System.out.print("Enter existing file name: "); String oldName = sc.nextLine(); System.out.print("Enter new file name: "); String newName = sc.nextLine();
File from = new File(oldName); File to = new File(newName); if (!from.exists()) {
System.out.println("Source file not found.");
} else if (to.exists()) {
System.out.println("Destination name already exists.");
} else if (from.renameTo(to)) { System.out.println("File renamed successfully.");
} else {
System.out.println("Unable to rename file.");
}
break;
}
case 3: { // Delete file
System.out.print("Enter file name to delete: "); String name = sc.nextLine();
File f = new File(name); if (!f.exists()) {
System.out.println("File not found.");
} else if (f.delete()) { System.out.println("File deleted.");
} else {
System.out.println("Failed to delete file.");
}
break;
}
case 4: { // Create directory
System.out.print("Enter directory name to create: "); String dir = sc.nextLine();
File d = new File(dir); if (d.exists()) {
System.out.println("Directory already exists.");
} else if (d.mkdir()) { System.out.println("Directory created.");
} else {
System.out.println("Unable to create directory.");
}
 
break;
}
case 5: { // Absolute path
System.out.print("Enter file name to find path: "); String name = sc.nextLine();
File f = new File(name);
System.out.println("Absolute Path: " + f.getAbsolutePath()); break;
 directory.");
 
}
case 6: { // List files in directory System.out.print("Enter directory name: "); String dir = sc.nextLine();
File d = new File(dir); String[] list = d.list(); if (list == null) {
System.out.println("Directory not found or not a

} else if (list.length == 0) { System.out.println("Directory is empty.");
} else {
System.out.println("Files in directory:"); for (String s : list) System.out.println(s);
 
}
break;
}
case 7:
System.out.println("Exiting..."); break;

default:
System.out.println("Invalid choice. Try again.");
}
} while (choice != 7);

sc.close();
}
}
