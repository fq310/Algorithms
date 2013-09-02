package coursera.part1.week1;

public class QuickFindUF {
    private int[] id;
    private int count;

    // instantiate N isolated components 0 through N-1
    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    // return number of connected components
    public int count() {
        return count;
    }

    // Return component identifier for component containing p
    public int find(int p) {
        return id[p];
    }

    // are elements p and q in the same component?
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // merge components containing p and q
    public void union(int p, int q) {
        if (connected(p, q)) return;
        int pid = id[p];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid) id[i] = id[q]; 
        count--;
    }
    
    public int[] getID() {
    	return this.id;
    }

    public static void main(String[] args) {
    	QuickFindUF un = new QuickFindUF(10);
    	un.union(1, 3);
    	un.union(9, 8);
    	un.union(1, 0);
    	un.union(2, 7);
    	un.union(8, 2);
    	un.union(1, 4);
    	for (int i : un.getID()) {
    		System.out.print(i + " ");
    	}
    }

}