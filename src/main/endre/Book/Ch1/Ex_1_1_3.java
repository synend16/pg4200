package Book.Ch1;

public class Ex_1_1_3 {

    public Ex_1_1_3(int a, int b, int c){
        testIfEqual(a,b,c);
    }

    public void testIfEqual(int a, int b, int c){
        if (a == b && a == c){
            System.out.println("equal");
        }
        else System.out.println("not equal");
    }
}
