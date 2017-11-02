package ResourceHierarchy;
/**
 * 
 * @author Conrad
 * <p>
 * Superclass of the classes representing people in the ED
 * <p>
 * Human-resources (HR) includes Physicians, Nurses and Transporters (the latter to transport patients from one service to another)
 */
public abstract class HumanResource extends Resource {
	/**
	 * Is characterized by a surname 
	 */
	private String surname;
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * Default creator: initializes the fields with the default value
	 */
	public HumanResource() {
		super(null);
		setSurname(null);
	}
	/**
	 * Creator: initializes the fields with the desired values
	 */
	public HumanResource(String name, String surname) {
		super(name);
		setSurname(surname);
	}

}
