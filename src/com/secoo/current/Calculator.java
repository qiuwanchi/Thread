package com.secoo.current;

public class Calculator extends Thread{

	int total;
	
	@Override
	public void run() {
		synchronized(this){
			for(int i = 0; i < 200; i++){
				total += i;
			}
			notifyAll();
		}
		
	}
}
