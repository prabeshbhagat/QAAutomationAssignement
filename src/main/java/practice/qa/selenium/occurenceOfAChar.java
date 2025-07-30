package practice.qa.selenium;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class occurenceOfAChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a="apiautoamtion";
		
		Map<Character,Integer> map= new HashMap<Character,Integer>();
		
		for(int i=0;i<a.length();i++) {
			char ch=a.charAt(i);
			//System.out.println(ch);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}else {
				map.put(ch, 1);
			}
		}
		
		System.out.println(map);
		
		for(Entry<Character,Integer> entry:map.entrySet()) {
			if(entry.getValue()==2) {
				System.out.println(entry.getKey());
			}
			
		}
		
		
		
		

	}

}
