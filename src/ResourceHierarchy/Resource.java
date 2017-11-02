package ResourceHierarchy;

/**
 * 
 * @author Conrad
 * Super class of the whole resources hierarchy
 * An ED is characterised by two kinds of resources: human-resources (HR), which include Physicians, Nurses and Transporters (the latter to transport patients from one service to another), as opposed to non-human-resources (NHR), which include Rooms, Stretchers and HealthServices (e.g. X-ray, MRI, blood testing, consultation). Furthermore the following kind of Rooms shall be considered: BoxRooms (where patients are first visited by a physician), ShockRooms for immediate treatment of most severe patients, WaitingRooms where patients are temporarily placed while waiting for a service (e.g. waiting for being visited by a physician, waiting to be transported to another department). Every resource is characterised by a name (and a surname too in case of an HR) as well as a unique numeric ID.
 * 
 */
public abstract class Resource {
	//attributes
	/**
	 * Name of the resource
	 */
	private String name;
	/**
	 * Unique numeric identifier of the resource
	 */
	private int iD;
	/**
	 * Class variable that keeps track of the assigned iD
	 */
	private static int iDcounter = 1;
	
	
	//getters and setters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	
	//creators
	
	/**
	 * Default creator: creates a resource and grants the iD to be unique 
	 */
	public Resource() {
		setName(null);
		setiD(iDcounter);
		iDcounter+=1;
	}
	
	/**
	 * Creates a resource with the given name and grants the iD to be unique
	 * @param Name
	 */
	public Resource(String Name) {
		setName(Name);
		setiD(iDcounter);
		iDcounter+=1;
		}
	
	//object overrides
	
	/**
	 * Resources are regarded as equal if they have the same iD
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Resource) {
			if (this.iD == ((Resource) obj).getiD()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * The hash code is the iD
	 */
	@Override
	public int hashCode() {
		return this.iD;
	}

}
