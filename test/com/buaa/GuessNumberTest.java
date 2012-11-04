package com.buaa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: STU
 * Date: 10/21/12
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(value= Parameterized.class)
public class GuessNumberTest {
    private GuessNumber guessNumber;
    private String inputStr;
    private String outputStr;

    public GuessNumberTest(String inputStr, String outputStr){
        this.inputStr = inputStr;
        this.outputStr = outputStr;
    }

    @Parameterized.Parameters
    public static Collection<String []> getParameters(){
        return Arrays.asList(new String[][] {
                {"1248", "0a0b"},
                {"1249", "0a1b"},
                {"1259", "0a2b"},
                {"1059", "0a3b"},
                {"5039", "0a4b"},
                {"9128", "1a0b"},
                {"9078", "1a1b"},
                {"9038", "1a2b"},
                {"9530", "1a3b"},
                {"9378", "2a0b"},
                {"9358", "2a1b"},
                {"9350", "2a2b"},
                {"9308", "3a0b"},
                {"9305", "You Win!"},
        });
    }

    @Before
    public void setup(){
        String serverNumber = "9305";
        this.guessNumber = new GuessNumber(serverNumber,4,6,0);
    }

    @After
    public void end(){

    }

    @Test
    public void params_test(){
        String result = guessNumber.validate(inputStr);
        assertEquals(outputStr, result);
    }

    /*
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
    */



}
