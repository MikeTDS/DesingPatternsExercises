package eu.jpereira.trainings.designpatterns.creational.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;

public abstract class ReportBodyBuilder implements ReportBody{
	
	protected ReportBody reportBody;
	protected SaleEntry saleEntry;

	public abstract ReportBody buildReportBody();
	
	public void setSaleEntry(SaleEntry saleEntry) {
		this.saleEntry = saleEntry;
	}
	
	public ReportBody getReportBody() {
		return buildReportBody();
	}
}