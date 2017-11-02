package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ResourceHierarchy.Patient;
import ResourceHierarchy.SeverityLevel;

public class PatientTest {

	@Test
	public void test() {
		/**
		 * Test creators, getters and setters
		 */
		try {
			/**
			 * Create a couple of patient and visulaize the attributes
			 */
			Patient myPatient = new Patient();
			System.out.println(	"Patient name:" + myPatient.getName() + "\n" +
					"Patient surname:" + myPatient.getSurname() + "\n" +
					"Patient insurance:" + myPatient.getInsuranceType() + "\n" +
					"Severity level:" + myPatient.getSeverityLevel().getLevel() + "\n");
			
			Patient mrJackson = new Patient("Robert", "Jackson", "gold", new SeverityLevel(3));
			System.out.println(	"Patient name:" + mrJackson.getName() + "\n" +
					"Patient surname:" + mrJackson.getSurname() + "\n" +
					"Patient insurance:" + mrJackson.getInsuranceType() + "\n" +
					"Severity level:" + mrJackson.getSeverityLevel().getLevel() + "\n");
			/**
			 * Verify the system safety in the case where invalid paramenters are passed
			 */
			try {
				Patient mrNo = new Patient("Robert", "Jackson", "asdf", new SeverityLevel(3));
				System.out.println(	"Patient name:" + mrNo.getName() + "\n" +
						"Patient surname:" + mrNo.getSurname() + "\n" +
						"Patient insurance:" + mrNo.getInsuranceType() + "\n" +
						"Severity level:" + mrNo.getSeverityLevel().getLevel() + "\n");
			} catch (Exception e) {
				System.out.println("Could not create mrNo becaouse an exeption occured");
			}
			try {
				Patient mrNo = new Patient("Robert", "Jackson", "gold", new SeverityLevel(7));
				System.out.println(	"Patient name:" + mrNo.getName() + "\n" +
						"Patient surname:" + mrNo.getSurname() + "\n" +
						"Patient insurance:" + mrNo.getInsuranceType() + "\n" +
						"Severity level:" + mrNo.getSeverityLevel().getLevel() + "\n");
			} catch (Exception e) {
				System.out.println("Could not create mrNo because an exeption occured");
			}
			
		} catch (Exception e) {
			System.out.println("Exeptions raised");
			fail("Exeptions raised");
		}
		
		/**
		 * test update method adding an arrival and a registration event
		 */
		//TODO;
		/**
		 * test get arrival time method
		 */
		
	}

}
