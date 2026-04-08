public class OverloadingDemo {
    static class Shapes {
        double length, breadth, radius;

        // Constructor Overloading
        Shapes(double l, double b) {   // Rectangle
            length = l;
            breadth = b;
        }

        Shapes(double r) {   // Circle
            radius = r;
        }

        Shapes() {   // Default constructor
            length = breadth = radius = 0;
        }

        // Method Overloading
        double area(double l, double b) {   // Rectangle area
            return l * b;
        }

        double area(double r) {   // Circle area
            return Math.PI * r * r;
        }

        double area(double base, double height, boolean isTriangle) {   // Triangle area
            return 0.5 * base * height;
        }
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Rectangle
        System.out.println("=== Rectangle ===");
        System.out.print("Enter length of rectangle: ");
        double length = sc.nextDouble();
        System.out.print("Enter breadth of rectangle: ");
        double breadth = sc.nextDouble();
        Shapes rect = new Shapes(length, breadth);
        System.out.println("Area of Rectangle: " + rect.area(length, breadth));

        System.out.println();

        // Circle
        System.out.println("=== Circle ===");
        System.out.print("Enter radius of circle: ");
        double radius = sc.nextDouble();
        Shapes circle = new Shapes(radius);
        System.out.println("Area of Circle: " + circle.area(radius));

        System.out.println();

        // Triangle
        System.out.println("=== Triangle ===");
        System.out.print("Enter base of triangle: ");
        double base = sc.nextDouble();
        System.out.print("Enter height of triangle: ");
        double height = sc.nextDouble();
        System.out.println("Area of Triangle: " + rect.area(base, height, true));

        sc.close();
    }
}
