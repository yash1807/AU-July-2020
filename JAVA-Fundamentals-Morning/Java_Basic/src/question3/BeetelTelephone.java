package question3;

import java.util.HashSet;
import java.util.Set;

public class BeetelTelephone implements TelephoneModel{
	
	private boolean idle; //state of phone
	private Set<Integer> record = new HashSet<Integer>();
	
	public BeetelTelephone(){
		this.idle = true;
	}
	
	public boolean isIdle() {
		return idle;
	}

	public void setIdle(boolean idle) {
		this.idle = idle;
	}

	public void MakeCall(Integer phoneNumber) {
		if(idle)
		{
			System.out.println("Calling : " + phoneNumber);
			record.add(phoneNumber);
			this.idle = false;  
		}
		else
			System.out.println("Phone is already on call");
	}
	
	public void TerminateCall(Integer phoneNumber) {
		if(idle)
			System.out.println("Phone is not on any call");
		else
			System.out.println("Terminating call with : " + phoneNumber);
		this.idle = true; 
	}
	
	public void RedialLastCall(Integer phoneNumber) {
		if(idle)
			System.out.println("Redialing : " + phoneNumber);
		else
			System.out.println("Phone is already on call");
		this.idle = false; 
	}
	
	public void DialledCallHistory() {
		System.out.println("Showing dialled history : " + record);
	}
}
