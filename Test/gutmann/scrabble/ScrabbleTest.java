package gutmann.scrabble;


import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ScrabbleTest
{
    @Test
    public void checkWord()
    {
    Scrabble scrabble = new Scrabble();

    assertTrue( scrabble.checkWord("yo"));
    }
}