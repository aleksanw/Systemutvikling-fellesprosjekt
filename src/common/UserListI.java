package common;

import java.util.ArrayList;

import server.model.User;

public interface UserListI extends ListModelI {
	public ArrayList<User> getList();

}