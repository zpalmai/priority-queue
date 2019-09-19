package main.app.strategy;

import main.app.type.JobResult;
import main.app.type.Priority;

import java.util.LinkedList;
import java.util.Map;

/**
 * Multiplies the priority value with a given number, increasing the time spent with a priority level. Could also be
 * exponential.
 */
public class MultiplierStrategy extends RoundRobinStrategy {

    public static final String TYPE = "multiplier";

    private Map<Priority, LinkedList<JobResult>> lists;

    private int currentCounter = 1;
    private int multiplier;

    public MultiplierStrategy(int multiplier) {
        super();
        this.multiplier = multiplier;
    }

    @Override
    public Priority getNextToConsumeFrom() {
        Priority next = rrQueue.getFirst();
        if (lists.get(next).size() == 0 || currentCounter == next.getPriority() * multiplier) {
            rrQueue.pop();
            rrQueue.offer(next);
            currentCounter = 1;
            return next;
        }
        currentCounter++;
        return next;
    }

    @Override
    public void setQueueReferences(Map<Priority, LinkedList<JobResult>> lists) {
        this.lists = lists;
    }
}
