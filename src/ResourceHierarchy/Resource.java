package ResourceHierarchy;

/**
 * 
 * @author Conrad
 * Super class of the whole resources hierarchy
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
	
	/**
	 * Creates a resource with the given name and grants the iD to be unique 
	 */
	public Resource(String Name) {
		setName(Name);
		setiD(iDcounter);
		iDcounter+=1;
		}

}
