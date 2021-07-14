package com.paridile.amazonviewer.functional;

public class Main {
	public static void main(String[] args) {
		
		OnOneListener oneListener = new OnOneListener() {			
			@Override
			public void onOne(String message) {
				System.out.println("One: " + message);
			}
		};
		
		OnOneListener oneListener2 = (String message) -> {
			System.out.println("One lambda: " + message);
		};
		
		oneListener.onOne("Sin lambda");
		oneListener2.onOne("Con lambda");
		
		OnClickListener onClickListener = (String element) -> {
			System.out.println("Has hecho click en: " + element);
		};
		
		onClickListener.clickListener("boton");
		
	}
}
