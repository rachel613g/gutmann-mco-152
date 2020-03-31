package gutmann.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapesFrame extends JFrame
{
    private ShapeComponent shapeComponent;
    private JPanel leftPanel;
    private JPanel backgroundPanel;
    private JButton starButton;
//    private JButton diamondRingButton;
    private JButton balloonButton;
    private JButton heartButton;
    private JButton airplaneButton;
    private final Dimension buttonDimension = new Dimension(150, 100);


    //add a left panel and buttons inside it
    //when button is hit paint a difficult shape

    public ShapesFrame()
    {
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shapes");

        backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BorderLayout());
        setContentPane(backgroundPanel);

        //add leftPanel for buttons
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        backgroundPanel.add(leftPanel, BorderLayout.WEST);
//initialize and instantiate shapeComponent, add shapeComponent
        shapeComponent = new ShapeComponent();
        backgroundPanel.add(shapeComponent);

        //instantiate, set preferred size and add buttons
        starButton = new JButton("Star");
        starButton.setPreferredSize(buttonDimension);
        balloonButton = new JButton("Balloon");
        balloonButton.setPreferredSize(buttonDimension);
        heartButton = new JButton("Rotate Heart");
        heartButton.setPreferredSize(buttonDimension);
        airplaneButton = new JButton("Airplane");
        airplaneButton.setPreferredSize(buttonDimension);

        leftPanel.add(starButton);
        leftPanel.add(balloonButton);
        leftPanel.add(heartButton);
        leftPanel.add(airplaneButton);

        //add action listeners
        starButton.addActionListener(actionEvent -> setStarAddStar());
        heartButton.addActionListener(actionEvent -> setHeartAddHeart());
        balloonButton.addActionListener(actionEvent -> setBalloonAddBalloon());
        airplaneButton.addActionListener(actionEvent -> setAirplaneAddAirplane());
    }

    private void setStarAddStar()
    {
        shapeComponent.setStarShape();
    }

    public void setHeartAddHeart()
    {
        shapeComponent.setHeartShape();
    }

    public void setBalloonAddBalloon()
    {
        shapeComponent.setBalloonShape();
    }

    public void setAirplaneAddAirplane()
    {
        shapeComponent.setAirplaneShape();
    }




    public static void main(String[] args)
    {
        new ShapesFrame().setVisible(true);
    }
}
