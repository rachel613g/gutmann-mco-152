package gutmann.cashier;

import javax.swing.*;
import javax.swing.BoxLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashierFrame extends JFrame
{
    private JPanel panel;
    private JPanel topPanel;
    private JPanel midPanel;
    private JPanel bottomPanel;
    private final Dimension smallButtonDimension = new Dimension(80, 30);
    private final Dimension panelDimension = new Dimension(500, 300);
    private JButton customerTwenty;
    private JButton customerTen;
    private JButton customerFive;
    private JButton customerOne;
    private JButton customerQuarter;
    private JButton customerDime;
    private JButton customerNickel;
    private JButton customerPenny;
    private JLabel priceLabel;
    private JTextField priceTF;
    private JButton clearButton;
    private JButton payButton;
    private JLabel registerLabel;
    private JLabel changeLabel;
    private JTextArea registerTA;
    private JTextArea changeTA;
    private JTextArea errorMessageTA;

    private Cash customerCashObject = new Cash();
    private Cash registerCashObject = new Cash(100, 100, 100, 100, 100, 100, 100, 100);
    private Cashier cashierObject;
    private Cash changeCashObject;

    public CashierFrame()
    {
        setSize(600, 600);
        setTitle("Cashier Frame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setContentPane(panel);

        configTopPanel();
        configureMidPanel();
        configureBottomPanel();


    }

    private void configTopPanel()
    {
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setPreferredSize(panelDimension);
        panel.add(topPanel);//add topPanel to back panel

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

        //add action listeners to buttons.
        //Action will update the customer's Cash object.
        customerTwenty.addActionListener(actionEvent -> customerCashObject.addTwentyDollars(1));
        customerTen.addActionListener(actionEvent -> customerCashObject.addTenDollars(1));
        customerFive.addActionListener(actionEvent -> customerCashObject.addFiveDollars(1));
        customerOne.addActionListener(actionEvent -> customerCashObject.addOneDollars(1));
        customerQuarter.addActionListener(actionEvent -> customerCashObject.addQuarters(1));
        customerDime.addActionListener(actionEvent -> customerCashObject.addDimes(1));
        customerNickel.addActionListener(actionEvent -> customerCashObject.addNickels(1));
        customerPenny.addActionListener(actionEvent -> customerCashObject.addPennies(1));

    }

    private void configureMidPanel()
    {
        //midPanel set up
        midPanel = new JPanel();
        midPanel.setLayout(new FlowLayout());
        midPanel.setPreferredSize(panelDimension);
        panel.add(midPanel);

        //initialize and add components to midPanel
        priceLabel = new JLabel("Price:");
        priceTF = new JTextField();
        priceTF.setPreferredSize(smallButtonDimension);
        clearButton = new JButton("Clear");
        payButton = new JButton("Pay");
        midPanel.add(priceLabel);
        midPanel.add(priceTF);
        midPanel.add(clearButton);
        midPanel.add(payButton);

        //add action listeners
        clearButton.addActionListener(actionEvent -> clearButtonActions());
        payButton.addActionListener(actionEvent -> pay());
    }

    private void clearButtonActions()
    {
        priceTF.setText(null);
        registerTA.setText(null);
        changeTA.setText(null);
        errorMessageTA.setText(null);
    }

    private void configureBottomPanel()
    {
        //bottom panel set up
        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(panelDimension);
        bottomPanel.setLayout(new FlowLayout());
        panel.add(bottomPanel);

        //initialize and add components to bottom panel
        registerLabel = new JLabel("Register:");
        changeLabel = new JLabel("Change:");
        registerTA = new JTextArea();
        changeTA = new JTextArea();
        errorMessageTA = new JTextArea();

        bottomPanel.add(registerLabel);
        bottomPanel.add(registerTA);
        bottomPanel.add(changeLabel);
        bottomPanel.add(changeTA);
        bottomPanel.add(errorMessageTA);
    }

    //I can't think of a good reason to make this public...
    private void pay()
    {

        cashierObject = new Cashier(registerCashObject);
        Double priceD = Double.parseDouble(priceTF.getText());
        //call Cashier's pay method
        //show error message if necessary
        try
        {
            changeCashObject = cashierObject.pay(priceD, customerCashObject);
        } catch (IllegalArgumentException e)
        {

            errorMessageTA.setText("ERROR: " + e.getMessage());
        }

        //display results
        double registerAfterTransaction = cashierObject.getCashInRegister().getTotal();
        String registerAfterTransactionString = Double.toString(registerAfterTransaction);
        double changeD = changeCashObject.getTotal();
        String changeString = Double.toString(changeD);
        registerTA.append(registerAfterTransactionString);
        changeTA.append(changeString);

    }

    public static void main(String[] args)
    {
        new CashierFrame().setVisible(true);
    }
}
