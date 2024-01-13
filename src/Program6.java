import java.util.*;

class Program6 {
    private List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Program6 p = new Program6();
        BST root = new BST(15);
        root.left = new BST(5);
        root.right = new BST(20);
        root.left.left = new BST(2);
        root.left.right = new BST(5);
        root.right.left = new BST(17);
        root.right.right = new BST(22);
        root.left.left.left = new BST(1);
        root.left.left.right = new BST(3);
        System.out.println(p.findKthLargestValueInBst(root, 3));
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        @Override
        public String toString() {
            return "BST{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        public BST(int value) {
            this.value = value;
        }
    }
    public int findKthLargestValueInBst(BST tree, int k) {
        traverse(tree, k);
        return result.get(k-1);
    }

    private void traverse(BST tree, int k) {
        if (tree == null || result.size() == k) {
            return;
        }
        traverse(tree.right, k);
        if (result.size() < k) {
            result.add(tree.value);
        }
        traverse(tree.left, k);
    }
}
