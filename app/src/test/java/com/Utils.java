package com;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class Utils {
    public static <T> void println(Collection<T> collections) {
        for (T collection : collections) {
            println(collection);
        }
    }

    public static <T> void print(Collection<T> collections) {
        StringBuilder stringBuilder = new StringBuilder();
        for (T collection : collections) {
            stringBuilder.append(collection).append("\t");
        }
        println(stringBuilder.toString());
    }


    public static void println(Object o) {
        if (o instanceof String) {
            printInternal((String) o, true);
        } else if (o instanceof Integer) {
            printInternal(String.valueOf(o), true);
        } else {
            printInternal(String.valueOf(o), true);
        }
    }

    public static void print(Object o) {
        if (o instanceof String) {
            printInternal((String) o, false);
        } else if (o instanceof Integer) {
            printInternal(String.valueOf(o), false);
        } else {
            printInternal(String.valueOf(o), false);
        }
    }

    private static void printInternal(String o, boolean enter) {
        if (o != null) {
            if (enter) {
                System.out.println("Thread:" + Thread.currentThread() + ",\t" + o);
            } else {
                System.out.print("Thread:" + Thread.currentThread() + ",\t" + o);
            }
        }

    }

    public static String getMD5(String val) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        }
        StringBuffer sb = new StringBuffer();
        if (md5 != null) {
            md5.update(val.getBytes());
            byte[] hash = md5.digest();//加密
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    sb.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    sb.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
        }
        return sb.toString();
    }


    public static void suspend(int second) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            countDownLatch.await(second, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("thread interrupt" + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public static void suspend() {
        suspend(10);
    }
}
