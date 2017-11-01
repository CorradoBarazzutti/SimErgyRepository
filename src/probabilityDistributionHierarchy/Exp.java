package probabilityDistributionHierarchy;

import java.lang.Math;

/**
 * 
 * @author Conrad
 * <p>
 * The negative exponential distribution with parameter λ ∈ R and λ > 0
 */
public class Exp extends ProbabilityDistribution {
	//attributes
	/**
	 * Name of the probability distribution	
	 */
	private static final String name = "exp";
	/**
	 * Parameter of the distribution
	 */
	private double lambda;
	/**
	 * Returns the name of the distribution
	 */
	@Override
	public String getName() {
		return name;
	}
	/**
	 * Returns a sample from the distribution
	 * @return
	 */
	@Override
	public double getSample() {
		return invertedCDF(rnd.nextDouble());
	}
	/**
	 * This is the inverted cumulative distribution function.
	 * Given a double in the interval [0, 1], interpreted as the integral of the distribution function, returns the associated quantile 
	 *
	 * @param u
	 * @return
	 */
	private double invertedCDF(double u) {
		double x = - (1/this.lambda) * Math.log(1 - u);
		return (x > 0) ? x : 0;
	}
	/**
	 * creates an instance of the distribution with a specified paramenter
	 * @param lambda
	 */
	//creator
	public Exp(double lambda) {
		super();
		this.lambda = lambda;
	}
}
