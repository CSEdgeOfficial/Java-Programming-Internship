import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nToDo List:");
            displayTasks();

            System.out.println("\nChoose an option:");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    deleteTask(scanner);
                    break;
                case 3:
                    markAsCompleted(scanner);
                    break;
                case 4:
                    System.out.println("Exiting ToDo List...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void addTask(Scanner scanner) {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter task description: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    private static void deleteTask(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to delete.");
            return;
        }

        System.out.print("Enter task number to delete: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number!");
            return;
        }

        tasks.remove(taskNumber - 1);
        System.out.println("Task deleted successfully.");
    }

    private static void markAsCompleted(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to mark as completed.");
            return;
        }

        System.out.print("Enter task number to mark as completed: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number!");
            return;
        }

        String completedTask = tasks.get(taskNumber - 1) + " (Completed)";
        tasks.set(taskNumber - 1, completedTask);
        System.out.println("Task marked as completed.");
    }
}
