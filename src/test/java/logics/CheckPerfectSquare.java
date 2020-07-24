package logics;

public class CheckPerfectSquare {
    double number = 37;

    public void checkPerfectSquare() {
        double number1 = Math.sqrt(number);
        System.out.println("SQRT " + number1);
        int num = (int) number;
        if (number1 % 1 == 0) {
            System.out.println(num + " is perfect square");
        } else {
            System.out.println(num + " is not perfect square");
        }
    }

    public void checkPerfectCube() {
        double number = 729;
        double cbrt = Math.cbrt(number);
        double ceil = Math.ceil(cbrt);
        System.out.println("Cube Root   :" + cbrt + "    " + "Cube Root Ceil " + ceil);
        int givenNumber = (int) number;
        if (cbrt == ceil) {
            System.out.println("Both are equal");
            System.out.println(givenNumber + " is perfect cube");
        } else {
            System.out.println(givenNumber + " is not perfect cube");
        }
    }

    public static void main(String[] args) {
        CheckPerfectSquare perfectSquare = new CheckPerfectSquare();
        //perfectSquare.checkPerfectSquare();
        perfectSquare.checkPerfectCube();
    }
}
