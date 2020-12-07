package io.github.tanghuibo.onepiecestudyweb.exception;

/**
 * @author tanghuibo
 * @date 2020/12/7下午11:55
 */
public class MyException extends RuntimeException {

    public MyException(String msg) {
        super(msg);
    }

    public static MyException build(String msg) {
        return new MyException(msg);
    }
}
