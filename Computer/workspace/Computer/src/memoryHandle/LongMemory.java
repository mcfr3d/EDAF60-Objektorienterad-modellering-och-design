package memoryHandle;

public class LongMemory extends Memory {
	
	public LongMemory  (int size){
		super(size);	
		for(int i = 0; i < size; i++){
			adressList[i] = new LongWord(0);
		}
	}

	
}
