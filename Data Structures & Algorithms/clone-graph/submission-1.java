/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public Node cloneGraph(Node node) {
        Map<Node, Node> oldGraphs = new HashMap<>();
        return dfs(node, oldGraphs);
    }

    private Node dfs(Node node, Map<Node, Node> oldGraphs) {
        if (node == null) {
            return null;
        }

        if (oldGraphs.containsKey(node)) {
            return oldGraphs.get(node);
        }

        Node newNode = new Node(node.val, new ArrayList<>());
        oldGraphs.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(neighbor, oldGraphs));
        }

        return newNode;
    }
}
/**
Questions:
0 <= The number of nodes in the graph <= 100.
1 <= Node.val <= 100
There are no dublicate edges and no self-loops in the graph

1 - 2   1' - 2'
|   |   |    |
3 - 4   3' - 4'

1:[2,3]
       ^
2:[1,4]
       ^
3:[1,4]
       ^
4:[2,3]
       ^
Map old node to new node
[1:1',2:2',3:3',4:4']

TC: O(V + E), SC: O(V)
*/