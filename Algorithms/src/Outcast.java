import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Outcast {
    // constructor takes a WordNet object
    private WordNet wordnet;
    public Outcast(WordNet wordnet) {
        this.wordnet = wordnet;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns) {
        List<String> validNouns = new ArrayList<String>();
        for (String noun : nouns) {
            if (wordnet.isNoun(noun)) {
                validNouns.add(noun);
            }
        }
        String[] newNouns = new String[validNouns.size()];
        validNouns.toArray(newNouns);
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < newNouns.length; ++i) {
            String noun = newNouns[i];
            int distance = 0;
            for (int j = 0; j < newNouns.length; ++j) {
                if (j == i) continue;
                    distance += wordnet.distance(noun, newNouns[j]);
            }
            map.put(noun, distance);
        }
        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new ValueComparator());
        return list.get(list.size() - 1).getKey();
    }
    
    private class ValueComparator implements Comparator<Entry<String, Integer>> {
        @Override
        public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
    }

    // for unit testing of this class (such as the one below)
    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            String[] nouns = In.readStrings(args[t]);
            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }
}
