package bintreevisual;

import javax.swing.JFrame;
import java.awt.Dimension;

public class BTFrame extends JFrame
{
    public BTFrame()
    {
        setPreferredSize(new Dimension(BTSettings.FRAME_WIDTH.value, BTSettings.FRAME_HEIGHT.value));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(getForeground());
        setTitle("Binary Tree Visualisation");
        add(new BTPanel());
        pack();
        setVisible(true);
    }
}
