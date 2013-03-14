package server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Group extends Model {

	private int groupID, parentGroupID;
	private String groupName;
	
	public Group(int groupID) throws SQLException {
		super("Groups", createTableFields(), "groupID");
		ResultSet result = super.getFromDB(groupID);
		if(result.next()) {
			this.groupID = result.getInt("groupID");
			this.parentGroupID = result.getInt("parentGroupID");
			this.groupName = result.getString("groupName");
		}
	}
	
	public Group(String groupName) throws SQLException {
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
	
	public int getGroupID() {
		return groupID;
	}
	
	public String getGroupName() {
		return this.groupName;
	}

	public int getParentGroupID() {
		return parentGroupID;
	}

	public void setParentGroupID(int parentGroupID) {
		this.parentGroupID = parentGroupID;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	@Override
	public void delete() throws SQLException {
		super.delete(groupID);		
	}
}
