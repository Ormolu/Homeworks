import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class NumbersScannerTest {
    private NumbersScanner numbersScanner;
    private int secretNumber;

    @Before
    public void init() {
        Random random = new Random();
        this.secretNumber = random.nextInt();
        numbersScanner = new NumbersScanner(this.secretNumber, 1);
    }

    @Test
    public void testGuessIncorrect() {
        assertFalse(numbersScanner.makeGuess(this.secretNumber -1));
    }

    @Test
    public void testGuessCorrect() {
        assertTrue(numbersScanner.makeGuess(this.secretNumber));
    }

}


