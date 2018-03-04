package mainComputer;
import memoryHandle.*;
public class Computer {
	
	Memory memory;
	Program program;
	
	public Computer(Memory memory){
		this.memory = memory;
	}
	
	public void load(Program program){
		this.program = program;
	}
	
	public void run(){
		program.setUp(memory);
	}
}
