package coursera.part1.week1;

public class WeightedQuickUnionUF {
    private int[] id;    // id[i] = parent of i
    private int[] sz;    // sz[i] = number of objects in subtree rooted at i
    private int count;   // number of components

    // Create an empty union find data structure with N isolated sets.
    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    // Return the number of disjoint sets.
    public int count() {
        return count;
    }

    // Return component identifier for component containing p
    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

   // Are objects p and q in the same set?
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

  
   // Replace sets containing p and q with their union.
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        // make smaller root point to larger one
        if   (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else                 { id[j] = i; sz[i] += sz[j]; }
        count--;
    }
    
    public int[] getID() {
    	return this.id;
    }


    public static void main(String[] args) {
    	WeightedQuickUnionUF un = new WeightedQuickUnionUF(10);
    	un.union(8, 0);
    	un.union(3,5 );
    	un.union(1,3 );
    	un.union(9,2 );
    	un.union(3,4 );
    	un.union(8,9 );
    	un.union(1, 7);
    	un.union(1,6 );
    	
    	un.union(0, 6);
//    	un.union(7, 4);
//    	un.union(8, 9);
//    	un.union(6, 0);
//    	un.union(8, 7);
//    	un.union(8, 2);
//    	un.union(1, 7);
    	for (int i : un.getID()) {
    		System.out.print(i + " ");
    	}
    	
    }

}