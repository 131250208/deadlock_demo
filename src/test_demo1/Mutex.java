package test_demo1;

public class Mutex {

	private int flag=0;
	private int num;
	public Mutex(int num){
		this.num=num;
	}
	public int getFlag() {
		return flag;
	}

	public void setFlag() {
		this.flag = (flag+1)%num;
	}
	
}
