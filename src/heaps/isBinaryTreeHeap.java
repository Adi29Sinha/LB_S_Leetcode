package heaps;

public class isBinaryTreeHeap {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
            this.left = this.right = null;
        }
    }

    boolean isTreeHeap(Node root) {
        int index = 0;
        if (isCBT(root, index, totalNodeCount(root)) && isMaxOrder(root)) {
            return true;
        }
        return false;
    }

    int totalNodeCount(Node root) {
        if (root == null) {
            return 0;
        }
        int ans = 1 + totalNodeCount(root.left) + totalNodeCount(root.right);
        return ans;
    }

    private boolean isMaxOrder(Node root) {
        //leaf node
        if (root.left == null && root.right == null) {
            return true;
        }

        //left node only
        if (root.right == null && root.left.data <= root.data) {
            return true;
        }

        boolean left = isMaxOrder(root.left);
        boolean right = isMaxOrder(root.right);

        return (left && right && (root.data >= root.left.data) && (root.data >= root.right.data));
    }

    private boolean isCBT(Node root, int index, int totalCount) {
        if (root == null) {
            return true;
        }
        if (index >= totalCount) {
            return false;
        } else {
            boolean left = isCBT(root.left, 2 * index + 1, totalCount);
            boolean right = isCBT(root.right, 2 * index + 2, totalCount);
            return (left && right);
        }
    }

    public static void main(String[] args) {
        isBinaryTreeHeap isBinaryTreeHeap = new isBinaryTreeHeap();
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(2);
        root.left.right.left = new Node(1);

        if (isBinaryTreeHeap.isTreeHeap(root) == true)
            System.out.println(
                    "Given binary tree is a Heap");
        else
            System.out.println(
                    "Given binary tree is not a Heap");
    }
}
