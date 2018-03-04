package memoryHandle;

public class Address implements MemorySpace{
	
	int index;
	
	public Address(int val){
		index = val;
	}
	
	public Word getWord(Memory mem){
		return mem.getWord(index);
	}

	
	public String toString() {
		return " [" + index + "] ";
	}
}