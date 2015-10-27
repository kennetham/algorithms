/**
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 http://www.programcreek.com/2013/01/leetcode-convert-sorted-array-to-binary-search-tree-java/
 **/

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }
}

public class SortedArrayBST {
    public TreeNode sortedArrayBST(int[] sorted_array) {
        if (sorted_array.length == 0)
            return null;

        return sortedArrayBST(sorted_array, 0, sorted_array.length - 1);
    }

    public TreeNode sortedArrayBST(int[] sorted_array, int start, int end) {
        // First find the mid of start and end
        int mid = (start + end) / 2;

        if (start > end)
            return null;

        // Divide and conquer to solve left and right
        TreeNode root = new TreeNode(sorted_array[mid]);
        root.left = sortedArrayBST(sorted_array, start, mid - 1);
        root.right = sortedArrayBST(sorted_array, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {
        int[] sorted_array = { 1, 2, 3, 4, 5, 6 };
        SortedArrayBST bst = new SortedArrayBST();
        TreeNode root;
        root = bst.sortedArrayBST(sorted_array);
        System.out.println(root.value);
    }
}
