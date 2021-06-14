import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

/**
 * The class is responsible for plotting the function and axes
 * Class DrawingComponent inherited from JPanel
 * @author Milyuk V.P.
 * @version 1.0.0.2021
 */
public class DrawingComponent extends JPanel {
    /**
     * Overridden method for drawing the graph of the function and axes
     * @param gh - graphics
     */
    @Override
    protected void paintComponent(Graphics gh) {
        super.paintComponent(gh);
        java.util.List<Double> x = new ArrayList<Double>();
        java.util.List<Double> y = new ArrayList<Double>();

        double a = Double.parseDouble(MainWindow.getA());
        double b = Double.parseDouble(MainWindow.getB());

        double y1 = a;
        int n = 0;

        showGridOnY(gh,30,-14);
        showGridOnX(gh,30,-14);
        showAxis(gh);

        //Запись точек x и y в массив
        while(true){
            if(y1 >= a && y1 <= b) {
                double scale = Math.pow(10,3);
                x.add(Math.round(y1 * scale) / scale);
                double funcResult = Math.pow(x.get(n), 4) + 5 * Math.pow(x.get(n), 3) - 10 * x.get(n);
                y.add(Math.round(funcResult * scale) / scale);
                n++;
                y1 += 0.01;
            }
            else
                break;
        }

        showGraph(gh,30,-14,x,y,n);
        //Отрисовка точки максимума
        if(MainWindow.getBoolMax()){
            showMaxDot(gh,30,-14);
            MainWindow.setBoolMaxToFalse();
        }
        //Отрисовка точки минимума
        if(MainWindow.getBoolMin()){
            showMinDot(gh,30,-14);
            MainWindow.setBoolMinToFalse();
        }
    }

    /**
     * Method for displaying the graph
     * @param gh - Graphics
     * @param scaleX - the number by which the variable is incremented along the X axis
     * @param scaleY - the number by which the variable is incremented along the Y axis
     * @param x - point x from array List
     * @param y - point y from array List
     * @param n - number of points
     */
    private void showGraph(Graphics gh, int scaleX, int scaleY,
                           java.util.List<Double> x, List<Double> y, int n){
        Graphics2D g = (Graphics2D)gh;

        g.setFont(new java.awt.Font("Times New Roman", 2, 14));

        int i = 0;
        Integer numYUp = 0,numYDown = 0,numXLeft = 0,numXRight = 0;

        //Цифры по оси Y вверх
        while(numYUp <= 10){
            String text = numYUp.toString();

            g.drawString(text,400,numYUp * scaleY + 200);
            numYUp += 2;
        }

        //Цифры по оси Y вниз
        while(numYDown >= -30){
            String text = numYDown.toString();

            g.drawString(text,400,numYDown * scaleY + 200);
            numYDown -= 2;
        }

        //Цифры по оси X влево
        while (numXLeft >= -10){
            String text = numXLeft.toString();

            g.drawString(text,numXLeft * scaleX + 400,200);
            numXLeft--;
        }

        //Цифры по оси X влево
        while(numXRight <= 10){
            String text = numXRight.toString();

            g.drawString(text,numXRight * scaleX + 400,200);
            numXRight++;
        }

        //Отрисовка графика
        while(i < n - 1){
            g.setColor(Color.RED);

            g.draw(new Line2D.Double(scaleX * x.get(i) + 400,scaleY * y.get(i) + 200,
                    scaleX * x.get(i + 1) + 400,scaleY * y.get(i + 1) + 200));
            i++;
        }
    }

    /**
     * Method for plotting axes
     * @param gh - graphics
     */
    private void showAxis(Graphics gh){
        Graphics2D g = (Graphics2D)gh;
        g.setColor(Color.BLACK);

        //Оси X и Y
        g.drawLine(400, 200, 400, 30);
        g.drawLine(400, 200, 700, 200);
        g.drawLine(400, 200, 100, 200);
        g.drawLine(400, 200, 400, 620);
        //Стрелки на концах осей X и Y
        g.drawLine(400,30,405,45);
        g.drawLine(400,30,395,45);
        g.drawLine(700,200,685,195);
        g.drawLine(700,200,685,205);
    }

    /**
     * Method for generating the y-axis mesh
     * @param gh - graphics
     * @param scaleX - the number by which the variable is incremented along the X axis
     * @param scaleY - the number by which the variable is incremented along the Y axis
     */
    private void showGridOnY(Graphics gh, int scaleX, int scaleY){
        Graphics2D g = (Graphics2D)gh;
        g.setColor(Color.LIGHT_GRAY);

        int numYUp = 0,numYDown = 0,numXLeft = 0,numXRight = 0;

        while(numYUp <= 13){
            numXLeft = -12;
            numXRight = 12;
            g.drawLine(numXLeft * scaleX + 400,numYUp * scaleY + 200,
                    numXRight * scaleX + 400,numYUp * scaleY + 200);
            numYUp++;
        }

        while(numYDown >= -30){
            numXLeft = -12;
            numXRight = 12;
            g.drawLine(numXLeft * scaleX + 400,numYDown * scaleY + 200,
                    numXRight * scaleX + 400,numYDown * scaleY + 200);
            numYDown--;
        }
    }

    /**
     * Method for generating the x-axis mesh
     * @param gh - graphics
     * @param scaleX - the number by which the variable is incremented along the X axis
     * @param scaleY - the number by which the variable is incremented along the Y axis
     */
    private void showGridOnX(Graphics gh, int scaleX, int scaleY){
        Graphics2D g = (Graphics2D)gh;
        g.setColor(Color.LIGHT_GRAY);

        int numYUp = 0,numYDown = 0,numXLeft = 0,numXRight = 0;

        while (numXLeft >= -12){
            numYDown = -30;
            numYUp = 13;
            g.drawLine(numXLeft * scaleX + 400,numYDown * scaleY + 200,
                    numXLeft * scaleX + 400,numYUp * scaleY + 200);
            numXLeft--;
        }

        while(numXRight <= 12) {
            numYDown = -30;
            numYUp = 13;
            g.drawLine(numXRight * scaleX + 400, numYDown * scaleY + 200,
                    numXRight * scaleX + 400, numYUp * scaleY + 200);
            numXRight++;
        }
    }

    /**
     * Method for drawing the maximum point
     * @param gh - graphics
     * @param scaleX - the number by which the variable is incremented along the X axis
     * @param scaleY - the number by which the variable is incremented along the Y axis
     */
    private void showMaxDot(Graphics gh,int scaleX,int scaleY){
        Graphics2D g = (Graphics2D)gh;

        double a = Double.parseDouble(MainWindow.getA());
        double b = Double.parseDouble(MainWindow.getB());
        double e = Double.parseDouble(MainWindow.getE());
        double scale = Math.pow(10,3);

        GoldenSection GS = new GoldenSection();
        double xResultMax = Double.parseDouble(GS.findMax(a,b,e));

        double yMax = Math.pow(xResultMax, 4) + 5 * Math.pow(xResultMax, 3) - 10 * xResultMax;
        double yResultMax = (Math.round(yMax * scale) / scale);

        g.setColor(Color.GREEN);
        g.setStroke(new BasicStroke(4));

        g.draw(new Line2D.Double(scaleX * xResultMax + 400,scaleY * yResultMax + 200,
                scaleX * xResultMax + 400,scaleY * yResultMax + 200));
    }

    /**
     * Method for drawing the minimum point
     * @param gh - graphics
     * @param scaleX - the number by which the variable is incremented along the X axis
     * @param scaleY - the number by which the variable is incremented along the Y axis
     */
    private void showMinDot(Graphics gh,int scaleX,int scaleY){
        Graphics2D g = (Graphics2D)gh;

        double a = Double.parseDouble(MainWindow.getA());
        double b = Double.parseDouble(MainWindow.getB());
        double e = Double.parseDouble(MainWindow.getE());
        double scale = Math.pow(10,3);

        GoldenSection GS = new GoldenSection();
        double xResultMin = Double.parseDouble(GS.findMin(a,b,e));

        double yMin = Math.pow(xResultMin, 4) + 5 * Math.pow(xResultMin, 3) - 10 * xResultMin;
        double yResultMin = (Math.round(yMin * scale) / scale);

        g.setColor(Color.GREEN);
        g.setStroke(new BasicStroke(4));

        g.draw(new Line2D.Double(scaleX * xResultMin + 400,scaleY * yResultMin + 200,
                scaleX * xResultMin + 400,scaleY * yResultMin + 200));
    }
}
