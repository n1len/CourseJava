import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Class AboutProgram inherited from JFrame
 * @author Milyuk V.P.
 * @version 1.0.0.2021
 */
public class AboutProgram extends JFrame {
    private JLabel lbForWhatProgramCanDo;
    private JLabel lbForMethodName;
    private JLabel lbForVersion;
    private JLabel lbList1;
    private JLabel lbList2;
    private JLabel lbList3;
    private JLabel lbList4;
    private JLabel lbForImg;
    private ImageIcon img;
    private JButton btnBack;

    /**
     * Constructor for creating an object
     */
    public AboutProgram(){
        JFrame frame = new JFrame("About Program");
        JPanel panel = new JPanel();

        Font font = new Font("Verdana", Font.BOLD, 18);

        lbForMethodName = new JLabel("Поиск экстремумов функций методом золотого сечения");
        lbForMethodName.setFont(font);
        panel.add(lbForMethodName).setBounds(50,10,600,40);

        img = new ImageIcon("D:\\Study\\Course Java\\src\\pictures\\method.png");
        lbForImg = new JLabel(img);
        panel.add(lbForImg).setBounds(10,50,200,310);

        font = new Font("Verdana", Font.BOLD, 14);
        lbForWhatProgramCanDo = new JLabel("Программа позволяет");
        lbForWhatProgramCanDo.setFont(font);
        panel.add(lbForWhatProgramCanDo).setBounds(240,50,400,20);

        font = new Font("Verdana", Font.PLAIN, 14);
        lbList1 = new JLabel("1. Находить максимум и минимум функции");
        lbList1.setFont(font);
        panel.add(lbList1).setBounds(240,90,400,20);

        lbList2 = new JLabel("(Отрезок задаётся и вводится пользователем)");
        lbList2.setFont(font);
        panel.add(lbList2).setBounds(240,110,400,20);

        lbList3 = new JLabel("2. Отрисовать график функции на отрезке, заданном пользователем");
        lbList3.setFont(font);
        panel.add(lbList3).setBounds(240,150,600,20);

        lbList4 = new JLabel("3. Вывести на экран найденные значения максимума и минимума");
        lbList4.setFont(font);
        panel.add(lbList4).setBounds(240,190,600,20);

        font = new Font("Verdana", Font.BOLD, 16);
        lbForVersion = new JLabel("Версия программы: ver. 1.0.0.2021");
        lbForVersion.setFont(font);
        panel.add(lbForVersion).setBounds(300,250,400,20);

        btnBack = new JButton("Назад");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainWindow();
                frame.setVisible(false);
            }
        });

        font = new Font("Verdana", Font.PLAIN, 15);
        btnBack.setSize(100,30);
        btnBack.setFont(font);
        panel.add(btnBack).setBounds(400,300,100,30);

        panel.setLayout(null);
        frame.add(panel);

        frame.setIconImage(new ImageIcon("D:\\Study\\Course Java\\src\\pictures\\icon.jpg").getImage());
        frame.setSize(800,400);
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
