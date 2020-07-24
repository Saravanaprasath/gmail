package logics;

public class CheckPrime {

    public void checkPrime() {
        int n = 3;
        boolean res = true;
        for (int i = 2; i <= n / 2; i++) {
            int temp = n % 2;
            if (temp == 0) {
                res = false;
                break;
            }
        }
        if (res) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is not prime");
        }
    }


    public static void main(String[] args) {
        CheckPrime checkPrime = new CheckPrime();
        //checkPrime.checkPrime();
    }
}
