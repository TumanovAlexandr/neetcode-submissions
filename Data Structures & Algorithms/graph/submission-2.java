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
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.add(src);
        seen.add(src);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == dst) {
                    return true;
                }

                for (int neighbor : graphs.get(curr)) {
                    if (!seen.contains(neighbor)) {
                        seen.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return false;
    }
}
