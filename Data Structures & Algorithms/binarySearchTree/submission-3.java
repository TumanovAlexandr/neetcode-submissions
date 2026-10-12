class TreeMap {

    TreeNode root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        TreeNode newNode = new TreeNode(key, val);
        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode curr = root;
        while (true) {
            if (key < curr.key) {
                if (curr.left == null) {
                    curr.left = newNode;
                    return;
                }
                curr = curr.left;
            } else if (key > curr.key) {
                if (curr.right == null) {
                    curr.right = newNode;
                    return;
                }
                curr = curr.right;
            } else {
                curr.val = val;
                return;
            }
        }
    }

    public int get(int key) {
        TreeNode curr = root;
        while (curr != null) {
            if (key < curr.key) {
                curr = curr.left;
            } else if (key > curr.key) {
                curr = curr.right;
            } else {
                return curr.val;
            }
        }
        return -1;
    }

    public int getMin() {
        TreeNode curr = getMinNode(root);
        return curr != null ? curr.val : -1;
    }

    public int getMax() {
        TreeNode curr = root;
        while (curr != null && curr.right != null) {
            curr = curr.right;
        }
        return curr != null ? curr.val : -1;
    }

    public void remove(int key) {
        root = removeHelper(root, key);
    }

    public List<Integer> getInorderKeys() {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode curr, List<Integer> arr) {
        if (curr == null) {
            return;
        }
        dfs(curr.left, arr);
        arr.add(curr.key);
        dfs(curr.right, arr);
    }

    private TreeNode removeHelper(TreeNode curr, int key) {
        if (curr == null) {
            return null;
        }
        if (key < curr.key) {
            curr.left = removeHelper(curr.left, key);
        } else if (key > curr.key) {
            curr.right = removeHelper(curr.right, key);
        } else {
            if (curr.left == null) {
                return curr.right;
            } else if (curr.right == null) {
                return curr.left;
            } else {
                TreeNode minNode = getMinNode(curr.right);
                curr.key = minNode.key;
                curr.val = minNode.val;
                curr.right = removeHelper(curr.right, minNode.key);
            }
        }

        return curr;
    }

    private TreeNode getMinNode(TreeNode root) {
        TreeNode curr = root;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}

class TreeNode {
    int key;
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
