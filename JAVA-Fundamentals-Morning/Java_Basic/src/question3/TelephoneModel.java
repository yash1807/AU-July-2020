package question3;

public interface TelephoneModel {
	public void MakeCall(Integer phoneNumber);
	public void TerminateCall(Integer phoneNumber);
	public void RedialLastCall(Integer phoneNumber);
	public void DialledCallHistory();
}
