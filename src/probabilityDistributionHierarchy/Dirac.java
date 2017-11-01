package probabilityDistributionHierarchy;
/**
 * 
 * @author Conrad
 * <p>
 * The deterministic distribution with parameter δ ∈ R
 */
public class Dirac extends ProbabilityDistribution {
	//attributes
	/**
	 * Name of the probability distribution
	 */
	private static final String name = "det";
	/**
	 * Parameter of the distribution
	 */
	private double delta;
	/**
	 * Returns the name of the distribution
	 */
	@Override
	public String getName() {
		return name;
	}
	/**
	 * Generate a sample of the distribution
	 */
	@Override
	public double getSample() {
		return this.delta;
	}
	/**
	 * Creates a deterministic distribution of probability with disired delta
	 */
	public Dirac(double delta) {
		super();
		this.delta = delta;
	}
}
