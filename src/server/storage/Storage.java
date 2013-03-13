package storage;

import java.util.Hashtable;
import model.Model;

public class Storage {
	private Hashtable objectList;
	private String modelType;
	
	public Model create() {
		return Class.forName(modelType).newInstance();
	}
	
	public Model get(int id) {
		
	}
}
