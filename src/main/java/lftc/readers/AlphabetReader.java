package lftc.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlphabetReader {
    private String fileName;

    public AlphabetReader(String fileName) {
        this.fileName = fileName;
    }

    public List<String> readAlphabetFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<String> lines  = reader.lines().collect(Collectors.toList());
            return lines.stream()
                    .map(s -> s.split(";"))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
        }
    }
}
