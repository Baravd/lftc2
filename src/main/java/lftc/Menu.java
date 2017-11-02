package lftc;

import lftc.repos.AlphabetRepository;
import lftc.repos.StateRepository;
import lftc.repos.TransitionRepository;

import java.util.Scanner;

public class Menu {
    private StateRepository stateRepository;
    private AlphabetRepository alphabetRepository;
    private TransitionRepository transitionRepository;
    private Scanner in;
    private AutomataChecker automataChecker;

    public Menu() {
        stateRepository = new StateRepository();
        alphabetRepository = new AlphabetRepository();
        transitionRepository = new TransitionRepository();
        in = new Scanner(System.in);
        try {
            automataChecker = new AutomataChecker(stateRepository.getInitialState());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void printMenu() {
        StringBuilder menu = new StringBuilder();
        final String lineSeparator = System.lineSeparator();

        menu.append("MENU").append(lineSeparator)
                .append("1. Print list of states").append(lineSeparator)
                .append("2. Print alphabet").append(lineSeparator)
                .append("3. Print list of transitions").append(lineSeparator)
                .append("4. Print initial state").append(lineSeparator)
                .append("5. Print list of final states").append(lineSeparator)
                .append("6. Determine if a sequence is valid for automaton").append(lineSeparator)
                .append("7. Determine longest valid sequence")
                .append("0. Exit")
                .append("Please insert the number of command: ");
        System.out.println(menu.toString());
    }

    public void show() {
        while (true) {
            printMenu();
            String option = in.nextLine();

            switch (option) {
                case "1":
                    printListOfStates();
                    break;
                case "2":
                    printAlphabet();
                    break;
                case "3":
                    printListOfTransitions();
                    break;
                case "4":
                    printFirstState();
                    break;
                case "5":
                    printFinalStates();
                    break;
                case "6":
                    determineIfASequenceIsValid();
                    break;
                case "7":
                    determineLongestValidSequence();
                    break;
                case "0":
                    System.exit(0);

                default:
                    System.out.println("Please insert a valid option.");
                    break;
            }
        }
    }

    private void determineLongestValidSequence() {
        System.out.println("Sequence  = ");
        String s = in.nextLine().trim();
        try {
            System.out.println(automataChecker.getLongestValidSequence(s));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void determineIfASequenceIsValid() {
        System.out.println("Sequence to validate = ");
        String s = in.nextLine().trim();
        try {
            System.out.println(automataChecker.check(s));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void printFinalStates() {
        System.out.println(stateRepository.getFinalStates());
    }

    private void printFirstState() {
        try {
            System.out.println(stateRepository.getInitialState());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printListOfTransitions() {
        System.out.println(transitionRepository.getAll());
    }

    private void printAlphabet() {
        System.out.println(alphabetRepository.getAlphabet());
    }

    private void printListOfStates() {
        System.out.println(stateRepository.getStates());
    }
}
