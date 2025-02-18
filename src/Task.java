import java.time.LocalDateTime;

public class Task {

    // ************ FIELDS ************
    // private static int globalId = 0;
    private int id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    

    // ************ CONSTRUCTOR ************

    public Task(String description) {
        setId(id);
        setDescription(description);
        this.status = Status.TODO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // ************ GETTERS ************

    public int getId() {
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

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "{id: " + this.getId() + ", description: " + this.getDescription() + ", status: " + this.getStatus() + ", createdAt: " + this.getCreatedAt() + ", updatedAt: " + this.getUpdatedAt() + "}";
    }

}
