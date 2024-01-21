package bintreevisual;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.util.function.Function;

public class BTFrame <T> extends JFrame
{
    public BTFrame(T root, Function<T, ?> valueGetter, Function<T, ?> leftGetter, Function<T, ?> rightGetter)
    {
        setPreferredSize(new Dimension(BTSettings.FRAME_WIDTH.value, BTSettings.FRAME_HEIGHT.value));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(getForeground());
        setTitle("Binary Tree Visualization");
        add(new BTPanel<T>(root, valueGetter, leftGetter, rightGetter));
        pack();
        setVisible(true);
    }
}
