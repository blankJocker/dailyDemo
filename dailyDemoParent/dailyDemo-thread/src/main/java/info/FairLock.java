package info;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable {
	public static ReentrantLock fairLock = new ReentrantLock(true);

	public void run() {
		while(true){
			try{
				fairLock.lock();
				System.out.println(Thread.currentThread().getName() + " 获得了锁" );
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				fairLock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		FairLock r1 = new FairLock();
		Thread t1 = new Thread(r1, "t1");
		Thread t2 = new Thread(r1, "t2");
		t1.start();
		t2.start();
	}
	
	
}
