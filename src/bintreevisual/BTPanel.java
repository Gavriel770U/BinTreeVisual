package bintreevisual;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class BTPanel extends JPanel 
{
    public BTPanel()
    {
        setDoubleBuffered(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(BTSettings.FRAME_WIDTH.value, BTSettings.FRAME_HEIGHT.value));
    }
}
