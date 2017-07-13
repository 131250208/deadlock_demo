package test_demo1;


public class Dead_Lock2 implements Runnable{  
     public int flag = 1;  
     public static Object o1 = new Object();  
     public static Object o2 = new Object();  
     public static void main(String[] args) {  
         Dead_Lock2 td1 = new Dead_Lock2();  
         Dead_Lock2 td2 = new Dead_Lock2();  
         td1.flag=1;  
         td2.flag=0;  
         Thread t1 = new Thread(td1);  
         Thread t2 = new Thread(td2);  
         t1.start();  
         t2.start();  
   
     }  
   
     @Override  
     public void run() {  
         System.out.println("flag:"+flag);  
         if(flag==1){  
             synchronized(o1){  
                 try {  
                     Thread.sleep(500);  
                 } catch (InterruptedException e) {  
                     // TODO Auto-generated catch block  
                     e.printStackTrace();  
                 }  
                 synchronized(o2){  
                     System.out.println("1");  
                 }  
             }  
               
         }  
         else if(flag == 0){  
             synchronized(o2){  
                 try {  
                     Thread.sleep(500);  
                 } catch (InterruptedException e) {  
                     // TODO Auto-generated catch block  
                     e.printStackTrace();  
                 }  
                 synchronized(o1){  
                     System.out.println("0");  
                 }  
             }  
               
         }  
           
     }  
   
 }  

