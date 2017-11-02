package lftc.model;

import java.util.List;

public class Transition {
    private String state1;
    private String state2;
    private List<String> transitions;

    public Transition(String state1, String state2, List<String> transitions) {
        this.state1 = state1;
        this.state2 = state2;
        this.transitions = transitions;
    }

    public Transition() {
    }

    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    public String getState2() {
        return state2;
    }

    public void setState2(String state2) {
        this.state2 = state2;
    }

    public List<String> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<String> transitions) {
        this.transitions = transitions;
    }

    @Override
    public String toString() {
        return "{" +
                "state1='" + state1 + '\'' +
                ", state2='" + state2 + '\'' +
                ", transitions=" + transitions +
                '}'+'\n';
    }
}
