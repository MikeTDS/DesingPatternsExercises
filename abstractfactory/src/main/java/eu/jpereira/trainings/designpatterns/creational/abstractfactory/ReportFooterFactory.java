package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportFooter;


public class ReportFooterFactory extends AbstractReportFactory{

	@Override
	public ReportFooter getReportFooter(String rb) {
		if (rb.equals("JSON")) {
			return new JSONReportFooter();
		}
		else if(rb.equals("XML")) {
				return new XMLReportFooter();
		}
			return null;
	}

	@Override
	public ReportBody getReportBody(String rf) {
		return null;
	}

	@Override
	public ReportHeader getReportHeader(String rh) {
		return null;
	}

}


