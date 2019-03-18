package study201903_16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWord {

	public static void main(String[] args) throws IOException {

         BufferedReader br1 = new BufferedReader(new FileReader("src/study201903_16/a.txt"));
         BufferedReader br2 = new BufferedReader(new FileReader("src/study201903_16/b.txt"));
	     BufferedWriter bw = new BufferedWriter(new FileWriter("src/study201903_16/c.txt"));
		 String str;
		 StringBuffer sb1=new StringBuffer();
		 StringBuffer sb2=new StringBuffer();
		 while((str=br1.readLine())!=null) {
			 sb1.append(str);
		 }
		 while((str=br2.readLine())!=null) {
			 sb2.append(str);
		 }
		 System.out.println("sb1: "+sb1);
		 getNumOfWord(sb1.toString());
		 System.out.println("sb2: "+sb2);
		 getNumOfWord(sb2.toString());
		 System.out.println("-----------合并-A-and-B--------------");
		 StringBuffer sb = getAAndBWord(sb1, sb2);
		 System.out.println("sb: "+sb.toString());
		 getNumOfWord(sb.toString());
		 bw.write(sb.toString());
		 bw.flush();
		 br1.close();
		 br2.close();
		 bw.close();
	}
	public static void getNumOfWord(String str) {
		Pattern p = Pattern.compile("\\b[a-zA-Z]+\\b");//正则\b字边界匹配，+一次或多次匹配前面的表达式
		Matcher m = p.matcher(str);
		int count = 0;
		while (m.find()) {
			System.out.print(m.group()+" ");
			count++;
		}
		System.out.println();
		System.out.println("总共:" + count + "个单词.");
	}
	public static StringBuffer getAAndBWord(StringBuffer sbA,StringBuffer sbB) {
		StringBuffer sb=new StringBuffer();
		Pattern p = Pattern.compile("\\b[a-zA-Z]+\\b");//正则\b字边界匹配，+一次或多次匹配前面的表达式
		Matcher m1 = p.matcher(sbA.toString());
		Matcher m2 = p.matcher(sbB.toString());
		ArrayList<String> list1=new ArrayList<String>();
		ArrayList<String> list2=new ArrayList<String>();
		while(m1.find()) {
			list1.add(m1.group());
		}
		while(m2.find()) {
			list2.add(m2.group());
		}
		if(list1.size()<=list2.size()) {
			for (int i = 0; i < list1.size(); i++) {
				sb.append(list1.get(i)+" ");
				sb.append(list2.get(i)+" ");
			}
			for (int i = list1.size(); i < list2.size(); i++) {
				sb.append(list2.get(i)+" ");
			}
		}else {
			for (int i = 0; i < list2.size(); i++) {
				sb.append(list1.get(i)+" ");
				sb.append(list2.get(i)+" ");
			}
			for (int i = list2.size(); i < list1.size(); i++) {
				sb.append(list1.get(i)+" ");
			}
		}
		return sb;
	}

}
