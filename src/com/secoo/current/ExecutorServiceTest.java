package com.secoo.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "正在执行....");
		
	}
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		pool.execute(new ExecutorServiceTest());
		pool.execute(new ExecutorServiceTest());
		pool.execute(new ExecutorServiceTest());
		pool.execute(new ExecutorServiceTest());
		pool.execute(new ExecutorServiceTest());
		
		pool.shutdown();
		
		
		
	}
}
