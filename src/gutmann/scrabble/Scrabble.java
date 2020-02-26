package gutmann.scrabble;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Scrabble
{
    public boolean checkWord(String word)
    {
        boolean isAWord = false;

        HashSet<String> hashSet = new HashSet<String>();

        File file = new File("dictionary.txt");
        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNext())
            {
                String dictionaryIn = scanner.next();
                hashSet.add(dictionaryIn.toLowerCase());
                scanner.nextLine();
            }
        } catch (IOException ioex)
        {
            System.out.println(ioex.getMessage());
        }

        if (hashSet.contains(word.toLowerCase()))
        {
            isAWord = true;
        }
        return isAWord;
    }

}

