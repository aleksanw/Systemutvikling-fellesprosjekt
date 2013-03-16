package common;

import java.rmi.Remote;

public interface GroupI extends Remote {

	public abstract int getGroupID();

	public abstract String getGroupName();

	public abstract int getParentGroupID();

	public abstract void setParentGroupID(int parentGroupID);

	public abstract void setGroupName(String groupName);

	public abstract void delete();

}