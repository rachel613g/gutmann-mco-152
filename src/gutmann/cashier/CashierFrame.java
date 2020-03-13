package gutmann.cashier;

import javax.swing.*;
import javax.swing.BoxLayout;
import java.awt.*;

public class CashierFrame extends JFrame
{
    private JFrame frame;
    private JPanel topPanel;
    private JPanel midPanel;
    private JPanel bottomPanel;
    private final Dimension smallButtonDimension = new Dimension(20,20);
    private final Dimension panelDimension = new Dimension(100, 200);
    private JButton customerTwenty;
    private JButton customerTen;
    private JButton customerFive;
    private JButton customerOne;
    private JButton customerQuarter;
    private JButton customerDime;
    private JButton customerNickel;
    private JButton customerPenny;
    private JTextField priceTF;
    private JButton clearButton;
    private JButton payButton;

    private Cash customer;
    private Cash register;

    public CashierFrame()
    {
        frame = new JFrame();
        frame.setSize(500, 600);
        frame.setTitle("Cashier Frame");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//frame is made using BoxLayout. it holds three panels: topPanel, midPanel and bottomPanel. Each with
// a FlowLayout
        frame.setLayout(new BoxLayout(frame, BoxLayout.X_AXIS));

        //top panel set up
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setPreferredSize(panelDimension);
        frame.add(topPanel);//add topPanel to frame

        //initialize, setPreferredSize and add customer input buttons to topPanel
        customerTwenty = new JButton("Twenties");
        customerTen = new JButton("Tens");
        customerFive = new JButton("Fives");
        customerOne = new JButton("Ones");
        customerQuarter = new JButton("Quarters");
        customerDime = new JButton("Dimes");
        customerNickel = new JButton("Nickels");
        customerPenny = new JButton("Pennies");

        customerTwenty.setPreferredSize(smallButtonDimension);
        customerTen.setPreferredSize(smallButtonDimension);
        customerFive.setPreferredSize(smallButtonDimension);
        customerOne.setPreferredSize(smallButtonDimension);
        customerQuarter.setPreferredSize(smallButtonDimension);
        customerNickel.setPreferredSize(smallButtonDimension);
        customerPenny.setPreferredSize(smallButtonDimension);

        topPanel.add(customerTwenty);
        topPanel.add(customerTen);
        topPanel.add(customerFive);
        topPanel.add(customerOne);
        topPanel.add(customerQuarter);
        topPanel.add(customerDime);
        topPanel.add(customerNickel);
        topPanel.add(customerPenny);

        //midPanel set up
        midPanel = new JPanel();
        midPanel.setLayout(new FlowLayout());
        midPanel.setPreferredSize(panelDimension);
        frame.add(midPanel);

        //initialize and add components to midPanel
        priceTF = new JTextField("Price:");
        clearButton = new JButton();
        payButton = new JButton();
        midPanel.add(priceTF);
        midPanel.add(clearButton);
        midPanel.add(payButton);

        //bottom panel set up
        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(panelDimension);
        bottomPanel.setLayout(new FlowLayout());
        frame.add(bottomPanel);
    }

    public static void main(String[] args)
    {
        new CashierFrame().setVisible(true);
    }
}
