package com.kv.test;

import java.net.InetAddress;

public class Test {

	public static void main(String[] args) throws Exception {
		InetAddress addr = InetAddress.getLocalHost();   
        String ip=addr.getHostAddress().toString(); //获取本机ip  
        System.out.println(ip);
	}
}
