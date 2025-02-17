import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    ArrayList<Task> arrayList;

    // ************ CONSTRUCTOR ************

    public TaskManager() {
        arrayList = new ArrayList<>();
    }

    // ************ METHODS ************

    void add(String description) {
        Task task = new Task(description);
        arrayList.add(task);
        for (Task taskFromArraylist : arrayList) {
            System.out.println(taskFromArraylist);
        }
    }

    void update(int id, String taskName) {
        System.out.println("Inside update method");
    }

    void delete(int id) {
        System.out.println("Inside delete method");
    }

    void markInProgress(int id) {
        System.out.println("Inside markInProgress method");
    }

    void markDone(int id) {
        System.out.println("Inside markDone method");
    }

    void list() {
        getTasksFromJson();
    }

    void list(String filter) {
        getTasksFromJson();
        switch (filter) {
            case "done":
                System.out.println("Listing done tasks");
                break;
            case "todo":
                System.out.println("Listing todo tasks");
                break;
            case "in-progress":
                System.out.println("Listing in-progress tasks");
                break;
            default:
                System.out.println("Invalid argument");
        }
    }

    void storeTasksToJson() {
        try {
            // Creating a file "tasks.json"
            File jsonFile = new File("tasks.json");
            jsonFile.createNewFile();

            // appending taskObject to tasks.json
            FileWriter jsonFileWriter = new FileWriter("tasks.json");

            jsonFileWriter.write("[\n");
            for (int i = 0; i < arrayList.size(); i++) {

                // Creating a task as StringBuilder object for json
                StringBuilder taskStringObject = new StringBuilder("{\"id\":\"" + (arrayList.get(i).getId()) + "\", \"description\":\""
                        + arrayList.get(i).getDescription().strip() + "\", \"status\":\"" + arrayList.get(i).getStatus().toString()
                        + "\", \"createdAt\":\"" + arrayList.get(i).getCreatedAt() + "\", \"updatedAt\":\""
                        + arrayList.get(i).getUpdatedAt() + "\"}");

                if (i != arrayList.size() - 1) {
                    taskStringObject = taskStringObject.append(",\n");
                }

                // Writing to json
                jsonFileWriter.write(taskStringObject.toString());
            }
            jsonFileWriter.write("\n]");
            jsonFileWriter.close();
        } catch (IOException e) {
            System.out.println("Error while saving to json.");
            e.printStackTrace();
        }
    }

    void getTasksFromJson() {
        try {
            File jsonFile = new File("tasks.json");
            Scanner jsonReader = new Scanner(jsonFile);
            while (jsonReader.hasNextLine()) {
                String data = jsonReader.nextLine();
                
                // process this data from json, convert to task object and save to arraylist
                String[] taskObjectsArray = data.replace("[","").replace("]", "").split(",\n");
                for (String taskObjectstring : taskObjectsArray) {
                    String[] taskInArray = taskObjectstring.replace(",", "").replace("{", "").replace("}", "").split(" ");
                    for (String brokenTaskProperties : taskInArray) {
                        String id = brokenTaskProperties.split(":")[1];
                    }
                }

            }
            jsonReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
