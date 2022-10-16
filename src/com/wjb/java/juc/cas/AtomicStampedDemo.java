package com.wjb.java.juc.cas;


import java.util.concurrent.atomic.AtomicStampedReference;


class Book
{
    private int id;
    private String bookName;

    public Book(int id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}

/**
 *
 */
public class AtomicStampedDemo
{
    public static void main(String[] args)
    {
        Book javaBook = new Book(1,"javaBook");

        AtomicStampedReference<Book> stampedReference = new AtomicStampedReference<>(javaBook,1);

        System.out.println(stampedReference.getReference()+"\t"+stampedReference.getStamp());

        Book mysqlBook = new Book(2,"mysqlBook");

        boolean b;
        b = stampedReference.compareAndSet(javaBook, mysqlBook, stampedReference.getStamp(), stampedReference.getStamp() + 1);

        System.out.println(b+"\t"+stampedReference.getReference()+"\t"+stampedReference.getStamp());


        b = stampedReference.compareAndSet(mysqlBook, javaBook, stampedReference.getStamp(), stampedReference.getStamp() + 1);

        System.out.println(b+"\t"+stampedReference.getReference()+"\t"+stampedReference.getStamp());

    }
}
