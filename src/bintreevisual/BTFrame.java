package bintreevisual;

import javax.swing.JFrame;

public class BTFrame extends JFrame
{
    public BTFrame()
    {
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(getForeground());
        setTitle("Binary Tree Visualisation");
    }
}
