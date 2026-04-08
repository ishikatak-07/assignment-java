import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ass4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter employee ID: ");
            int empId = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter employee name: ");
            String empName = sc.nextLine();

            System.out.print("Enter employee salary: ");
            double salary = sc.nextDouble();

            
            FileWriter writer = new FileWriter("employee.txt");
            writer.write("Employee ID: " + empId + "\n");
            writer.write("Employee Name: " + empName + "\n");
            writer.write("Salary: " + salary);
            writer.close();

            System.out.println("\nEmployee details written successfully.\n");

            
            FileReader reader = new FileReader("employee.txt");
            int ch;

            System.out.println("Employee details from file:");

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }

            reader.close();
        }
        catch (IOException e) {
            System.out.println("Error occurred while handling the file.");
            System.out.println(e.getMessage());
        }
        finally {
            sc.close();
            System.out.println("\nFile operation completed.");
        }
    }
}