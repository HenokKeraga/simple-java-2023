package tree;

public class Main {

    public static void main(String[] args) {


        BinaryTree binaryTree= new BinaryTree();
        binaryTree.insert(1);
        binaryTree.insert(5);
        binaryTree.insert(6);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(4);

        System.out.println("In order  "+binaryTree.inOrderTraversal());
        System.out.println("preOrder "+binaryTree.preOrderTraversal());
        System.out.println("post order "+binaryTree.postOrderTraversal());
        System.out.println("level order "+binaryTree.levelOrderTraversal());
        System.out.println("level order "+binaryTree.leverOrderTraversalLevelByLevel());
        System.out.println("height "+binaryTree.highetOfATree());
        System.out.println("size "+binaryTree.size());
        System.out.println("max element  "+binaryTree.maxElement());
        System.out.println("legt view  "+binaryTree.leftView());
        System.out.println("top view  "+binaryTree.topView());

    }
}
