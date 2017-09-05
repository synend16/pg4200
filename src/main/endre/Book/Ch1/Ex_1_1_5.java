package Book.Ch1;

public class Ex_1_1_5 {

    public Ex_1_1_5(double x, double y){
        testIfBetweenZeroAndOne(x, y);
    }


    public void testIfBetweenZeroAndOne(double x, double y){
        if ((x < 1 && x > 0) && (y < 1 && y > 0)){
            System.out.println("true");
        }
        else System.out.println("false");
    }

    public static void main(String[] args) {
        Ex_1_1_5 ex = new Ex_1_1_5(0.5, 0.2);
    }
}
