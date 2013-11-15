import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WordNet {
    private Set<String> words = new HashSet<String>();
    private Map<String, Word> synsetsMap = new HashMap<String, Word>();
    private Map<String, Word> nameToWord = new HashMap<String, Word>();
    private class Word {
        private String id;
        private String name;
        private List<Word> hypernyms = new ArrayList<Word>();
        private Map<String, Integer> distanceMap = new HashMap<String, Integer>();
        public Word(String id, String name) {
            this.id = id;
            this.name = name;
            distanceMap.put(name, 0);
        }
        public void addDistance(String targetWord, int distance) {
            distanceMap.put(targetWord, distance);
        }
        public Integer getDistance(String word) {
            return distanceMap.get(word);
        }
        public List<Word> getHypernyms() {
            return hypernyms;
        }
        public void addHypernyms(Word hypernym) {
            this.hypernyms.add(hypernym);
        }
        public String getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        @Override
        public String toString() {
            return "name : "+ name + " parents ->> " + hypernyms;
        }
    }
    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        List<String> synsetList = readAllLines(synsets);
        for (String synset : synsetList) {
            String[] values = synset.split(",");
            Word word = new Word(values[0].trim(), values[1].trim());
            synsetsMap.put(word.getId(), word);
            words.add(word.getName());
            nameToWord.put(word.getName(), word);
        }
        List<String> hypernymsList = readAllLines(hypernyms);
        for (String hypernym : hypernymsList) {
            String[] values = hypernym.split(",");
            String childID = values[0];
            Word child = synsetsMap.get(childID);
            for (int i = 1; i < values.length; ++i) {
                String parentID = values[i];
                Word parent = synsetsMap.get(parentID);
                child.addHypernyms(parent);
            }
        }
    }

    private List<String> readAllLines(String synsets) {
        In in = new In(synsets);
        List<String> lines = new ArrayList<String>();
        while (!in.isEmpty()) {
            String s = in.readLine();
            lines.add(s);
        }
        return lines;
    }

    // the set of nouns (no duplicates), returned as an Iterable
    public Iterable<String> nouns() {
        return words;
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        return words.contains(word);
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        checkParameter(nounA);
        checkParameter(nounB);
        return sapEntry(nounA, nounB).getValue();
    }

    private void checkParameter(String noun) {
        if (isNoun(noun)) return;
        throw new IllegalArgumentException();
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        checkParameter(nounA);
        checkParameter(nounB);
        return sapEntry(nounA, nounB).getKey().getName();
    }
    
    private Entry<Word, Integer> sapEntry(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB))
            throw new IllegalArgumentException();
        Set<Word> parentsOfA = getAllParents(nameToWord.get(nounA));
        Set<Word> parentsOfB = getAllParents(nameToWord.get(nounB));
        Set<Word> commonParents = new HashSet<Word>();
        for (Word parent : parentsOfA) {
            if (parentsOfB.contains(parent)) {
                commonParents.add(parent);
            }
        }
        Map<Word, Integer> parentDistanceMap = new HashMap<Word, Integer>();
        for (Word parent : commonParents) {
            int stepsA = parent.getDistance(nounA);
            int stepsB = parent.getDistance(nounB);
            parentDistanceMap.put(parent, stepsA + stepsB);
        }
        List<Entry<Word, Integer>> list = new LinkedList<Entry<Word, Integer>>(parentDistanceMap.entrySet());
        Collections.sort(list, new ValueComparator());
        return list.get(0);
    }
    
    private class ValueComparator implements Comparator<Entry<Word, Integer>> {
        @Override
        public int compare(Entry<Word, Integer> o1, Entry<Word, Integer> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
    }

    private Set<Word> getAllParents(Word word) {
        Queue<Word> queue = new Queue<Word>();
        Set<Word> marked = new HashSet<Word>();
        queue.enqueue(word);
        marked.add(word);
        
        while (!queue.isEmpty()) {
            Word currentWord = queue.dequeue();
            for (Word parent : currentWord.getHypernyms()) {
                if (!marked.contains(parent)) {
                    marked.add(parent);
                    queue.enqueue(parent);
                    int newDistance = currentWord.getDistance(word.getName()) + 1;
                    Integer oldDistance = parent.getDistance(word.getName());
                    if (oldDistance == null) {
						parent.addDistance(word.getName(), newDistance);
                    } else {
                    	if (newDistance < oldDistance) {
                    		parent.addDistance(word.getName(), newDistance);
                    	}
                    }
                }
            }
        }
        return marked;
    }

    // for unit testing of this class
    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        while (!StdIn.isEmpty()) {
            String v = StdIn.readString();
            String w = StdIn.readString();
            int length   = wordnet.distance(v, w);
            StdOut.printf("length = %d\n", length);
        }
    }

}
