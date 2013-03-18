package server.model;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.GroupI;

public class Group extends Model implements GroupI {

	private int groupID, parentGroupID;
	private String groupName;
	
	public Group(Integer groupID) throws RemoteException, SQLException {
		super("Groups", createTableFields(), "groupID");
		ResultSet result = super.getFromDB(groupID);
		if(result.next()) {
			this.groupID = result.getInt("groupID");
			this.parentGroupID = result.getInt("parentGroupID");
			this.groupName = result.getString("groupName");
		}
	}
	
	public Group(String groupName) throws RemoteException, SQLException {
		super("Groups", createTableFields(), "groupID");
		ArrayList<Integer> keyList = super.addToDB();
		this.groupID = keyList.get(0);
	}
	
	private static ArrayList<String> createTableFields() {
		ArrayList<String> tableFields = new ArrayList<String>();
		tableFields.add("GroupID");
		tableFields.add("parentGroupID");
		tableFields.add("groupName");
		return tableFields;
	}
	
	/* (non-Javadoc)
	 * @see server.model.GroupI#getGroupID()
	 */
	@Override
	public int getGroupID() {
		return groupID;
	}
	
	/* (non-Javadoc)
	 * @see server.model.GroupI#getGroupName()
	 */
	@Override
	public String getGroupName() {
		return this.groupName;
	}

	/* (non-Javadoc)
	 * @see server.model.GroupI#getParentGroupID()
	 */
	@Override
	public int getParentGroupID() {
		return parentGroupID;
	}

	/* (non-Javadoc)
	 * @see server.model.GroupI#setParentGroupID(int)
	 */
	@Override
	public void setParentGroupID(int parentGroupID) {
		this.parentGroupID = parentGroupID;
	}

	/* (non-Javadoc)
	 * @see server.model.GroupI#setGroupName(java.lang.String)
	 */
	@Override
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	/* (non-Javadoc)
	 * @see server.model.GroupI#delete()
	 */
	@Override
	public void delete() {
		super.delete(groupID);		
	}
}
