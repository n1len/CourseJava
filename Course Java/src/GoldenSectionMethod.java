/**
 * Main class
 * @author Milyuk V.P.
 * @version 1.0.0.2021
 */
public class GoldenSectionMethod {
    /**
     * The main function for creating a jfrm object of the SplashScreen class
     * @param args command line arguments
     */
    public static void main(String[] args) {
        new SplashScreen();
    }
}

/**
 * Class responsible for calculations using the golden ratio
 * @author Milyuk V.P.
 * @version 1.0.0.2021
 */
class GoldenSection{

    final double PHI = 1.618;

    double f(double x){
        return Math.pow(x, 4) + 5 * Math.pow(x, 3) - 10 * x;
    }

    /**
     * Method responsible for calculating the minimum
     * @param a - left border of the line
     * @param b - right border of the line
     * @param e - calculation accuracy
     * @return - result
     */
    String findMin(double a, double b, double e){
        double x , x1, x2, x3 = 0;
        while (true){
            x1 = b - ((b - a) / PHI);
            x2 = a + ((b - a) / PHI);
            if (f(x1) >= f(x2))
                a = x1;
            else
                b = x2;
            if (Math.abs(b - a) < e)
                break;
            x3 = (a + b) / 2;
        }
        double scale = Math.pow(10,3);
        x = (Math.round(x3 * scale) / scale);
        return String.valueOf(x);
    }

    /**
     * Method responsible for calculating the maximum
     * @param a - left border of the line
     * @param b - right border of the line
     * @param e - calculation accuracy
     * @return - result
     */
    String findMax(double a, double b, double e){
        double x, x1, x2, x3 = 0;
        while (true){
            x1 = b - ((b - a) / PHI);
            x2 = a + ((b - a) / PHI);
            if (f(x1) <= f(x2))
                a = x1;
            else
                b = x2;
            if (Math.abs(b - a) < e)
                break;
            x3 = (a + b) / 2;
        }
        double scale = Math.pow(10,3);
        x = (Math.round(x3 * scale) / scale);
        return String.valueOf(x);
    }
}
