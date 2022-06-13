package Multithreading.CreateThreads;

public class DemonThreadDemo extends Thread {

    public static void main(String[] args) {

        System.out.println("Inside main thread");

        Thread thread = new Thread(new DaemonTask());

        thread.setDaemon(true);
        thread.start();

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
