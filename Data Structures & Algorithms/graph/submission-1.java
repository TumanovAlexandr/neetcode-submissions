class Graph {

    Map<Integer, Set<Integer>> graphs;

    public Graph() {
        graphs = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        graphs.computeIfAbsent(src, k -> new HashSet<>());
        graphs.computeIfAbsent(dst, k -> new HashSet<>());
        graphs.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!graphs.containsKey(src) || !graphs.containsKey(dst)) {
            return false;
        }

        return graphs.get(src).remove(dst);
    }

    public boolean hasPath(int src, int dst) {
        return dfs(src, dst, new HashSet<>());
    }

    private boolean dfs(int src, int dst, Set<Integer> seen) {
        if (src == dst) {
            return true;
        }

        seen.add(src);

        for (int neighbor : graphs.get(src)) {
            if (!seen.contains(neighbor)) {
                if (dfs(neighbor, dst, seen)) {
                    return true;
                }
            }
        }
        return false;
    }
}
