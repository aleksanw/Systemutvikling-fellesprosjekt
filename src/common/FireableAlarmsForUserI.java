package common;

import java.rmi.RemoteException;
import java.util.ArrayList;

import server.model.Alarm;

public interface FireableAlarmsForUserI {

	public ArrayList<Alarm> getList() throws RemoteException;

}