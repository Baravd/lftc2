package lftc.repos;

import lftc.readers.AlphabetReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlphabetRepository {
    private AlphabetReader alphabetReader;
    private List<String> alphabet;

    public AlphabetRepository() {
        alphabetReader = new AlphabetReader("C:\\Faculta\\lftc\\labs\\FA\\src\\main\\resources\\alphabet");
        alphabet = new ArrayList<>();
        try {
            alphabet = alphabetReader.readAlphabetFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAlphabet() {
        return alphabet;
    }
}
