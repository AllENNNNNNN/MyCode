package com.bridge.coffee;

import com.bridge.Foam.AbstractFoam;
import com.bridge.cupsize.AbstractCupsize;
import com.bridge.milk.AbstractMilk;

public class AbstractCoffee {
	private AbstractCupsize cupsize;
	private AbstractMilk milk;
	private AbstractFoam foam;
	

	public AbstractCupsize getCupsize() {
		return cupsize;
	}

	public void setCupsize(AbstractCupsize cupsize) {
		this.cupsize = cupsize;
	}

	public AbstractMilk getMilk() {
		return milk;
	}

	public void setMilk(AbstractMilk milk) {
		this.milk = milk;
	}

	public AbstractFoam getFoam() {
		return foam;
	}

	public void setFoam(AbstractFoam foam) {
		this.foam = foam;
	}

}
