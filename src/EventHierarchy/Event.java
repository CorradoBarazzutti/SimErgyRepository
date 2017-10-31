package EventHierarchy;

import ResourceHierarchy.Location;
import ResourceHierarchy.Resource;
import ResourceHierarchy.Patient;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;

/**
 * 
 * @author Conrad
 *
 * Superclass of the event Hierarchy.
 * 
 * <p>
 * 
 * An event is characterised by a timestamp (other than by its nature) representing the instant of time (or delay) of its occurrence. An event may use resources which are (instantly) released when the event occurs.
 */
public abstract class Event {
	/**
	 * Indicates the type of the event, eg: arrival, trasportation, being-visited, taking-exam, waiting, released
	 */
	private String type;
	/**
	 * Represents the instant of time (or delay) of its occurrence
	 */
	private Date timeStamp;
	/**
	 * Indicates the duration of the event, eventually zero
	 */
	private Duration duration;
	/**
	 * Represent the location in wich the event take place
	 */
	private Location place;
	/**
	 * the iD of the patient to whome the event occurs
	 */
	private int patientId;
	/**
	 * Maps the resources needed in the creation of the event to the quantity needed.
	 */
	private HashMap<Resource,Integer> nededResouces;
	
	/**
	 * Creates an event with the desired paramenters
	 * @param type
	 * @param timeStamp
	 * @param place
	 * @param patient
	 * @param nededResources
	 */
	public Event(String type, Date timeStamp, Location place, Patient patient, HashMap<Resource,Integer> nededResources) {
		this.type = type;
		this.timeStamp = timeStamp;
		this.place = place;
		this.patientId = patient.getiD();
		this.nededResouces = nededResources;
	}
	
	@Override
	public int hashCode() {
		return this.type.hashCode() + ((this.timeStamp.hashCode() * 41) + this.patientId) * 41;
	}
}
