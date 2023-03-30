public class SLR implements Regression {
    private DataSet dataSet;
    private DiscreteMaths discreteMaths;

    public SLR(DataSet dataSet, DiscreteMaths discreteMaths){
        this.dataSet = dataSet;
        this.discreteMaths = discreteMaths;
    }

    public void printRegEquation(){
        double[] val = discreteMaths.regression(dataSet.getX(), dataSet.getY());
        if(val.length > 0) {
            System.out.println("y = ( " + val[0] + " + " + val[1] + "x + " + val[2] + "x^2 + " + val[3] + "x^3)");
        }
    }
    public double predict(double x){
        double[] val = discreteMaths.regression(dataSet.getX(), dataSet.getY());
        double result = val[0] + (val[1] * x) + (val[2] * Math.pow(x, 2) + (val[3] * Math.pow(x, 3)));
        System.out.println("Predict of Y: " + result);
        return result;
    }
}
