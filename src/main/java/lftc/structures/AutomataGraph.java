package lftc.structures;

import lftc.model.Transition;

import java.util.ArrayList;
import java.util.List;

public class AutomataGraph {
    private List<Pereche> transitions;

    public AutomataGraph() {
        transitions = new ArrayList<>();
    }

    public void put(String key, Transition value) {
        transitions.add(new Pereche(key, value));

    }

    public List<Transition> get(String key) {
        List<Transition> list = new ArrayList<>();
        for (Pereche item : transitions) {
            String x = item.getX();
            //System.out.println("comparare="+x+"|"+key);
            if (x.equals(key)) {
               list.add(item.getY());
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return "AutomataGraph{" +
                "transitions=" + transitions +
                '}';
    }
}
