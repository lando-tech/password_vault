package com.landotech;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordEngine {

    private SecureRandom secRandom;

    private static final int passwordPolicy = 4; // Minimum one of each character

    private static final char[] ALPHANUM = {
        'a', 'b', 'c', 'd', 'e', 'f', 
        'g', 'h', 'i', 'j', 'k', 'l', 
        'm', 'n', 'o', 'p', 'q', 'r', 
        's', 't', 'u', 'v', 'w', 'x', 
        'y', 'z', 'A', 'B', 'C', 'D', 
        'E', 'F', 'G', 'H', 'I', 'J', 
        'K', 'L', 'M', 'N', 'O', 'P', 
        'Q', 'R', 'S', 'T', 'U', 'V', 
        'W', 'X', 'Y', 'Z', '0', '1', 
        '2', '3', '4', '5', '6', '7', 
        '8', '9', '!', '@', '#', '$', 
        '%', '^', '&', '*', '(', ')', 
        '-', '_', '=', '+', '{', '}', 
        '|', '\\', ':', ';', '"', '\'', 
        '<', '>', '.', '?', '/', '[', 
        ']', ','
    };

    private static final char[] LOWERCASE_CHARS = {
        'a', 'b', 'c', 'd', 'e', 'f', 
        'g', 'h', 'i', 'j', 'k', 'l', 
        'm', 'n', 'o', 'p', 'q', 'r', 
        's', 't', 'u', 'v', 'w', 'x', 
        'y', 'z'
    };

    private static final char[] UPPERCASE_CHARS = {
        'A', 'B', 'C', 'D', 'E', 'F',
        'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z'
    };

    private static final char[] NUMBERS = {
        '0', '1', '2', '3', '4', '5',
        '6', '7', '8', '9'
    };

    private static final char[] SPECIAL_CHARS = {
        '!', '@', '#', '$', '%', '^',
        '&', '*', '(', ')', '-', '_',
        '=', '+', '{', '}', '|', '\\',
        ':', ';', '"', '\'', '<', '>',
        '.', '?', '/', '[', ']', ',',
    };

    PasswordEngine() {
        this.secRandom = new SecureRandom();
    }

    public String generatePassword(int length) {
        List<Character> passwordChars = new ArrayList<>();

        enforcePasswordPolicy(passwordChars);
        iterateAppendChars(passwordChars, length - passwordPolicy, ALPHANUM.length, ALPHANUM);

        String password = shufflePassword(passwordChars);
        verifyPasswordLength(password, length);
        return password;
    }

    public String generatePassword(int numChars, int numSpecialChars, int numDigits) {

        List<Character> passwordChars = new ArrayList<>();
        int totalChars = numChars + numSpecialChars + numDigits;

        int numLower;
        int numUpper;
        if (!(numChars % 2 == 0)) {
            numLower = numChars / 2 + 1;
            numUpper = numChars / 2;
        } else {
            numLower = numChars / 2;
            numUpper = numChars / 2;
        }

        if (verifyPasswordParams(numChars, numSpecialChars, numDigits)) {
            iterateAppendChars(passwordChars, numLower, LOWERCASE_CHARS.length - 1, LOWERCASE_CHARS);
            iterateAppendChars(passwordChars, numUpper, UPPERCASE_CHARS.length - 1, LOWERCASE_CHARS);
            iterateAppendChars(passwordChars, numSpecialChars, SPECIAL_CHARS.length - 1, SPECIAL_CHARS);
            iterateAppendChars(passwordChars, numDigits, NUMBERS.length - 1, NUMBERS);
        }
        String password = shufflePassword(passwordChars);
        verifyPasswordLength(password, totalChars);
        return password;
    }

    public String generatePassword(int numUpperCase, int numLowerCase, int numSpecialChars, int numDigits) {

        List<Character> passwordChars = new ArrayList<>();
        int totalChars = numUpperCase + numLowerCase + numSpecialChars + numDigits;

        if (verifyPasswordParams(numUpperCase, numLowerCase, numSpecialChars, numDigits)) {
            iterateAppendChars(passwordChars, numLowerCase, LOWERCASE_CHARS.length - 1, LOWERCASE_CHARS);
            iterateAppendChars(passwordChars, numUpperCase, UPPERCASE_CHARS.length - 1, LOWERCASE_CHARS);
            iterateAppendChars(passwordChars, numSpecialChars, SPECIAL_CHARS.length - 1, SPECIAL_CHARS);
            iterateAppendChars(passwordChars, numDigits, NUMBERS.length - 1, NUMBERS);
        }

        String password = shufflePassword(passwordChars);
        verifyPasswordLength(password, totalChars);
        return password;
    }

    private void iterateAppendChars(List<Character> passwordChars, int numChar, int randRange, char[] charArray) {
        for (int i = 0; i < numChar; i++) {
            int index = this.secRandom.nextInt(0, randRange);
            passwordChars.add(charArray[index]);
        }
    }

    private void appendChar(List<Character> passwordBuilder, int randRange, char[] charArray) {
        int index = this.secRandom.nextInt(0, randRange);
        passwordBuilder.add(charArray[index]);
    }

    private void enforcePasswordPolicy(List<Character> passwordChars) {
        appendChar(passwordChars, LOWERCASE_CHARS.length - 1, LOWERCASE_CHARS);
        appendChar(passwordChars, UPPERCASE_CHARS.length - 1, UPPERCASE_CHARS);
        appendChar(passwordChars, SPECIAL_CHARS.length - 1, SPECIAL_CHARS);
        appendChar(passwordChars, NUMBERS.length - 1, NUMBERS);
    }

    private String shufflePassword(List<Character> passwordChars) {
        Collections.shuffle(passwordChars);
        return toCustomString(passwordChars);
    }

    private String toCustomString(List<Character> passwordChars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (var it : passwordChars) {
            stringBuilder.append(it);
        }
        return stringBuilder.toString();
    }

    private boolean verifyPasswordLength(String password, int expectedLength) {
        if (password.length() != expectedLength) {
            throw new IllegalArgumentException(
                "Password length is not equal to the expected length. Current length: " + 
                password.length() + 
                " Expected Length: " + expectedLength);
        } else if (password.length() <= 3) {
            throw new IllegalArgumentException("Password length must be >= 4. Current length: " + password.length());
        }
        return true;
    }

    private boolean verifyPasswordParams(int numChars, int numSpecialChars, int numDigits) {
        if (numChars < 0 || numSpecialChars < 0 || numDigits < 0) {
            throw new IllegalArgumentException("Number of characters, special characters, and digits must be > 0.");
        }

        int totalChars = numChars + numSpecialChars + numDigits;
        if (totalChars == 0) {
            throw new IllegalArgumentException("Total number of characters must be > 0.");
        }
        return true;
    }

    private boolean verifyPasswordParams(int numUpperCase, int numLowerCase, int numSpecialChars, int numDigits) {
        if (numUpperCase < 0 || numLowerCase < 0 || numSpecialChars < 0 || numDigits < 0) {
            throw new IllegalArgumentException("Number of characters, special characters, and digits must be > 0.");
        }

        int totalChars = numUpperCase + numLowerCase + numSpecialChars + numDigits;
        if (totalChars == 0) {
            throw new IllegalArgumentException("Total number of characters must be > 0.");
        }
        return true;
    }
}
