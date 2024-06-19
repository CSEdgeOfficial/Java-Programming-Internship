import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String name;
    private boolean completed;

    public Task(String name) {
        this.name = name;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }
}

public class TaskManager {
    private ArrayList<Task> tasks;
    private Scanner scanner;

    public TaskManager() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Task Manager Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. View Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public void addTask(String taskName) {
        Task task = new Task(taskName);
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task index!");
        }
    }

    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid task index!");
        }
    }

    public void viewTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.getName() + " - Completed: " + task.isCompleted());
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            taskManager.displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();
                    taskManager.addTask(taskName);
                    break;
                case 2:
                    System.out.print("Enter index of task to delete: ");
                    int deleteIndex = scanner.nextInt();
                    taskManager.deleteTask(deleteIndex - 1);
                    break;
                case 3:
                    System.out.print("Enter index of task to mark as completed: ");
                    int completeIndex = scanner.nextInt();
                    taskManager.markTaskCompleted(completeIndex - 1);
                    break;
                case 4:
                    taskManager.viewTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
        
        scanner.close();
    }
}
