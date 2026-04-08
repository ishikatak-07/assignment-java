import java.io.*;
import java.util.*;

// Custom Exceptions
class MinimumBalanceException extends Exception {
    public MinimumBalanceException(String msg) {
        super(msg);
    }
}

class InvalidCIDException extends Exception {
    public InvalidCIDException(String msg) {
        super(msg);
    }
}

class NegativeAmountException extends Exception {
    public NegativeAmountException(String msg) {
        super(msg);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}

// Customer class
class Customer implements Serializable {
    int cid;
    String cname;
    double amount;

    public Customer(int cid, String cname, double amount) {
        this.cid = cid;
        this.cname = cname;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CID: " + cid + ", Name: " + cname + ", Balance: Rs." + amount;
    }
}

public class BankingSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Customer> customers = new ArrayList<>();
    static final String FILE_NAME = "customers.txt";

    // Save records to file
    public static void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Customer c : customers) {
                pw.println(c.cid + "," + c.cname + "," + c.amount);
            }
            System.out.println("Records saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving records: " + e.getMessage());
        }
    }

    // Load records from file
    public static void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int cid = Integer.parseInt(parts[0]);
                String cname = parts[1];
                double amount = Double.parseDouble(parts[2]);
                customers.add(new Customer(cid, cname, amount));
            }
        } catch (Exception e) {
            customers = new ArrayList<>(); // start fresh if file not found
        }
    }

    // Create account
    public static void createAccount() {
        try {
            System.out.print("Enter CID (1-20): ");
            int cid = sc.nextInt();
            if (cid < 1 || cid > 20) throw new InvalidCIDException("CID must be between 1 and 20.");

            System.out.print("Enter Name: ");
            String cname = sc.next();

            System.out.print("Enter Initial Amount: ");
            double amount = sc.nextDouble();
            if (amount < 0) throw new NegativeAmountException("Amount must be positive.");
            if (amount < 1000) throw new MinimumBalanceException("Minimum balance should be Rs.1000.");

            customers.add(new Customer(cid, cname, amount));
            System.out.println("Account created successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Deposit
    public static void deposit() {
        System.out.print("Enter CID: ");
        int cid = sc.nextInt();
        for (Customer c : customers) {
            if (c.cid == cid) {
                System.out.print("Enter deposit amount: ");
                double amt = sc.nextDouble();
                try {
                    if (amt <= 0) throw new NegativeAmountException("Amount must be positive.");
                    c.amount += amt;
                    System.out.println("Deposit successful! New Balance: Rs." + c.amount);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Customer not found!");
    }

    // Withdraw
    public static void withdraw() {
        System.out.print("Enter CID: ");
        int cid = sc.nextInt();
        for (Customer c : customers) {
            if (c.cid == cid) {
                System.out.print("Enter withdrawal amount: ");
                double amt = sc.nextDouble();
                try {
                    if (amt <= 0) throw new NegativeAmountException("Amount must be positive.");
                    if (amt > c.amount) throw new InsufficientFundsException("Insufficient balance.");
                    c.amount -= amt;
                    System.out.println("Withdrawal successful! New Balance: Rs." + c.amount);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Customer not found!");
    }

    // Display all customers
    public static void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Customer c : customers) {
                System.out.println(c);
            }
        }
    }

    // Main menu
    public static void main(String[] args) {
        loadFromFile();
        int choice;
        do {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Customers");
            System.out.println("5. Save & Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: displayCustomers(); break;
                case 5: saveToFile(); System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}
