package com.debiotech.scheduler.service;

import com.debiotech.scheduler.tasks.ScheduledTask;
import com.debiotech.scheduler.tasks.ScheduledTaskFactory;
import com.debiotech.scheduler.tasks.TaskA;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledTaskManager {
    private static final int DEFAULT_MAX_CONCURRENT_TASKS = 2;
    private static final int CORE_THREAD_POOL_SIZE = 5;

    private final ScheduledTaskFactory scheduledTaskFactory;
    private final ExecutionPlanLogger executionPlanLogger;
    // private final int MAX_CONCURRENT_TASKS;


    private static AtomicInteger timeElapsedInSeconds = new AtomicInteger(0);

    public ScheduledTaskManager(ScheduledTaskFactory scheduledTaskFactory,
                                ExecutionPlanLogger executionPlanLogger,
                                int MAX_CONCURRENT_TASKS) {
        this.scheduledTaskFactory = scheduledTaskFactory;
        this.executionPlanLogger = executionPlanLogger;
        MAX_CONCURRENT_TASKS =  MAX_CONCURRENT_TASKS <= 0 ? MAX_CONCURRENT_TASKS : DEFAULT_MAX_CONCURRENT_TASKS;
    }

    public void invokeAllTasks() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(CORE_THREAD_POOL_SIZE);
        this.scheduledTaskFactory.createAllTasks().forEach(scheduledTask  -> {
            scheduleTask(scheduler, scheduledTask);
        });
    }

    private void scheduleTask(ScheduledExecutorService scheduler, ScheduledTask scheduledTask) {

        scheduler.scheduleAtFixedRate(() -> {
            scheduledTask.run();

            executionPlanLogger.addTask(timeElapsedInSeconds.get(), scheduledTask);

            if (scheduledTask instanceof TaskA) {
                timeElapsedInSeconds.incrementAndGet();
            }

        }, scheduledTask.getInitialDelay(), scheduledTask.getInterval(), TimeUnit.SECONDS);
    }

}