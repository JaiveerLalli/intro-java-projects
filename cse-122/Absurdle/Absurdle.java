
// Jaiveer Lalli
// 2-18-26
// CSE 122
// TA: Yang Wu
// P2: Absurdle

// This class is a game of absurdle where the user chooses a dictionary of words
// to try to guess a random word. This random word changes around according to the users
// guesses to try to avoid being guessed. The user must enter in the correct amount Of 
// letters for guesses to be considered valid. The game ends when the user guesses the 
// target word.



import java.util.*;
import java.io.*;

public class Absurdle  {
    public static final String GREEN = "🟩";
    public static final String YELLOW = "🟨";
    public static final String GRAY = "⬜";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the game of Absurdle.");

        System.out.print("What dictionary would you like to use? ");
        String dictName = console.next();

        System.out.print("What length word would you like to guess? ");
        int wordLength = console.nextInt();

        List<String> contents = loadFile(new Scanner(new File(dictName)));
        Set<String> words = prepDictionary(contents, wordLength);

        List<String> guessedPatterns = new ArrayList<>();
        while (!isFinished(guessedPatterns)) {
            System.out.print("> ");
            String guess = console.next();
            String pattern = recordGuess(guess, words, wordLength);
            guessedPatterns.add(pattern);
            System.out.println(": " + pattern);
            System.out.println();
        }
        System.out.println("Absurdle " + guessedPatterns.size() + "/∞");
        System.out.println();
        printPatterns(guessedPatterns);
    }

    // Prints out the given list of patterns.
    // - List<String> patterns: list of patterns from the game
    public static void printPatterns(List<String> patterns) {
        for (String pattern : patterns) {
            System.out.println(pattern);
        }
    }

    // Returns true if the game is finished, meaning the user guessed the word. Returns
    // false otherwise.
    // - List<String> patterns: list of patterns from the game
    public static boolean isFinished(List<String> patterns) {
        if (patterns.isEmpty()) {
            return false;
        }
        String lastPattern = patterns.get(patterns.size() - 1);
        return !lastPattern.contains("⬜") && !lastPattern.contains("🟨");
    }

    // Loads the contents of a given file Scanner into a List<String> and returns it.
    // - Scanner dictScan: contains file contents
    public static List<String> loadFile(Scanner dictScan) {
        List<String> contents = new ArrayList<>();
        while (dictScan.hasNext()) {
            contents.add(dictScan.next());
        }
        return contents;
    }


    // This method narrows down the words according to the length of the words that the user
    // wants to play with
    // Parameters:
    //    - contents: takes in the dictionary file full of words
    //    - wordLength: indicates the length of the words the user wants to play with
    // Exceptions:
    //    - IllegalArgumentException is thrown when the wordLength is less than 1
    // Returns:
    //     - wordSet: a set of words that are valid in the dictionary and matches the wordLength
    public static Set<String> prepDictionary(List<String> contents, int wordLength) {
        if (wordLength < 1) {
            throw new IllegalArgumentException();
        }
        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < contents.size(); i++) {
            if (contents.get(i).length() == wordLength) {
                wordSet.add(contents.get(i));
            }
        }
        return wordSet;
        
    }


    // This method records the users guess and sorts the patterns of words, changing around the
    // the target word.
    // Parameters:
    //    - guess: represents the users guess
    //    - words: represents the possible words that the user is guessing from
    //    - wordLength: represents the length of the words that are being guessed
    // Exceptions:
    //    - IllegalArgumentException is thrown if words is empty or the users guess length
    // does not match the wordLength
    // Returns:
    //    - the best pattern of letter matches that are in the set of words
    public static String recordGuess(String guess, Set<String> words, int wordLength) {
        if (words.isEmpty() || guess.length() != wordLength) {
            throw new IllegalArgumentException();
        }
        Map<String, Set<String>> possibleWordsMap = new TreeMap<>();
        for (String possibleWords : words) {
            String pattern = patternFor(possibleWords, guess);
            if (!possibleWordsMap.containsKey(pattern)) {
                Set<String> newPatterns = new HashSet<>();
                newPatterns.add(possibleWords);
                possibleWordsMap.put(pattern, newPatterns);
            } else {
            Set<String> oldPatterns = possibleWordsMap.get(pattern);
            oldPatterns.add(possibleWords);
            }
        }
        String bestPattern = bestPattern(possibleWordsMap);
        words.clear();
        words.addAll(possibleWordsMap.get(bestPattern));
        return bestPattern;
    }


    // this method goes through possible words that can be the target word and 
    // returns the pattern with the largest amount of words still possible for that same
    // pattern
    // Parameters:
    //    - possibleWordsMap: A map that has all of the possible words while keeping track of 
    //     the current pattern from the users guess.
    public static String bestPattern(Map <String, Set<String>> possibleWordsMap) {
        String largestPattern = "";
        int largestSize = 0;
        for (String pattern : possibleWordsMap.keySet()) {
            Set<String> patternHolder = possibleWordsMap.get(pattern);
            if (patternHolder.size() > largestSize) {
                largestSize = patternHolder.size();
                largestPattern = pattern;
            }
        }
        return largestPattern;
    }


    // This method examines the users guess to the target word and returns the colored
    // squares that indicates to the user how close they were. With gray representing that
    // the letter is not in the word, yellow being that the letter is correct but in the wrong
    // position, and green being that the letter is in the correct place
    // Parameters:
    //    - word: represents the target word that the user is attempting to guess
    //    - guess: represents the users guess
    public static String patternFor(String word, String guess) {
        String result = "";

        List<String> guessLetters = new ArrayList();        
        for (int i = 0; i < guess.length(); i++) {
            guessLetters.add(i, "" + guess.charAt(i));
        }

        Map<Character, Integer> wordLetterCounts = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (wordLetterCounts.containsKey(letter)) {
                wordLetterCounts.put(letter, wordLetterCounts.get(letter) + 1);
            } else {
                wordLetterCounts.put(letter, 1);
            }
        }
        for (int i = 0; i < guessLetters.size(); i++) {
            if (guessLetters.get(i).charAt(0) == word.charAt(i)) {
                guessLetters.set(i, GREEN);
                wordLetterCounts.put(word.charAt(i), wordLetterCounts.get(word.charAt(i)) - 1);
            
            }
        }
        for (int i = 0; i < guessLetters.size(); i++) {
            if (wordLetterCounts.containsKey(guess.charAt(i)) && 
            (wordLetterCounts.get(guess.charAt(i)) > 0) && (!guessLetters.get(i).equals(GREEN))) {
                guessLetters.set(i, YELLOW);
                wordLetterCounts.put(guess.charAt(i), 
                        wordLetterCounts.get(guess.charAt(i)) - 1);
            } else if (!guessLetters.get(i).equals(GREEN) && 
                                !guessLetters.get(i).equals(YELLOW)) {
                guessLetters.set(i, GRAY);
            }
            result += guessLetters.get(i);

        }
        
        return result;

    }
}
