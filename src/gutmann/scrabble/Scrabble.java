package gutmann.scrabble;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Scrabble

{
    private File file;
    private final Set<String> set = new HashSet<>();
    public Scrabble()
    {
        file = new File("dictionary.txt");
        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNext())
            {
                String dictionaryIn = scanner.next();
                set.add(dictionaryIn.toLowerCase());
                scanner.nextLine();
            }
        } catch (IOException ioex)
        {
            System.out.println(ioex.getMessage());
        }
    }
    public boolean isWord(String word)
    {
        boolean isAWord = false;
        if (set.contains(word.toLowerCase()))
        {
            isAWord = true;
        }
        return isAWord;
    }

}

