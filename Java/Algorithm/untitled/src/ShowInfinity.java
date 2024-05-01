public class ShowInfinity {
    public static void main(String[] args) {
        // 0.0
        System.out.println(0/10.0);
        //Infinity
        System.out.println(10.0/0);

        //0
        System.out.println(0/10);

        //ArithmeticException
        System.out.println(10/0);

    }
}
