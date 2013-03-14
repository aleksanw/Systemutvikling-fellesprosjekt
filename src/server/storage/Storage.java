package server.storage;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import common.StorageI;

import server.model.*;

public class Storage extends UnicastRemoteObject implements StorageI {
	private Class modelClass;
	
	public Storage(Class modelClass) throws RemoteException {
		this.modelClass = modelClass;
	}

	public Model create() throws RemoteException {
		try {
			return (Model)modelClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Model get(int ID) throws RemoteException {
		try {
			return (Model)modelClass.getConstructor(Integer.class).newInstance(ID);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(int ID) throws RemoteException {
		Model model = this.get(ID);
		model.delete();
		
		// Delete from memory
		model = null;
	}

	@Override
	public void delete(Model model) throws RemoteException {
		model.delete();
		
		// Delete from memory
		model = null;
	}
}
