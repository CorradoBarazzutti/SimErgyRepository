package ResourceHierarchy;
/**
 * 
 * @author Conrad
 * 
 */
public abstract class HumanResource extends Resource {
	
	private String surname;
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public HumanResource(String name, String surname) {
		super(name);
		setSurname(surname);
	}

}
