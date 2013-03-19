package common;

import java.beans.PropertyChangeListener;
import java.rmi.Remote;

public interface ListModelI extends Remote {

	public void addPropertyChangeListner(PropertyChangeListener listener);

	public void removePropertyChangeListener(PropertyChangeListener listener);

}