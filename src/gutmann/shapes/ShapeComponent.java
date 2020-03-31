package gutmann.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapeComponent extends JComponent
{
    String drawThisShape = "star";
    int y = 0;

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        int centerX = width / 2;
        int centerY = height / 2;

        // //makes the center the origin
        g.translate(centerX, centerY);
        if (drawThisShape.equalsIgnoreCase("star"))
        {
            drawStar(g);
        }
        else if (drawThisShape.equalsIgnoreCase("heart"))
        {
            drawHeart(g);
        }
        else if (drawThisShape.equalsIgnoreCase("balloon"))
        {
            drawBalloon(g);
        }
        repaint();
    }

    private void drawHeart(Graphics g)
    {
        g.setColor(new Color(100, 14, 21));
        //2 arcs
        g.fillArc(-100, -100, 100, 100, 0, 180);
        g.fillArc(0, -100, 100, 100, 0, 180);
        // triangle
        int[] xArray = new int[]{-100, 0, 100};
        int[] yArray = new int[]{-50, 0, -50};
        g.fillPolygon(xArray, yArray, 3);
    }

    private void drawStar(Graphics g)
    {
        //draw a star
        int[] x1values = new int[]{-50, 0, 50};
        int[] y1values = new int[]{0, 50, 0};
        g.drawPolygon(x1values, y1values, 3);

        int[] x2values = new int[]{-50, 50, 0};
        int[] y2values = new int[]{25, 25, -25};
        g.drawPolygon(x2values, y2values, 3);
    }

    private void drawBalloon(Graphics g)
    {
        g.setColor(new Color(0, 100, 100));

        g.fillArc(0, -100 + y, 100, 100, 0, 180);

        int[] xArray = new int[]{0, 50, 100};
        int[] yArray = new int[]{-50 + y, 0 + y, -50 + y};

        g.fillPolygon(xArray, yArray, 3);

        int[] xArray2 = new int[]{40, 60, 50};
        int[] yArray2 = new int[]{10 + y, 10 + y, 0 + y};

        g.fillPolygon(xArray2, yArray2, 3);
        y++;
    }

    public void setStarShape()
    {
        drawThisShape = "star";
        repaint();
    }

    public void setHeartShape()
    {
        drawThisShape = "heart";
        repaint();
    }

    public void setBalloonShape()
    {
        drawThisShape = "balloon";
        repaint();
    }
}
