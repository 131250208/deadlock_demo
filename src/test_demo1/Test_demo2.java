package test_demo1;

import java.nio.channels.NonReadableChannelException;

public class Test_demo2{

	public void f(Test_demo1 t){}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test_demo2 test_demo2=new Test_demo2();
		test_demo2.f(new Test_demo1(21l) {
			
			@Override
			public void f() {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
