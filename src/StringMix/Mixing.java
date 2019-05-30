package StringMix;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mixing {

    public static void main(String[] args) {
        mix("Are they here", "yes, they are here");
    }

    public static String mix(String s1, String s2) {

        final Map<Character, Integer> dictionary1 = fillDictionary(s1);
        final Map<Character, Integer> dictionary2 = fillDictionary(s2);

        Map<Character, Integer> dictionary = uniteDictionaries(dictionary1, dictionary2);
        Map<Character, Integer> states = getStates(dictionary1, dictionary2, dictionary);

        List list = new ArrayList(dictionary.entrySet());
        Collections.sort(list, (Comparator<Map.Entry<Character, Integer>>) (e1, e2) -> e1.getKey().compareTo(e2.getKey()));
        Collections.sort(list, (Comparator<Map.Entry<Character, Integer>>) (e1, e2) -> e2.getValue() - e1.getValue());

        String differentiation = "";

        for (int i = 0; i < list.size(); i++) {
            differentiation += createSubstring(list.get(i).toString(), states);
        }
        System.out.println(differentiation.substring(0, differentiation.length() - 1));
        return differentiation.substring(0, differentiation.length() - 1);
    }

    public static Map<Character, Integer> getStates(Map<Character, Integer> dict1, Map<Character, Integer> dict2, Map<Character, Integer> dict) {
        Set<Character> characterSet = dict.keySet();
        Map<Character, Integer> states = new HashMap<>();
        for (Character c : characterSet) {
            if (!dict1.containsKey(c))
                states.put(c, 2);
            else if (!dict2.containsKey(c))
                states.put(c, 1);
            else if (dict1.get(c) < dict2.get(c))
                states.put(c, 2);
            else if (dict1.get(c) > dict2.get(c))
                states.put(c, 1);
            else states.put(c, 0);
        }
        return states;
    }

    public static Map<Character, Integer> fillDictionary(String s) {
        Map<Character, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                if (dictionary.containsKey(s.charAt(i)))
                    dictionary.put(s.charAt(i), dictionary.get(s.charAt(i)) + 1);
                else
                    dictionary.put(s.charAt(i), 1);
            }
        }

        Set<Character> characterSet = dictionary.keySet();
        Collection<Character> removeCandidates = new LinkedList<>();

        for (Character c : characterSet) {
            if (dictionary.get(c) == 1)
                removeCandidates.add(c);
        }

        for (char c : removeCandidates) {
            dictionary.remove(c);
        }

        return dictionary;
    }

    public static String createSubstring(String s, Map<Character, Integer> states) {
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(s);

        Pattern pattern2 = Pattern.compile("\\d+");
        Matcher matcher2 = pattern2.matcher(s);
        while (matcher.find()) while (matcher2.find()) {
            switch (states.get(s.substring(matcher.start(), matcher.end()).charAt(0))) {
                case 0:
                    return "=:" + new String(new char[Integer.parseInt(s.substring(matcher2.start(), matcher2.end()))]).replace("\0", s.substring(matcher.start(), matcher.end())) + "/";
                case 1:
                    return "1:" + new String(new char[Integer.parseInt(s.substring(matcher2.start(), matcher2.end()))]).replace("\0", s.substring(matcher.start(), matcher.end())) + "/";
                case 2:
                    return "2:" + new String(new char[Integer.parseInt(s.substring(matcher2.start(), matcher2.end()))]).replace("\0", s.substring(matcher.start(), matcher.end())) + "/";
            }
        }
        return "";
    }

    public static Map<Character, Integer> uniteDictionaries(Map<Character, Integer> dict1, Map<Character, Integer> dict2) {
        Map<Character, Integer> dict = new HashMap<>();
        Set<Character> characterSet = dict1.keySet();
        for (Character c : characterSet) dict.put(c, dict1.get(c));
        characterSet = dict2.keySet();
        for (Character c : characterSet) {
            if (dict.containsKey(c) && dict.get(c) < dict2.get(c))
                dict.put(c, dict2.get(c));
            else if (!dict.containsKey(c))
                dict.put(c, dict2.get(c));
        }
        return dict;
    }
}
