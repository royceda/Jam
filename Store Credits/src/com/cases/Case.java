package com.cases;


import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPSolver;

import ilog.concert.IloException;
import ilog.concert.IloNumVar;
import ilog.concert.IloRange;
import ilog.cplex.IloCplex;


public class Case {

	private int credit;
	private int item;
	private int price[];
	
	
	
	public Case(){}
	
	public Case(int c, int i, int p[]){
		setCredit(c);
		setItem(i);
		setPrice(p);
	}

	
	
	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public int[] getPrice() {
		return price;
	}

	public void setPrice(int price[]) {
		this.price = price;
	}
	
	
}
