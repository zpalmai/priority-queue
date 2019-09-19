package main.app.strategy;

import main.app.type.JobResult;
import main.app.type.Priority;

import java.util.LinkedList;
import java.util.Map;

/**
 * Prioritizes by time, meaning highest priority gets more time to consume from the queues then the lower priorities.
 * TODO
 */
public class TimeBasedStrategy implements FairnessStrategy {

    public static final String TYPE = "timebased";

    @Override
    public Priority getNextToConsumeFrom() {
        return null;
    }

    @Override
    public void setQueueReferences(Map<Priority, LinkedList<JobResult>> lists) {

    }
}
