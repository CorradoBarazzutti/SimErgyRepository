package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ResourceHierarchy.BoxRoom;
import ResourceHierarchy.Nurse;
import ResourceHierarchy.Patient;
import ResourceHierarchy.Physician;
import ResourceHierarchy.Resource;
import ResourceHierarchy.ShockRoom;
import ResourceHierarchy.Stretcher;
import ResourceHierarchy.Transporter;
import ResourceHierarchy.WaitingRoom;

public class ResourceTest {

	@Test
	public void test() {
		/**
		 * Create some resources
		 */
		ArrayList<Resource> myR = new ArrayList<Resource>();
		
		BoxRoom myBox = new BoxRoom();
		myR.add(myBox);
		
		Nurse myNurse = new Nurse();
		myR.add(myNurse);
		
		Patient myPatient = new Patient();
		myR.add(myPatient);
		
		Physician myPhysician = new Physician();
		myR.add(myPhysician);
		
		ShockRoom myShockRoom = new ShockRoom();
		myR.add(myShockRoom);
		
		Stretcher myStretcher = new Stretcher();
		myR.add(myStretcher);
		
		Transporter myTransporter = new Transporter();
		myR.add(myTransporter);
		
		WaitingRoom myWaiting = new WaitingRoom();
		myR.add(myWaiting);
		
		/**
		 * verify the uniqueness of the iDs,
		 * the properties of reflexivity of the equal() method
		 * and the property of reflexivity of the hashCode()
		 */
		for (int i = 0; i < myR.size(); i++) {
			for (int j = 0; j < myR.size(); j++) {
				if (i != j) {
					assertNotEquals(myR.get(i), myR.get(j));
					assertNotEquals(myR.get(i).getiD(), myR.get(j).getiD());
				}
				else {
					assertEquals(myR.get(i), myR.get(j));
					assertEquals(myR.get(i).hashCode(), myR.get(j).hashCode());
				}
			}
		}

	}
}
