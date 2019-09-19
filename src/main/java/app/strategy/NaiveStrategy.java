package main.app.strategy;

import main.app.type.JobResult;
import main.app.type.Priority;

import java.util.LinkedList;
import java.util.Map;

/**
 *  The bad solution, causes starvation
 */
public class NaiveStrategy implements FairnessStrategy {

    public static final String TYPE = "naive";

    private Map<Priority, LinkedList<JobResult>> queues;

    @Override
    public Priority getNextToConsumeFrom() {
        if (queues.get(Priority.HIGH).size() > 0) {
            return Priority.HIGH;
        } else if (queues.get(Priority.MEDIUM).size() > 0) {
            return Priority.MEDIUM;
        } else {
            return Priority.LOW;
        }
    }

    @Override
    public void setQueueReferences(Map<Priority, LinkedList<JobResult>> queues) {
        this.queues = queues;
    }
}
