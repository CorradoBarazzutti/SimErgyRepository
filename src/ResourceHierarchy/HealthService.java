package ResourceHierarchy;

import java.util.HashMap;

import probabilityDistributionHierarchy.ProbabilityDistribution;

/**
 * 
 * @author Conrad
 * <p>
 * <p>
 * An health service is characterised by a name (e.g. X-ray, MRI, scan, blood-test, consultation), a waiting-queue (representing the queue of patients waiting to take the service), a distribution of probability (representing the duration of the service) and a cost (representing how much a patient would be charged for taking the service). 
 * An health-service allows for:
 * 	– arrival of a new patient in the waiting-queue
 * 	– execution of the service on a patient (the first in the queue) and issue of an outcome for the patient who took the service
 * <p>
 * Remark: the SimErgy system guarantee that when a service is terminated on a given patient the physician overseeing the patient get automatically notified, thanks to a observer pattern implemented in the messageSystem package.
 */
public abstract class HealthService extends Resource {
	
	//attributes
	
	/**
	 * TODO waiting queue, think about using an object of class WaitingRoom as queue and the interface ResourceManager
	 */
	
	/**
	 * Represent the duration of the service
	 */
	private ProbabilityDistribution durationDistribution; 
	
	/**
	 * Maps the names of the services to the cost charged.
	 */
	private static HashMap<String, Integer> pricingTable;
	/**
	 * Represents how much a patient would be charged for taking the service
	 */
	private int cost;
	
	/**
	 * 
	 * @param Name
	 */
	public HealthService(String Name, ProbabilityDistribution durationDistribution) {
		super(Name);
		this.durationDistribution = durationDistribution;
	}

}
