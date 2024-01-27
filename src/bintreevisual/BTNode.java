package bintreevisual;

// Custom class of Binary Tree Node for Deep Copy

public class BTNode <T>
{
    private T value; 
    private BTNode<T> right; 
    private BTNode<T> left; 

    public BTNode(T value)
    {
        this.value = value;
        this.right = null;  
        this.left = null;
    }

    public BTNode(BTNode<T> left, T value, BTNode<T> right)
    {
        this.value = value;
        this.right = right;  
        this.left = left;
    }

    public T getValue()
    {
        return this.value; 
    }

    public BTNode<T> getLeft()
    {
        return this.left; 
    } 

    public BTNode<T> getRight()
    {
        return this.right; 
    }

    public void setValue(T value)
    {
        this.value = value;
    }  

    public void setLeft(BTNode<T> left)
    {
        this.left = left;
    }

    public void setRight(BTNode<T> right)
    {
        this.right = right;
    }
}