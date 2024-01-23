package bintreevisual;

import java.util.function.Function;

// Class for running multiple BTFrames in every part of the program as Threads

public class BTRunnable <T> implements Runnable
{
    private T root;
    private Function<T, ?> valueGetter;
    private Function<T, ?> leftGetter;
    private Function<T, ?> rightGetter;

    public BTRunnable(T root, Function<T, ?> valueGetter, Function<T, ?> leftGetter, Function<T, ?>  rightGetter)
    {
        this.root = root;
        this.valueGetter = valueGetter;
        this.leftGetter = leftGetter;
        this.rightGetter = rightGetter;
    }

    @Override
    public void run()
    {
        new BTFrame<T>(root, valueGetter, leftGetter, rightGetter);
    }
}