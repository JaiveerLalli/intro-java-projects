// Jaiveer Lalli
// 10/24/25
// CSE 121
// C2: Password Protector
// TA: Nhan Truong
// This class builds a password protector using different methods. The methods include
// logging in, checking for a character, attempting to guess the password, and also 
// generating a complex password.

import java.util.*;
public class PasswordProtector {

    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String SPECIAL_CHARACTERS = "!@#$%^&*(){}?+=";
    public static final String NUMBERS = "1234567890";
    public static final String ALL_CHARACTERS = LETTERS + LETTERS.toUpperCase() 
                                                + SPECIAL_CHARACTERS + NUMBERS;
    public static final String PASSWORD = "Ralph47$";

    public static void main(String[] args) {
        Random randy = new Random();
        /* 
        The five steps below can be used to time how long 
        passwordGuesser() takes to guess PASSWORD. 
        */

        // 1. Start timer
        long startTime = currentTime();
        
        // 2. Call passwordGuesser to crack PASSWORD
        String guessedPassword = passwordGuesser();

        // 3. Stop timer, calculate elapsed time
        double duration = elapsedTime(startTime);

        // 4. Check if the guessedPassword is correct by calling the login method
        boolean loggedIn = login(guessedPassword);

        // 5. Print results (if successful)
        if(loggedIn) {
            System.out.println("PASSWORD cracked in " + duration + " milliseconds");
        } else {
            System.out.println("Brute force attempt unsuccessful :(");
        }
        // Notice that the time taken by passwordGuesser() only depends on the password length.
        // The brute force algorithm we use in our tests will be a little more sophisticated...
    }

    // TODO: Implement the login method
    
    // Checks to see if the password entered (matchesPassword) matches the PASSWORD string.
    // returns true when the two strings match each other
    public static boolean login(String matchesPassword) {
        System.out.println("Logging in...");
        return matchesPassword.equals(PASSWORD);
    }


    // TODO: Implement the checkPasswordCharacter method
    
    // Checks to see if the character at the index matches to the PASSWORD string.
    // we use the char parameter to see which char we're looking for and the index parameter
    // to see where we're looking for that char. When they match we return true.
    public static boolean checkPasswordCharacter(char testChar, int index) {
        return testChar == PASSWORD.charAt(index);
    }

    // TODO: Implement the passwordGuesser method

    // Returns a string of the matching characters that we found in the 
    // checkPasswordCharacter method by looping through as many characters as we have in PASSWORD
    // and if checkPasswordCharacter returns true we add that char to the 
    // correctCharacters string and return that
    public static String passwordGuesser() {
        String correctCharacters = "";
        for (int i = 0; i < PASSWORD.length(); i++) {
            for (int j = 0; j < ALL_CHARACTERS.length(); j++) {
                if (checkPasswordCharacter(ALL_CHARACTERS.charAt(j), i)) {
                    correctCharacters += ALL_CHARACTERS.charAt(j);
                }
            }
        }
        return correctCharacters;
    }

    // TODO: Implement one of the creative option methods

    // This method returns a randomPassword of 5 characters. We do this by implementing
    // a random parameter and an int of the passwordLength. We use the random by picking
    // out 5 random letters/numbers from ALL_CHARACTERS and then adding that random char
    // to randomPassword, which is what we return.
    public static String generateComplexPassword(Random randy, int passwordLength) {
        String randomPassword = "";
        if (passwordLength < 5) {
            passwordLength = 5;
        }
        for (int i = 1; i <= passwordLength; i++) {
            int index = randy.nextInt(ALL_CHARACTERS.length());
            randomPassword += ALL_CHARACTERS.charAt(index);
        }
        return randomPassword;
    }

    

    // Returns the current time in nanoseconds
    public static long currentTime() {
        return System.nanoTime();
    }

    // Returns the difference between the current time and startTime,
    // and returns the result in milliseconds
    public static double elapsedTime(long startTime) {
        return (double) (System.nanoTime() - startTime) / 1_000_000;
    }
}

