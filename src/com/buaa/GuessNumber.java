package com.buaa;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: STU
 * Date: 10/21/12
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuessNumber {

    private String number;
    private int numberSize;
    private int guessTimes;
    private int guessCount;

    public static final String WIN = "You Win!";
    public static final String LOSE = "You LOSE!";
    public static final String OTHER = "Impossible!";

    public GuessNumber() {

    }

    public GuessNumber(int numberSize, int guessTimes) {
        setNumberSize(numberSize);
        setGuessTimes(guessTimes);
        setGuessCount(0);
        setNumber(createNumber());
    }

    public GuessNumber(String number, int numberSize, int guessTimes, int guessCount) {
        this.number = number;
        this.numberSize = numberSize;
        this.guessTimes = guessTimes;
        this.guessCount = guessCount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getNumberSize() {
        return numberSize;
    }

    public void setNumberSize(int numberSize) {
        this.numberSize = numberSize;
    }

    public int getGuessTimes() {
        return guessTimes;
    }

    public void setGuessTimes(int guessTimes) {
        this.guessTimes = guessTimes;
    }

    public int getGuessCount() {
        return guessCount;
    }

    public void setGuessCount(int guessCount) {
        this.guessCount = guessCount;
    }

    /**
     * 校验猜测结果;
     * @param str 输入字符串;
     * @return [x]a[x]b（"输入不合法！"）
     */
    public String validate(String str) {
        String s = str.replaceAll("\\s", "");
        if(validateStr(s)) {
            if(validateStr(number)){
                guessCount ++;
                String result = compareTwoStr(number, s);
                if(guessCount == guessTimes){
                    if(!result.equalsIgnoreCase(WIN)){
                        return LOSE;
                    }
                }else if(guessCount>guessTimes){
                    return OTHER;
                }
                return result;
            }
            return "对不起，服务器产生数据错误！";
        }
        return "对不起，您的输入不合法！";
    }

    /**
     * 随机产生字符串（合法的,四位有效数字）;
     * @return [xxxx].
     */
    public String createNumber() {
        int [] ranArr = getRandomNumber(numberSize);
        String str = "";
        for(int i=0; i<ranArr.length; i++){
            str += ranArr[i];
        }
        return str;
    }

    /**
     * 内部方法，比较两个字符串（合法的,四位有效数字）;
     * @param s 服务器产生的字符串;
     * @param d 用户输入字符串;
     * @return [x]a[x]b.
     */
    private String compareTwoStr(String s, String d) {
        char [] sArr = s.toCharArray();
        char [] dArr = d.toCharArray();
        //获取a的数量
        int aNum = getMatchNumber(sArr, dArr, dArr.length);
        //获取b+a的数量
        int bNum = getRightNumber(sArr, dArr, dArr.length);
        if(aNum == numberSize){
            return WIN;
        }else{
            return aNum + "a" + (bNum-aNum) + "b";
        }
    }

    private int getMatchNumber(char[] sArr, char[] dArr, int num) {
        int sum = 0;
        for (int i=0; i<num; i++){
            if(sArr[i] == dArr[i]) sum++;
        }
        return sum;
    }

    private int getRightNumber(char[] sArr, char[] dArr, int num) {
        int sum = 0;
        for (int i=0; i<num; i++){
            for (int j=0; j<num; j++){
                if(sArr[i] == dArr[j]) sum++;
            }
        }
        return sum;
    }


    /**
     * 内部方法，校验字符串的合法性;
     * @param s 输入字符串;
     * @return 是否合法;
     */
    private boolean validateStr(String s) {
        Pattern pattern = Pattern.compile("\\d{4}");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()){
            //校验是否有相等的情况
            return true;
        }
        return false;
    }

    /**
     * 内部方法，校验字符串的合法性;
     * @param n 数组大小;
     * @return int[n] int数组;
     */
    public static int[] getRandomNumber(int n) {
        int [] seed = {0,1,2,3,4,5,6,7,8,9};
        int [] ranArr = new int [n];
        Random ran = new Random();
        for(int i = 0 ; i<n ; i++){
            int j = ran.nextInt(seed.length-i);
            ranArr [i] = seed [j];
        }
        return ranArr;
    }


    public static void main(String[] args)
    {
        GuessNumber gn = new GuessNumber(4,6);

        String str = "1234";

        String result = gn.validate(str);

        System.out.println(result);
    }

}
