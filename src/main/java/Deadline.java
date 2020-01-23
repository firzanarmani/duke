public class Deadline extends Task {
    private String deadlineDate;

    public Deadline(String deadlineName) {
        super(deadlineName);
    }

    public Deadline(String deadlineName, String deadlineDate) {
        super(deadlineName);
        this.deadlineDate = deadlineDate;
    }

    /**
     * A method to return the details of the current Task object.
     * Contains the task done status and the task name.
     *
     * @return A String representation of the task details.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: "
            + this.deadlineDate + ")";
    }
}