package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;

public class ThirdPartyDoorObjectAdapter implements Door{

ThirdPartyDoorAdapter thirdPartyDoorAdapter= new ThirdPartyDoorAdapter();
	
	@Override
	public void open(String code) throws IncorrectDoorCodeException {
		thirdPartyDoorAdapter.open(code);
	}

	@Override
	public void close() {
		thirdPartyDoorAdapter.close();
	}

	@Override
	public boolean isOpen() {
		return thirdPartyDoorAdapter.isOpen();
	}

	@Override
	public void changeCode(String oldCode, String newCode, String newCodeConfirmation)
			throws IncorrectDoorCodeException, CodeMismatchException {
		thirdPartyDoorAdapter.changeCode(oldCode, newCode, newCodeConfirmation);
		
	}

	@Override
	public boolean testCode(String code) {
		return thirdPartyDoorAdapter.testCode(code);
	}

}
