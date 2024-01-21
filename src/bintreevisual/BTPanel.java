package bintreevisual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.function.Supplier;

import javax.swing.JPanel;

public class BTPanel <T> extends JPanel 
{
    private T root;
    private Supplier<T> valueGetter;
    private Supplier<T> leftGetter;
    private Supplier<T> rightGetter;

    public BTPanel(T root, Supplier<T> valueGetter, Supplier<T> leftGetter, Supplier<T> rightGetter)
    {
        setPreferredSize(new Dimension(BTSettings.FRAME_WIDTH.value, BTSettings.FRAME_HEIGHT.value));
        setDoubleBuffered(true);
        setBackground(Color.BLACK);
        requestFocusInWindow();
        setFocusable(true);

        this.root = root;
        this.valueGetter = valueGetter;
        this.leftGetter = leftGetter;
        this.rightGetter = rightGetter;
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        graphics.setColor(Color.WHITE);
        graphics.drawOval(100, 100, 10, 10);


        repaint();
    }
}
