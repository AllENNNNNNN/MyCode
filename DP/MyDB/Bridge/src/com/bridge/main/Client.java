package com.bridge.main;

import com.bridge.Foam.NoFoam;
import com.bridge.coffee.AbstractCoffee;
import com.bridge.coffee.American;
import com.bridge.cupsize.Short;
import com.bridge.milk.Soy;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractCoffee coffe=new American();
		coffe.setCupsize(new Short());
		coffe.setFoam(new NoFoam());
		coffe.setMilk(new Soy());
		System.out.println("Coffe:"+coffe);
		System.out.println("Cupsize:"+coffe.getCupsize());
		System.out.println("Foam"+coffe.getFoam());
		System.out.println("Milk:"+coffe.getMilk());
	}

}
