package com.secoo.current;

public class ReadResult extends Thread{

	Calculator c ;
	public ReadResult(Calculator c ){
		this.c = c;
	}
	
	@Override
	public void run() {
		synchronized(c){
			for(int i = 0; i < 5; i++){
				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "等待计算结果..." + i);
			}
			try {
				c.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + "计算结果:" + c.total);
			
		}
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		
		new ReadResult(c).start();
		new ReadResult(c).start();
		new ReadResult(c).start();
		
		c.start();
	}
}
