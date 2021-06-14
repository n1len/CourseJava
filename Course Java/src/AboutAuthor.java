import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Class AboutAuthor inherited from JFrame
 * @author Milyuk V.P.
 * @version 1.0.0.2021
 */
public class AboutAuthor extends JFrame {
    private JLabel lbAuthor;
    private JLabel lbStudent;
    private JLabel lbStudentName;
    private JLabel lbForEmail;
    private JLabel lbForImg;
    private JButton btnBack;
    private ImageIcon img;

    /**
     * Constructor for creating an object
     */
    public AboutAuthor(){
        JFrame frame = new JFrame("About Author");
        JPanel panel = new JPanel();

        img = new ImageIcon("D:\\Study\\Course Java\\src\\pictures\\author.png");
        lbForImg = new JLabel(img);
        panel.add(lbForImg).setBounds(25,10,230,300);

        Font font = new Font("Verdana", Font.BOLD, 18);
        lbAuthor = new JLabel("Автор");
        lbAuthor.setFont(font);
        panel.add(lbAuthor).setBounds(110,320,100,20);

        font = new Font("Verdana", Font.PLAIN, 14);
        lbStudent = new JLabel("Студент группы 10702318");
        lbStudent.setFont(font);
        panel.add(lbStudent).setBounds(25,340,300,20);

        font = new Font("Verdana", Font.BOLD, 15);
        lbStudentName = new JLabel("Милюк Вадим Павлович");
        lbStudentName.setFont(font);
        panel.add(lbStudentName).setBounds(25,360,300,20);

        font = new Font("Verdana", Font.PLAIN, 14);
        lbForEmail = new JLabel("vadimmilyuk1@gmail.com");
        lbForEmail.setFont(font);
        panel.add(lbForEmail).setBounds(25,380,300,20);

        btnBack = new JButton("Назад");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainWindow();
                frame.setVisible(false);
            }
        });

        btnBack.setFont(font);
        btnBack.setSize(90,30);
        panel.add(btnBack).setBounds(70,420,150,30);

        panel.setLayout(null);
        frame.add(panel);

        frame.setIconImage(new ImageIcon("D:\\Study\\Course Java\\src\\pictures\\icon.jpg").getImage());
        frame.setSize(300,500);
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
