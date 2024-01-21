package bintreevisual;

// Queue for Breadth First algorithm

public class GQueue <T>
{
    private GNode<T> first;
    private GNode<T> last;

    public GQueue()
    {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty()
    {
        return (null == this.first);
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
            this.last = pos.getNext();
        }
    }

    public T remove()
    {
        T value = this.first.getValue();
        this.first = this.first.getNext();
        return value;
    }

    public String toString()
    {
        GNode<T> pos = this.first;
        String str = "[";

        while (pos != null)
        {
            if (pos.hasNext())
            {
                str += pos.getValue()+",";
            }
            pos = pos.getNext();
        }

        return str+"]";
    }
}
