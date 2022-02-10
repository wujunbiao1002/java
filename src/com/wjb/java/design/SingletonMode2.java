package com.wjb.java.design;

/**
 * <b><code>SingletonMode</code></b>
 * <p/>
 * Description 单例设计模式，懒汉式
 * <p/>
 * <b>Creation Time:</b> 2022/2/10 11:15.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class SingletonMode2 {
    public static void main(String[] args) {
        Bank2 bank1 = Bank2.getInstance();
        Bank2 bank2 = Bank2.getInstance();
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

class Bank2 {
    private String bankName = "中国";
    private static Bank2 bank = null;

    private Bank2() {

    }

    public static Bank2 getInstance() {
        if (bank != null) {
            return bank;
        }
        return bank = new Bank2();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}