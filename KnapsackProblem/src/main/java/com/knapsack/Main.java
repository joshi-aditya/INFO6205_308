package main.java.com.knapsack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Knapsack knapsack = populateKnapsack();

        System.out.println("Enter the population size: ");
        int sizeOfPopulation = (int) inputNumber();

        System.out.println("Enter the maximum number of generations: ");
        int maxGenerations = (int) inputNumber();

        System.out.println("Enter the crossover probability: ");
        double crossoverProbability = (double) inputNumber();

        System.out.println("Enter the mutation probability: ");
        double mutationProbability = (double) inputNumber();

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(knapsack, sizeOfPopulation, maxGenerations, crossoverProbability, mutationProbability);
        geneticAlgorithm.start();

    }

    public static Knapsack populateKnapsack() {
        Scanner c = new Scanner(System.in);

        System.out.println("Enter the knapsack capacity: ");
        int knapsackCapacity = (int) inputNumber();

        System.out.println("Enter the number of items: ");
        int numberOfItems = (int) inputNumber();

        System.out.println("Enter the max-weight for items: ");
        int maxWeight = (int) inputNumber();

        System.out.println("Enter the max-values for items: ");
        int maxValue = (int) inputNumber();

        Random randomValue = new Random(10);
        Random randomWeight = new Random(5);

        ArrayList<Integer> itemValues = new ArrayList<>();
        ArrayList<Integer> itemWeights = new ArrayList<>();
        // Randomly generate weight and value
        for (int i = 0; i < numberOfItems; i++) {
            itemValues.add(randomValue.nextInt(maxValue) + 1);
            itemWeights.add(randomWeight.nextInt(maxWeight) + 1);
        }

        Knapsack knapsack = new Knapsack(knapsackCapacity, numberOfItems, itemValues,itemWeights);
        return knapsack;

    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    // Function to take input as a number
    public static Number inputNumber() {

        String input;
        Scanner c = new Scanner(System.in);

        char ch;
        do {
            input = c.nextLine();
            if (isInteger(input)) {
                return Integer.parseInt(input);
            } else if (isDouble(input)) {
                return Double.parseDouble(input);
            } else {
                System.out.println("Not a number. Would you like to try again?(Y/n)");
                ch = c.next().charAt(0);
            }
            if (ch == 'n' || ch == 'N')
                System.exit(1);
        } while (true);
    }

}
