package com.test;


import java.util.Arrays;

import com.cases.Case;
import com.parser.Parser;

import ilog.concert.*;
import ilog.cplex.*;


public class IntegerProg {
	
	
	
	public IntegerProg(){};
	
	
   public double[] solve(Case case1) {
      try {
    	  //Case case1 = new Case();   
    	  //Parser parse = new Parser("./input/A-small-practice.in");

    	  //case1 = parse.getCases().get(2);
    	  
    	   
         IloCplex cplex = new IloCplex();

         IloNumVar[][] var = new IloNumVar[1][];
         IloRange[][]  rng = new IloRange[1][];
 
         populateByRow(cplex, var, rng, case1);
         
         if ( cplex.solve() ) {
        	 double[] x     = cplex.getValues(var[0]);
            double[] slack = cplex.getSlacks(rng[0]);

            System.out.println("Solution status = " + cplex.getStatus());
            System.out.println("Solution value  = " + cplex.getObjValue());

           /* 
            for (int j = 0; j < x.length; ++j) {
               System.out.println("Variable " + j + ": Value = " + x[j]);
            }

            for (int i = 0; i < slack.length; ++i) {
               System.out.println("Constraint " + i + ": Slack = " + slack[i]);
            }*/
            
            cplex.exportModel("mipex1.lp");
            cplex.end();
            return x;         
         }
 
         cplex.exportModel("mipex1.lp");
         cplex.end();
         
      }
      catch (IloException e) {
         System.err.println("Concert exception caught '" + e + "' caught");
      }
	return null;
   }


   static void populateByRow (IloMPModeler  model,
                              IloNumVar[][] var,
                              IloRange[][]  rng, Case case1) throws IloException {
	   
	   int n       = case1.getItem();
	   int price[] = case1.getPrice();
	   int credit  = case1.getCredit();
	   
      // First define the variables, three continuous and one integer
      double[]        xlb = new double[n];
      Arrays.fill(xlb, 0.0);
      double[]        xub = new double[n];
      Arrays.fill(xub, 1.0);
      
      
      IloNumVarType[] xt  = new IloNumVarType[n];
      Arrays.fill(xt, IloNumVarType.Int);
      
      IloNumVar[]     x   = model.numVarArray(n, xlb, xub, xt);
      
      var[0] = x;

      // Objective Function:  maximize 5*x0 + 75*x1 + 25*x2 
      //double[] objvals = {5.0, 75.0, 25.0};
      model.addMaximize(model.scalProd(price, x));

      // Two constraints
      rng[0] = new IloRange[2];
      
      //  5*x0 + 75*x1 + 25*x2 <= 100   
      //double[] line1 = {-1.0, 1.0, 1.0};
      rng[0][0] = model.addLe(model.scalProd(price, x), credit);   
      
      // x0 - x1 + x2 + x3 <= 2     
      double[] line2 = new double[n];
      Arrays.fill(line2, 1.0);
      rng[0][1] = model.addEq(model.scalProd( line2, x), 2.0);
      
   }
}