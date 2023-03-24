package tree;

public class Main {

    public static void main(String[] args) {

        var node = new Node(1, null, null);
        node.setLeft(new Node(3,null,null));
        node.setRight(new Node(4,null,null));

        System.out.println(node);

    }
}
