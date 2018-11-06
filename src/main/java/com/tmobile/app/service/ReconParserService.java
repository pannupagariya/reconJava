package com.tmobile.app.service;

import org.springframework.stereotype.Service;

import com.tmobile.app.model.XMLSchema;

@Service
public interface ReconParserService {
	
	public XMLSchema[] readingXml();

}
