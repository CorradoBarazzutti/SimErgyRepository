package probabilityDistributionHierarchy;

import java.util.Random;

/**
 * 
 * @author Conrad
 * 
 * This is the superclass of the probability distribution hierarchy.
 * <p>
 * Is characterised by a name (e.g. Exp, LogNorm, Gamma) and a random number generator rnd. 
 * A probability distribution provides the getSample() method that generate a sample from the distribution.
 */
public abstract class ProbabilityDistribution {
	/**
	 * Random number generator
	 */
	protected Random rnd;
	
	//getters and setters
	public abstract String getName();
	public abstract double getSample();
	
	//creator
	public ProbabilityDistribution() {
		this.rnd = new Random();
	}

}
