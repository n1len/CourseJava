import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Main window for working with the program
 * Class MainWindow inherited from JFrame
 * @author Milyuk V.P.
 * @version 1.0.0.2021
 */
public class MainWindow extends JFrame{
    private static JTextField tfA;
    private static JTextField tfB;
    private static JTextField tfE;
    private JLabel lbA;
    private JLabel lbB;
    private JLabel lbE;
    private JLabel resultMin;
    private JLabel resultMax;
    private JLabel lbTab;
    private JButton btnPaint;
    private JButton btnFindMax;
    private JButton btnFindMin;
    private JButton btnPaintDots;
    private static boolean btnFindMaxTrue;
    private static boolean btnFindMinTrue;

    /**
     * Constructor for creating an object
     */
    public MainWindow() {
        JFrame frame = new JFrame("Метод золотого сечения");
        Container contentPane = frame.getContentPane();

        JPanel panel5 = new JPanel(new BorderLayout());
        panel5.add(new DrawingComponent());
        contentPane.add(panel5,BorderLayout.CENTER);

        JPanel panel1 = new JPanel(new GridLayout(4,2,120,80));

        lbA = new JLabel("Введите a: ");
        panel1.add(lbA);

        tfA = new JTextField("-4.2");
        panel1.add(tfA);

        lbB = new JLabel("Введите b: ");
        panel1.add(lbB);

        tfB = new JTextField("1");
        panel1.add(tfB);

        lbE = new JLabel("Введите e: ");
        panel1.add(lbE);

        tfE = new JTextField("0.001");
        panel1.add(tfE);

        btnFindMax = new JButton("Найти максимум");
        btnFindMax.setPreferredSize(new Dimension(130, 30));

        btnFindMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GoldenSection GS = new GoldenSection();
                double A = Double.parseDouble(getA());
                double B = Double.parseDouble(getB());
                double E = Double.parseDouble(getE());
                btnFindMaxTrue = true;
                JOptionPane.showMessageDialog(null, "Найден максимум = " + GS.findMax(A,B,E));
                resultMax.setText("Максимум функции = "+ GS.findMax(A,B,E));
            }
        });

        btnFindMin = new JButton("Найти минимум");
        btnFindMin.setPreferredSize(new Dimension(130, 30));

        btnFindMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GoldenSection GS = new GoldenSection();
                double A = Double.parseDouble(getA());
                double B = Double.parseDouble(getB());
                double E = Double.parseDouble(getE());
                btnFindMinTrue = true;
                JOptionPane.showMessageDialog(null, "Найден минимум = " + GS.findMin(A,B,E));
                resultMin.setText("Минимум функции = " + GS.findMin(A,B,E));
            }
        });

        panel1.add(btnFindMax);
        panel1.add(btnFindMin);

        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(panel1);
        contentPane.add(flow,BorderLayout.EAST);

        JPanel panel2 = new JPanel();
        btnPaint = new JButton("Построить график");
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        panel2.setLayout(layout);

        btnPaint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel4 = new JPanel(new BorderLayout());
                panel4.add(new DrawingComponent(),BorderLayout.CENTER);
                contentPane.add(panel4,BorderLayout.CENTER);
                frame.setVisible(true);
                panel5.setVisible(false);
            }
        });

        panel2.add(btnPaint);

        btnPaintDots = new JButton("Отрисовать точки");

        btnPaintDots.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btnFindMaxTrue || btnFindMinTrue){
                    JPanel panel4 = new JPanel(new BorderLayout());
                    panel4.add(new DrawingComponent(),BorderLayout.CENTER);
                    contentPane.add(panel4,BorderLayout.CENTER);
                    frame.setVisible(true);
                    panel5.setVisible(false);
                }else
                    JOptionPane.showMessageDialog(null, "Точки максимума/минимума не найдены");
            }
        });

        panel2.add(btnPaintDots);
        contentPane.add(panel2,BorderLayout.SOUTH);

        JPanel panel3 = new JPanel();
        resultMax = new JLabel("Максимум функции ещё не искался");
        panel3.add(resultMax);
        lbTab = new JLabel("                                    ");
        panel3.add(lbTab);
        resultMin = new JLabel("Минимум функции ещё не искался");
        panel3.add(resultMin);

        contentPane.add(panel3,BorderLayout.NORTH);

        //MenuBar
        MenuBar myMenuBar = new MenuBar();
        Menu myFileMenu = new Menu("File");
        Menu myInformationMenu = new Menu("Information");
        Menu myHelpMenu = new Menu("Help");

        myMenuBar.add(myFileMenu);
        myMenuBar.add(myInformationMenu);
        myMenuBar.add(myHelpMenu);

        MenuItem myFileExitMenuItem = new MenuItem("Exit");
        myFileExitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,"Are u sure?",
                        "Select \"Yes\" or \"No\"",JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

        MenuItem aboutAuthorMenuItem = new MenuItem("About Author");
        aboutAuthorMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AboutAuthor();
                frame.setVisible(false);
            }
        });

        MenuItem aboutProgramMenuItem = new MenuItem("About Program");
        aboutProgramMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AboutProgram();
                frame.setVisible(false);
            }
        });

        MenuItem myHelpMenuItem = new MenuItem("Help");
        myHelpMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HelpMenu();
                frame.setVisible(false);
            }
        });

        MenuItem myVersionMenuItem = new MenuItem("Version");
        myVersionMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Версия программы: ver. 1.0.0.2021","Version",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        myFileMenu.add(myFileExitMenuItem);
        myInformationMenu.add(aboutAuthorMenuItem);
        myInformationMenu.add(aboutProgramMenuItem);
        myHelpMenu.add(myHelpMenuItem);
        myHelpMenu.addSeparator();
        myHelpMenu.add(myVersionMenuItem);

        frame.setMenuBar(myMenuBar);

        frame.setIconImage(new ImageIcon("D:\\Study\\Course Java\\src\\pictures\\icon.jpg").getImage());
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Method for getting data from field A
     * If the field is empty, the value is set to -4.2
     * @return result
     */
    public static String getA(){
        if(tfA.getText().isEmpty()){
            tfA.setText("-4.2");
        }
        return tfA.getText();
    }

    /**
     * Method for getting data from field B
     * If the field is empty, the value is set to 1
     * @return result
     */
    public static String getB(){
        if(tfB.getText().isEmpty()){
            tfB.setText("1");
        }
        return tfB.getText();
    }

    /**
     * Method for getting data from field E
     * If the field is empty, the value is set to 0.001
     * @return result
     */
    public static String getE(){
        if(tfE.getText().isEmpty()){
            tfE.setText("0.001");
        }
        return tfE.getText();
    }

    /**
     * Method for getting data from btnFindMaxTrue
     * @return btnFindMaxTrue
     */
    public static boolean getBoolMax(){
        return btnFindMaxTrue;
    }

    /**
     * Method for getting data from btnFindMinTrue
     * @return btnFindMinTrue
     */
    public static boolean getBoolMin(){
        return btnFindMinTrue;
    }

    /**
     * Method to set the value to false
     */
    public static void setBoolMinToFalse(){
        btnFindMinTrue = false;
    }

    /**
     * Method to set the value to false
     */
    public static void setBoolMaxToFalse(){
        btnFindMaxTrue = false;
    }
}
