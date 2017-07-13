package test_demo1;

import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public abstract class Test_demo1 {

	private long length;
	public Test_demo1(long l) {
		// TODO Auto-generated constructor stub
		this.setLength(l);
	}
	public abstract void f();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String, Integer> hashMap=new TreeMap<String, Integer>();
		hashMap.put("ads", 2);
		hashMap.put("sfd", 7);
		hashMap.put("we", 5);
		hashMap.put("ff", 6);
		
		Set<String> set=hashMap.keySet();
		Collection<Integer> values = hashMap.values();
		
	}
	public long getLength() {
		return length;
	}
	public int getDemo1(){
		return 0;
	}
	public int getDemo1(int ii){
		return ii;
	}
	public double getDemo1(double ii){
		return ii;
	}
	
	public void setLength(long length) {
		this.length = length;
	}

}
