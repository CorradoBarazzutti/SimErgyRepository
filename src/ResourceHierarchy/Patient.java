package ResourceHierarchy;

//imports
import java.util.ArrayList;
import java.util.Date;
import EventHierarchy.Event;
import java.util.Random;

/**
 * 
 * @author Conrad
 * 
 * <p>
 * 
 * A patient is characterized by a name, surname, a unique ID, an health insurance indicating whether the patient is insured or not, a severity level (i.e. either L1, L2, L3, L4, L5) a state (the event now occuring), the arrival time (the time the patients has been registered to the ED), a location (the physical place where he/she is located within the ED or any other department), the history (showing the history of each state/event. 
 * A patient’s operations include: setting of the arrival time, change of current state, change of location, updating the patient’s history with a new event, computation of a patient’s charges for the services taken “so-far”.
 */
public class Patient extends HumanResource {
	
	//nested-classes definition
	/**
	 * 
	 * @author Conrad
	 * 
	 * <p>
	 * Patient are equipped with an insurance.
	 * <p>
	 * There are there different types of insurance:
	 * 	- no insurance: the patient is charged with full cost of each service he/she underwent
	 * 	- silver insurance: a 50% discount is applied to each service he/she underwent
	 * 	- gold insurance: a 80% discount is applied to each service he/she underwent 
	 * <p>
	 * Patients are charged with respect to the services they get throughout their staying at the ED. The total charges of a patient are computing with respect to the patient’s insurance state. 
	 */
	private class Insurance {	
		/**
		 * 
		 * @author Conrad
		 * 
		 * <p>
		 * The insurance constructor may rise this exeptions if the insurance name passed is invalid. 
		 * The only valids names are: no (for no insurance), siver or gold
		 */
				
		//attributes 
		/**
		 * Name of the insurance: either no (for no insurance), siver or gold.
		 */
		private String name;
		/**
		 * Indicats the discount rate associated to the insurance, between 0 and 1.
		 */
		private double discount;
		
		//getters and setters
		public String getName() {
			return name;
		}
		public void setName(String name) throws InvalidParameterException {
			if (name == "no" || name == "silver" || name == "gold") {
				this.name = name;
				this.setDiscount();
			}
			else {
				throw new InvalidParameterException();
			}
		}
		public double getDiscount() {
			return discount;
		}
		private void setDiscount()  {
			switch (this.name) {
			case "no":
				this.discount = 0;
				break;
			case "silver":
				this.discount = 0.5;
				break;
			case "gold":
				this.discount = 0.8;
			default:
				break;
			}
		}
		
		//creators
		
		/**
		 * Default constructor
		 */
		public Insurance() {
			this.name = "no";
			this.setDiscount();
		}
		
		/**
		 * Creates the insurance specified by the parameter passed.
		 * <p>
		 * May throw inexistentInsuranceExeption if the passed parameter is invalid.
		 * @param name
		 * @throws inexistentInsuranceExeption
		 */
		public Insurance(String name) throws InvalidParameterException {
			this.setName(name);
			this.setDiscount();
		}
	}
	
	/**
	 * Creates a random insurance.
	 */
	public Insurance RandomInsurance() {
		
		Random rnd = new Random();
		
		String type = null;
		switch (rnd.nextInt(2)) {
		case 0:
			type = "no";
			break;
		case 1:
			type = "silver";
			break;
		case 2:
			type = "gold";
			break;
		default:
			break;
		}
		
		Insurance rndInsurance = new Insurance();
		try {
			rndInsurance =  new Insurance(type);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rndInsurance;
	}
	
	//attributes
	
	/**
	 * Insurance level owned by the patient
	 */
	private Insurance insurance;
	
	/**
	 * Indicates the severity level of the patient at the moment   
	 */
	private SeverityLevel severityLevel;
	
	/**
	 * indicates the present state of the patient wich is to say the event that is occurring 
	 */
	private Event state;
	
	/**
	 * Saves the history of all the occurred events
	 */
	private ArrayList<Event> history;
	 
	//creators
	
	/**
	 * Default constructor 
	 */
	public Patient() {
		super();
		this.insurance = new Insurance();
		this.severityLevel = new SeverityLevel();
		
		this.state = null;
		this.history = new ArrayList<Event>();
	}

	/**
	 * Constructor: instance a new patient with given characteristics 
	 * @param name
	 * @param surname
	 * @param insurance
	 * @param severityLevel
	 * @throws ResourceHierarchy.Patient.Insurance.inexistentInsuranceExeption 
	 */
	public Patient(String name, String surname, String insurance, SeverityLevel severityLevel) throws ResourceHierarchy.InvalidParameterException {
		super(name, surname);
		this.insurance = new Insurance(insurance);
		this.severityLevel = severityLevel;
		new ArrayList<Event>();
	}
	
	/**
	 * returns a new patient with random caracteristics 
	 */
	public Patient RandomPatient() {
		//invocates the HumanResource constructor with random name and surnames 
		try {
			return new Patient(
					generateString(new Random(), "qwertyuiopasdfghjklzxcvbnm", new Random().nextInt(10) + 4), 
					generateString(new Random(), "qwertyuiopasdfghjklzxcvbnm", new Random().nextInt(10) + 4),
					"no",
					new SeverityLevel()	
			);
		} catch (Exception e) {
			return null;
		}
	}
	
	//getters and setters
	public String getInsuranceType() {
		return insurance.getName();
	}
	public double getInsuranceDiscount() {
		return insurance.getDiscount();
	}
	
	public void setInsurance(String insuranceName) throws InvalidParameterException {
		this.insurance = new Insurance(insuranceName);
	}

	public SeverityLevel getSeverityLevel() {
		return severityLevel;
	}

	public void setSeverityLevel(SeverityLevel severityLevel) {
		this.severityLevel = severityLevel;
	}

	public Event getState() {
		return state;
	}

	/**
	 * Update the current patient state and the history. 
	 * The new state value is saved as ne current state while the old state is saved the old state in history
	 * @param newState
	 */
	public void updateState(Event newState) {
		if (this.state != null) {
			this.history.add(this.state);
		}
		this.state = newState;
	}

	public ArrayList<Event> getHistory() {
		return history;
	}
	
	//methods
	/**
	 * Generating a random string of characters
	 * @param rng is the random generator
	 * @param characters are the characters to use in the string
	 * @param length is the lenght of the random string
	 * @return
	 */
	private static String generateString(Random rng, String characters, int length) {
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++) {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	

	/**
	 * Returns the time the patients has been registered to the ED 
	 * @return
	 */
	public Date getArrivalTime() {
		for (Event event : history) {
			if (event.getType() == "registration") {
				return event.getTimeStamp();
			}
		}
		return null;
	}
	/**
	 * Returns the current patient location in the ED
	 * @return
	 */
	public Location getLocation() {
		return state.getPlace();
	}
	/*
	public calculateCharges() {
		for (Event event : history) {
			if (event istanceof service) {
				
			}
		}
	}
	*/
}
