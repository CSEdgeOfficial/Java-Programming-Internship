import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDo {
    private List<String> tasks;

    public ToDo() {
        tasks = new ArrayList<>();
    }

    public void addTask(String taskDescription) {
        tasks.add(taskDescription);
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void displayTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        ToDo toDoList = new ToDo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    toDoList.addTask(taskDescription);
                    break;
                case 2:
                    System.out.print("Enter task index to delete: ");
                    int indexToDelete = scanner.nextInt();
                    toDoList.deleteTask(indexToDelete - 1);
                    break;
                case 3:
                    toDoList.displayTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
