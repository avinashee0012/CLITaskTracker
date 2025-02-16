# CLI Task Tracker Application

TaskTrackerCLIApp is a CLI app to track tasks and manage to-do list.

## Features:
______

- Add, Update, and Delete tasks
- Mark a task as in progress or done
- List all tasks
- List all tasks that are done
- List all tasks that are not done
- List all tasks that are in progress

## Installation:
______
1. Clone the repo
```bash
git clone git@github.com:avinashee0012/TaskTrackerCLIApp.git
cd task_tracker_cli
```
2. Compile the source code
```bash
javac TaskTrackerCLIApp.java
```
3. Run the compiled code
```bash
java TaskTrackerCLIApp <command> [arguments]
```

## Example:
______
```bash
# Adding a new task
java TaskTrackerCLIApp add "Buy groceries"
# Output: Task added successfully (ID: 1)

# Updating and deleting tasks
java TaskTrackerCLIApp update 1 "Buy groceries and cook dinner"
java TaskTrackerCLIApp delete 1

# Marking a task as in progress or done
java TaskTrackerCLIApp mark-in-progress 1
java TaskTrackerCLIApp mark-done 1

# Listing all tasks
java TaskTrackerCLIApp list

# Listing tasks by status
java TaskTrackerCLIApp list done
java TaskTrackerCLIApp list todo
java TaskTrackerCLIApp list in-progress
```