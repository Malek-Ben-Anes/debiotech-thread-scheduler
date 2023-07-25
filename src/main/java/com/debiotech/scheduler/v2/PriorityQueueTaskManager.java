package com.debiotech.scheduler.v2;

import com.debiotech.scheduler.v2.tasks.Task;
import com.debiotech.scheduler.v2.tasks.TaskFactory;

import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * A Task Manager that uses a priority queue to schedule and execute tasks.
 */
public class PriorityQueueTaskManager {

    private static final int EXECUTION_INTERVAL_IN_MS = 1000; // Execution interval in milliseconds.
    private static TaskFactory taskFactory = new TaskFactory();

    private long currentExecutionTimeInSeconds = 1; // Current execution time in seconds.

    /**
     * Executes the tasks using a priority queue and a scheduled executor service.
     * The tasks are executed at the specified interval.
     */
    public void execute() {
        PriorityQueue<Task> taskQueue = createTasksPriorityQueue();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        System.out.println("Time (sec) -> Tasks");

        scheduler.scheduleAtFixedRate(() -> {
            System.out.print("\n" + currentExecutionTimeInSeconds + " -> ");

            // Execute the first two tasks with the highest priority from the priority queue.
            Task task1 = taskQueue.poll();
            Task task2 = taskQueue.poll();

            if (task1 != null) {
                if (task1.isReadyToExecute(currentExecutionTimeInSeconds)) {
                    task1.execute();
                    task1.reSchedule();
                }
                taskQueue.offer(task1); // Reinsert the task into the queue.
            }

            if (task2 != null) {
                if (task2.isReadyToExecute(currentExecutionTimeInSeconds)) {
                    task2.execute();
                    task2.reSchedule();
                }
                taskQueue.offer(task2); // Reinsert the task into the queue.
            }

            currentExecutionTimeInSeconds++;
        }, 0, EXECUTION_INTERVAL_IN_MS, TimeUnit.MILLISECONDS);
    }

    /**
     * Creates a priority queue of tasks based on their next execution times.
     * The tasks are obtained from the TaskFactory and ordered in the priority queue.
     *
     * @return A priority queue of tasks ordered by their next execution times.
     */
    private static PriorityQueue<Task> createTasksPriorityQueue() {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        taskFactory.createAllTasks().forEach(task -> taskQueue.offer(task));
        return taskQueue;
    }
}
