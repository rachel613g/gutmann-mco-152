package gutmann.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileFrame extends JFrame
{
    private JTextArea projectileCoordinates;
    private JTextField velocity;
    private JTextField angle;
    private JButton calculateButton;
    private JLabel velocityLabel;
    private JLabel angleLabel;
    private JPanel leftPanel;
    private Projectile projectile;


    public ProjectileFrame()
    {
        setSize(300, 400);
        setTitle("Projectile");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        projectileCoordinates = new JTextArea();
        velocity = new JTextField();
        angle = new JTextField();
        calculateButton = new JButton("Calculate");
        velocityLabel = new JLabel("Velocity");
        angleLabel = new JLabel("Angle (in degrees)");


        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3, 2));
        leftPanel.add(velocityLabel);
        leftPanel.add(velocity);
        leftPanel.add(angleLabel);
        leftPanel.add(angle);
        leftPanel.add(calculateButton);
        calculateButton.addActionListener(actionEvent -> calculateProjectile());

        add(projectileCoordinates, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);

    }
    public void calculateProjectile()
    {
        for (int i = 0; i < 31 ; i++)
        {
            double angleD = Double.parseDouble(angle.getText());
            double velocityD = Double.parseDouble(velocity.getText());
            projectile = new Projectile(angleD, velocityD);
            projectile.increaseTime(i);
            projectileCoordinates.append(projectile.toString() + "\n");
        }
    }

    public static void main(String[] args)
    {
        new ProjectileFrame().setVisible(true);
    }
}
