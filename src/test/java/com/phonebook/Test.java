package com.phonebook;

public class Test {

	public static void main(String[] args) {
		int x=2;
		int y=2;
		for(int i=0;i<5;i++) {
			if(++x>2 && y++>2) {
				x++;
			}
		}
		System.out.println("X :: "+x);
		System.out.println("Y :: "+y);
	}

}
