package gutmann.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapeComponent extends JComponent
{
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        int centerX = width/2;
        int centerY = height/2;

        //makes the center the origin
        g.translate(centerX, centerY);

        drawStar(g);
    }

//    public void setStar()
//    {
//
//    }

    private void drawStar(Graphics g)
    {
        int[] x1values = new int[]{ -50, 0, 50};
        int[] y1values = new int[]{0, 50, 0};
        g.drawPolygon(x1values, y1values, 3);

        int[] x2values = new int[]{-50, 50, 0};
        int[] y2values = new int[]{25, 25, -25};
        g.drawPolygon(x2values, y2values, 3);
    }
}
