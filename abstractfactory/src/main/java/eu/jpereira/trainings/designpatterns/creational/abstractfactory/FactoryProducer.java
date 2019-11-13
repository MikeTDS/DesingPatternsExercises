package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

public class FactoryProducer {
	public static AbstractReportFactory getFactory(String type) {
		if(type.equals("body"))
			return new ReportBodyFactory();
		else if(type.equals("header"))
			return new ReportHeaderFactory();
		else if(type.equals("footer"))
			return new ReportFooterFactory();
		
		return null;
	}

}
