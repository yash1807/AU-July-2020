package question3;

public class Main {
	
	public static void main(String args[]){
		BeetelTelephone telephone = new BeetelTelephone();
		telephone.MakeCall(985478562);
		telephone.RedialLastCall(985478562);
		telephone.TerminateCall(985478562);
		telephone.DialledCallHistory();
	}
	
}
