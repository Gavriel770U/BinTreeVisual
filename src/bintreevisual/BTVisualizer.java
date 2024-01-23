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

    public void visualize(T root, Function<T, ?> valueGetter, Function<T, ?> leftGetter, Function<T, ?>  rightGetter)
    {
        Runnable visRunnable = new BTRunnable<T>(root, valueGetter, leftGetter, rightGetter);
        new Thread(visRunnable).start();
    }
}