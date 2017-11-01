package probabilityDistributionHierarchy;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.Name;

public class ProbabilityDistributionTest {

	@Test
	public void test() {
		
		//uniform distribution creators test
		Uniform u1 = new Uniform();
		Uniform u2 = new Uniform(10);
		Uniform u3 = new Uniform(10.5, 20.5);
		
		assertEquals(u1.getName(), new String("uniform"));
		System.out.println(	"u1:  " + u1.getName() + "[" + u1.getLowerBound() + ", " + u1.getUpperBound() + "]" + "\n" +
							"u2:  " + u2.getName() + "[" + u2.getLowerBound() + ", " + u2.getUpperBound() + "]" + "\n" +
							"u3:  " + u3.getName() + "[" + u3.getLowerBound() + ", " + u3.getUpperBound() + "]" );
		System.out.println("u1 sample: " + u1.getSample());
		
		//Norm test
		Norm x1 = new Norm();
		System.out.println(	"x1:  " + x1.getName() + ", mean: " + x1.getMean() + ", variance: " + x1.getVariance() );
		Norm x2 = new Norm(1, 1);
		System.out.println(	"x2:  " + x2.getName() + ", mean: " + x2.getMean() + ", variance: " + x2.getVariance() );
		System.out.println("x1 sample: " + x1.getSample());
		
		//Exp test
		Exp y = new Exp(1);
		System.out.println(	"y:  " + y.getName() + ", sample: " + y.getSample() );
		//Dirac test
		Dirac z = new Dirac(1);
		System.out.println(	"z:  " + z.getName() + ", sample: " + z.getSample() );
		
	}

}
