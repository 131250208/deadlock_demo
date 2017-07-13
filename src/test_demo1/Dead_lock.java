package test_demo1;

public class Dead_lock implements Runnable{

	private int flag;
	public static Object res1=new Object();//注意要声明成static ，因为这是临界资源，如果声明成private就是各自线程中的私有成员变量
	public static Object res2=new Object();
	public Dead_lock(int f) {
		// TODO Auto-generated constructor stub
		flag=f;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1=new Thread(new Dead_lock(0));
		Thread thread2=new Thread(new Dead_lock(1));
		thread1.start();
		thread2.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(flag==0){
			synchronized (res1) {
				System.out.println("线程0已经获取资源1，正在请求资源2……");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (res2) {
					System.out.println("线程0已获取资源1和2");
				}
			}
		}
		else if(flag==1){
			synchronized (res2) {
				System.out.println("线程1已经获取资源2，正在请求资源1……");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (res1) {
					System.out.println("线程1已获取资源1和2");
				}
			}
		}
	}

}
