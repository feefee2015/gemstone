import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Definition for undirected graph.
	static class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		HashMap<UndirectedGraphNode, UndirectedGraphNode> cloned = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		return cloneGraph(node, cloned);
	}

	static UndirectedGraphNode cloneGraph(UndirectedGraphNode node,
			HashMap<UndirectedGraphNode, UndirectedGraphNode> cloned) {
		if (cloned.containsKey(node)) {
			return cloned.get(node);
		}
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		cloned.put(node, copy);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			if (!cloned.containsKey(neighbor)) {
				UndirectedGraphNode nc = cloneGraph(neighbor, cloned);
				cloned.put(neighbor, nc);
			}
			copy.neighbors.add(cloned.get(neighbor));
		}
		return copy;
	}

}
