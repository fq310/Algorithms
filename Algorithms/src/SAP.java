import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class SAP {
     private Digraph G;
     // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        this.G = G;
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        checkParameter(v);
        checkParameter(w);
        ArrayList<Integer> listV = new ArrayList<Integer>();
        listV.add(v);
        ArrayList<Integer> listW = new ArrayList<Integer>();
        listW.add(w);
        Entry<Integer, Integer> parent = getParentNode(listV, listW);
        if (parent == null) return -1;
        return parent.getValue();
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        checkParameter(v);
        checkParameter(w);
        ArrayList<Integer> listV = new ArrayList<Integer>();
        listV.add(v);
        ArrayList<Integer> listW = new ArrayList<Integer>();
        listW.add(w);
        Entry<Integer, Integer> parent = getParentNode(listV, listW);
        if (parent == null) return -1;
        return parent.getKey();
    }
    
    private Entry<Integer, Integer> getParentNode(Iterable<Integer> v, Iterable<Integer> w) {
        Map<Integer, Integer> vParents = bfs(G, v);
        Map<Integer, Integer> wParents = bfs(G, w);
        Map<Integer, Integer> commonParents = new HashMap<Integer, Integer>();
        
        for (Integer vNode : vParents.keySet()) {
            Integer wParent = wParents.get(vNode);
            if (wParent == null) continue;
            int sumDistance = wParent + vParents.get(vNode);
            commonParents.put(vNode, sumDistance);
        }
        
        List<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(commonParents.entrySet());
        Collections.sort(list, new ParentComparator());
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
    private class ParentComparator implements Comparator<Entry<Integer, Integer>> {
        @Override
        public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        checkParameter(v);
        checkParameter(w);
        Entry<Integer, Integer> parent = getParentNode(v, w);
        if (parent == null) return -1;
        return parent.getValue();
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        checkParameter(v);
        checkParameter(w);
        Entry<Integer, Integer> parent = getParentNode(v, w);
        if (parent == null) return -1;
        return parent.getKey();
    }
    
    private Map<Integer, Integer> bfs(Digraph graph, Iterable<Integer> vertices) {
        Set<Integer> marked = new HashSet<Integer>();
        Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
        int[] distanceTo = new int[graph.V()];
        for (int i = 0; i < graph.V(); ++i) {
            distanceTo[i] = -1;
        }
        Queue<Integer> queue = new Queue<Integer>();
        for (Integer vertex : vertices) {
            queue.enqueue(vertex);
            marked.add(vertex);
            distanceTo[vertex] = 0;
        }
        while (!queue.isEmpty()) {
            int vertex = queue.dequeue();
            for (int adjacentVertex : graph.adj(vertex)) {
                if (marked.contains(adjacentVertex)) continue;
                queue.enqueue(adjacentVertex);
                marked.add(adjacentVertex);
                int newDistance = distanceTo[vertex] + 1;
                if (distanceTo[adjacentVertex] != -1) {
                    if (newDistance < distanceTo[adjacentVertex]) {
                        distanceTo[adjacentVertex] = newDistance;
                    }
                } else {
                    distanceTo[adjacentVertex] = newDistance;
                }
                parents.put(adjacentVertex, distanceTo[adjacentVertex]);
            }
        }
        return parents;
    }
    
    private void checkParameter(Iterable<Integer> v) {
        for (Integer i : v) {
            checkParameter(i);
        }
    }
    
    private void checkParameter(int v) {
        if (invalid(v))
            throw new IndexOutOfBoundsException();
    }
    
    private boolean invalid(int w) {
        if (0 <= w && w <= G.V()) return false;
        return true;
    }

    // for unit testing of this class (such as the one below)
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length   = sap.length(v, w);
            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }

}
