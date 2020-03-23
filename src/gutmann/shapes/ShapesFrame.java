package gutmann.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapesFrame extends JFrame
{
    private ShapeComponent shapeComponent;
    private JPanel leftPanel;
   // private JPanel midPanel;
    private JButton starButton;
    private JButton diamondRingButton;
    private JButton balloonButton;
    private JButton brokenHeartButton;
    private JButton airplaneButton;
    private final Dimension buttonDimension = new Dimension(150,100);



    //add a left panel and buttons inside it
    //when button is hit paint a difficult shape

    public ShapesFrame()
    {
        setSize(500,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shapes");

        setLayout(new BorderLayout());

        //midPanel = new JPanel();
        //add(midPanel, BorderLayout.CENTER);
        //midPanel.setLayout(new FlowLayout());
        shapeComponent = new ShapeComponent();
        //add leftPanel for buttons
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        add(leftPanel, BorderLayout.WEST);

        //instantiate, set preferred size and add buttons
        starButton = new JButton("Star");
        starButton.setPreferredSize(buttonDimension);
        diamondRingButton = new JButton("Diamond Ring");
        diamondRingButton.setPreferredSize(buttonDimension);
        balloonButton = new JButton("Balloon");
        balloonButton.setPreferredSize(buttonDimension);
        brokenHeartButton = new JButton("Broken Heart");
        brokenHeartButton.setPreferredSize(buttonDimension);
        airplaneButton = new JButton("Airplane");
        airplaneButton.setPreferredSize(buttonDimension);

        leftPanel.add(starButton);
        leftPanel.add(diamondRingButton);
        leftPanel.add(balloonButton);
        leftPanel.add(brokenHeartButton);
        leftPanel.add(airplaneButton);

        starButton.addActionListener(actionEvent -> addComponent());
    }

    private void addComponent()
    {
        add(shapeComponent, BorderLayout.CENTER);
    }


    public static void main(String [] args)
    {
        new ShapesFrame().setVisible(true);
    }
}
