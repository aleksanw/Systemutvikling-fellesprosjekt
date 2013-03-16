package common;

import java.rmi.Remote;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import server.model.Alarm;
import server.model.Event;
import server.model.Invitation;


public interface UserI extends Remote {

	public abstract String getEmail();

	public abstract void setEmail(String email) throws SQLException;

	public abstract Date getDateOfBirth();

	public abstract boolean isCreatorOfEvent(EventI event);

	public abstract ArrayList<Alarm> getAlarms();

	public abstract ArrayList<Alarm> getAlarmsBeforeNow();

	public abstract void addToGroup(GroupI group);

	public abstract ArrayList<Event> getCreatedEvents();

	public abstract ArrayList<Invitation> getInvitations();

	public abstract int getUserID();

	public abstract String getName();

	public abstract void setName(String name) throws SQLException;

	public abstract void setDateOfBirth(Date dateOfBirth) throws SQLException;

	public abstract void delete();

}