package com.secoo.current;

public class OneThread implements Runnable{

	@Override
	public void run() {
		int num = 0;
		while(num < 100){
			num++;
			try {
				Thread.currentThread().sleep(1);
				System.out.println(Thread.currentThread().getName() + "线程睡眠1毫秒");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(num % 10 == 0){
				System.out.println(num);
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Thread(new OneThread()).start();
	}
	
}
