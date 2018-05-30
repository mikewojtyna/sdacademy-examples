package pl.sdacademy.punkt;


public class Main {

    public static int dodaj(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Punkt punk1 = new Punkt(3,4);
        Punkt punk2 = new Punkt(6,7);
        Punkt punk3 = new Punkt(4,2);
        Punkt punk4 = new Punkt(2,3);
        Punkt punk5 = new Punkt(9,4);

        System.out.printf("Odległość p1 do p3 : %.2f , inny punkt: \n", punk1.distance(punk3), punk2.distance(punk4));
        System.out.printf("Odległość p2 do p5 : %.2f \n", punk2.distance(punk5));

        System.out.println("Suma wszystkich: " + punk1.sumX(punk2, punk3, punk4, punk5));

    }
}
