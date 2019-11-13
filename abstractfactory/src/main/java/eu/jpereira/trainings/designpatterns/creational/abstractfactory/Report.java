/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportHeader;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportHeader;

public class Report {

	private String reportContent;
	private ReportBody body;
	private ReportFooter footer;
	private ReportHeader header;
	private String reportType;
	private AbstractReportFactory reportBodyFactory;
	private AbstractReportFactory reportFooterFactory;
	private AbstractReportFactory reportHeaderFactory;
	
	
	/**
	 * @param string
	 */
	public Report(String string) {
		this.reportType = string;
		reportBodyFactory = FactoryProducer.getFactory("body");
		reportFooterFactory = FactoryProducer.getFactory("footer");
		reportHeaderFactory = FactoryProducer.getFactory("header");
		
		setBody(reportBodyFactory.getReportBody(reportType));
		setFooter(reportFooterFactory.getReportFooter(reportType));
		setHeader(reportHeaderFactory.getReportHeader(reportType));
		
		
//		if ( reportType.equals("JSON")) {
//			//to compose Report with JSON objects
//			this.setBody(new JSONReportBody());
//			this.setFooter(new JSONReportFooter());
//			this.setHeader(new JSONReportHeader());
//		} else {
//			this.setFooter(new XMLReportFooter());
//			this.setHeader(new XMLReportHeader());
//			this.setBody(new XMLReportBody());
//		}
	}


	public void setBody(ReportBody body) {
		this.body = body;

	}
	
	public void setFooter(ReportFooter footer) {
		this.footer = footer;

	}

	
	public void setHeader(ReportHeader header) {
		this.header = header;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public ReportBody getBody() {
		return body;
	}

	public String getReportContent() {
		return reportContent;
	}

	public ReportFooter getFooter() {
		return footer;
	}


	public ReportHeader getHeader() {
		return header;
	}

	
}
