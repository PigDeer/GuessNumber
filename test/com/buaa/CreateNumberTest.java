package com.buaa;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Zhutao
 * Date: 12-10-23
 * Time: 下午8:57
 * To change this template use File | Settings | File Templates.
 */
public class CreateNumberTest {
    private GuessNumber guessNumber;

    @Before
    public void setup(){
        guessNumber = new GuessNumber();
        guessNumber.setCount(4);
        guessNumber.setNumber(guessNumber.createNumber());
    }

    @Test
    public void should_return_number_in_four_length(){
        String number = guessNumber.getNumber();
        Pattern pattern = Pattern.compile("\\d{4}");
        Matcher matcher = pattern.matcher(number);
        boolean isNum = matcher.find();
        int result = number.length();
        assertEquals(true, isNum);
        assertEquals(4, result);
    }

    @Test
    public void should_return_number_all_different(){
        String number = guessNumber.getNumber();
        int count = guessNumber.getCount();
        char [] sArr = number.toCharArray();
        int result = 0;
        for(int i=0;i<count;i++){
            for(int j=i+1;j<count;j++){
                if(sArr[i]==sArr[j])
                    result++;
            }
        }
        assertEquals(0, result);
    }


}
