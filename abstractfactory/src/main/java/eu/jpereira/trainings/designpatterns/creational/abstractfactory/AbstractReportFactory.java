package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

public abstract class AbstractReportFactory {
	public abstract ReportBody getReportBody(String rb);
	public abstract ReportFooter getReportFooter(String rf);
	public abstract ReportHeader getReportHeader(String rh);
}
