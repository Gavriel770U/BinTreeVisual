package bintreevisual;

class Main
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Bin Tree Visualisation!");
        
        BTVisualizer<BinNode> vis = BTVisualizer.getInstance();

        BinNode<Integer> root = new BinNode<>(1);
        root.setLeft(new BinNode<>(2));
        root.setRight(new BinNode<>(3));

        vis.visualize(root, BinNode::getValue, BinNode::getLeft, BinNode::getRight);
    }
}