package ResourceHierarchy;

public interface ResourceAllocator {
	void allocate(String type);
	void free(int resourceid);
}
