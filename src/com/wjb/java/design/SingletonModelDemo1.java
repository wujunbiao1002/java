package com.wjb.java.design;

/**
 * <b><code>SingletonMode</code></b>
 * <p/>
 * Description 单例设计模式，饿汉式
 * <p/>
 * <b>Creation Time:</b> 2022/2/10 11:15.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class SingletonModelDemo1 {
    public static void main(String[] args) {
        Bank1 bank1 = Bank1.getInstance();
        Bank1 bank2 = Bank1.getInstance();
        System.out.println(bank1.getBankName());
        System.out.println(bank2.getBankName());

        bank2.setBankName("银行");
        System.out.println(bank1.getBankName());
        System.out.println(bank2.getBankName());

        System.out.println(bank1 == bank2);
        System.out.println(bank1.toString());
        System.out.println(bank2.toString());
    }
}

class Bank1 {
    private String bankName = "中国银行";
    private static final Bank1 BANK = new Bank1();

    private Bank1() {

    }

    public static Bank1 getInstance() {
        return BANK;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}