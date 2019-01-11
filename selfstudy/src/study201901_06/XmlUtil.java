package study201901_06;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultAttribute;

public class XmlUtil {

	/**
	 * 	读取并解析XML文档 从文件读取XML，输入文件名,返回XML文档
	 * 
	 * @param fileName
	 * @return XML文档
	 * @throws DocumentException
	 */
	public static Document read(String fileName) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(fileName));
		return document;
	}

	/**
	 * 
	 * @param element
	 * @return
	 */
	public static String getNodeAttribute(Element element) {
		String xattribute = "";
		DefaultAttribute e = null;
		List<Attribute> list = element.attributes();
		for (int i = 0; i < list.size(); i++) {
			e = (DefaultAttribute) list.get(i);
			xattribute += " " + e.getName() + "=" + "\"" + e.getText() + "\"";//显示效果：a="12" b="46"
		}
		return xattribute;
	}

	/**
	 * 	遍历element的所有叶子节点
	 * @param element
	 * @return
	 */
	public static ArrayList<Leaf> getElementList(Element element, ArrayList<Leaf> elemList) {
		List<Element> elements = element.elements();
		if (elements.size() == 0) {
			// 没有子元素
			String xpath = element.getPath();
			String value = element.getTextTrim();
			elemList.add(new Leaf(getNodeAttribute(element), xpath, value));
		} else {
			// 有子元素
			Iterator<Element> it = elements.iterator();
			while (it.hasNext()) {
				Element elem = (Element) it.next();
				// 递归遍历
				getElementList(elem, elemList);

			}
		}
		return elemList;
	}

}
