package memoryHandle;
public abstract class Memory {
	protected Word[] adressList;
	protected int size;
	
	public Memory  (int size){
		adressList = new Word[size];
		this.size = size;
	}
	
	
	
	public  Word getWord(int index){
		return adressList[index];
		
	}
	

}
