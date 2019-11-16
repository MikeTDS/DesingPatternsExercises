package eu.jpereira.trainings.designpatterns.structural.facade.model;

import eu.jpereira.trainings.designpatterns.structural.facade.BookstoreFacade;
import eu.jpereira.trainings.designpatterns.structural.facade.service.BookDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerNotificationService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.OrderingService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.WharehouseService;

public class DefaultBookStoreFacade implements BookstoreFacade{
	
	public BookDBService bookService;
	public CustomerDBService customerService;
	public OrderingService orderingService;
	public WharehouseService warehouseService;
	public CustomerNotificationService customerNotificationService;
	

	@Override
	public void placeOrder(String customerId, String isbn) {
		Book orderedBook = bookService.findBookByISBN(isbn);
		Customer theClient = customerService.findCustomerById(customerId);
		Order theOrder = orderingService.createOrder(theClient, orderedBook);
		DispatchReceipt dr = warehouseService.dispatch(theOrder);
		customerNotificationService.notifyClient(dr);
		
	}
	
	
	public void setBookService(BookDBService bs) {
		bookService = bs;
	}
	
	public void setCustomerService(CustomerDBService cs) {
		customerService = cs;
	}
	
	public void setOrderingService(OrderingService os) {
		orderingService = os;
	}
	
	public void setWharehouseService(WharehouseService ws) {
		warehouseService = ws;
	}
	
	public void setCustomerNotificationService(CustomerNotificationService cns) {
		customerNotificationService = cns;
	}

}
