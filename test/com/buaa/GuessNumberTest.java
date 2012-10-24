package com.buaa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: STU
 * Date: 10/21/12
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuessNumberTest {
    private GuessNumber guessNumber;


    @Before
    public void setup(){
        String serverNumber = "9305";
        this.guessNumber = new GuessNumber(serverNumber,4,6,0);
    }

    @After
    public void end(){

    }


    @Test
    public void should_return_0a0b_if_input_no_match_and_no_right(){
        String userNumber = "1248";
        String result = guessNumber.validate(userNumber);
        assertEquals("0a0b", result);
    }

    @Test
    public void should_return_0a1b_if_input_no_match_and_one_right(){
        String userNumber = "1249";
        String result = guessNumber.validate(userNumber);
        assertEquals("0a1b", result);
    }

    @Test
    public void should_return_0a2b_if_input_no_match_and_two_right(){
        String userNumber = "1259";
        String result = guessNumber.validate(userNumber);
        assertEquals("0a2b", result);
    }

    @Test
    public void should_return_0a3b_if_input_no_match_and_three_right(){
        String userNumber = "1059";
        String result = guessNumber.validate(userNumber);
        assertEquals("0a3b", result);
    }

    @Test
    public void should_return_0a4b_if_input_no_match_and_all_right(){
        String userNumber = "5039";
        String result = guessNumber.validate(userNumber);
        assertEquals("0a4b", result);
    }

    @Test
    public void should_return_1a0b_if_input_one_match_and_no_right(){
        String userNumber = "9128";
        String result = guessNumber.validate(userNumber);
        assertEquals("1a0b", result);
    }

    @Test
    public void should_return_1a1b_if_input_one_match_and_one_right(){
        String userNumber = "9078";
        String result = guessNumber.validate(userNumber);
        assertEquals("1a1b", result);
    }

    @Test
    public void should_return_1a2b_if_input_one_match_and_two_right(){
        String userNumber = "9038";
        String result = guessNumber.validate(userNumber);
        assertEquals("1a2b", result);
    }

    @Test
    public void should_return_1a3b_if_input_one_match_and_three_right(){
        String userNumber = "9530";
        String result = guessNumber.validate(userNumber);
        assertEquals("1a3b", result);
    }

    @Test
    public void should_return_2a0b_if_input_two_match_and_no_right(){
        String userNumber = "9378";
        String result = guessNumber.validate(userNumber);
        assertEquals("2a0b", result);
    }

    @Test
    public void should_return_2a1b_if_input_two_match_and_one_right(){
        String userNumber = "9358";
        String result = guessNumber.validate(userNumber);
        assertEquals("2a1b", result);
    }

    @Test
    public void should_return_2a2b_if_input_two_match_and_two_right(){
        String userNumber = "9350";
        String result = guessNumber.validate(userNumber);
        assertEquals("2a2b", result);
    }

    @Test
    public void should_return_3a0b_if_input_three_match_and_no_right(){
        String userNumber = "9308";
        String result = guessNumber.validate(userNumber);
        assertEquals("3a0b", result);
    }

    @Test
    public void should_return_4a0b_if_input_all_match_and_no_right(){
        String userNumber = "9305";
        String result = guessNumber.validate(userNumber);
        assertEquals("You Win!", result);
    }



}
