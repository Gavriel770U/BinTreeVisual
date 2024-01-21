package bintreevisual;

import java.util.function.Supplier;

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
            instance = new BTVisualizer();
        }

        return instance;
    }

    public <T> void visualize(T root, Supplier<T> valueGetter, Supplier<T> leftGetter, Supplier<T> rightGetter)
    {
        new BTFrame(root, valueGetter, leftGetter, rightGetter);
    }

    // public <T> void visualize(T root, Supplier<T> valueGetter)
    // {
    //     new BTFrame(root, valueGetter);
    // }
}