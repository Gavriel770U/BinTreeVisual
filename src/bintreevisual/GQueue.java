package bintreevisual;

// Queue for Breadth First algorithm

public class GQueue <T>
{
    private GNode<T> first;
    private GNode<T> last;
    private int count;

    public GQueue()
    {
        this.first = null;
        this.last = null;
        this.count = 0;
    }

    public boolean isEmpty()
    {
        return (null == this.first);
    }

    public T head()
    {
        return this.first.getValue(); 
    }

    public void insert(T value)
    {
        GNode<T> temp = new GNode<T>(value); 

        if (this.isEmpty())
        {
            this.first = temp; 
        }
        else
        {
            this.last.setNext(temp); 
        }
        this.last = temp; 

        this.count++;
    }

    public T remove()
    {
        T value = this.first.getValue(); 
        this.first = this.first.getNext(); 

        if (this.isEmpty())
        {
          this.last = null; 
        }

        this.count--;
        return value;
    }

    public int getCount()
    {
        return this.count;
    }

    @Override
    public String toString()
    {
        GNode<T> pos = this.first;
        String str = "[";

        while (pos != null)
        {
            if (pos.hasNext())
            {
                str += pos.getValue() + ",";
            }
            pos = pos.getNext();
        }

        return str + "]";
    }
}
