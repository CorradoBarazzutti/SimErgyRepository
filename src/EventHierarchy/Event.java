package EventHierarchy;

import ResourceHierarchy.Patient;

/**
 * 
 * @author Conrad
 *
 * Superclass of the event Hierarchy
 */
public abstract class Event {
	/**
	 * 
	 */
	private Time timeStamp;
	private Location place;
	private String name;
	private Patient patient;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}
}
