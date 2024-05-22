import javax.swing.JOptionPane;

public class Main {
    public static String name;
    public static String password;
    public static String firstName;
    public static String surname;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to Easy Kanban");

        createAccount();
        login();

        int numOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to add?"));

        Task[] tasks = new Task[numOfTasks];

        for (int i = 0; i < numOfTasks; i++) {
            tasks[i] = new Task();

            tasks[i].setTaskName(JOptionPane.showInputDialog("What is the name of the task?"));
            tasks[i].setTaskNbr(JOptionPane.showInputDialog("Enter Task number:"));
            tasks[i].setTaskDescription(JOptionPane.showInputDialog("Enter Task description"));
            tasks[i].setTaskDetails(JOptionPane.showInputDialog("Enter developer details"));
            tasks[i].setTaskDuration(JOptionPane.showInputDialog("Enter task duration: "));
            tasks[i].setTaskStatus(JOptionPane.showInputDialog("Enter task status: "));
        }

        String[] options = {"Add Task", "View Tasks", "Quit"};
        while (true) {
            String choice = (String) JOptionPane.showInputDialog(null, "Choose option:", "EasyKanban",
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (choice == null || choice.equals("Quit")) {
                break;
            } else if (choice.equals("Add Task")) {
                addTask(tasks);
            } else if (choice.equals("View Tasks")) {
                viewTasks(tasks);
            }
        }
    }

    // Creating an account
    public static void createAccount() {
        name = JOptionPane.showInputDialog("Enter Username:");
        password = JOptionPane.showInputDialog("Enter Password:");
        firstName = JOptionPane.showInputDialog("Enter First Name:");
        surname = JOptionPane.showInputDialog("Enter Last Name:");

        if (Validatename(name)) {
            JOptionPane.showMessageDialog(null, "Username successfully captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
        }

        if (Validatepassword(password)) {
            JOptionPane.showMessageDialog(null, "Password successfully captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that your password contains at least 8 characters, a capital letter, a number, and a special character.");
        }

        if (Validatename(name) && Validatepassword(password)) {
            JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + surname + ", it is great to see you!");
            JOptionPane.showMessageDialog(null, "Account created successfully!\nName: " + name + "\nPassword: " + password + "\nFirst name: " + firstName + "\nLast name: " + surname);
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect. Please try again.");
        }
    }

    // Log in to an account using the same
    public static void login() {
        String enteredName = JOptionPane.showInputDialog("Enter Username:");
        String enteredPassword = JOptionPane.showInputDialog("Enter Password:");

        if (enteredName.equals(name) && enteredPassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Login successful! Welcome, " + firstName + " " + surname);
        } else {
            JOptionPane.showMessageDialog(null, "Login failed. Please try again.");
        }
    }

    public static boolean Validatename(String name) {
        return name.contains("_") && name.length() <= 5;
    }

    public static boolean Validatepassword(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*].*");
    }

    public static void addTask(Task[] tasks) {
        // Add task to task list
        JOptionPane.showMessageDialog(null, "Task addition not allowed!");
    }

    public static void viewTasks(Task[] tasks) {
        StringBuilder tasksList = new StringBuilder();

        for (Task task : tasks) {
            tasksList.append("Task Name: ").append(task.getTaskName()).append("\n");
            tasksList.append("Task Number: ").append(task.getTaskNbr()).append("\n");
            tasksList.append("Task Description: ").append(task.getTaskDescription()).append("\n");
            tasksList.append("Developer Details: ").append(task.getTaskDetails()).append("\n");
            tasksList.append("Task Duration: ").append(task.getTaskDuration()).append("\n");
            tasksList.append("Task Status: ").append(task.getTaskStatus()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, tasksList.toString(), "Tasks List", JOptionPane.INFORMATION_MESSAGE);
    }
}

class Task {
    private String taskName;
    private String taskNbr;
    private String taskDescription;
    private String taskDetails;
    private String taskDuration;
    private String taskStatus;
    private String taskID;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskNbr() {
        return taskNbr;
    }

    public void setTaskNbr(String taskNbr) {
        this.taskNbr = taskNbr;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }

    public String getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(String taskDuration) {
        this.taskDuration = taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }
}