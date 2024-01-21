package bintreevisual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.function.Function;

import javax.swing.JPanel;

public class BTPanel <T> extends JPanel 
{
    private T root;
    private Function<T, ?> valueGetter;
    private Function<T, ?> leftGetter;
    private Function<T, ?> rightGetter;
    private boolean enabled = true;

    public BTPanel(T root, Function<T, ?> valueGetter, Function<T, ?> leftGetter, Function<T, ?> rightGetter)
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

        if (!this.enabled)
        {
            return;
        }

        if (null == this.root)
        {
            repaint();
            return;
        }
            
        // Breadth First Traversal

        GQueue<T> queue = new GQueue<>();
        int count = 0, i = 0, level = 0;
        int x0 = (BTSettings.FRAME_WIDTH.value - BTSettings.RADIUS.value) / 2;
        int y0 = BTSettings.RADIUS.value;
        int x = x0;
        int y = y0;
        queue.insert(this.root);

        while (!queue.isEmpty())
        {
            count = queue.getCount();

            x = x0 - (int)(BTSettings.RADIUS.value * Math.pow(2.0, (double)level) * 0.5);

            for (i = 0; i < count; i++)
            {
                this.root = queue.remove();

                if (this.root != null)
                {
                    // System.out.println(this.valueGetter.apply(this.root) + " ");

                    graphics.setColor(Color.WHITE);
                    graphics.fillOval(x, y, BTSettings.RADIUS.value, BTSettings.RADIUS.value);
                    graphics.drawString(this.valueGetter.apply(this.root).toString(), x, y);

                    if (this.leftGetter.apply(this.root) != null)
                    {
                        queue.insert((T) this.leftGetter.apply(this.root));
                    }
                    else
                    {
                        queue.insert(null);
                    }

                    if (rightGetter.apply(this.root) != null)
                    {
                        queue.insert((T) this.rightGetter.apply(this.root));
                    }
                    else
                    {
                        queue.insert(null);
                    }
                }

                x += 1.5 * BTSettings.RADIUS.value;
            }

            // System.out.println("");
            y += 2 * BTSettings.RADIUS.value;
            level++;
        }

        this.enabled = false;

        // repaint(); // if I will improve this in the future repaint will be needed for dynamic changes.
    }
}
