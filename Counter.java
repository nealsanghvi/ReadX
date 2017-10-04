import java.util.HashMap;
import java.util.Map;

/**
 * Created by nealsanghvi on 6/25/16.
 */
public class Counter {
    private HashMap<String, HashMap<String, Integer>> codename;

    public Counter() {
        codename = new HashMap<>();
    }

    public void add(String code, String word) {
        if (!codename.containsKey(code)) {
            HashMap<String, Integer> newkey = new HashMap<>();
            newkey.put(word, 1);
            codename.put(code, newkey);
        } else {
            HashMap existing = codename.get(code);
            //System.out.println("codename.get(code)" + "{" + code + "}" + "Before = " + existing);
            if (!existing.containsKey(word)) {
              //  System.out.println("FIRST IF STATEMENT");
                codename.get(code).put(word, 1);
                //System.out.println("codename.get(code)" + "{" + code + "}" + "After = " + existing);

            } else {
                //System.out.println("SECOND STATEMENT");
                int val = (int) existing.get(word);
                existing.put(word, val + 1);
                //System.out.println("codename.get(code)" + "{" + code + "}" + "After = " + existing);

            }

        }

    }

    public HashMap getHasher() {
        return codename;
    }


    public static void main(String[] args) {
        Counter parse = new Counter();
//        parse.add("CATARAN", "Catherine");
//        parse.add("CATARAN", "Catherine");
//        parse.add("CATARAN", "Catherine");
//        parse.add("CATARAN", "Catherine");
//        parse.add("CATARAN", "Catherine");
//        parse.add("CATARAN", "Catherine");
//        parse.add("CATARAN", "Catherine");
//
//        parse.add("CATARAN", "Katherine");
//        parse.add("CATARAN", "Katherine");
//        parse.add("CATARAN", "Katherine");
//        parse.add("CATARAN", "Katherine");
//        parse.add("CATARAN", "Katherine");
//        parse.add("CATARAN", "Katherine");
//        parse.add("CATARAN", "Katherine");
//        parse.add("CATARAN", "Katherine");
//        parse.add("CATARAN", "Katherine");
//        parse.add("CATARAN", "Katherine");
//        parse.add("CATARAN", "Katherine");
//        parse.add("CATARAN", "Katherine");
//
//
//        parse.add("CATARAN", "Katerina");
//        parse.add("CATARAN", "Katerina");
//        parse.add("CATARAN", "Katerina");
//
//        parse.add("JANATAN", "Johnathan");
//        parse.add("JANATAN", "Johnathan");
//        parse.add("JANATAN", "Johnathan");
//        parse.add("JANATAN", "Johnathan");
//        parse.add("JANATAN", "Johnathan");
//
//        parse.add("JANATAN", "Jonathan");
//        parse.add("JANATAN", "Jonathan");
//        parse.add("JANATAN", "Jonathan");
//        parse.add("JANATAN", "Jonathan");
//        parse.add("JANATAN", "Jonathan");
//        parse.add("JANATAN", "Jonathan");
//        parse.add("JANATAN", "Jonathan");
//        parse.add("JANATAN", "Jonathan");
//
//        parse.add("JAN", "Jon");
//
//        parse.add("TARAS", "Theresa");
//        parse.add("TARAS", "Theresa");
//        parse.add("TARAS", "Theresa");
//        parse.add("TARAS", "Theresa");
//        parse.add("TARAS", "Theresa");
//        parse.add("SNATH", "Smith");
//
//        parse.add("TARAS", "Theresa");
//
//        parse.add("TARAS", "Teresa");
//        parse.add("TARAS", "Teresa");
//
//        parse.add("SNATH", "Smith");
//        parse.add("SNATH", "Smith");
//        parse.add("SNATH", "Smith");
//        parse.add("SNATH", "Smith");
//        parse.add("SNATH", "Smith");
//        parse.add("SNATH", "Smith");
//        parse.add("SNATH", "Smith");
//        parse.add("SNATH", "Smith");
//        parse.add("SNATH", "Smith");
//        parse.add("SNATH", "Smith");
//        parse.add("SNATH", "Smith");
//        parse.add("SNATH", "Smith");
//
//        parse.add("SNATH", "Smyth");
//        parse.add("SNATH", "Smyth");
//        parse.add("SNATH", "Smyth");
//
//        parse.add("JASAC", "Jessica");
//        parse.add("JASAC", "Jessica");
//
//        parse.add("JAS", "Joshua");
//
////        int value = (int) parse.getInner("S200").get("Mek");
////        System.out.println("Mek = " + value);
//        System.out.println(parse.getHasher().get("CATARAN"));
//        System.out.println(parse.getHasher().get("JANATAN"));
//        System.out.println(parse.getHasher().get("JAN"));
//        System.out.println(parse.getHasher().get("TARAS"));
//        System.out.println(parse.getHasher().get("SNATH"));
//        System.out.println(parse.getHasher().get("JASAC"));
//        System.out.println(parse.getHasher().get("JAS"));
//
////        System.out.println(parse.getHasher().get("G350"));
    }
}
