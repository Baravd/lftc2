package lftc.readers;

import lftc.model.Transition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransitionReader {
    private String fileName;

    public TransitionReader(String fileName) {
        this.fileName = fileName;
    }

    public List<Transition> readTransitionsFromFile() throws IOException {
        List<Transition> transitions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<String> lines = reader.lines().collect(Collectors.toList());
            return lines.stream()
                    .map(s -> {
                        String[] split = s.split(";");
                        String[] trans = split[2].split(" ");

                        return new Transition(split[0], split[1], Arrays.asList(trans));
                    })
                    .collect(Collectors.toList());
        }
    }
}
