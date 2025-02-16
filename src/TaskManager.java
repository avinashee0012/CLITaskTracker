
public class TaskManager {

    // ************ CONSTRUCTOR ************

    public TaskManager() {
    }

    // ************ METHODS ************

    void add(String description) {
        Task task = new Task(description);
        task.printTaskToJson();
        list();
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
        getFromJson();
        
    }

    void list(String filter) {
        getFromJson();
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

    void getFromJson(){
        
    }

    
}
