package Multithreading.CreateThreads;

public class TaskByThreadClass extends Thread {

    public static void main(String[] args) {

        System.out.println("Inside main mehtod");
        //Lets create Task first to assign it to the Thread
        TaskByThreadClass task = new TaskByThreadClass();

        //Lets create a thread and assign task to it
        Thread thread = new Thread(task);


        //lets start the thread
        System.out.println("thread is going to start");
        thread.start();
        System.out.println("end of main method");

    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                sleep(2000);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
