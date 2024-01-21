package bintreevisual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BTPanel extends JPanel 
{
    public BTPanel()
    {
        setPreferredSize(new Dimension(BTSettings.FRAME_WIDTH.value, BTSettings.FRAME_HEIGHT.value));
        setDoubleBuffered(true);
        setBackground(Color.BLACK);
        requestFocusInWindow();
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        repaint();
    }
}
