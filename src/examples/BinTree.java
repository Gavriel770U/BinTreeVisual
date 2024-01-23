package examples;

public class BinTree <T>
{
  private T data; 
  private BinTree<T> right; 
  private BinTree<T> left; 

  public BinTree(T data)
  {
    this.data = data;
    this.right = null;  
    this.left = null;
  }

  public BinTree(BinTree<T> left, T data, BinTree<T> right)
  {
    this.data = data;
    this.right = right;  
    this.left = left;
  }

  public T getData()
  {
    return this.data; 
  }

  public BinTree<T> getLeft()
  {
    return this.left; 
  } 

  public BinTree<T> getRight()
  {
    return this.right; 
  }

  public void setData(T data)
  {
    this.data = data;
  }  

  public void setLeft(BinTree<T> left)
  {
    this.left = left;
  }

  public void setRight(BinTree<T> right)
  {
    this.right = right;
  }

  public boolean hasRight()
  {
    return (this.right != null); 
  }

  public boolean hasLeft()
  {
    return (this.left != null); 
  }

  public String toString()
  {
    return "(" + this.left + " " + this.data + " " + this.right + ")";  
  }
}