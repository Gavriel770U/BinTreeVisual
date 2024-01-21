package bintreevisual;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.util.function.Supplier;

public class BTFrame <T> extends JFrame
{
    public BTFrame(T root, Supplier<T> getter)
    {
        setPreferredSize(new Dimension(BTSettings.FRAME_WIDTH.value, BTSettings.FRAME_HEIGHT.value));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(getForeground());
        setTitle("Binary Tree Visualisation");
        add(new BTPanel(root, getter));
        pack();
        setVisible(true);
    }
}
