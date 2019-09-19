# priority-queue

A simple priority-queue implementation. 

## Running the app
* `./mvnw clean install`
* `java -jar ./target/priority-queue-1.0.0-RELEASE.jar`

## Important
There are multiple strategies implemented for consuming, which can be selected with the following program arguments:
* naive: actually not a fair strategy since it processes the highest first.
* roundroubin: takes 1 from each queue until there are no jobs left
* multiplier (default): takes an int (x) as an extra argument. Consumes x\*P1 from the highest priority queue, (x-1)\*P2 
from the next one etc... until the last one which is 1\*Pn.
* timebased: not implemented but would be a time slot based algorithm.

## Testing
Inputs are provided in the input.txt file. Every "job" should be a new line.
When ran, first, the input order is displayed then the processing order, like this:

```
Input order: 
LOW MEDIUM MEDIUM MEDIUM HIGH HIGH HIGH LOW LOW MEDIUM HIGH LOW HIGH MEDIUM HIGH LOW LOW MEDIUM HIGH LOW HIGH MEDIUM HIGH LOW LOW MEDIUM HIGH LOW HIGH MEDIUM 
---------------
Processing order: 
HIGH HIGH HIGH MEDIUM MEDIUM LOW HIGH HIGH HIGH MEDIUM MEDIUM LOW HIGH HIGH HIGH MEDIUM MEDIUM LOW HIGH HIGH MEDIUM MEDIUM LOW MEDIUM LOW LOW LOW LOW LOW LOW
```

Providing a different fairness strategy as a program argument will result in different orders. 