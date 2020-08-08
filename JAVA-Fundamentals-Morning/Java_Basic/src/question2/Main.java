package question2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		
		String str;
		System.out.print("Enter String here : ");
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		sc.close();
		
		HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
		for(int i = 0; i < str.length(); i++)
		{
			if(!mp.isEmpty() && mp.get(str.charAt(i)) != null)
				mp.put(str.charAt(i), mp.get(str.charAt(i)) + 1);
			else
				mp.put(str.charAt(i),1);
		}
		
		mp.forEach((k,v) -> System.out.println("Character = "+ k + ", Count = " + v));
	}

}
