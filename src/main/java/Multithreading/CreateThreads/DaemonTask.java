package Multithreading.CreateThreads;

public class DaemonTask implements Runnable {
    @Override
    public void run() {
        System.out.println("inside daemon task");

        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread childThread = Thread.currentThread();
                while (true) {
                    System.out.println("insie child thread :" + childThread.getName());
                }
//                System.out.println();
            }
        });

    }
}
