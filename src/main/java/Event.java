public class Event extends Task {
    private String eventDate;

    public Event(String eventName) {
        super(eventName);
    }

    public Event(String eventName, String eventDate) {
        super(eventName);
        this.eventDate = eventDate;
    }

    /**
     * A method to return the details of the current Task object.
     * Contains the task done status and the task name.
     *
     * @return A String representation of the task details.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: "
            + this.eventDate + ")";
    }
}