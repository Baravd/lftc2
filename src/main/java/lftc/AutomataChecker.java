package lftc;

import lftc.model.State;
import lftc.model.Transition;
import lftc.repos.AlphabetRepository;
import lftc.repos.StateRepository;
import lftc.repos.TransitionRepository;
import lftc.structures.AutomataGraph;
import lftc.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AutomataChecker {
    private String currentState;
    private TransitionRepository transitionRepository;
    private List<String> alphabet;
    private AlphabetRepository alphabetRepository;
    private boolean isInitialState;
    private StateRepository stateRepository;
    private Utils utils;

    public AutomataChecker(State initialState) {
        this.currentState = initialState.getName();
        transitionRepository = new TransitionRepository();
        alphabetRepository = new AlphabetRepository();
        stateRepository = new StateRepository();
        alphabet = alphabetRepository.getAlphabet();
        utils = new Utils();
        this.isInitialState = true;
    }

    public Boolean check(String sequence) throws Exception {
        currentState=stateRepository.getInitialState().getName();
        boolean isValid = false;
        char[] chars = sequence.toCharArray();
        List<String> characters = new ArrayList<>();
        for (char c : chars) {
            characters.add(String.valueOf(c));
        }

        List<Transition> transitions = transitionRepository.getAll();
        AutomataGraph transMap = utils.getAutomataGraph(transitions);

        for (String c : characters) {
            List<Transition> tranzitii = transMap.get(currentState);
            isValid = isValid(c, tranzitii);

            if (!isValid) {
                return false;
            }

        }


        return true;
    }


    private boolean isValid(String c, List<Transition> tranzitii) {
        for (Transition t : tranzitii) {
            if (t.getTransitions().contains(c)) {
                currentState = t.getState2();
                return true;
            }
        }
        return false;
    }


    public String getLongestValidSequence(String sequence) throws Exception {
        currentState=stateRepository.getInitialState().getName();
        List<String> characters = utils.convertToStringList(sequence);
        StringBuilder s = new StringBuilder();
        for (String c : characters) {
            if (check(c)) {
                s.append(c);
            } else {
                return s.toString();
            }
        }
        return s.toString();
    }

}
