import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    // ************ FIELDS ************

    private static int id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // DateTime formatter
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

    // ************ CONSTRUCTOR ************

    public Task(String description) {
        id++;
        setDescription(description);
        this.status = Status.TODO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    // ************ GETTERS ************

    public static int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // ************ SETTERS ************

    public static void setId(int id) {
        id++;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // ADDITIONAL METHODS

    void printTaskToJson(){
        System.out.println("{\"id\":\"" + id + "\", \"description\":\"" + description.strip() + "\", \"status\":\"" + status.toString() +
                "\", \"createdAt\":\"" + createdAt.format(formatter) + "\", \"updatedAt\":\"" + updatedAt.format(formatter) + "\"}");
    }

    @Override
    public String toString() {
        System.out.println("********* Task Details: *********");
        System.out.println("id: " + getId());
        System.out.println("description: " + this.getDescription());
        System.out.println("status: " + this.getStatus());
        System.out.println("createdAt: " + this.getCreatedAt());
        System.out.println("updatedAt: " + this.getUpdatedAt());
        return "";
    }

}
