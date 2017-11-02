package lftc.repos;

import lftc.model.Transition;
import lftc.readers.TransitionReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransitionRepository {
    private TransitionReader transitionReader;
    private List<Transition> transitions;

    public TransitionRepository() {
        transitionReader = new TransitionReader("C:\\Faculta\\lftc\\labs\\FA\\src\\main\\resources\\transitions.txt");
        transitions = new ArrayList<>();
        try {
            transitions = transitionReader.readTransitionsFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Transition> getAll() {
        return transitions;

    }
    public List<Transition> getTranstionForState(String statePornire) {
        return transitions.stream()
                .filter(transition -> transition.getState1().equals(statePornire)).collect(Collectors.toList());
    }
}
