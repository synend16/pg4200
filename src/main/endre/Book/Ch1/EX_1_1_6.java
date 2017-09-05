package Book.Ch1;

public class EX_1_1_6 {


    public EX_1_1_6(){
        test();
    }

    public void test(){
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

    public static void main(String[] args) {
        EX_1_1_6 ex = new EX_1_1_6();
    }

}
