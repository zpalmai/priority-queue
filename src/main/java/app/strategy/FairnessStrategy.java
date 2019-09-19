package main.app.strategy;

import main.app.type.JobResult;
import main.app.type.Priority;

import java.util.LinkedList;
import java.util.Map;

/**
 * Interface to implement for different strategies
 */
public interface FairnessStrategy {
    Priority getNextToConsumeFrom();

    /*
    Function to observe the different queue states
     */
    void setQueueReferences(Map<Priority, LinkedList<JobResult>> lists);
}
