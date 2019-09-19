package app;

import app.strategy.MultiplierStrategy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> input = getInput();
        System.out.println("Input order: ");
        input.forEach(s -> System.out.print(s + " "));
        System.out.println("\n---------------");

        JobConsumer mainApp = getConsumerFromArgs(args);
        mainApp.run(input);
    }

    private static JobConsumer getConsumerFromArgs(String[] args) {
        String strategyType = MultiplierStrategy.TYPE;
        int multiplier = 1;
        if (args.length > 0) {
            strategyType = args[0];
        }
        if (args.length > 1) {
            multiplier = Integer.valueOf(args[1]);
        }
        return new JobConsumer(strategyType, multiplier);
    }

    private static List<String> getInput() {
        File initialFile = new File("input.txt");
        InputStream targetStream = null;

        try {
            targetStream = new FileInputStream(initialFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(targetStream);
        List<String> inputList = new ArrayList<>();

        while (scanner.hasNext()) {
            inputList.add(scanner.nextLine());
        }
        scanner.close();
        return inputList;
    }

}
