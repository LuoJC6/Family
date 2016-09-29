package com.Family.familyfinances.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class text {
	public static void main(String[] args) {  
        String str = "测试字符转换 hello word"; //默认环境，已是UTF-8编码  
        try {  
            String strGBK = URLEncoder.encode(str, "GBK");  
            System.out.println(strGBK);  
            String strUTF8 = URLDecoder.decode(str, "UTF-8");  
            System.out.println(strUTF8);  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
    }  
}
