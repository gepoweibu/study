package study201901_06;

import java.io.File;
import java.util.ArrayList;

import org.dom4j.Document;
import org.dom4j.DocumentException;

public class DOM4jXML02 {

	public static void main(String[] args) throws DocumentException {
		testXmlUtil();
	}
	public static void testXmlUtil() throws DocumentException {
		Document document = XmlUtil.read("src" + File.separator + "study201901_06" + File.separator + "emp.xml");
		ArrayList<Leaf> elemList=new ArrayList<Leaf>();
		elemList=XmlUtil.getElementList(document.getRootElement(), elemList);
		for (Leaf leaf : elemList) {
			System.out.println(leaf.getXpath());
		}
	}

}
