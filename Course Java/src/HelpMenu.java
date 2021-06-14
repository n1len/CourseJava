import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class HelpMenu inherited from JFrame
 * @author Milyuk V.P.
 * @version 1.0.0.2021
 */
public class HelpMenu extends JFrame {
    private JLabel lbAboutA;
    private JLabel lbAboutB;
    private JLabel lbAboutE;
    private JButton btnBack;

    /**
     * Constructor for creating an object
     */
    public HelpMenu(){
        JFrame frame = new JFrame("Help");
        JPanel panel = new JPanel();

        Font font = new Font("Verdana", Font.PLAIN, 16);

        lbAboutA = new JLabel("a - левое значение начального отрезка");
        lbAboutA.setFont(font);
        panel.add(lbAboutA).setBounds(30,20,400,40);

        lbAboutB = new JLabel("b - правое значение начального отрезка");
        lbAboutB.setFont(font);
        panel.add(lbAboutB).setBounds(30,80,400,40);

        lbAboutE = new JLabel("e - точность для вычисления метода");
        lbAboutE.setFont(font);
        panel.add(lbAboutE).setBounds(30,140,400,40);

        btnBack = new JButton("Назад");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainWindow();
                frame.setVisible(false);
            }
        });
        btnBack.setSize(100,30);
        btnBack.setFont(font);
        panel.add(btnBack).setBounds(190,200,100,30);

        panel.setLayout(null);
        frame.add(panel);

        frame.setIconImage(new ImageIcon("D:\\Study\\Course Java\\src\\pictures\\icon.jpg").getImage());
        frame.setSize(500,280);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new MainWindow();
            }
        });
        frame.setVisible(true);
    }
}
