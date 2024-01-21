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

        if(!this.enabled)
        {
            return;
        }

        if(null == this.root)
        {
            repaint();
            return;
        }

        graphics.setColor(Color.WHITE);
        graphics.fillOval(100, 100, 50, 50);

        GQueue<T> queue = new GQueue<>();
        int count = 0, i = 0;
        queue.insert(this.root);

        while (!queue.isEmpty())
        {
            count = queue.getCount();

            for (i = 0; i < count; i++)
            {
                this.root = queue.remove();

                if (this.root != null)
                {
                    System.out.println(this.valueGetter.apply(this.root) + " ");

                    if (this.leftGetter.apply(this.root) != null)
                    {
                        queue.insert((T) this.leftGetter.apply(this.root));
                    }

                    if(rightGetter.apply(this.root) != null)
                    {
                        queue.insert((T) this.rightGetter.apply(this.root));
                    }
                }
            }

            System.out.println("");
        }

        this.enabled = false;

        // repaint(); // if I will improve this in the future repaint will be needed for dynamic changes.
    }
}
