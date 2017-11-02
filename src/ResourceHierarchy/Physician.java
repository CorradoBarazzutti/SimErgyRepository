package ResourceHierarchy;

import java.util.ArrayList;
import java.util.HashSet;

import messageSystem.Message;
/**
 * 
 * @author Conrad
 * <p>
 * This class represent a physician 
 * <p>
 * A physician is characterised by a name, surname, a unique ID and username, a state (i.e. either idle, visiting, offduty), a list of patients being overseen, a list of patients already treated (repre- senting the history of activity of the physician) and a message-box to store relevant messages related to patients’ overseeing.
 * <p>
 * A physician is in charge of overseeing patients throughout their staying at the ED.  This includes visiting a patient, taking decisions (e.g. requiring exams to be taken) and finally emitting a result for a treated patient. A physicians can:
 * 	– start handling of a (newly arrived) patient
 * 	– emit a verdict for a treated patient
 * 	– prescribe a given exam (e.g. x-ray, RMI, etc) to a treated patient
 * 	– receive a new message in the message-box	
 * 	– isplay the content of the message-box
 * 	– handle a newly received message by either removing it, storing it, or marking it as unread.
 */
public class Physician extends HumanResource {
	
	//attributes
	
	/**
	 * Username of the pysician
	 */
	private String username;
	
	/**
	 * A physician is characterised by a state (i.e. either idle, visiting, offduty)
	 */
	private String state;
	
	/**
	 * a list of patients being overseen
	 */
	HashSet<Patient> patientsOverseen;
	
	/**
	 * list of patients already treated (representing the history of activity of the physician
	 */
	ArrayList<Patient> patientsTreated;
	
	/**
	 * Store relevant messages related to patients’ overseeing
	 * <p>
	 * When an service is terminated on a given patient the physicien overseeing the patient should get automatically notified
	 */
	ArrayList<Message> MessageBox;
	
	//getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) throws InvalidParameterException {
		if (state == "idle" || state == "visiting" || state == "offduty") {
			this.state = state;
		}
		else throw new InvalidParameterException();
	}
	
	//creators
	/**
	 * Default constructor
	 */
	public Physician() {
		super();
		this.username = null;
		this.state = null; 
		patientsOverseen = new HashSet<Patient>();
		patientsTreated = new ArrayList<Patient>();
		
	}
	/**
	 * Constructor: creates an instance of the class with the specified parameter, state = idle and empty patientsOverseen and patientsTreated lists
	 * @param name
	 * @param surname
	 * @param username
	 */
	public Physician(String name, String surname, String username) {
		super(name, surname);
		this.username = username;
		this.state = "idle"; 
		patientsOverseen = new HashSet<Patient>();
		patientsTreated = new ArrayList<Patient>();
	}
	
	//methods
	/* TODO
– start handling of a (newly arrived) patient
– emit a verdict for a treated patient
– prescribe a given exam (e.g. x-ray, RMI, etc) to a treated patient
– receive a new message in the message-box
– display the content of the message-box
– handle a newly received message by either removing it, storing it, or marking it as unread.
	 */
	
	/**
	 * 
	 */
	private void welcomePatient(Patient patient) {
		patientsOverseen.add(patient);
		//TODO start patienthandler thread
	};
	
	private boolean leavePatient(Patient patient) {
		if (patientsOverseen.remove(patient)) {
			patientsTreated.add(patient);
			return true;
		}
		else {
			return false;
		}
		//TODO kill handler tread
	}


}
