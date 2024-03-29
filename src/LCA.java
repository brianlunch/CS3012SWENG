// Java Program for Lowest Common Ancestor in a Binary Tree
// A O(n) solution to find LCA of two given values n1 and n2
import java.util.ArrayList;
import java.util.List;

public class LCA {
    // A Binary Tree node
    public static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    public static class BT_NoParentPtr_Solution1 {

        Node root;
        private static List<Integer> path1 = new ArrayList<>();
        private static List<Integer> path2 = new ArrayList<>();

        // Finds the path from root node to given root of the tree.
        int findLCA(int n1, int n2) {
            path1.clear();
            path2.clear();
            return findLCAInternal(root, n1, n2);
        }

        private static int findLCAInternal(Node root, int n1, int n2) {

            if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            return -1;
            }

            int i;
            for (i = 0; i < path1.size() && i < path2.size(); i++) {

                // System.out.println(path1.get(i) + " " + path2.get(i));
                if (!path1.get(i).equals(path2.get(i)))
                    break;
            }

            return path1.get(i - 1);
        }

        // Finds the path from root node to given root of the tree, Stores the
        // path in a vector path[], returns true if path exists otherwise false
        private static boolean findPath(Node root, int n, List<Integer> path) {


            // Store this node . The node will be removed if
            // not in path from root to n.


            path.add(root.data);

            if (root.data == n) {
                return true;
            }

            if (root.left != null && findPath(root.left, n, path)) {
                return true;
            }

            if (root.right != null && findPath(root.right, n, path)) {
                return true;
            }

            // If not present in subtree rooted with root, remove root from
            // path[] and return false
            path.remove(path.size() - 1);

            return false;
        }

        // Driver code
    }

}
