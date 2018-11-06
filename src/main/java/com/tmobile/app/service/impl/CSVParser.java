package com.tmobile.app.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.tmobile.app.model.XMLSchema;

@Service
public class CSVParser {

	
		public void csvParser(XMLSchema[] xmlSchema) {

			for (int i = 0; i < xmlSchema.length; i++) {

				String csvFile = xmlSchema[i].getFilename();
				BufferedReader reader = null;

				String line = "";
				String cvsSplitBy = xmlSchema[i].getSplitter();
				try {
					reader = new BufferedReader(new FileReader(csvFile));
					while ((line = reader.readLine()) != null) {
					
							// use comma as separator
							String[] data = line.split(cvsSplitBy);

							for (String column : data) {
								System.out.print(column + "\t");

							}
						System.out.println();

					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

}
