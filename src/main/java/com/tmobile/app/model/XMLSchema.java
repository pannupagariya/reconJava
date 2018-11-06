package com.tmobile.app.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name="layout")
public class XMLSchema {
	private String filename;
	private String noofheaders;
	private String headerrows;
	private String isfooter;
	private String footerrows;
	private String isformulacol;
	private String splitter;
	
	public String getSplitter() {
		return splitter;
	}
	public void setSplitter(String splitter) {
		this.splitter = splitter;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getNoofheaders() {
		return noofheaders;
	}
	public void setNoofheaders(String noofheaders) {
		this.noofheaders = noofheaders;
	}
	public String getHeaderrows() {
		return headerrows;
	}
	public void setHeaderrows(String headerrows) {
		this.headerrows = headerrows;
	}
	public String getIsfooter() {
		return isfooter;
	}
	public void setIsfooter(String isfooter) {
		this.isfooter = isfooter;
	}
	public String getFooterrows() {
		return footerrows;
	}
	public void setFooterrows(String footerrows) {
		this.footerrows = footerrows;
	}
	public String getIsformulacol() {
		return isformulacol;
	}
	public void setIsformulacol(String isformulacol) {
		this.isformulacol = isformulacol;
	}
	@Override
	public String toString() {
		return "XMLSchema [filename=" + filename + ", noofheaders=" + noofheaders + ", headerrows=" + headerrows
				+ ", isfooter=" + isfooter + ", footerrows=" + footerrows + ", isformulacol=" + isformulacol
				+ ", splitter=" + splitter + "]";
	}
	
}
