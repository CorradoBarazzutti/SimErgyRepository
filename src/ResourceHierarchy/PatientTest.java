package ResourceHierarchy;

import static org.junit.Assert.*;

import org.junit.Test;

public class PatientTest {

	@Test
	public void test() {
		try {
			Patient myPatient = new Patient();
			System.out.println(	"Patient name:" + myPatient.getName() + "\n" +
					"Patient surname:" + myPatient.getSurname() + "\n" +
					"Patient insurance:" + myPatient.getInsuranceType() + "\n" +
					"Severity level:" + myPatient.getSeverityLevel() + "\n");
			
			Patient mrJackson = new Patient("Robert", "Jackson", "gold", 3);
			System.out.println(	"Patient name:" + mrJackson.getName() + "\n" +
					"Patient surname:" + mrJackson.getSurname() + "\n" +
					"Patient insurance:" + mrJackson.getInsuranceType() + "\n" +
					"Severity level:" + mrJackson.getSeverityLevel() + "\n");
			
			/**
			 * test update method adding an arrival and a registration event
			 */
			//mrJackson.updateState();
			/**
			 * test get arrival time method
			 */
			
		} catch (Exception e) {
			System.out.println("Exeptions raised");
			fail("Not yet implemented");
		}
		
	}

}
