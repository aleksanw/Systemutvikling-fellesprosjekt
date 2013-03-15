package server.storage;

import java.rmi.RemoteException;
import server.model.Alarm;
import common.AlarmStorageI;

public class AlarmStorage extends Storage implements AlarmStorageI {
	
	public AlarmStorage() throws RemoteException {
		super(Alarm.class);
	}
	
	public Alarm create() throws RemoteException {
		return (Alarm) super.create();
	}
	
	public Alarm get(int ID) throws RemoteException {
		return (Alarm) super.get(ID);
	}
	
	public void delete(int ID) throws RemoteException {
		super.delete(ID);
	}
	
	public void delete(Alarm model) throws RemoteException {
		super.delete(model);
	}
}