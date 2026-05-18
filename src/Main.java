import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);

        }

        Thread.Builder.OfVirtual builder = Thread.ofVirtual()
                .name("MyVirtualThread")
                .inheritInheritableThreadLocals(true)
                .uncaughtExceptionHandler((t, e) ->
                        System.out.println("Error in " + t.getName() + ": " + e.getMessage())
                );

// Start a virtual thread using the builder
        Thread vt = builder.start(() -> {
            System.out.println("Running in: " + Thread.currentThread());
        });

        vt.join(); // Wait for completion
        try (var executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                executor.submit(() -> {
                    System.out.println("Running in " + Thread.currentThread()+" - Task: " + Thread.currentThread().getName()+" - ID: " + Thread.currentThread().getId()
                    + " - State: " + Thread.currentThread().getState()+"   i value"+ finalI);
                });
            }
        }
        record Person(String name, int age) {}

        Object obj = new Person("Karthikeyan", 25);

        if (obj instanceof Person(String name, int age)) {
            System.out.println(name + " is " + age);
        }
        SequencedCollection<String> list = new ArrayList<>();
        list.addFirst("Start");
        list.addLast("End");

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> System.out.println("Task executed"));

        executor.shutdown();


    }
    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Running...");
        }
        System.out.println("Stopped");
    }

    public void stop() {
        running = false;
    }

}
