package ResourceHierarchy;

public interface ResourceManager {
	/**
	 * allocates a resource of the given type. If no resource isavailable returns null
	 * @param type
	 * @return
	 */
	int allocate(String type);
	/**
	 * Free the resource whose id is passed as parameter
	 * @param resourceId
	 */
	void free(int resourceId);
}
