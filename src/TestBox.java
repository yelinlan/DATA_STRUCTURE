

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Scanner;


/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: TestBox
 * @类描述:
 * @创建人: 权义翔
 * @创建时间: 2020/3/4 21:19
 **/
public class TestBox {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        BigInteger c = new BigInteger("0");

        BigInteger one = new BigInteger("1");
        BigInteger len = new BigInteger("10000000000");
        BigInteger i = new BigInteger("1");


        for (; new BigInteger(String.valueOf(a.bitLength())).compareTo(len)!=0 &&new BigInteger(String.valueOf(b.bitLength())).compareTo(len)!=0; ) {
            c = a.add(b);
            b = c.add(b);
            a = c;
            i = i.add(one);
        }
        System.out.println((i.multiply(new BigInteger("2")).subtract(new BigInteger("3"))) + " : " + a);
        System.out.println((i.multiply(new BigInteger("2")).subtract(new BigInteger("2"))) + " : " + b);
        System.out.println("长度 : " + a.bitLength());
        System.out.println("长度 : " + b.bitLength());
    }


}