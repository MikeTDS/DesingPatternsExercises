package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportHeader;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportHeader;

public class ReportHeaderFactory extends AbstractReportFactory{
	@Override
	public ReportHeader getReportHeader(String rb) {
		if (rb.equals("JSON")) {
			return new JSONReportHeader();
		}
		else if(rb.equals("XML")) {
				return new XMLReportHeader();
		}
			return null;
	}

	@Override
	public ReportBody getReportBody(String rf) {
		return null;
	}

	@Override
	public ReportFooter getReportFooter(String rh) {
		return null;
	}

}
