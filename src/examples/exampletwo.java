package examples;

import bintreevisual.BTVisualizer;

class ExampleTwo 
{
    public static void main(String[] args)
    {
        System.out.println("Example Two - Create BinTree Visualization With One Frame");
        
        BTVisualizer<BinTree> vis = BTVisualizer.getInstance();

        BinTree<String> root = new BinTree<String>("Data 1");
        BinTree<String> n1 = new BinTree<String>("Data 2");
        BinTree<String> n2 = new BinTree<String>("Data Gavriel");
        BinTree<String> n3 = new BinTree<String>("Data Test");

        root.setRight(n1);
        n1.setRight(n2);
        n2.setRight(n3);

        vis.visualize(root, BinTree::getData, BinTree::getLeft, BinTree::getRight);
    }
}
