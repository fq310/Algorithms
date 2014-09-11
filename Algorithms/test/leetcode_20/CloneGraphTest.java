package leetcode_20;


import org.junit.Test;

public class CloneGraphTest {

	@Test
	public void test() {
		UndirectedGraphNode u0 = new UndirectedGraphNode(0);
		UndirectedGraphNode u1 = new UndirectedGraphNode(1);
		UndirectedGraphNode u2 = new UndirectedGraphNode(2);
		UndirectedGraphNode u3 = new UndirectedGraphNode(3);
		UndirectedGraphNode u4 = new UndirectedGraphNode(4);
		UndirectedGraphNode u5 = new UndirectedGraphNode(5);
		
		u0.neighbors.add(u1);
		u0.neighbors.add(u5);
		
		u1.neighbors.add(u2);
		u1.neighbors.add(u5);
		
		u2.neighbors.add(u3);
		
		u3.neighbors.add(u4);
		u3.neighbors.add(u4);
		
		u4.neighbors.add(u5);
		u4.neighbors.add(u5);
		
		CloneGraph c = new CloneGraph();
		UndirectedGraphNode newNode = c.cloneGraph(u0);
		newNode.neighbors.size();
	}

}
