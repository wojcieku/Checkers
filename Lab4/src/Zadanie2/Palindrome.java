package Zadanie2;

import java.io.Serializable;

/**
 * To store palindromes.
 */
public class Palindrome implements Serializable {
    /**
     * For serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * This palindrome.
     */
    private final String palindrome;

    /**
     * This palindrome with punctuation removed.
     */
    private String rawPalindrome;

    /**
     * @return This palindrome.
     */
    public String getPalindrome() {
        return palindrome;
    }

    /**
     * Makes the raw representation of this palindrome.
     */
    private void makeRawPalindrome() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < palindrome.length(); i++) {
            if (Character.isLetter(palindrome.charAt(i))) {
                sb.append(palindrome.charAt(i));
            }
        }
        rawPalindrome = sb.toString().toLowerCase();
    }

    /**
     * Tries to create a palindrome from the given word.
     * @param palindromeCandidate to set. If this word is not a palindrome, a runtime
     *                   exception is thrown (need not to be checked).
     */
    public Palindrome(final String palindromeCandidate) {
        this.palindrome = palindromeCandidate;
        makeRawPalindrome();

        if (!isPalindrome(rawPalindrome)) {
            throw new IllegalArgumentException("[" + palindromeCandidate + "] is not a palindrome.");
        }
    }

    @Override
    public String toString() {
        return palindrome;
    }

    @Override
    public boolean equals(final Object anObject) {
        if (anObject == null) {
            return false;
        }
        if (anObject instanceof Palindrome) {
            return rawPalindrome.equals(((Palindrome) anObject).rawPalindrome);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return rawPalindrome.hashCode();
    }

    /**
     * Library function that finds the longest palindrome in the given word.
     *
     * @param word to be searched in to find the longest palindrome.
     * @return the longest palindrome found or empty string if no palindrome in the
     *         given word.
     */
    public static String findLongestPalindrome(final String word) {
        String longestPalidrome = "";
        for (int i = 0; i < word.length(); i++) {
            final String current = analyzeSubstring(word.substring(i));
            if (longestPalidrome.length() < current.length()) {
                longestPalidrome = current;
            }
        }
        return longestPalidrome;
    }

    /**
     * An auxiliary library function that tries to find the palindrome in the given word,
     * starting from its beginning.
     *
     * @param word to be searched in to find a palindrome.
     * @return palindrome found or empty string if no palindrome was found in the
     *         given word.
     */
    private static String analyzeSubstring(final String word) {
        for (int i = word.length(); i > 0; i--) {
            final String subword = word.substring(0, i);
            if (isPalindrome(subword)) {
                return subword;
            }
        }
        return "";
    }

    /**
     * Checks if the word is a palindrome.
     * Implementation remark: reverses the word and compares both.
     * @param word to be checked.
     * @return <code>true</code> if the given word is a palindrome,
     *         <code>false</code> otherwise.
     */
    public static boolean isPalindrome(final String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }

    /**
     * Checks if the word is a palindrome.
     * Implementation remark: directly compares characters at both ends of the word.
     * @param word to be checked.
     * @return <code>true</code> if the given word is a palindrome,
     *         <code>false</code> otherwise.
     */
    public static boolean isPalindrome2(final String word) {
        int half = word.length() >> 1;
        int lOne = word.length() - 1;
        for (int i = 0; i < half; i++) {
            if (word.charAt(i) != word.charAt(lOne - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Simple class' test.
     * @param args not used.
     */
    public static void main(final String[] args) {
        final Palindrome p1 = new Palindrome("kobyłamamałybok");
        final Palindrome p2 = new Palindrome("kobyła ma mały bok!");
        final Palindrome p3 = new Palindrome("elf układał kufle");

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);

        System.out.println("p1 == p2 : " + (p1 == p2));
        System.out.println("p1.equals(p2) : " + p1.equals(p2));
        System.out.println("p1.equals(p3) : " + p1.equals(p3));

        final String word = "rrrrr abccccccccccccba kobyłamamałybok";
        final String longestPalindrome = findLongestPalindrome(word);
        System.out.println("longestPalindrome: " + longestPalindrome);
    }
}
