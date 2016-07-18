package com.secoo.current;

public class Food implements Runnable{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		String name = "qiuwanchi";
		if(Thread.currentThread().getName().equals("1")){
			name = "abcdefg";
		}
		
		this.setName(name);
		System.out.println(Thread.currentThread().getName() + ":修改name=" + this.getName());
	}
	
	public static void main(String[] args) {
		
		Food f = new Food();
		
		Thread threadA = new Thread(f);
		threadA.setName("1");
		
		Thread threadB = new Thread(f);
		threadB.setName("2");
		
		threadA.start();
		threadB.start();
		
	}

	
}