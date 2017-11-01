package probabilityDistributionHierarchy;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Conrad
 * <p>
 * This is the superclass of the probability distribution hierarchy.
 * <p>
 * This class characterized by a name (e.g. Exp, LogNorm, Gamma) and has random number generator called rnd. 
 * A probability distribution must provide the implementation of both the getName() and getSample() method.
 */
public abstract class ProbabilityDistribution {
	/**
	 * Random number generator
	 */
	protected Random rnd;
	
	//getters and setters
	/**
	 * Returns the name of the distribution (e.g. Exp, LogNorm, Gamma)
	 * @return
	 */
	public abstract String getName();
	/**
	 * Returns a sample from the distribution
	 * @return
	 */
	public abstract double getSample();
	
	//creator
	public ProbabilityDistribution() {
		this.rnd = new Random();
	}

}
