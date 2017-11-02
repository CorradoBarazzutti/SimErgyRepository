package ResourceHierarchy;
/**
 * 
 * @author Conrad
 * <p>
 * Represent a room of the ED
 * <p>
 * The following kind of Rooms shall be considered: BoxRooms (where patients are first visited by a physician), ShockRooms for immediate treatment of most severe patients, WaitingRooms where patients are temporarily placed while waiting for a service (e.g. waiting for being visited by a physician, waiting to be transported to another department).
 * Room implements the Location interface, which means that can be assigned as values to the attribute "place" of an event
 */
public abstract class Room extends Resource implements Location {
	/**
	 * Default creator: Creates a new room and initializes the fields with the default value.
	 * @param Name
	 */
	public Room() {
		super(null);
	}
	/**
	 * Creates a new room with the desired name.
	 * @param Name
	 */
	public Room(String Name) {
		super(Name);
	}	
}
