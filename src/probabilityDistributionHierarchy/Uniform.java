package probabilityDistributionHierarchy;
/**
 * 
 * @author Conrad
 * <p>
 * A uniform distribution is such that has constant probability of 1 / (upperbound - lowerbound) in the closed interval [lowerbound, upperbound] and zero elsewere.
 */
public class Uniform extends ProbabilityDistribution {
	//attributes
	/**
	 * Name of the probability distribution
	 */
	private static final String name = "uniform";
	/**
	 * Parameter of the distribution
	 */
	private double lowerBound;
	/**
	 * Parameter of the distribution
	 */
	private double upperBound;
	
	/**
	 * Returns the name of the distribution
	 */
	@Override
	public String getName() {
		return name;
	}
	/**
	 * Returns the first parameter of the distribution
	 */
	public double getLowerBound() {
		return lowerBound;
	}
	/**
	 * Returns the second parameter of the distribution
	 */
	public double getUpperBound() {
		return upperBound;
	}
	/**
	 * Generate a sample of the distribution
	 */
	@Override
	public double getSample() {
		return rnd.nextDouble() * (upperBound - lowerBound) + lowerBound;
	}
	//creators
	/**
	 * Creates a uniform distribution of probability with lowerBound = 0 and upperbound = 1
	 */
	public Uniform() {
		super();
		this.lowerBound = 0;
		this.upperBound = 1;
	}
	/**
	 * Creates a uniform distribution of probability with lowerBound = 0 and the upperbound passed as parameter
	 */
	public Uniform(double upperBound) {
		super();
		this.lowerBound = 0;
		this.upperBound = upperBound;
	}
	/**
	 * Creates a uniform distribution of probability with lowerBound as specified in the first parameter and upperbound passed as second parameter
	 */
	public Uniform(double lowerBound, double upperBound) {
		super();
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
}
