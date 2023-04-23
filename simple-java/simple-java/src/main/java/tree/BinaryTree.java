package tree;

import java.util.*;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int val) {
        this.root = insertNode(root, val);
    }

    private TreeNode insertNode(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val, null, null);
        } else if (val < node.getData()) {
            node.setLeft(insertNode(node.getLeft(), val));
        } else {
            node.setRight(insertNode(node.getRight(), val));
        }
        return node;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }

    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> result) {

        if (root.getLeft() != null) {
            inOrderTraversal(root.getLeft(), result);
        }
        result.add(root.getData());
        if (root.getRight() != null) {
            inOrderTraversal(root.getRight(), result);
        }

    }

    public List<Integer> preOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        preOrder(this.root, result);

        return result;
    }

    private void preOrder(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.getData());
        }
        if (node.getLeft() != null) {
            preOrder(node.getLeft(), result);
        }
        if (node.getRight() != null) {
            preOrder(node.getRight(), result);
        }
    }

    public List<Integer> postOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);

        return result;
    }

    private void postOrder(TreeNode node, List<Integer> result) {
        if (node.getLeft() != null) {
            postOrder(node.getLeft(), result);
        }
        if (node.getRight() != null) {
            postOrder(node.getRight(), result);
        }
        if (node != null) {
            result.add(node.getData());
        }

    }

    public List<Integer> levelOrderTraversal() {
        List<Integer> result = new ArrayList<>();

        levelOrder(root, result);

        return result;
    }

    private void levelOrder(TreeNode node, List<Integer> result) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        if (node != null)
            queue.add(node);

        while (!queue.isEmpty()) {
            var polledNode = queue.poll();
            result.add(polledNode.getData());
            if (polledNode.getLeft() != null) {
                queue.add(polledNode.getLeft());
            }
            if (polledNode.getRight() != null) {
                queue.add(polledNode.getRight());
            }

        }

    }

    public List<List<Integer>> leverOrderTraversalLevelByLevel() {
        List<List<Integer>> result = new ArrayList<>();

        levelBylevel(result, root);
        return result;
    }

    private void levelBylevel(List<List<Integer>> result, TreeNode node) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (node != null) {
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            var size = queue.size();
            var arrayList = new ArrayList<Integer>();
            while (size > 0) {
                var pollNode = queue.poll();
                arrayList.add(pollNode.getData());

                if (pollNode.getLeft() != null) {
                    queue.add(pollNode.getLeft());

                }
                if (pollNode.getRight() != null) {
                    queue.add(pollNode.getRight());
                }
                size--;
            }
            result.add(arrayList);
        }


    }

    public int highetOfATree() {


        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.getRight()), height(node.getLeft()));
    }


    public int size() {

        return sizeOfTree(this.root);
    }

    private int sizeOfTree(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + sizeOfTree(node.getLeft()) + sizeOfTree(node.getRight());
    }

    public int maxElement() {

        return maxElement(this.root);
    }

    private int maxElement(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(node.getData(), Math.max(maxElement(node.getRight()), maxElement(node.getRight())));
    }

    public List<List<Integer>> leftView() {

        return leftView(this.root);
    }

    private List<List<Integer>> leftView(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            var size = queue.size();
            var arrayList = new ArrayList<Integer>();

            while (size > 0) {
                var poll = queue.poll();

                arrayList.add(poll.getData());
                if(poll.getLeft()!=null){
                    queue.add(poll.getLeft());
                }

                if(poll.getRight()!=null){
                   queue.add(poll.getRight());
                }
                size--;
            }
            result.add(List.of(arrayList.get(0)));

        }
        return result;
    }

    public List<Integer> topView() {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(0, root.getData());

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int hd = map.getOrDefault(node, 0);

            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
                map.put(hd - 1, node.getLeft().getData());
            }

            if (node.getRight() != null) {
                queue.offer(node.getRight());
                map.put(hd + 1, node.getRight().getData());
            }
        }

        // sort the map by horizontal distance
        Map<Integer, Integer> sortedMap = new TreeMap<>(map);

        // add the values of the top view nodes to the result list
        for (int val : sortedMap.values()) {
            result.add(val);
        }

        return result;
    }
}
