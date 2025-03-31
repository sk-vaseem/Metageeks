public class ThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Threading());
        Thread thread2 = new Thread(new Threading());

        thread1.start(); // Start first thread
        thread2.start(); // Start second thread
    }
}