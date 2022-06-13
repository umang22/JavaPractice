package Multithreading.CreateThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskByCallableInterface {
    public static void main(String[] args) {
        //Create a Thread Pool of size 2 (2 here is number of threads in Thread pool.)
        //using executor framework

        ExecutorService executorService = Executors.newFixedThreadPool(2);


        ThreadTask task = new ThreadTask();

        /*executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am inside execute method.");
            }
        });*/
        //Submit a task to Threads present in Thread pool.

//        Future<Result> resultFuture = executorService.submit(task);  //runn/t
//        Future<Result> resultFuture = executorService.submit(task); //callable
        Future<Result> resultFuture = executorService.submit(task); //runnable

        Result result = null;
        // result = resultFuture.get();
        executorService.shutdown();
    }
}
