public class Main {

    public static void main(String[] args) {

        DataSet dataSet = new DataSet();
        DiscreteMaths discreteMaths = new DiscreteMaths();

        SLR slr = new SLR(dataSet, discreteMaths);

        slr.printRegEquation();
        slr.predict(89);

    }
}
