package EventHierarchy;

import ResourceHierarchy.Location;
import ResourceHierarchy.Resource;
import ResourceHierarchy.Patient;

import java.time.Duration;
import java.util.ArrayList;
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
	//attributes
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
	 * Maps the types of resource needed in the creation of the event with the quantity needed.
	 */
	private  HashMap<String,Integer> nededResouces;
	/**
	 * List the iDs of the resources allocated for the creation of this event
	 */
	private ArrayList<Integer> usedResources;
	
	//getters and setters
	public String getType() {
		return type;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public Duration getDuration() {
		return duration;
	}
	public Location getPlace() {
		return place;
	}
	public int getPatientId() {
		return patientId;
	}
	public void cancelUsedResources() {
		this.usedResources = null;
	}
	


	public Event(String type, Date timeStamp, Duration duration, Location place, int patientId, HashMap<String,Integer> nededResources, ArrayList<Integer> usedResources) {
		this.type = type;
		this.timeStamp = timeStamp;
		this.place = place;
		this.patientId = patientId;
		this.nededResouces = nededResources;
		//TODO used resources
	}
	
	
	@Override
	public int hashCode() {
		return this.type.hashCode() + ((this.timeStamp.hashCode() * 41) + this.patientId) * 41;
	}
}
