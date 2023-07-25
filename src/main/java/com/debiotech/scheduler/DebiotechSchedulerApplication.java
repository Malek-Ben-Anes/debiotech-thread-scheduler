package com.debiotech.scheduler;

import com.debiotech.scheduler.service.ExecutionPlanLogger;
import com.debiotech.scheduler.v1.manager.ScheduledTaskManager;
import com.debiotech.scheduler.v1.tasks.ScheduledTaskFactory;
import com.debiotech.scheduler.v2.PriorityQueueTaskManager;
import com.debiotech.scheduler.v2.tasks.TaskFactory;

import java.util.Scanner;

/**
 * The main class for the Debiotech Scheduler application.
 * This class provides a text-based menu to choose between the two scheduling algorithms:
 * 1. Scheduled Task Algorithm
 * 2. Priority Queue Based Algorithm
 * The user can choose to execute either of the algorithms or exit the program.
 */
public class DebiotechSchedulerApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer

            switch (choice) {
                case 1:
                    executeScheduledTaskAlgorithm();
                    break;
                case 2:
                    launchPriorityQueueAlgorithm();
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    /**
     * Prints the menu with available options to the console.
     */
    private static void printMenu() {
        System.out.println("----------- Menu -----------");
        System.out.println("1. Execute scheduled task algorithm");
        System.out.println("2. Launch priority queue based algorithm");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Executes the scheduled task algorithm.
     */
    private static void executeScheduledTaskAlgorithm() {
        System.out.println("\nScheduled task algorithm executed... \n");

        // Self-scheduled task algorithm
        ScheduledTaskFactory taskFactory = new ScheduledTaskFactory();
        ExecutionPlanLogger executionPlanLogger = new ExecutionPlanLogger();

        ScheduledTaskManager taskScheduler = new ScheduledTaskManager(taskFactory, executionPlanLogger);
        taskScheduler.execute();
    }

    /**
     * Launches the priority queue based algorithm.
     */
    private static void launchPriorityQueueAlgorithm() {
        System.out.println("\nPriority queue based algorithm launched... \n");

        // The priority queue based algorithm implementation
        TaskFactory taskFactory = new TaskFactory();
        ExecutionPlanLogger executionPlanLogger = new ExecutionPlanLogger();

        PriorityQueueTaskManager taskManager = new PriorityQueueTaskManager(taskFactory, executionPlanLogger);
        taskManager.execute();
    }

}
