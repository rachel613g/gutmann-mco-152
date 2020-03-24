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

        shapeComponent = new ShapeComponent();

        backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BorderLayout());
        setContentPane(backgroundPanel);

        //add leftPanel for buttons
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        backgroundPanel.add(leftPanel, BorderLayout.WEST);

        //instantiate, set preferred size and add buttons
        starButton = new JButton("Star");
        starButton.setPreferredSize(buttonDimension);
//        diamondRingButton = new JButton("Diamond Ring");
//        diamondRingButton.setPreferredSize(buttonDimension);
        balloonButton = new JButton("Balloon");
        balloonButton.setPreferredSize(buttonDimension);
        heartButton = new JButton("Broken Heart");
        heartButton.setPreferredSize(buttonDimension);
        airplaneButton = new JButton("Airplane");
        airplaneButton.setPreferredSize(buttonDimension);

        leftPanel.add(starButton);
        // leftPanel.add(diamondRingButton);
        leftPanel.add(balloonButton);
        leftPanel.add(heartButton);
        leftPanel.add(airplaneButton);

        //add action listeners
        starButton.addActionListener(actionEvent -> setStarAddStar());
        heartButton.addActionListener(actionEvent -> setHeartAddHeart());
        balloonButton.addActionListener(actionEvent -> setBalloonAddBalloon());
    }

    private void setStarAddStar()
    {
        shapeComponent.setStarShape();
        backgroundPanel.add(shapeComponent);
    }

    public void setHeartAddHeart()
    {
        shapeComponent.setHeartShape();
        backgroundPanel.add(shapeComponent);
    }

    public void setBalloonAddBalloon()
    {
        shapeComponent.setBalloonShape();
        backgroundPanel.add(shapeComponent);
    }


    public static void main(String[] args)
    {
        new ShapesFrame().setVisible(true);
    }
}
