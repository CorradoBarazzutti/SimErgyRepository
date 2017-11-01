package probabilityDistributionHierarchy;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.Name;

public class ProbabilityDistributionTest {

	@Test
	public void test() {
		Uniform x = new Uniform();
		Uniform y = new Uniform(10);
		Uniform z = new Uniform(10.5, 20.5);
		
		assertEquals(x.getName(), new String("uniform"));
		System.out.println(	"x:  " + x.getName() + "[" + x.getLowerBound() + ", " + x.getUpperBound() + "]" + "\n" +
							"y:  " + y.getName() + "[" + y.getLowerBound() + ", " + y.getUpperBound() + "]" + "\n" +
							"z:  " + z.getName() + "[" + z.getLowerBound() + ", " + z.getUpperBound() + "]" );
		
		//fail("Not yet implemented");
	}

}
