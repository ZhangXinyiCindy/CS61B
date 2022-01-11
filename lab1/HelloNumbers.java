public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int sumX=0;
        while (x < 10) {
            sumX = sumX + x;
            System.out.print(sumX + " ");
            x = x + 1;
        }
        System.out.println();
        System.out.println("What does System.out.println(5 + \"10\");");
        System.out.println(5 + "10");
        System.out.println("How about System.out.println(5 + 10);");
        System.out.println(5 + 10);
    }
}
