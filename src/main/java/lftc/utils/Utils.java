package lftc.utils;

import lftc.model.Transition;
import lftc.structures.AutomataGraph;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public List<String> convertToStringList(String str) {
        List<String> strings = new ArrayList<>();
        for (char c : str.toCharArray()) {
            strings.add(String.valueOf(c));
        }
        return strings;
    }
    public AutomataGraph getAutomataGraph(List<Transition> transitions) {
        AutomataGraph transMap = new AutomataGraph();
        for (Transition t : transitions) {
            transMap.put(t.getState1(), t);
        }
        return transMap;
    }
}
