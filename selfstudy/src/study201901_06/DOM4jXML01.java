package study201901_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DOM4jXML01 {

	public static void main(String[] args) throws DocumentException, IOException{
		//ArrayList<Emp> empList = readXml();
		//writeXml(empList);
		testFastLooping();
	}
	public static ArrayList<Emp> readXml() throws DocumentException {
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
		return empList;
	}
	public static void writeXml(ArrayList<Emp> empList) throws IOException {
		Document document=DocumentHelper.createDocument();
		Element root = document.addElement("emplist");
		for (Emp e : empList) {
			Element emp = root.addElement("emp").addAttribute("id",Integer.toString(e.getId()));
			emp.addElement("name").setText(e.getName());
			emp.addElement("age").setText(Integer.toString(e.getAge()));
			emp.addElement("gender").setText(e.getGender());
			emp.addElement("salary").setText(Integer.toString(e.getSalary()));
		}
		    FileWriter out = new FileWriter("src" + File.separator + "study201901_06" + File.separator + "write2Emp.xml");
		    OutputFormat format = OutputFormat.createPrettyPrint();
		    //PrettyPrint格式写到文件
		    XMLWriter writer1 = new XMLWriter(out,format);
		    writer1.write( document );
		    writer1.close();
		    //PrettyPrint格式写到控制台
		    System.out.println("漂亮打印");
		    XMLWriter writer = new XMLWriter(System.out, format);
	        writer.write( document );
	        //CompactFormat紧凑格式写到控制台
	        System.out.println("紧凑格式");
	        format = OutputFormat.createCompactFormat();
	        writer= new XMLWriter(System.out, format);
	        writer.write(document);
	        writer.close();
	        
	}
	public static void testFastLooping() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read("src" + File.separator + "study201901_06" + File.separator + "emp.xml");
		treeWalk(doc.getRootElement());
		findAllChildNode(doc.getRootElement());
	}
	public void treeWalk(Document document) {
	    treeWalk(document.getRootElement());
	}
	public static void treeWalk(Element element) {
		
	    for (int i = 0, size = element.nodeCount(); i < size; i++) {
	        Node node = element.node(i);
	        if (node instanceof Element) {
	        	System.out.println(node.getPath());
	            treeWalk((Element) node);
	        }else {
	          //do something
	        }
	    }
	   
	}
	public static void findAllChildNode(Element element) {
		 for (Iterator<Element> it = element.elementIterator(); it.hasNext();) {
			 Element ii=it.next();
			 System.out.println(ii.getPath());
		    if(it.hasNext()) {
		    	findAllChildNode(ii);
		    }else {
		    	System.out.println("no next...");
		    }
		 }
	}

}
