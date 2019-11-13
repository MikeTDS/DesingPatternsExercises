package eu.jpereira.trainings.designpatterns.creational.builder.xml;

import java.util.Iterator;

import eu.jpereira.trainings.designpatterns.creational.builder.ReportBodyBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;

public class XMLReportBodyBuilder extends ReportBodyBuilder{

	@Override
	public ReportBody buildReportBody() {
		XMLReportBody reportBody = new XMLReportBody();
		reportBody.putContent("<sale><customer><name>");
		reportBody.putContent(this.saleEntry.getCustomer().getName());
		reportBody.putContent("</name><phone>");
		reportBody.putContent(this.saleEntry.getCustomer().getPhone());
		reportBody.putContent("</phone></customer>");
		
		reportBody.putContent("<items>");
		
		Iterator<SoldItem> it = saleEntry.getSoldItems().iterator();
		while ( it.hasNext() ) {
			SoldItem soldEntry= it.next();
			reportBody.putContent("<item><name>");
			reportBody.putContent(soldEntry.getName());
			reportBody.putContent("</name><quantity>");
			reportBody.putContent(soldEntry.getQuantity());
			reportBody.putContent("</quantity><price>");
			reportBody.putContent(soldEntry.getUnitPrice());
			reportBody.putContent("</price></item>");
		}
		reportBody.putContent("</items></sale>");
		return reportBody;
	}
	
	@Override
	public Object getAsString() {
		return reportBody.getAsString();
	}
}

