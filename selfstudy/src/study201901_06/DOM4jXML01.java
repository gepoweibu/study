package study201901_06;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4jXML01 {

	public static void main(String[] args) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read("src" + File.separator + "study201901_06" + File.separator + "emp.xml");
		Element root = doc.getRootElement();
		ArrayList<Emp> empList = new ArrayList<Emp>();
		for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
			Element element = it.next();
			Emp emp = new Emp();
			emp.setId(Integer.parseInt(element.attributeValue("id")));
			emp.setName(element.elementTextTrim("name"));
			emp.setAge(Integer.parseInt(element.elementTextTrim("age")));
			emp.setGender(element.elementTextTrim("gender"));
			emp.setSalary(Integer.parseInt(element.elementTextTrim("salary")));
			empList.add(emp);
		}
		for (Emp emp : empList) {
			System.out.println(emp);
		}
	}

}
