package memoryHandle;

public interface Word extends MemorySpace{
	
	public Word getWord(Memory m);
	
	public void add(Word w1, Word w2);
    
	public void mul(Word word, Word word2);
	
	public void copy(Word w1); 
	
}
