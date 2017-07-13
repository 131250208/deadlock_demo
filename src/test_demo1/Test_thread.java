package test_demo1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test_thread extends Thread{

	private int flag;
	private Mutex mutex;
	private List<Object> list;
	
	public Test_thread(int flag,Mutex mutex,List<Object> list) {
		// TODO Auto-generated constructor stub
		this.mutex=mutex;
		this.flag=flag;
		this.list=list;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<26;++i){
			synchronized (mutex) {
				while(mutex.getFlag()!=this.flag){
					try {
						mutex.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.print(list.get(i)+" ");
				if(this.flag==2)System.out.println();
				mutex.setFlag();
				mutex.notifyAll();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mutex mutex=new Mutex(3);
		
		ArrayList<Object> list1=new ArrayList<Object>();
		ArrayList<Object> list2=new ArrayList<Object>();
		ArrayList<Object> list3=new ArrayList<Object>();
		for(int i=0;i<26;++i){
			list1.add(i+1);
			list2.add((char)(i+'a'));
			list3.add((char)(i+'A'));
		}
		Test_thread test_thread1=new Test_thread(0,mutex,list1);
		Test_thread test_thread2=new Test_thread(1,mutex,list2);
		Test_thread test_thread3=new Test_thread(2,mutex,list3);
		test_thread1.start();
		test_thread2.start();
		test_thread3.start();
	}

}
