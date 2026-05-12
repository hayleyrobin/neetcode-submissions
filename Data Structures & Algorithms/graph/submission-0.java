class Graph {
    Map<Integer, HashSet<Integer>> adjList;
    public Graph() {
        adjList = new HashMap<>(); // src node -> Set() of neighbors
    }

    public void addEdge(int src, int dst) {
        // if key/node/vertex dsnt exist in map yet
        adjList.putIfAbsent(src,new HashSet<>());
        // if destiantion dsnt exist in map yet
        adjList.putIfAbsent(dst, new HashSet<>()); // map adjacency list to an empty set
        // add edge if it doesnt exist already
        adjList.get(src).add(dst);
        
    }

    public boolean removeEdge(int src, int dst) {
        //does edge exist from src->dst?

        // if src node or dst node dsnt exist in map
        if(!adjList.containsKey(src) || !adjList.containsKey(dst)) return false;

        // if they both exist, remove the edge
        adjList.get(src).remove(dst);
        return true;
    }

    public boolean hasPath(int src, int dst) {
        // can use DFS or BFS
        // use visited hashset to not get stuck in a cycle
        HashSet<Integer> visited = new HashSet<>();
        return dfs(src, dst, visited);
    }
    
    private boolean dfs(int src, int dst, HashSet<Integer> visited){
        // base case : if we reached destination node
        if(src == dst) return true;
        
        visited.add(src); // to not visit a node multiple times
        // if dest node in src node neighbors hashset
        for(int neighbor : adjList.getOrDefault(src, new HashSet<>())){
            if(!visited.contains(neighbor)){
                if(dfs(neighbor, dst, visited)) return true;
            }
        }
        return false;
    }
}
