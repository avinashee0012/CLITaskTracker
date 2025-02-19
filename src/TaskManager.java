import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    ArrayList<Task> arrayList = new ArrayList<>();;

    // ************ CONSTRUCTOR ************

    public TaskManager() {

        // Creating a file "tasks.json"
        File jsonFile = new File("tasks.json");
        try {
            if(!jsonFile.createNewFile()){
                // Fetching data from tasks.json and saving to arraylist
                this.getTasksFromJson();
            }
        } catch (IOException e) {
            System.out.println("Error while creating json.");
            e.printStackTrace();
        }

    }

    // ************ METHODS ************

    void add(String description) {
        Task task = new Task(description);
        arrayList.add(task);
    }

    void update(int id, String taskName) {
        Task task = arrayList.get(id);
        task.setDescription(taskName);
    }

    void delete(int id) {
        arrayList.remove(id);
    }

    void markInProgress(int id) {
        Task task = arrayList.get(id);
        task.setStatus(Status.PROGRESS);
        task.setUpdatedAt(LocalDateTime.now());
    }

    void markDone(int id) {
        Task task = arrayList.get(id);
        task.setStatus(Status.DONE);
        task.setUpdatedAt(LocalDateTime.now());
    }

    void list() {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
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
            // appending taskObject to tasks.json
            FileWriter jsonFileWriter = new FileWriter("tasks.json");
            jsonFileWriter.write("[\n");
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i).setId(i);
                // Creating a task as StringBuilder object for json
                StringBuilder taskStringObject = new StringBuilder(
                        "{\"id\":\"" + (arrayList.get(i).getId()) + "\", \"description\":\""
                                + arrayList.get(i).getDescription().strip() + "\", \"status\":\""
                                + arrayList.get(i).getStatus().toString()
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
                // // process this data from json, convert to task object and save to arraylist
                if (data.equals("[") || data.equals("]") || data.equals("\n") || data.isEmpty() || data == null) {
                    continue;
                }
                String[] ObjectsInArray = data.replace("{", "").split("},");
                for (String individualObject : ObjectsInArray) {
                    if (individualObject.endsWith("}")) {
                        individualObject = individualObject.replace("}", "");
                    }
                    String[] individualObjectBrokenToArray = individualObject.split(", ");
                    Task task = new Task(individualObjectBrokenToArray[1].split("\":")[1].replace("\"", ""));
                    task.setId(Integer.parseInt(individualObjectBrokenToArray[0].split("\":")[1].replace("\"", "")));
                    switch (individualObjectBrokenToArray[2].split("\":")[1].replace("\"", "")) {
                        case "TODO":
                            task.setStatus(Status.TODO);
                            break;
                        case "PROGRESS":
                            task.setStatus(Status.PROGRESS);
                            break;
                        case "DONE":
                            task.setStatus(Status.DONE);
                            break;
                        default:
                            System.out.println("Invalid Status found!");
                    }
                    task.setCreatedAt(LocalDateTime.parse(individualObjectBrokenToArray[3].split("\":")[1].replace("\"", "")));
                    task.setUpdatedAt(LocalDateTime.parse(individualObjectBrokenToArray[4].split("\":")[1].replace("\"", "")));
                    arrayList.add(task);
                }
            }
            jsonReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
