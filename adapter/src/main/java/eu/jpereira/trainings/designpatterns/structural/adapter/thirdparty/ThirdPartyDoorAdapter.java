package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

public class ThirdPartyDoorAdapter extends ThirdPartyDoor implements Door{
	@Override
	public void open(String code) throws IncorrectDoorCodeException{
		try {
			super.unlock(code);
		} catch (CannotUnlockDoorException e1) {
			throw new IncorrectDoorCodeException();
		}
		try {
			super.setState(DoorState.OPEN);
		} catch (CannotChangeStateOfLockedDoor e) {}
	}

	@Override
	public void close() {
		try {
			super.setState(DoorState.CLOSED);
		} catch (CannotChangeStateOfLockedDoor e) {
			System.out.println("close fail");
		}
	}

	@Override
	public boolean isOpen() {
		if(super.getState().equals(DoorState.CLOSED)) {
			return false;
		}
		return true;
	}

	@Override
	public void changeCode(String oldCode, String newCode, String newCodeConfirmation)
			throws IncorrectDoorCodeException, CodeMismatchException {
			if(!testCode(oldCode))
				throw new IncorrectDoorCodeException();
			if(!newCode.equals(newCodeConfirmation))
				throw new CodeMismatchException();
			try {
				super.unlock(oldCode);
			}
			catch(CannotUnlockDoorException e){}
			try {
				super.setNewLockCode(newCode);
			} catch (CannotChangeCodeForUnlockedDoor e) {
				System.out.println("code change failed");
			}
	}

	@Override
	public boolean testCode(String code) {
		return code.contentEquals(super.code);
	}

}
