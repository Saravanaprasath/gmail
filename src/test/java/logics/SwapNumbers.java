package logics;

public class SwapNumbers {
    int first = 1;
    int second = 2;

    public void swapping1() {
        System.out.println("Before Swapping : First :" + first + " Second :" + second);
        first = first - second;
        second = first + second;
        first = second - first;
        System.out.println("After Swapping : First :" + first + " Second :" + second);
    }

    public void swapping2() {
        System.out.println("Before Swapping : First :" + first + " Second :" + second);
        int temp = first;
        first = second;
        second = temp;
        System.out.println("After Swapping : First :" + first + " Second :" + second);
    }


    public static void main(String[] args) {
        SwapNumbers swapNumbers = new SwapNumbers();
        swapNumbers.swapping1();
    }
}
