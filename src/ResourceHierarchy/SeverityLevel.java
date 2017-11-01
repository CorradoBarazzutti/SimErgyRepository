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
	/**
	 * Indicates the level of severity with a number between 1 and 5
	 */
	private int level;
	//getters and setters
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
