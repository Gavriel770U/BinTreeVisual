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

    // TODO: fix this function
    private int treeHeight(T root)
    {
        if (null == root)
        {
            return -1;
        }

        int leftHeight = 0, rightHeight = 0;
        
        leftHeight = treeHeight((T) this.leftGetter.apply(root));
         
        rightHeight = treeHeight((T) this.rightGetter.apply(root));

        return Math.max(leftHeight, rightHeight) + 1;
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
        int height = treeHeight(this.root);
        int x0 = (BTSettings.FRAME_WIDTH.value - BTSettings.RADIUS.value) / 2;
        int y0 = BTSettings.RADIUS.value;
        int x = x0;
        int y = y0;
        int elemi = 0;
        queue.insert(this.root);

        while (!queue.isEmpty())
        {
            count = queue.getCount();

            for (i = 0; i < count; i++)
            {
                this.root = queue.remove();
                
                elemi++;
                if(elemi == Math.pow(2, level))
                {
                    elemi = 0;
                }

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
                if (0 <= elemi && elemi >= Math.pow(2.0, level) / 2)
                {
                    x = x0 - (int)(1.5 * BTSettings.RADIUS.value * Math.pow(2.0, height-level) * elemi);
                }
                else
                {
                    x = x0 + (int)(1.5 * BTSettings.RADIUS.value * Math.pow(2.0, height-level) * (Math.pow(2.0, level) / 2 - elemi));
                }
            }

            // System.out.println("");
            y += 2 * BTSettings.RADIUS.value;
            level++;
        }

        this.enabled = false;

        // repaint(); // if I will improve this in the future repaint will be needed for dynamic changes.
    }
}
