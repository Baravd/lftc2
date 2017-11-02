package lftc.readers;

import lftc.model.State;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StateReader {
    private String fileName;

    public StateReader(String fileName) {
        this.fileName = fileName;
    }

    public List<State> readStatesFromFile() throws IOException {
        List<State> states = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<String> lines = reader.lines().collect(Collectors.toList());
            return lines.stream()
                    .map(s -> {
                        String[] elements = s.split(";");
                        return new State(elements[0], Boolean.valueOf(elements[1]), Boolean.valueOf(elements[2]));
                    })
                    .collect(Collectors.toList());
        }
    }

}
