package com.k2data.qa.mytest;

import java.nio.ByteBuffer;
import java.util.Random;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

public class Jptest {
	
	public static int[][] mutation(int count, int cycle){
		int[][] mp = new int[1000][2];
		int fp = count/10;
		Random r = new Random();
		for (int i=0; i<1000; i++){
			mp[i][0] = fp*(i+1);
			mp[i][1] = r.nextInt(cycle*2-1)-(cycle-1);
		}
		return mp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String json = "{\"count\":18,\"data\":{\"ld_d1\":{\"ld_s1\":{\"count\":4,\"data\":[{\"20130501010003000\":672},{\"20130501010002000\":355},{\"20130501010001000\":345},{\"20130501010000000\":314}]},\"ld_s2\":{\"count\":4,\"data\":[{\"20130501010003000\":455},{\"20130501010002000\":414},{\"20130501010001000\":445},{\"20130501010000000\":414}]}},\"ld_d2\":{\"ld_s1\":{\"count\":5,\"data\":[{\"20130501010006000\":2},{\"20130501010004000\":72},{\"20130501010003000\":972},{\"20130501010002000\":855},{\"20130501010001000\":335}]},\"ld_s2\":{\"count\":5,\"data\":[{\"20130501010006000\":272},{\"20130501010004000\":955},{\"20130501010003000\":955},{\"20130501010002000\":55},{\"20130501010001000\":45}]}}},\"success\":true}";
//		Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
//		int d1s2v02 = JsonPath.read(document, "$.data.ld_d1.ld_s2.data[0].20130501010003000");
//		System.out.println(d1s2v02);
		
		//System.out.println(110/10);
//		int[][] mp = mutation(111,10);
//		for(int j=0;j<1000;j++){
//			System.out.println(mp[j][0] + " : " + mp[j][1]);
//		}
		
//		Random r = new Random();
//		for(int i=0; i<1000; i++){
//			int seed = r.nextInt(11);
//			int value = (int) Math.pow(-seed, seed);
//			System.out.println(value);
//		}
		
//		byte[] buff = new byte[100];
//		for(int i=0;i<10;i++){
//			buff[i] = 0x33;
//		}
//		buff[10] = 0x70;
//		buff[11] = 0x6c;
//		buff[12] = 0x61;
//		buff[13] = 0x79;
//		for(int i=14;i<50;i++){
//			buff[i] = 0x33;
//		}
//		buff[50] = 0x70;
//		buff[51] = 0x6c;
//		buff[52] = 0x61;
//		buff[53] = 0x79;
//		for(int i=54;i<100;i++){
//			buff[i] = 0x33;
//		}
//		ByteBuffer bb = ByteBuffer.wrap(buff);
//		byte[] sep = new byte[4];
//		sep[0] = 0x70;
//		sep[1] = 0x6c;
//		sep[2] = 0x61;
//		sep[3] = 0x79;
//		
//		ByteBuffer[] res = ByteBufferUtil.split(bb, sep);
//		for(ByteBuffer b:res){
//			System.out.println("---------------------");
//			byte[] array = b.array();
//			for(byte t:array){
//				System.out.println(t);
//			}
//		}
		
		byte[] b = new byte[4];
		b[0] = 0x11;
		b[1] = 0x11;
		b[2] = 0x11;
		b[3] = 0x11;
		
		byte[] bb = new byte[4];
		bb[0] = 0x11;
		bb[1] = 0x11;
		bb[2] = 0x11;
		bb[3] = 0x11;
		
		System.out.println(b.equals(bb));

	}

}
