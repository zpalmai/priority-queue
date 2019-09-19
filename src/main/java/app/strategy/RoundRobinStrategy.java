package main.app.strategy;

import main.app.type.JobResult;
import main.app.type.Priority;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;

/**
    This completely removes the "priority" function from the priority queue
 */
public class RoundRobinStrategy implements FairnessStrategy {

    public static final String TYPE = "roundrobin";

    protected LinkedList<Priority> rrQueue = new LinkedList<>();

    public RoundRobinStrategy() {
        Arrays.stream(Priority.values())
                .sorted(Comparator.comparingInt(Priority::getPriority).reversed())
                .forEach(rrQueue::offer);
    }

    @Override
    public Priority getNextToConsumeFrom() {
        Priority toReturn = rrQueue.pop();
        rrQueue.offer(toReturn);
        return toReturn;
    }

    @Override
    public void setQueueReferences(Map<Priority, LinkedList<JobResult>> lists) {
        //NOOP
    }
}
