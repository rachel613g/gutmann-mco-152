package gutmann.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapeComponent extends JComponent
{
    String drawThisShape = "star";
    int rotate = 0;
   // int y = 0; //y variable to make balloon fly

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        int centerX = width / 2;
        int centerY = height / 2;

         //makes the center the origin
        g.translate(centerX, centerY);
        if (drawThisShape.equalsIgnoreCase("star"))
        {
            drawStar(g);
        }
        else if (drawThisShape.equalsIgnoreCase("heart"))
        {
            //add in graphics2d to rotate the heart
            Graphics2D g2d = (Graphics2D) g;
            g2d.rotate(Math.toRadians(rotate));
            drawHeart(g);
            rotate++;
        }
        else if (drawThisShape.equalsIgnoreCase("balloon"))
        {
            //the y variable to make the balloon fly...
            //y++;
            drawBalloon(g);
        }
        else if (drawThisShape.equalsIgnoreCase("airplane"))
        {
            drawAirplane(g);
        }

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

        g.fillArc(0, -100 , 100, 100, 0, 180);

        int[] xArray = new int[]{0, 50, 100};
        int[] yArray = new int[]{-50, 0 , -50};

        g.fillPolygon(xArray, yArray, 3);

        int[] xArray2 = new int[]{40, 60, 50};
        int[] yArray2 = new int[]{10, 10, 0 };

        g.fillPolygon(xArray2, yArray2, 3);
    }

    public void drawAirplane(Graphics g)
    {
//        int [] xArray = new int[] {140,40,-40,-80,-100,-160};
//        int [] yArray = new int[] {-120,140,60,120,20,0};
//        g.drawPolygon(xArray,yArray,7);

        //airplane base
        g.drawOval(0,0,20,100);
        //airplane wing
        g.drawOval(0,50,10,40);
        Graphics2D g2d = (Graphics2D) g;
        g2d.getTransform().setToRotation(Math.toRadians(45));
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

    public void setAirplaneShape()
    {
        drawThisShape = "airplane";
        repaint();
    }
}
