package app;

import app.strategy.FairnessStrategy;
import app.type.JobResult;
import app.type.Priority;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Contains a fixed number of queues generated according to the Priority object. JobResults are pushed to a linked list
 * according to their priority (the the order between same priorities remains). The pop mechanism is then controlled by
 * the strategy provided.
 */
public class PriorityQueue {
    private final Map<Priority, LinkedList<JobResult>> queueMap = new HashMap<>();
    private final FairnessStrategy strategy;

    private int size = 0;

    public PriorityQueue(FairnessStrategy strategy) {
        for (Priority priority : Priority.values()) {
            queueMap.put(priority, new LinkedList<>());
        }
        this.strategy = strategy;
        this.strategy.setQueueReferences(queueMap);
    }

    public void offer(JobResult jobResult) {
        queueMap.get(jobResult.getPriority()).offer(jobResult);
        size++;
    }

    public JobResult pop() {
        LinkedList<JobResult> currentQueue = queueMap.get(strategy.getNextToConsumeFrom());
        while (currentQueue.size() == 0 && size > 0) { //Skip the actual queue if it's empty but we still have objects
            currentQueue = queueMap.get(strategy.getNextToConsumeFrom());
        }
        size--;
        return currentQueue.pollFirst();
    }

    public int getSize() {
        return size;
    }
}
