package gutmann.scrabble;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Scrabble
{
    public boolean checkWord()
    {
        String input = "AW";
        boolean isAWord = false;

        String filePath = "dictionary.txt";
        try (Scanner wordsIn = new Scanner(new FileReader(filePath)))
        {
            wordsIn.useDelimiter("[^a-zA-Z']+");
            while (wordsIn.hasNext())      // while more words to process
            {
                String word = wordsIn.next();
                if (input.compareTo(word) < 0)
                {
                    isAWord = true;
                    break;
                }
            }
        } catch (IOException ioex)
        {
            System.out.println(ioex.getMessage());
        }
        return isAWord;
    }

}

