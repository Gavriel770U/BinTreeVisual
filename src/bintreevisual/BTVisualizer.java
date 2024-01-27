package bintreevisual;

import java.util.function.Function;

// Singleton class for calling functions to display binary trees

public class BTVisualizer <T>
{
    private static BTVisualizer instance = null;

    private BTVisualizer()
    {

    }
    
    public static synchronized BTVisualizer getInstance()
    {
        if (null == instance)
        {
            instance = new BTVisualizer<>();
        }

        return instance;
    }

    private <U> BTNode<U> copyTree(T root, Function<T, ?> valueGetter, Function<T, ?> leftGetter, Function<T, ?> rightGetter)
    {
        if (null == root)
        {
            return null;
        }

        BTNode<U> copy = new BTNode<U>((U)valueGetter.apply(root));
        
        copy.setLeft(this.copyTree((T)leftGetter.apply(root), valueGetter, leftGetter, rightGetter));

        copy.setRight(this.copyTree((T)rightGetter.apply(root), valueGetter, leftGetter, rightGetter));

        return copy;
    }

    public void visualize(T root, Function<T, ?> valueGetter, Function<T, ?> leftGetter, Function<T, ?> rightGetter) 
    {
        BTNode copyRoot = copyTree(root, valueGetter, leftGetter, rightGetter);
        Runnable visRunnable = new BTRunnable<BTNode>(copyRoot, BTNode::getValue, BTNode::getLeft, BTNode::getRight);
        Thread thread = new Thread(visRunnable);
        thread.start();
    }
}