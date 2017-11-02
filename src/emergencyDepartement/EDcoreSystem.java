package emergencyDepartement;
/**
 * 
 * @author
 * <p>
 * This is the core part of the system. 
 * <p>
 * It stores the entire state of the system (i.e., patients, resources, queues), the history of occurred events (e.g. patients’ registration, consultations, examinations, etc), the state of each queue in the ED (patients’ arrival queue, queues for each health service, e.g. consultation, x-ray, etc). 
 * <p>
 * SimErgy should also provide the user with the following functionalities:
 * 	- setting the arrival-time probability distribution for a given category (L1, ... L5) of patients.
 * 	- setting the service-time probability distribution for a given service (consultation, x- ray, etc).
 *	- setting how many individuals of a given resource (physician, nurse, waiting room, x-ray facilities, etc.) are present in the ED.
 *	- arrival (i.e. registration) of a patient of a given category in the ED.
 *	- emission of a verdict (i.e. departure) for a patient in the ED.
 *	- allocation of a resource to a registered patient
 *	- termination of an health-service being performed on a patient and updating the state of system accordingly
 *	- computation of the average value of a KPI (e.g. LOS, DTDT) for a given category of patients (L1, ... L5).
 *	- display of the state of a given patient
 *	- display of the state of a given physician (mailbox included)
 *	- display of current state of the whole system (state of each queue, state of each patient, each physician)
 */
public class EDcoreSystem {

}
