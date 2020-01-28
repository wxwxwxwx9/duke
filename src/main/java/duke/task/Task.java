package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * An abstract task class to be extended for specific tasks.
 */
public abstract class Task {

    /**
     * Task name that describes the nature of the task.
     */
    protected String taskName = "";

    /**
     * Indicates whether the task is completed.
     */
    protected boolean isDone;

    /**
     * Indicates the date and time of the task (if any).
     */
    protected LocalDate dateTime;

    /**
     * Indicates the type of the task.
     */
    protected String taskType = "";

    /**
     * Constructor for the task.
     *
     * @param taskName Describes the nature of the task.
     */
    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    /**
     * Overloaded constructor for the task.
     *
     * @param taskName Describes the nature of the task.
     * @param dateTime The date and time of the task (if any).
     */
    public Task(String taskName, String dateTime) {
        this.taskName = taskName;
        this.isDone = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dateTime = LocalDate.parse(dateTime, formatter);
    }

    /**
     * Overloaded constructor for the task (for ToDo tasks).
     *
     * @param taskName Describes the nature of the task.
     * @param isDone Indicates if the task is completed already.
     */
    public Task(String taskName, boolean isDone) {
        this.taskName = taskName;
        this.isDone = isDone;
    }

    /**
     * Overloaded constructor for the task (for Event or Deadline tasks).
     *
     * @param taskName Describes the nature of the task.
     * @param isDone Indicates if the task is completed already.
     * @param dateTime The date and time of the task (if any).
     */
    public Task(String taskName, boolean isDone, String dateTime) {
        this.taskName = taskName;
        this.isDone = isDone;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dateTime = LocalDate.parse(dateTime, formatter);
    }

    public void completeTask() {
        this.isDone = true;
    }

    /**
     * Icon to display completion status of the task.
     * @return The icon status.
     */
    public String getStatusIcon() {
        return (this.isDone ? "\u2713" : "\u2718");
    }

    /**
     * To convert the task into a format for saving to text file.
     * @return The task in the appropriate string format for saving.
     */
    public String getSaveFormat() {
        return this.taskType + "_" + this.isDone + "_" + this.taskName + "_" + this.dateTime;
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.taskName;
    }

}
