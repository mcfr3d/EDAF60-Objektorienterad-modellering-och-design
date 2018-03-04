package mainComputer;
import memoryHandle.*;

public class ComputerSimulator{
	public static void main(String[] args){
		Program factorial = new Factorial(); 
		System.out.println(factorial); 
		Computer computer = new Computer(new LongMemory(1024)); 
		computer.load(factorial); 
		computer.run();
	}
}
