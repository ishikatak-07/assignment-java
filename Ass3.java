import java.util.Scanner;

class Shapes {
    double length, breadth, radius;

    Shapes() {
        length = breadth = radius = 0;
    }

    Shapes(double l, double b) {   
        length = l;
        breadth = b;
    }

    Shapes(double r) {   
        radius = r;
    }

    // Method Overloading
    double area(double l, double b) {
        return l * b;   
    }

    double area(double r) {
        return Math.PI * r * r;   
    }
}


class Triangle extends Shapes {
    @Override
    double area(double b, double h) {
        return 0.5 * b * h;
    }
}

public class Ass3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length of rectangle: ");
        double length = sc.nextDouble();

        System.out.print("Enter breadth of rectangle: ");
        double breadth = sc.nextDouble();

        Shapes rect = new Shapes(length, breadth);
        System.out.println("Area of Rectangle: " + rect.area(length, breadth));


        System.out.print("Enter radius of circle: ");
        double radius = sc.nextDouble();

        Shapes circle = new Shapes(radius);
        System.out.println("Area of Circle: " + circle.area(radius));


        System.out.print("Enter base of triangle: ");
        double base = sc.nextDouble();

        System.out.print("Enter height of triangle: ");
        double height = sc.nextDouble();

        Shapes tri = new Triangle();
        System.out.println("Area of Triangle: " + tri.area(base, height));

        sc.close();
    }
}