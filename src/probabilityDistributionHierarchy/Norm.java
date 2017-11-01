package probabilityDistributionHierarchy;

/**
 * 
 * @author Conrad
 * <p>
 * The uniform distribution with parameter lowerbound, upperbound ∈ R, lowerbound < upperbound
 */
public class Norm extends ProbabilityDistribution {
	//attributes
	/**
	 * Name of the probability distribution
	 */
	private static final String name = "uniform";
	/**
	 * Parameter of the distribution: mean
	 */
	private double mean;
	/**
	 * Parameter of the distribution: variance
	 */
	private double variance;
	
	//getters and setters
	@Override
	public String getName() {
		return name;
	}
	public double getMean() {
		return mean;
	}
	public double getVariance() {
		return variance;
	}
	/**
	 * Returns a sample from the distribution
	 * @return
	 */
	@Override
	public double getSample() {
		return (rnd.nextGaussian() + mean) * variance * variance;
	}
	/**
	 * Creates a uniform distribution of probability with mean = 0 and variance = 1
	 */
	public Norm() {
		super();
		this.mean = 0;
		this.variance = 1;
	}
	/**
	 * Creates a uniform distribution of probability with mean as specified in the first parameter and variance passed as second parameter
	 */
	public Norm(double mean, double variance) {
		super();
		this.mean = mean;
		this.variance = variance;
	}
}
