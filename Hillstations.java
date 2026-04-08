class Hillstations {
    void famousfor() {
        System.out.println("Hillstation is famous for scenic beauty.");
    }

    void famousfood() {
        System.out.println("Hillstation has local traditional food.");
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        Hillstations h;  // Parent class reference

        System.out.println("=== Hillstations Information ===");
        System.out.println("1. Manali");
        System.out.println("2. Mussoorie");
        System.out.println("3. Darjeeling");
        System.out.print("Enter your choice (1-3): ");
        
        int choice = sc.nextInt();
        System.out.println();

        switch(choice) {
            case 1:
                h = new Manali();
                h.famousfor();
                h.famousfood();
                break;
            case 2:
                h = new Mussoorie();
                h.famousfor();
                h.famousfood();
                break;
            case 3:
                h = new Darjeeling();
                h.famousfor();
                h.famousfood();
                break;
            default:
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
        }

        sc.close();
    }
}

// Subclass 1
class Manali extends Hillstations {
    void famousfor() {
        System.out.println("Manali is famous for snow and adventure sports.");
    }

    void famousfood() {
        System.out.println("Manali famous food: Siddu.");
    }
}

// Subclass 2
class Mussoorie extends Hillstations {
    void famousfor() {
        System.out.println("Mussoorie is famous for hills and waterfalls.");
    }

    void famousfood() {
        System.out.println("Mussoorie famous food: Momos.");
    }
}

// Subclass 3
class Darjeeling extends Hillstations {
    void famousfor() {
        System.out.println("Darjeeling is famous for tea gardens.");
    }

    void famousfood() {
        System.out.println("Darjeeling famous food: Thukpa.");
    }
}
