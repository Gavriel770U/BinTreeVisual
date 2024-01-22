package bintreevisual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.function.Function;

import javax.swing.JPanel;

public class BTPanel <T> extends JPanel 
{
    private T root;
    private Function<T, ?> valueGetter;
    private Function<T, ?> leftGetter;
    private Function<T, ?> rightGetter;
    private HashMap<T, Point> nodePositions;

    public BTPanel(T root, Function<T, ?> valueGetter, Function<T, ?> leftGetter, Function<T, ?> rightGetter)
    {
        setPreferredSize(new Dimension(BTSettings.FRAME_WIDTH.value, BTSettings.FRAME_HEIGHT.value));
        setDoubleBuffered(true);
        setBackground(Color.BLACK);
        requestFocusInWindow();
        setFocusable(true);

        this.nodePositions = new HashMap<>();

        this.root = root;
        this.valueGetter = valueGetter;
        this.leftGetter = leftGetter;
        this.rightGetter = rightGetter;

        this.calculateNodePositions(this.root, BTSettings.FRAME_WIDTH.value / 2, 50, BTSettings.RADIUS.value * (this.treeHeight(this.root) + 1));
    }

    private void calculateNodePositions(T root, int x, int y, int xOffset)
    {
        if (null == root)
        {
            return;
        }

        this.nodePositions.put(root, new Point(x, y));

        this.calculateNodePositions((T)this.leftGetter.apply(root), x - xOffset, y + 50, xOffset / 2);

        this.calculateNodePositions((T)this.rightGetter.apply(root), x + xOffset, y + 50, xOffset / 2);
    }

    private void drawTree(Graphics graphics, T root, int x, int y, int xOffset)
    {
        if (null == root)
        {
            return;
        }

        Point point = this.nodePositions.get(root);

        graphics.setColor(Color.WHITE);
        graphics.fillOval(point.x - (BTSettings.RADIUS.value / 2), point.y - (BTSettings.RADIUS.value / 2), BTSettings.RADIUS.value, BTSettings.RADIUS.value);
        graphics.setColor(Color.GREEN);
        graphics.drawString(this.valueGetter.apply(root).toString(), point.x - 5, point.y + 5);

        if (this.leftGetter.apply(root) != null)
        {
            Point leftPoint = nodePositions.get(this.leftGetter.apply(root));
            graphics.setColor(Color.WHITE);
            graphics.drawLine(point.x, point.y, leftPoint.x, leftPoint.y);
            drawTree(graphics, (T)this.leftGetter.apply(root), leftPoint.x, leftPoint.y, xOffset / 2);
        }

        if (this.rightGetter.apply(root) != null)
        {
            Point rightPoint = nodePositions.get(this.rightGetter.apply(root));
            graphics.setColor(Color.WHITE);
            graphics.drawLine(point.x, point.y, rightPoint.x, rightPoint.y);
            drawTree(graphics, (T)this.rightGetter.apply(root), rightPoint.x, rightPoint.y, xOffset / 2);
        }
    }

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

        this.drawTree(graphics, this.root, BTSettings.FRAME_WIDTH.value / 2, 50, BTSettings.RADIUS.value * (this.treeHeight(this.root) + 1));

        repaint();
    }
}
