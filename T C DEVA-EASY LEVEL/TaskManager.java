/*
This code below show the GUI application for managing a list of tasks,
Name: Deva,
Task2: To Do List,
Java Internship Programming.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Task Manager");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String taskToAdd = scanner.nextLine();
                    addTask(taskToAdd);
                    break;
                case 2:
                    System.out.print("Enter index of task to delete: ");
                    int indexToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    deleteTask(indexToDelete);
                    break;
                case 3:
                    System.out.print("Enter index of task to mark as completed: ");
                    int indexToComplete = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    markTaskAsCompleted(indexToComplete);
                    break;
                case 4:
                    viewTasks();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }

    private static void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    private static void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid index. No task deleted.");
        }
    }

    private static void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            String task = tasks.get(index);
            tasks.set(index, "[Completed] " + task);
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid index. No task marked as completed.");
        }
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }
}
