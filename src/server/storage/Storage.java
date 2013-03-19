package server.storage;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.model.Model;

import common.ModelI;

public abstract class Storage extends UnicastRemoteObject {
	private Class<? extends Model> modelClass;

	public Storage(Class<? extends Model> modelClass) throws RemoteException {
		this.modelClass = modelClass;
	}

	public ModelI create() throws RemoteException {
		try {
			return (ModelI) modelClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public ModelI get(int ID) throws RemoteException {
		try {
			return (ModelI) modelClass.getConstructor(Integer.class)
					.newInstance(ID);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public void delete(int ID) throws RemoteException {
		ModelI model = this.get(ID);
		model.delete();
	}

	public void delete(ModelI model) throws RemoteException {
		model.delete();
	}
}
