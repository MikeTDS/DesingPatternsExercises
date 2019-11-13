package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportBody;

public class ReportBodyFactory extends AbstractReportFactory{

	@Override
	public ReportBody getReportBody(String rb) {
		if (rb.equals("JSON")) {
			return new JSONReportBody();
		}
		else if(rb.equals("XML")) {
			return new XMLReportBody();
		}
		return null;
	}

	@Override
	public ReportFooter getReportFooter(String rf) {
		return null;
	}

	@Override
	public ReportHeader getReportHeader(String rh) {
		return null;
	}

}
