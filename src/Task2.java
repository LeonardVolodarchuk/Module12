import java.util.ArrayList;

public class Task2 {

    static ArrayList list = new ArrayList();
    static boolean flag = true;
    static int n = 15;
    public static void main(String[] args) throws InterruptedException {

        Thread fizzThread = new Thread(() -> fizz());
        Thread buzzThread = new Thread(() -> buzz());
        Thread fizzBuzzThread = new Thread(() -> fizzBuzz());
        Thread numberThread = new Thread(() -> number());

        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        numberThread.start();

        fizzThread.join();
        buzzThread.join();
        fizzBuzzThread.join();
        numberThread.join();

        print();
    }

    public static void fizz() {
        while (!flag){
            list.add("fizz");
            flag =true;
        }
    }

    public static void buzz()  {
        while (!flag){
            list.add("buzz");
            flag =true;
        }
    }

    public static void fizzBuzz() {
        while (!flag){
            list.add("fizzbuzz");
            flag =true;
        }
    }

    public static void number() {
        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                flag =false;
                fizzBuzz();
            } else if (i % 3 == 0) {
                flag =false;
                fizz();
            } else if (i % 5 == 0) {
                flag =false;
                buzz();
            } else {
                list.add(String.valueOf(i));
            }
        }
    }

    public static void print(){
        for (Object arr : list){
            System.out.println(arr);
        }
    }
}