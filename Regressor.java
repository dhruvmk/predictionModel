import java.lang.Math;
public class Regressor {

  double[] x;
  double[] y;
  double quad;
  double slope;
  double intercept;

  public Regressor(double[] xvals, double[] yvals) {
    x = xvals;
    y = yvals;
    quad = 0;
    slope = 0;
    intercept = 0;
  }

  public void fitToData(double a1, double a2, double b1, double b2, double c1, double c2) {
    double aval=0;
    double bval=0;
    double cval=0;
    double minCost = Integer.MAX_VALUE;
    for(double a=a1;a<a2;a+=0.1) {
      for(double b=b1;b<b2;b+=0.1) {
        for(double c=c1;c<c2;c+=0.1) {
          double cost = getCost(a, b, c);
          if(cost<minCost) {
            aval = a;
            bval = b;
            cval = c;
          }
        }
      }
    }
    quad = aval;
    slope = bval;
    intercept = cval;
  }

  public void fitToData() {
    double aval=0;
    double bval=0;
    double cval=0;
    double minCost = Integer.MAX_VALUE;
    for(double a=0;a<10.0;a+=0.1) {
      for(double b=0;b<10.0;b+=0.1) {
        for(double c=0;c<10.0;c+=0.1) {
          double cost = getCost(a, b, c);
          if(cost<minCost) {
            minCost = cost;
            aval = a;
            bval = b;
            cval = c;
          }
        }
      }
    }
    quad = aval;
    slope = bval;
    intercept = cval;
  }

  public double getCost(double a, double b, double c) {
    double totalCost = 0.0;
    for(int i=0;i<x.length;i++) {
      double predictedValue = a*x[i]*x[i]+b*x[i]+c;
      double actualValue = y[i];
      double loss = Math.abs(predictedValue-actualValue);
      totalCost+=loss;
    }
    return totalCost;
  }

  public double predict(double input) {
    double predicted = quad*input*input+slope*input+intercept;
    return predicted;
  }
}
