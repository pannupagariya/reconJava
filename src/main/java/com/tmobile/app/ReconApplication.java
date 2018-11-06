package com.tmobile.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.tmobile.app.service.ReconParserService;
import com.tmobile.app.service.impl.CSVParser;
import com.tmobile.app.service.impl.XMLParser;

@SpringBootApplication
@ComponentScan("com.tmobile.app")
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
public class ReconApplication {
	
	@Value("${app.xmlfilepath}")
	private static String xmlfilepath;
	
	@Autowired
	ReconParserService  parserService;
	
	@Autowired
	CSVParser csvParser;

	public static void main(String[] args) {
		SpringApplication.run(ReconApplication.class, args);
		
		System.out.println("Hello !!!!" + xmlfilepath);
		
		ReconApplication app = new ReconApplication(); 
		
			app.csvParsing();
				
				
		
		
	}
	
	 public void csvParsing() {
		 parserService = new XMLParser();
		 csvParser = new CSVParser();
		 csvParser.csvParser(parserService.readingXml());
	 }
}
