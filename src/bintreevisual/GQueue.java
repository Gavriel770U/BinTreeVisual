package bintreevisual;

// Queue for Breadth First algorithm

public class GQueue <T>
{
    private GNode<T> first;
    private GNode<T> last;

    public GQueue()
    {
        first = null;
        last = null;
    }

    public boolean isEmpty()
    {
        return (null == first);
    }

    public void insert(T value)
    {
        if(this.isEmpty())
        {
            this.first = new GNode<T>(value);
        }
        else
        {
            GNode<T> pos = first;

            while(pos.hasNext())
            {
                pos = pos.getNext();
            }
            pos.setNext(new GNode<T>(value));
            last = pos.getNext();
        }
    }

    public T remove()
    {
        return null;
    }

    @Override
    public String toString()
    {
        return "Queue";
    }
}
