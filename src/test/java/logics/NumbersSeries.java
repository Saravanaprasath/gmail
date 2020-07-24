package logics;

public class NumbersSeries {


    public void factorial() {
        int number = 5;
        int fact = 1;
        int ans = 1;

        for (int i = 1; i <= number; i++) {
            fact = fact * i;
            System.out.println(fact);
        }
        System.out.println(fact);
    }

    public void fibo() {
        int limit = 10;
        int a = -1;
        int b = 1;
        int c = 0;
        for (int i = 0; i <= limit; i++) {
            a = b;
            b = c;
            c = a + b;
            System.out.print(c + "    ");
        }
    }


    public void palindrome() {
        int givenNumber = 353;
        int reversedNumber = 0;
        while (givenNumber > 0) {
            reversedNumber = reversedNumber * 10;
            reversedNumber = givenNumber + (reversedNumber % 10);
            givenNumber = givenNumber / 10;
        }
        System.out.println(reversedNumber);
    }

    public static void main(String[] args) {
        NumbersSeries numbersSeries = new NumbersSeries();
        //numbersSeries.factorial();
        //numbersSeries.fibo();
        numbersSeries.palindrome();
    }
}
