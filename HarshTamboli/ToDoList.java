package HarshTamboli.ToDoList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage; 

public class ToDoList extends Application {
    private ListView<String> listView;
    private TextField taskInput;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        listView = new ListView<>();
        taskInput = new TextField();
        taskInput.setPromptText("Enter a new task");
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addTask());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteTask());
        HBox inputBox = new HBox(10, taskInput, addButton, deleteButton);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.setPadding(new Insets(10));
        VBox centerBox = new VBox(10, listView, inputBox);
        centerBox.setPadding(new Insets(10));
        root.setCenter(centerBox);
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("ToDo List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addTask() {
        String taskDescription = taskInput.getText().trim();
        if (!taskDescription.isEmpty()) {
            listView.getItems().add(taskDescription);
            taskInput.clear();
        }
    }

    private void deleteTask() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            listView.getItems().remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}