package com.tmobile.app.service.impl;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.tmobile.app.model.XMLSchema;
import com.tmobile.app.service.ReconParserService;

@Service
public class XMLParser implements ReconParserService {

	@Autowired
	 private Environment env;
	
	@Value("${app.xmlfilepath}")
	String property;
	
	 @Value("${app.domain}")
	    private String appDomain;
	
String XmlFilePath="D://project2/ProjectDoc/csvreader.xml";
	
	public XMLSchema[] readingXml() {
		//System.out.println("Property---> "+env.getProperty("app.xmlfilepath"));
	//	String XmlFilePath = env.getProperty("app.xmlfilepath");
		System.out.println(appDomain);
		int NoOfLayout;
		 try {
	         File inputFile = new File(XmlFilePath);
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	         NodeList nList = doc.getElementsByTagName("layout");
	         System.out.println("----------------------------");
	         NoOfLayout=nList.getLength();
	      
	    
	      XMLSchema[] obj = new XMLSchema[nList.getLength()];
	      
	  
	  
	    	for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	         
	            
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	            //   fileName = eElement.getElementsByTagName("filename").item(0).getTextContent();
	               System.out.println("\nCurrent Element :" + nNode.getNodeName());
	              
	               obj[temp]=new XMLSchema();
	               obj[temp].setFilename(eElement.getElementsByTagName("filename").item(0).getTextContent());
	               obj[temp].setFooterrows(eElement.getElementsByTagName("footerrows").item(0).getTextContent());
	               obj[temp].setIsformulacol(eElement.getElementsByTagName("isformulacol").item(0).getTextContent());
	               obj[temp].setSplitter(eElement.getElementsByTagName("splitter").item(0).getTextContent());
	               obj[temp].setIsfooter(eElement.getElementsByTagName("isfooter").item(0).getTextContent());
	               obj[temp].setHeaderrows(eElement.getElementsByTagName("headerrows").item(0).getTextContent());
	               obj[temp].setNoofheaders(eElement.getElementsByTagName("noofheaders").item(0).getTextContent());
	               
	               
	               System.out.println(obj[temp]);
	            }
	            
	         }
	    	return obj;
	  
	       } catch (Exception e) {
	         e.printStackTrace();
	         return null;
	      }
	   
	}

}
