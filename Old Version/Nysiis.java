import java.io.IOException;
import java.util.*;
import java.util.Scanner;

/**
 * Created by nealsanghvi on 6/25/16.
 */

public class Nysiis {

    private StringBuffer word = null;

    public Result sencode(String word) {
        Nysiis ny = new Nysiis();
        return ny.encode(word);
    }

    /**
     * Encode the given string using the Nysiis phonetic encoding algorithm.
     *
     * @param originalWord
     * @return String - the encoded word
     */
    public Result encode(String originalWord) {

        if (originalWord != null &&
                originalWord.length() > 0) {
            word = new StringBuffer(originalWord.toUpperCase());
        } else {
            Result res = new Result(originalWord, "");
            return res;
        }
        char first;

        while (word.toString().endsWith("S") || word.toString().endsWith("Z")) {
            word.deleteCharAt(word.length() - 1);
        }

        replaceFront("MAC", "MC");
        replaceFront("PF", "F");
        replaceEnd("IX", "IC");
        replaceEnd("EX", "EC");

        replaceEnd("YE", "Y");
        replaceEnd("EE", "Y");
        replaceEnd("IE", "Y");

        replaceEnd("DT", "D");
        replaceEnd("RT", "D");
        replaceEnd("RD", "D");


        replaceEnd("NT", "N");
        replaceEnd("ND", "N");

        replaceAll("EV", "EF", 1);


        first = word.charAt(0);

        replaceAll("E", "A");
        replaceAll("I", "A");
        replaceAll("O", "A");
        replaceAll("U", "A");

        replaceAll("AW", "A");
        replaceAll(" ", "");
        replaceAll("DB", "B");

        replaceAll("GHT", "GT");
        replaceAll("DG", "G");
        replaceAll("PH", "F");

        replaceAll("AH", "A", 1);
        replaceAll("HA", "A", 1);

        replaceAll("KN", "N");
        replaceAll("K", "C");

        replaceAll("M", "N", 1);
        replaceAll("Q", "G", 1);

        replaceAll("SH", "S");
        replaceAll("SCH", "S");

        replaceAll("YW", "Y");

        replaceAll("Y", "A", 1, word.length() - 2);

        replaceAll("WR", "R");

        replaceAll("Z", "S", 1);

        replaceEnd("AY", "Y");

        while (word.toString().endsWith("A")) {
            word.deleteCharAt(word.length() - 1);
        }

        reduceDuplicates();

        if (('A' == first
                || 'E' == first
                || 'I' == first
                || 'O' == first
                || 'U' == first) && word.length() > 0) {
            word.deleteCharAt(0);
            word.insert(0, first);
        }

        String encoded = word.toString();
        Result result = new Result(originalWord, encoded);
        return result;
    }

    /**
     * Traverse the string reducing duplicated characters.
     */
    private void reduceDuplicates() {
        char lastChar;
        StringBuffer newWord = new StringBuffer();

        if (0 == word.length()) {
            return;
        }

        lastChar = word.charAt(0);
        newWord.append(lastChar);
        for (int i = 1; i < word.length(); ++i) {
            if (lastChar != word.charAt(i)) {
                newWord.append(word.charAt(i));
            }
            lastChar = word.charAt(i);
        }

        word = newWord;
    }

    /**
     * Replace all occurances of the given pattern in the string to be encoded
     * with the given replacement.
     *
     * @param find the sequence to locate
     * @param repl the string to replace it with
     */
    private void replaceAll(String find,
                            String repl) {
        replaceAll(find, repl, 0, -1);
    }

    /**
     * Replace all occurances of the given pattern in the string to be encoded
     * with the given replacement, beginning at the given staring position.
     *
     * @param find     the sequence to locate
     * @param repl     the string to replace it with
     * @param startPos the position to begin at
     */
    private void replaceAll(String find,
                            String repl,
                            int startPos) {
        replaceAll(find, repl, startPos, -1);
    }

    /**
     * Replace all occurances of the given pattern in the string to be encoded
     * with the given replacement, beginning at the given staring position up to
     * the given end position.
     *
     * @param find     the sequence to locate
     * @param repl     the string to replace it with
     * @param startPos the position to begin at
     * @param endPos   the position to stop at
     */
    private void replaceAll(String find,
                            String repl,
                            int startPos,
                            int endPos) {
        int pos = word.toString().indexOf(find, startPos);

        if (-1 == endPos) {
            endPos = word.length() - 1;
        }

        while (-1 != pos) {
            if (-1 != endPos && pos > endPos) {
                break;
            }

            word.delete(pos, pos + find.length());

            word.insert(pos, repl);

            pos = word.toString().indexOf(find);

        }

    }

    /**
     * If the encoded string begins with the given find string, replace it.
     *
     * @param find the prefix to test for
     * @param repl the replacement to substitue
     */
    private void replaceFront(String find,
                              String repl) {
        if (word.toString().startsWith(find)) {
            word.delete(0, find.length());
            word.insert(0, repl);
        }
    }

    /**
     * If the encoded string ends with the given find string, replace it.
     *
     * @param find the suffix to test for
     * @param repl the replacement to substitue
     */
    private void replaceEnd(String find,
                            String repl) {
        if (word.toString().endsWith(find)) {
            word.delete(word.length() - find.length(), word.length());
            word.append(repl);
        }
    }
    public static void main(String[] args) throws IOException {
        Nysiis ny = new Nysiis();
        Counter parse = new Counter();
        List list = new List();
        list.reader();

        Scanner input = new Scanner(System.in);


        System.out.println("Enter location: ");
        String location = input.nextLine();


        for (int i = 1; i < list.getAllNames().size(); i++) {
            parse.add(ny.sencode(list.getAllNames().get(i)).getEncoded(), ny.sencode(list.getAllNames().get(i)).getOG());

        }

        HashMap<String, HashMap<String, Integer>> temp = parse.getHasher();

        for (String key : temp.keySet()) {
            HashMap<String, Integer> x = temp.get(key);
            if (x.containsKey(location)) {
                for (String og : x.keySet()) {
                    Integer y = x.get(og);
                    System.out.println((og + " occurs " + y + " time(s) in the set"));
                }
            }
        }

        System.out.println("");
        System.out.println("");

        System.out.println("Enter again to see all the matches: ");
        String n = input.nextLine();

        for (String key : temp.keySet()) {
            HashMap<String, Integer> x = temp.get(key);
            for (String og : x.keySet()) {
                Integer y = x.get(og);
                System.out.println((og + " occurs " + y + " time(s) in the set"));
            }
            System.out.println("");
            System.out.println("");
        }

    }
}

/** Credit for framework of algorithm to New York State Identification and Intelligence System **/

