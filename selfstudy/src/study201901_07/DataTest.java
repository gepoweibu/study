package study201901_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataTest {

	public static void main(String[] args) {
		//System.out.println(flagReverse( "上海自来水来自海上"));
		getNumOfWord("i am a coder,you are my friend!");
	}

	public static boolean flagReverse(String str) {
		String[] strs = str.trim().split("");
		StringBuffer sbStr = new StringBuffer();
		for (int i = strs.length - 1; i >= 0; i--) {
			sbStr.append(strs[i]);
		}
		return str.trim().equals(sbStr.toString());
	}

	public static int getNumOfWord(String str) {
		Pattern p = Pattern.compile("\\b[a-zA-Z]+\\b");//正则\b字边界匹配，+一次或多次匹配前面的表达式
		Matcher m = p.matcher(str);
		int count = 0;
		while (m.find()) {
			System.out.print(m.group()+" ");
			count++;
		}
		System.out.println();
		System.out.println("总共:" + count + "个单词.");
		return count;
	}

}
