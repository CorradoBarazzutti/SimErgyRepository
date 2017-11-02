package ResourceHierarchy;

/**
 * 
 * @author Conrad
 *
 * on arrival to the ED each patient is assigned a severity level. 
 * There are five possible severity levels: L1 (resuscitation), L2 (Emergency), L3 (Urgent), L4 (Less urgent), L5 (non-urgent). 
 * [TODO] Each severity level is characterised by a (continuous) distribution of probability which is used to determine the arrival time of the next patient with a given level of severity. 
 */
public class SeverityLevel {
	
	//attribute
	/**
	 * Indicates the level of severity with a number between 1 and 5
	 */
	private int level;
	
	//getters and setters
	
	public int getLevel() {
		return level;
	}
	/**
	 * Set the severity to the specified level
	 * <p>
	 * Grants the level to be in the interval [1, 5] and throws an exeption if the client tries to set it to invalid values
	 * @param level
	 * @throws InvalidParameterException
	 */
	public void setLevel(int level) throws InvalidParameterException {
		if (level >= 1 && level <= 5) {
			this.level = level;
		}
		else {
			throw new InvalidParameterException();
		}
	}
	//creators
	/**
	 * Default constructor, set the severity level to 5
	 */
	public SeverityLevel() {
		this.level = 5;
	}
	/**
	 * Creates a SeverityLevel instance with the specified level
	 * @throws InvalidParameterException 
	 */
	public SeverityLevel(int level) throws InvalidParameterException {
		this.setLevel(level);
	}
	
	//object overrides
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SeverityLevel) {
			if ( ((SeverityLevel)obj).getLevel() == this.getLevel() ) {
				return true;
			}
		}
		return false;
	}
}
