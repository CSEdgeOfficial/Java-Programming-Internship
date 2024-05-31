import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[X] " : "[ ] ") + description;
    }
}

public class TaskManager {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    markTaskAsCompleted();
                    break;
                case 4:
                    listTasks();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nTask Manager:");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. List Tasks");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added.");
    }

    private static void deleteTask() {
        listTasks();
        System.out.print("Enter task number to delete: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void markTaskAsCompleted() {
        listTasks();
        System.out.print("Enter task number to mark as completed: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.get(taskNumber - 1).markAsCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
