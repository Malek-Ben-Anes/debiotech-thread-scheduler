# Debiotech Scheduler Project

Welcome to the Debiotech Scheduler Project!

This project is a task scheduling application designed to efficiently manage and execute tasks based on different scheduling algorithms. It provides **two distinct solutions** for task execution:

1. **Scheduled Task Algorithm:** This solution uses a timer-based approach to execute tasks periodically at specified intervals. Tasks are executed sequentially, ensuring a maximum of two tasks run concurrently. The Scheduled Task Algorithm is ideal for simple, sequential task execution.

2. **Priority Queue Based Algorithm:** This solution employs a priority queue to schedule and execute tasks based on their next execution times. Tasks are prioritized by their next execution times, allowing the application to execute the most time-sensitive tasks first. The Priority Queue Based Algorithm is suitable for handling tasks with varying execution frequencies and priority levels.

Both solutions aim to optimize task execution and provide a flexible and efficient task management system. The project is implemented in Java and organized into different packages to facilitate modularity and maintainability.

In this README, you will find information on how to get started with the project, the project structure, usage instructions, and how to contribute. We hope this application proves to be a valuable tool for your task scheduling needs. Happy scheduling!

## Table of Contents

- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Docker](#Docker)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

This section will guide users through setting up the project and getting it running on their local machine.

### Prerequisites

List all the prerequisites needed to run the project. For example:
- Java Development Kit (JDK) 11 or higher [installation guide](https://docs.oracle.com/en/java/javase/11/install/installation-guide.pdf)
- Maven  [installation guide](https://www.baeldung.com/install-maven-on-windows-linux-mac)
- Intellij IDEA  [Download link](https://www.jetbrains.com/idea/download/?section=windows)

Make sure that **JAVA_HOME** And **M2_HOME** are added to your system path.

### Installation

Step-by-step instructions on how to install the project on the user's local machine.

1. Clone the repository: [GitHub](https://github.com/Malek-Ben-Anes/debiotech-thread-scheduler.git)

*git clone https://github.com/Malek-Ben-Anes/debiotech-thread-scheduler.git*

2. Change into the project directory:

*cd debiotech-thread-scheduler*

3. Build the project using Maven:

*mvn clean install*

4. Launching command:

*cd target*

*java -jar debiotech-scheduler-1.0.jar*

## Docker
To facilitate deployment and ensure consistency across different environments, this project includes Docker support. Docker allows you to package your application and its dependencies into a container, providing an isolated and portable environment.

### Building the Docker Image
To build the Docker image for this project, make sure you have Docker installed on your machine. Then, open a terminal or command prompt and navigate to the root directory of the project. Use the following command to build the Docker image:

*docker build -t debiotech-scheduler-1.0.jar .*

### Running the Docker Image
After building the Docker image, you can run the application inside a Docker container. To run the image in interactive mode and provide input to the command, use the following command:

*docker run -it -p 8080:8080 debiotech-scheduler-1.0.jar*

This command allocates a pseudo-TTY and allows you to interact with the application as if it were running on your local machine. If the application expects input from the command line, you can provide it directly from your terminal.

## Usage

Once you have set up the Debiotech Scheduler project on your local machine, you can use it to schedule and manage tasks efficiently. Here's a guide on how to use the project effectively:

1. Choose a Scheduling Algorithm
   The project offers two scheduling algorithms: the Scheduled Task Algorithm and the Priority Queue Based Algorithm. Decide which algorithm best suits your task scheduling needs:

a. Scheduled Task Algorithm
If you have simple, sequential tasks that need to be executed periodically with a maximum concurrency of two tasks, the Scheduled Task Algorithm is a suitable choice. This algorithm utilizes a timer-based approach for task execution.

b. Priority Queue Based Algorithm
For more complex scenarios involving tasks with varying execution frequencies and priority levels, the Priority Queue Based Algorithm is ideal. This algorithm uses a priority queue to prioritize tasks based on their next execution times, ensuring that time-sensitive tasks are executed first.

2. Implement Custom Tasks (If Needed)
   Both algorithms work with custom task implementations. If your tasks require specific behavior, you can create custom task classes by extending the ScheduledTask class (for Scheduled Task Algorithm) or the Task class (for Priority Queue Based Algorithm). Override the execute() method to define the specific behavior of your tasks.

3. Run the Application
   To run the Debiotech Scheduler application, execute the DebiotechSchedulerApplication class, which serves as the entry point for the project. The application will display a text-based menu with the following options:

Execute scheduled task algorithm: This option triggers the execution of tasks using the Scheduled Task Algorithm. The application will schedule and execute tasks at specified intervals.

Launch priority queue based algorithm: This option launches the Priority Queue Based Algorithm. The application will schedule and execute tasks based on their priority in the queue.

4. Observe the Execution Plan
   The Debiotech Scheduler application logs the execution plan, which provides insights into the scheduled tasks' execution times and order. You can monitor the application's output to observe task execution.

5. Customize Task Scheduling
   To customize the tasks' initial delay, interval, or execution behavior, modify the ScheduledTask or Task subclasses accordingly. You can adjust these parameters to fit your specific task scheduling requirements.

Example Usage Scenario:
Let's consider a scenario where you have a system with multiple tasks of varying priorities, such as data processing, sending notifications, and generating reports. You can utilize the Priority Queue Based Algorithm to schedule these tasks efficiently based on their priorities and next execution times. By using custom task classes, you can implement specific logic for each task type and achieve optimal task execution.

For more detailed examples and information, please refer to the project's source code and documentation.

## Project Structure

The Debiotech Scheduler project follows a well-organized and modular structure, making it easy to navigate and understand. Here is an overview of the project's directory structure:

- src: Contains the main source code of the application.
- main: Holds the main application code.
- DebiotechSchedulerApplication.java: The entry point of the application.
- pom.xml: The Maven Project Object Model (POM) file containing the project's configuration and dependencies.
- .gitignore: A file specifying which files and directories should be ignored by Git version control.
- README.md: The main documentation file providing an overview, usage instructions, and other relevant information about the project.

## Contributing

We welcome contributions to the Debiotech Scheduler project! If you encounter any issues, have ideas for improvements, or want to add new features, feel free to contribute to the project. Please follow our guidelines for contributing outlined in the CONTRIBUTING.md file.

## License

The Debiotech Scheduler project is open-source and distributed under the MIT License. You can find the detailed license information in the LICENSE file.