package com.buaa.errors;

/**
 * Created with IntelliJ IDEA.
 * User: Zhutao
 * Date: 12-10-23
 * Time: 下午8:08
 * To change this template use File | Settings | File Templates.
 */
public class SameNumberException extends RuntimeException {
    private String message = "字符串中存在相同的数字！";
    public SameNumberException(String message) {
        super(message);
    }
}
