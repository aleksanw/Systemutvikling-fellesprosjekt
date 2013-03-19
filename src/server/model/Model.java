package server.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import server.system.Database;
import exceptions.ObjectNotFoundException;

public abstract class Model extends UnicastRemoteObject {

	private static Database DB = new Database();
	private String tableName;
	private String primaryKeyField1;
	private ArrayList<String> tableFields;
	private PropertyChangeSupport pcs;

	public Model(String tableName, ArrayList<String> tableFields,
			String primaryKeyField1) throws RemoteException {
		this.tableName = tableName;
		this.tableFields = tableFields;
		this.primaryKeyField1 = primaryKeyField1;
	}

	public static Database getDB() throws RemoteException {
		return DB;
	}

	public abstract void delete() throws RemoteException;

	protected void delete(Integer ID) throws ObjectNotFoundException {
		try {
			ResultSet rs = DB.readQuery("SELECT FROM " + tableName
					+ " WHERE userID=" + ID);
			if (rs.getBoolean(0)) { // rs er enten tom eller har et element
				DB.updateQuery("DELETE FROM " + tableName + " WHERE userID="
						+ ID);
			} else {
				throw new ObjectNotFoundException();
			}
		} catch (SQLException e) {
			System.out.println("Could not delete " + tableName
					+ " where userID is " + ID);
		}
	}

	protected void updateField(String field, Object value, int primaryKey1) {
		String c = ((value instanceof String) ? ("'" + value + "'") : value
				.toString());
		String query = "UPDATE " + tableName + " SET " + field + "=" + c
				+ " WHERE " + primaryKeyField1 + "=" + primaryKey1 + ";";
		DB.updateQuery(query);
	}

	public void addPropartyChangeListener(PropertyChangeListener listener)
			throws RemoteException {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropartyChangeListener(PropertyChangeListener listener)
			throws RemoteException {
		pcs.removePropertyChangeListener(listener);
	}

	protected ArrayList<String> getTableFields() {
		return tableFields;
	}

	protected ArrayList<Integer> addToDB() {
		String query = "INSERT INTO " + tableName + " () VALUES ();";
		ArrayList<Integer> keyList;
		try {
			keyList = DB.insertAndGetKeysQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return keyList;
	}

	protected ResultSet getFromDB(int primaryKey1) {
		String query = "Select * FROM " + tableName + " WHERE "
				+ primaryKeyField1 + "='" + primaryKey1 + "';";
		ResultSet result;
		result = DB.readQuery(query);
		return result;
	}
}
