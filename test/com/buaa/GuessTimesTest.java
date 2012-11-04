package com.buaa;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Zhutao
 * Date: 12-10-24
 * Time: 下午4:51
 * To change this template use File | Settings | File Templates.
 */
public class GuessTimesTest {
    private GuessNumber guessNumber;

    @Before
    public void setup(){
        guessNumber = new GuessNumber(4,6);
    }

    @Test
    public void should_return_win_if_guess_count_get_guess_times(){
        int guessTimes = guessNumber.getGuessTimes();
        guessNumber.setGuessCount(guessTimes-1);
        String number = guessNumber.getNumber();
        String result = guessNumber.validate(number);
        assertEquals(GuessNumber.WIN, result);
    }

    @Test
    public void should_return_lose_if_guess_count_get_guess_times(){
        int guessTimes = guessNumber.getGuessTimes();
        guessNumber.setGuessCount(guessTimes-1);
        String number = guessNumber.getNumber();
        String str = guessNumber.createNumber();
        while(str.equalsIgnoreCase(number)){
            str = guessNumber.createNumber();
        }
        String result = guessNumber.validate(str);
        assertEquals(GuessNumber.LOSE, result);
    }


}
