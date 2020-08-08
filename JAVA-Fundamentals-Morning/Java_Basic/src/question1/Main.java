package question1;

public class Main {
	public static void main(String args[]) throws CloneNotSupportedException{
		Singleton instanceOne = Singleton.getInstance();
		Singleton instanceTwo = Singleton.getInstance();
		
        System.out.println("hashCode of instance 1 - " + instanceOne.hashCode());
        System.out.println("hashCode of instance 2 - " + instanceTwo.hashCode()); //these two will have same Hash Code
        
        //cloning to get multiple instances
        Singleton instanceThree = (Singleton) instanceOne.clone();
        
        //difference in Hash Code will mean there are two different instances, hence breaking the singleton pattern.
        
        System.out.println("hashCode of instance 3 - " + instanceThree.hashCode()); //Different Hash Code 
	}

}
