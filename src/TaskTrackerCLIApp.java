public class TaskTrackerCLIApp {
    private static String command;
    public static void main(String[] args) throws Exception {

        try {
            command = args[0];
        } catch (Exception e) {
            command = "";
        }

        TaskManager taskManager = new TaskManager(); 

        switch (command) {
            case "add":
                taskManager.add(args[1]);
                break;
            case "update":
                taskManager.update(Integer.parseInt(args[1]), args[2]);
                break;
            case "delete":
                taskManager.delete(Integer.parseInt(args[1]));
                break;
            case "mark-in-progress":
                taskManager.markInProgress(Integer.parseInt(args[1]));
                break;
            case "mark-done":
                taskManager.markDone(Integer.parseInt(args[1]));
                break;
            case "list":
                try {
                    taskManager.list(args[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    taskManager.list();
                }
                break;
            default:
                System.out.println("#################### Invalid command! Syntax: java TaskTrackerCLIApp <command> [argument]");
        }

        taskManager.storeTasksToJson();
    }
}
