package gutmann.scrabble;


import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class ScrabbleFrame extends JFrame
{
    private final JTextField wordField;
    private final JLabel answerLabel;
    private Scrabble dictionary;

    public ScrabbleFrame() throws FileNotFoundException
    {
        //pixel size
        setSize(400, 300);

        setTitle("Scrabble Frame");

        //when does the code stop running
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //automatically sets to lowest possible size, so set the other components to preferred size,
        //see other lines below
        setLayout(new FlowLayout());

        wordField = new JTextField();
        wordField.setPreferredSize(new Dimension(100, 40));
        JButton checkButton = new JButton("Check");
        //ActionListener is a interface. first we saw anonymous class, then lambda, we used a lambda
        checkButton.addActionListener(actionEvent -> checkWord());

        answerLabel = new JLabel();
        answerLabel.setPreferredSize(new Dimension(100, 40));

        add(wordField);
        add(checkButton);
        add(answerLabel);

        dictionary = new Scrabble();
    }

    public void checkWord()
    {
        boolean isDictionary = dictionary.isWord(wordField.getText());
        answerLabel.setText(String.valueOf(isDictionary));
    }


//JComponent is a library of all components - what goes into JFrame
//JLabel- unalterable text or image
//JButton- don't use absolute coordinates, need a LayoutManager
//JTextField
//JTextArea
//JPanel - put other components into this component
//Listeners - used to respond to user, diff kinds...
//ActionListener - responds to mouse left click
//MouseMotionListener
//DragListener


    public static void main(String[] args) throws FileNotFoundException
    {
        ScrabbleFrame frame = new ScrabbleFrame();
        //cause it creates it but you have to make it visible
        frame.setVisible(true);
    }

}