package mainComputer;
import memoryHandle.*;
public class Print implements Instructions {
	
	Address address;
	
	public Print(Address address){
		this.address = address;
	}

	@Override
	public void execute(Memory m, ProgramCounter p) {
		System.out.println(address.getWord(m).toString());
		p.setIndex(p.getIndex()+1);
	}


	public String toString() {
		return "PRT " + address;
	}

}
