package eu.jpereira.trainings.designpatterns.creational.builder;

import java.util.Iterator;

import eu.jpereira.trainings.designpatterns.creational.builder.ReportBodyBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;

public class HTMLReportBodyBuilder extends ReportBodyBuilder{
	
	@Override
	public ReportBody buildReportBody() {
		
		HTMLReportBody reportBody = new HTMLReportBody();
		reportBody.putContent("<span class=\"customerName\">");
		reportBody.putContent(super.saleEntry.getCustomer().getName());
		reportBody.putContent("</span><span class=\"customerPhone\">");
		reportBody.putContent(this.saleEntry.getCustomer().getPhone());
		reportBody.putContent("</span>");
		
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
		reportBody.putContent("</items>");
		return reportBody;
	}

	@Override
	public Object getAsString() {
		return this.reportBody.getAsString();
	}
}
