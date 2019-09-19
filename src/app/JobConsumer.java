package app;

import app.strategy.*;
import app.type.JobResult;
import app.type.Priority;

import java.util.List;

/*
 Feeds the input jobs to the priorityQueue and then consumes them.
 */
public class JobConsumer {

    private final PriorityQueue priorityQueue;

    public JobConsumer(String strategyParam, int multiplier) {
        FairnessStrategy strategy = getStrategyByParam(strategyParam, multiplier);
        this.priorityQueue = new PriorityQueue(strategy);
    }

    public void run(List<String> input) {
        input.forEach(s -> handleJobResult(new JobResult(Priority.valueOf(s))));
        System.out.println("Processing order: ");
        while (priorityQueue.getSize() > 0) {
            System.out.print(priorityQueue.pop().getPriority() + " ");
        }
    }

    private void handleJobResult(JobResult jr) {
        priorityQueue.offer(jr);
    }

    private FairnessStrategy getStrategyByParam(String strategyParam, int exponent) {
        FairnessStrategy strategy = new MultiplierStrategy(exponent);
        if (NaiveStrategy.TYPE.equals(strategyParam)) {
            strategy = new NaiveStrategy();
        } else if (RoundRobinStrategy.TYPE.equals(strategyParam)) {
            strategy = new RoundRobinStrategy();
        } else if (TimeBasedStrategy.TYPE.equals(strategyParam)) {
            throw new UnsupportedOperationException("Not yet implemented");
        }
        return strategy;
    }

}
