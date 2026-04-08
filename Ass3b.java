public class Ass3b {

    static class Hillstations {
        void famousfood() {
            System.out.println("Hill station famous food");
        }

        void famousfor() {
            System.out.println("Hill station is famous for its beauty");
        }
    }

    static class Manali extends Hillstations {
        @Override
        void famousfood() {
            System.out.println("Manali is famous for Siddu");
        }

        @Override
        void famousfor() {
            System.out.println("Manali is famous for snow mountains");
        }
    }

    static class Shimla extends Hillstations {
        @Override
        void famousfood() {
            System.out.println("Shimla is famous for Chana Madra");
        }

        @Override
        void famousfor() {
            System.out.println("Shimla is famous for Mall Road");
        }
    }

    static class Darjeeling extends Hillstations {
        @Override
        void famousfood() {
            System.out.println("Darjeeling is famous for momos");
        }

        @Override
        void famousfor() {
            System.out.println("Darjeeling is famous for tea gardens");
        }
    }

    public static void main(String[] args) {

        Hillstations h;

        h = new Manali();
        h.famousfood();
        h.famousfor();

        h = new Shimla();
        h.famousfood();
        h.famousfor();

        h = new Darjeeling();
        h.famousfood();
        h.famousfor();
    }
}