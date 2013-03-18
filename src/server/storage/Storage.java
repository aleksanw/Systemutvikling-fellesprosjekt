package server.storage;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.ModelI;


public abstract class Storage extends UnicastRemoteObject {
	private Class modelClass;
	
	public Storage(Class modelClass) throws RemoteException {
		this.modelClass = modelClass;
	}

	public ModelI create() throws RemoteException {
		try {
			return (ModelI)modelClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ModelI get(int ID) throws RemoteException {
		try {
			return (ModelI)modelClass.getConstructor(Integer.class).newInstance(ID);
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

	public void delete(int ID) throws RemoteException {
		ModelI model = this.get(ID);
		model.delete();
		
		// Delete from memory
		model = null;
	}
	
	public void delete(ModelI model) throws RemoteException {
		model.delete();
		
		// Delete from memory
		model = null;
	}
}
