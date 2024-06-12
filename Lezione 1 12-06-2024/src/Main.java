public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        String ma = "Ma";
        double uno = 1.23;
        String rio = ma + "rio";
        System.out.println(rio);
        rio += " Mario";
        System.out.println(rio);

        System.out.printf("Hello %f\n", uno);

        Rettangolo rettangolo = new Rettangolo(3, 7);
//        System.out.printf("\nRettangolo\nArea: %.2f\nPerimetro %.2f\n", rettangolo.getArea(), rettangolo.getPerimetro());
        System.out.println("\nRettangolo:\n" + rettangolo);

        Triangolo triangolo = new Triangolo(3, 7);
//        System.out.printf("\nTriangolo\nArea: %.2f\nPerimetro %.2f\n", triangolo.getArea(), triangolo.getPerimetro());
        System.out.println("\nTriangolo:\n" + triangolo);
    }
}