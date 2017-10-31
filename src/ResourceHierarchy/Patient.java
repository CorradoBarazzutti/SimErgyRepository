package ResourceHierarchy;

import static org.junit.Assert.fail;

//imports
import java.util.ArrayList;
import java.util.Date;
import EventHierarchy.Event;
import java.util.Random;

/**
 * a patient is characterized by a name, surname, a unique ID, an health insurance (mutuelle) indicating whether the patient is insured or not, a severity level (i.e. either L1, L2, L3, L4, L5) a state (i.e. either waiting, being-visited, taking-exam, released, etc.), the arrival time (the time the patients has been reg- istered to the ED), a location (the physical place where he/she is located within the ED or any other department), the history (showing the history of each state/event together with the corresponding timestamp for the patient, e.g. (arrived, 19h10), (visited, 19h45), (x-ray, 20h05), (visited,20h30), etc). A patient’s operations include: setting of the arrival time, change of current state, change of location, updating the patient’s history with a new event, computation of a patient’s charges for the services taken “so-far”.
 */

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
	 * There are there defferent types of insurance:
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
		
		//subclass declaration
		private class inexistentInsuranceExeption extends Exception {
			private static final long serialVersionUID = 1L;
		}
		
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
		public void setName(String name) throws inexistentInsuranceExeption {
			if (name == "no" || name == "silver" || name == "gold") {
				this.name = name;
				this.setDiscount();
			}
			else {
				throw new inexistentInsuranceExeption();
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
				break;
			}
		}
		/**
		 * Creates a random insurance.
		 */
		public Insurance() {
			String type = null;
			Random rnd = new Random();
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
			this.name = type;
			this.setDiscount();
		}
		/**
		 * Creates the insurance specified by the parameter passed.
		 * <p>
		 * May throw inexistentInsuranceExeption if the passed parameter is invalid.
		 * @param name
		 * @throws inexistentInsuranceExeption
		 */
		public Insurance(String name) throws inexistentInsuranceExeption {
			this.setName(name);
			this.setDiscount();
		}
	}
	/**
	 * 
	 * @author Conrad
	 *
	 * on arrival to the ED each patient is assigned a severity level. 
	 * There are five possible severity levels: L1 (resuscitation), L2 (Emergency), L3 (Urgent), L4 (Less urgent), L5 (non-urgent). 
	 * [TODO] Each severity level is characterised by a (continuous) distribution of probability which is used to determine the arrival time of the next patient with a given level of severity. 
	 */
	private class SeverityLevel {
		/**
		 * Indicates the level of severity with a number between 1 and 5
		 */
		private int level;

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}
		//creators
		/**
		 * Creates a severity level with random level
		 */
		public SeverityLevel() {
			this.level = 5;
			//[TODO]
		}
		/**
		 * Creates a severity level with the specified level level
		 */
		public SeverityLevel(int level) {
			this.level = level;
		}
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
	 * returns a new patient with random caracteristics 
	 */
	
	public Patient() {
		//invocates the HumanResource constructor with random name and surnames 
		super(
			generateString(new Random(), "qwertyuiopasdfghjklzxcvbnm", new Random().nextInt(10) + 4), 
			generateString(new Random(), "qwertyuiopasdfghjklzxcvbnm", new Random().nextInt(10) + 4)
		);
		try {	
			this.insurance = new Insurance();
		} catch (Exception e) {
			System.out.println("inexistent insurance name");
		}
		this.severityLevel = new SeverityLevel();
		this.state = null;
		this.history = new ArrayList<Event>();
	}
	/**
	 * returns a new patient with given caracteristics 
	 * @param name
	 * @param surname
	 * @param insurance
	 * @param severityLevel
	 * @throws ResourceHierarchy.Patient.Insurance.inexistentInsuranceExeption 
	 */
	public Patient(String name, String surname, String insurance, int severityLevel) throws ResourceHierarchy.Patient.Insurance.inexistentInsuranceExeption {
		super(name, surname);
		this.insurance = new Insurance(insurance);
		this.severityLevel = new SeverityLevel(severityLevel);
	}
	//getters and setters
	public String getInsuranceType() {
		return insurance.getName();
	}
	public double getInsuranceDiscount() {
		return insurance.getDiscount();
	}
	
	public void setInsurance(String insuranceName) throws ResourceHierarchy.Patient.Insurance.inexistentInsuranceExeption {
		this.insurance = new Insurance(insuranceName);
	}

	public int getSeverityLevel() {
		return severityLevel.getLevel();
	}

	public void setSeverityLevel(int severityLevel) {
		this.severityLevel.setLevel(severityLevel);
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
	 * get arrival time
	 * setting of the arrival time, 
	 * get location
	 * change of current state, 
	 * change of location, 
	 * updating the patient’s history with a new event, 
	 * computation of a patient’s charges 
	 */
	/**
	 * Returns the time the patients has been registered to the ED 
	 * @return
	 */
	private Date getArrivalTime() {
		for (Event event : history) {
			if (event.getType() == "registration") {
				return event.getTimeStamp();
			}
		}
		return null;
	}
	
}
