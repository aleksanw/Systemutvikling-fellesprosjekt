package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public abstract class Model {

	private Database db;
	private String tableName;
	private String primaryKeyField1, primaryKeyField2;
	private ArrayList<String> tableFields;
	private boolean isSavedInDB;
	private PropertyChangeSupport pcs;
	
	public Model(){
		db = new Database();
	}
	
	protected void addTableField(String field){
		
	}
	
	protected void updateField(String field, Object value){
		
	}
	
	public void addPropartyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropartyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	
	
}
