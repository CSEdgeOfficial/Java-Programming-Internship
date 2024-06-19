import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();
                    tasks.add(task);
                    break;
                case 2:
                    System.out.print("Enter task number to delete: ");
                    int taskNumber = sc.nextInt();
                    if (taskNumber > 0 && taskNumber <= tasks.size()) {
                        tasks.remove(taskNumber - 1);
                    } else {
                        System.out.println("Invalid task number!");
                    }
                    break;
                case 3:
                    System.out.print("Enter task number to mark as completed: ");
                    int completedTaskNumber = sc.nextInt();
                    if (completedTaskNumber > 0 && completedTaskNumber <= tasks.size()) {
                        tasks.set(completedTaskNumber - 1, tasks.get(completedTaskNumber - 1) + " (completed)");
                    } else {
                        System.out.println("Invalid task number!");
                    }
                    break;
                case 4:
                    System.out.println("Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}
