package ex02;
import java.util.Random;

public class BigONotation {

    public void printNames1() {
        int [] array = new int[1_000_0000];

        Random random = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000) + 1;
        }


        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            System.out.println(sum);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("This print took " + (endTime - startTime) + " milli seconds");
    }

    public static void main(String[] args) {
        BigONotation bigONotation = new BigONotation();
        bigONotation.printNames1();
    }
}
