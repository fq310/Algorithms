
public class Subset {
    public static void main(String[] args) {
        int subsetNumber = Integer.valueOf(args[0]);
        if (StdIn.isEmpty()) return;
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        String[] inputs = StdIn.readAllStrings();
        for (String input : inputs) {
            String value = input.trim();
            if (value.length() == 0) continue;
            queue.enqueue(value);
        }
        for (int i = 0; i < subsetNumber; ++i) {
            StdOut.println(queue.dequeue());
        }
    }
}
