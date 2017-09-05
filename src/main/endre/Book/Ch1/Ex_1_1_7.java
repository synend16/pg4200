package Book.Ch1;


public class Ex_1_1_7 {

    public static void main(String[] args) {


        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001){
            t = (9.0/t + t) / 2.0;
            System.out.printf("%.5f\n", t);
        }

        System.out.println();

        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        System.out.println(sum);










    }


}
