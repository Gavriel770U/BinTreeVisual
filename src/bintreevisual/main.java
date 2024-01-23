package bintreevisual;

class Main
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Bin Tree Visualization!");

        BTVisualizer<BinNode> vis = BTVisualizer.getInstance();

        BinNode<Integer> root = new BinNode<>(1);
        BinNode<Integer> left = new BinNode<>(2);
        BinNode<Integer> right = new BinNode<>(3);
        BinNode<Integer> leftleft = new BinNode<>(4);
        BinNode<Integer> leftright = new BinNode<>(5);
        BinNode<Integer> rightleft = new BinNode<Integer>(6);
        BinNode<Integer> rightright = new BinNode<Integer>(7);
        BinNode<Integer> nn = new BinNode<Integer>(770);
        BinNode<Integer> n1 = new BinNode<Integer>(11);
        BinNode<Integer> n2 = new BinNode<Integer>(12);
        BinNode<Integer> n3 = new BinNode<Integer>(13);
        BinNode<Integer> t1 = new BinNode<Integer>(20);
        BinNode<Integer> t2 = new BinNode<Integer>(21);
        BinNode<Integer> t3 = new BinNode<Integer>(22);
        BinNode<Integer> t4 = new BinNode<Integer>(23);

        BinNode<Integer> tr1 = new BinNode<Integer>(30);
        BinNode<Integer> tr2 = new BinNode<Integer>(31);
        BinNode<Integer> tr3 = new BinNode<Integer>(32);
        BinNode<Integer> tr4 = new BinNode<Integer>(33);


        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftleft);
        left.setRight(leftright);
        right.setLeft(rightleft);
        right.setRight(rightright);
        rightleft.setLeft(nn);

        rightleft.setRight(n1);
        nn.setLeft(n2);
        n2.setRight(n3);

        leftleft.setLeft(t1);
        t1.setLeft(t2);
        t2.setLeft(t3);
        t3.setLeft(t4);

        t1.setRight(tr1);
        tr1.setRight(tr2);
        tr2.setRight(tr3);
        tr3.setRight(tr4);
        
        // testing if it shows two frames
        // vis.visualize(root, BinNode::getValue, BinNode::getLeft, BinNode::getRight);

        t2.setRight(new BinNode<Integer>(88));

        vis.visualize(root, BinNode::getValue, BinNode::getLeft, BinNode::getRight);
    }
}