package app.type;

public enum Priority {
    LOW(1), MEDIUM(2), HIGH(3);

    int priority;

    Priority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
