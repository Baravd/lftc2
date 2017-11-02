package lftc.repos;

import lftc.model.State;
import lftc.readers.StateReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StateRepository {
    private List<State> states;
    private StateReader stateReader;

    public StateRepository() {
        stateReader = new StateReader("C:\\Faculta\\lftc\\labs\\FA\\src\\main\\resources\\states.txt");
        states = new ArrayList<>();
        try {
            states = stateReader.readStatesFromFile();
            System.out.println(states);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<State> getStates() {
        return states;
    }

    public List<State> getFinalStates() {
        return states.stream().filter(state -> state.getFinalState().equals(true)).collect(Collectors.toList());
    }

    public State getInitialState() throws Exception {
        List<State> collect = states.stream().filter(state -> state.getInitialState().equals(true)).collect(Collectors.toList());
        if (collect.size() > 1) {
            throw new Exception("more than one intil state!");
        }
        return collect.get(0);
    }

    public State getStateFromName(String state) {
        for (State state1 : states) {
            if (state1.getName() == state) {
                return state1;
            }
        }
        return null;
    }
}
