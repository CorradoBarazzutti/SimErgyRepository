package ResourceHierarchy;

/**
 * 
 * @author Conrad
 *
 */
public class Patient extends HumanResource {

	private class Insurance {	
		/**
		 * 
		 * @author Conrad
		 * 
		 * 	ED patients are charged with respect to the services they get throughout their staying at the ED. 
		 * The total charges of a patient are computing with respect to the patient’s insurance state. 
		 * SimErgy support the following pricing policies:
		 * 	- no insurance: the patient is charged with full cost of each service he/she underwent
		 * 	- silver insurance: a 50% discount is applied to each service he/she underwent
		 * 	- gold insurance: a 80% discount is applied to each service he/she underwent
		 */
		private class inexistentInsuranceExeption extends Exception {
			/**
			 * The insurance constructor may rise this exeptions if the insurance name passed is invalid. 
			 * The only valids names are: no (for no insurance), siver or gold
			 */
			private static final long serialVersionUID = 1L;
		}
		/**
		 * Name of the insurance: either no (for no insurance), siver or gold
		 */
		private String name;
		/**
		 * discount rate associated to the insurance, between 0 and 1
		 */
		private double discount;
		public Insurance(String name) throws inexistentInsuranceExeption {
			this.name = name;
			try {
				switch (name) {
					case "no":
						discount = 0;
						break;
					case "silver":
						discount = 0.5;
						break;
					case "gold":
						discount = 0.8;
						break;
					}
				}
			finally {
				Exception inexistentInsuranceExeption;
				throw (inexistentInsuranceExeption);
			}
		}
	}
	private Insurance insurance;
	/**
	 * on arrival to the ED each patient is assigned a severity level. 
	 * There are five possible severity levels: L1 (resuscitation), L2 (Emergency), L3 (Urgent), L4 (Less urgent), L5 (non-urgent). 
	 * [TODO] Each severity level is characterised by a (continuous) distribution of probability which is used to determine the arrival time of the next patient with a given level of severity.
	 */
	private int severityLevel;
	private Event State;
	private Time arrivalTime;
	private Location location;
	private ArrayList<Event> History;
	
	
	public Patient(String name, String surname) {
		super(name, surname);
		// TODO Auto-generated constructor stub
	}
	
	setting of the arrival time, 
	change of current state, 
	change of location, 
	updating the patient’s history with a new event, 
	computation of a patient’s charges 
	
}
