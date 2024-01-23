package examples;

import bintreevisual.BTVisualizer;

class ExampleOne 
{
    public static void main(String[] args)
    {
        System.out.println("Example One - Create BinNode Visualization With One Frame");
        
        BTVisualizer<BinNode> vis = BTVisualizer.getInstance();

        BinNode<Integer> root = new BinNode<Integer>(1);
        BinNode<Integer> n1 = new BinNode<Integer>(2);
        BinNode<Integer> n2 = new BinNode<Integer>(3);
        BinNode<Integer> n3 = new BinNode<Integer>(4);

        root.setLeft(n1);
        root.setRight(n2);
        n2.setLeft(n3);

        vis.visualize(root, BinNode::getValue, BinNode::getLeft, BinNode::getRight);
    }
}
