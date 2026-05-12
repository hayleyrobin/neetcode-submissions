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
    // adjacency list -> travserse node/neighbors using bfs/dfs
    public Node cloneGraph(Node node) { 
        // graph may contain cycles, so cannot simply copy nodes recursively w/o remembering what we've already copied.
        // Hashmap to track visited nodes to prevent infinite loops in cyclic graphs
        
        if(node == null) return null; // if input node is null

        // a map (original node → cloned node)
        Map<Node, Node> oldToNew = new HashMap<>();
        return dfs(node, oldToNew);
    }
    private Node dfs(Node node, Map<Node, Node> oldToNew){
        if(node == null) return null;
        
        // if orginal ndoe already in map, return it's clone
        if(oldToNew.containsKey(node)){
            return oldToNew.get(node); 
        }
        // if first time seeing node, create its copy
        Node copyNode = new Node(node.val);
        oldToNew.put(node, copyNode);

        // recursively clone all neighbors & add them to the clone's neighbor list
        for(Node neighbor : node.neighbors){
            copyNode.neighbors.add(dfs(neighbor, oldToNew));
        }
        return copyNode; // return cloned node corresponding to the OG node
    }
}