package memoryHandle;

public class LongWord implements Word{
	private long value;
	
	public LongWord(int val){
		value = val;
	}
	
	
	public void add(Word w1, Word w2){	
		value = ((LongWord) w1).value + ((LongWord) w2).value;
	}


	public void mul(Word w1, Word w2) {	
		this.value = ((LongWord) w1).value * ((LongWord) w2).value;
	}

	public void copy(Word w1) {
		this.value = ((LongWord) w1).value;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof LongWord){
			return this.value == ((LongWord)obj).value;
		}
		
		return true;
	}
	
	public String toString(){
		return "" + value;
	}

	public Word getWord(Memory m) {
		return this;
	}
}
