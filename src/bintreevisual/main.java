package bintreevisual;

class Main
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Bin Tree Visualisation!");
        
        BTVisualizer<BinNode> vis = BTVisualizer.getInstance();

        BinNode<Integer> root = new BinNode<>(1);
        BinNode<Integer> left = new BinNode<>(2);
        BinNode<Integer> right = new BinNode<>(3);
        BinNode<Integer> leftleft = new BinNode<>(4);
        BinNode<Integer> rightleft = new BinNode<Integer>(6);

        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftleft);
        right.setLeft(rightleft);

        vis.visualize(root, BinNode::getValue, BinNode::getLeft, BinNode::getRight);
    }
}