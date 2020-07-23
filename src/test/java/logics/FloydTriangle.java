package logics;

public class FloydTriangle {
    int limit = 5;
    int num = 1;

    public void printTriangle() {
        for (int row = 0; row < limit; row++) {
            for (int column = 0; column <= row; column++) {
                System.out.print("*" + "   ");
                num = num + 1;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FloydTriangle triangle = new FloydTriangle();
        triangle.printTriangle();
    }
}
