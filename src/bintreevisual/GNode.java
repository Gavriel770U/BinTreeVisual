package bintreevisual;

// Node that is used for GQueue

public class GNode <T>
{
    private T value;
    private GNode<T> next;

    public GNode(T value)
    {
        this.value = value;
        this.next = null;
    }

    public GNode(T value, GNode<T> next)
    {
        this.value = value;
        this.next = next;
    }

    public T getValue()
    {
        return this.value;
    }

    public GNode<T> getNext()
    {
        return this.next;
    }

    public void setValue(T value)
    {
        this.value = value;
    }

    public void setNext(GNode<T> next)
    {
        this.next = next;
    }

    public boolean hasNext()
    {
        return (this.next != null);
    }

    @Override
    public String toString()
    {
      return this.value + " --> " + this.next;
    }
}
