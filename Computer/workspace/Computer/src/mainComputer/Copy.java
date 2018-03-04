package mainComputer;
import memoryHandle.*;
public class Copy implements Instructions{
	
	MemorySpace mem;
	Address address;
	
	public Copy(MemorySpace m1,  Address a){
		address = a;
		mem = m1;
	}

	@Override
	public void execute(Memory m, ProgramCounter p) {
		address.getWord(m).copy(mem.getWord(m));
		p.setIndex(p.getIndex()+1);
	}

	@Override
	public String toString(){
		return "CPY " + mem.toString() + address.toString();
	}
}
