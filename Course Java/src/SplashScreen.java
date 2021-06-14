import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class will display the initial window with the ability to navigate to MainWindow
 * @author Milyuk V.P.
 * @version 1.0.0.2021
 */
public class SplashScreen extends JFrame {
    private JLabel lbForUniversityName;
    private JLabel lbForFacultyName;
    private JLabel lbForChairName;
    private JLabel lbCourse;
    private JLabel lbForCourseName;
    private JLabel lbForStudent;
    private JLabel lbForStudentName;
    private JLabel lbForTeacher;
    private JLabel lbForTeacherName;
    private JLabel lbJava;
    private JLabel lbMINSK;
    private JLabel lbForImg;
    private JButton btnNext;
    private JButton btnExit;
    private ImageIcon img;

    /**
     * Constructor for creating an object
     */
    public SplashScreen(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        Font font = new Font("Verdana", Font.PLAIN, 14);

        lbForUniversityName = new JLabel("Белорусский национальный технический университет");
        lbForUniversityName.setFont(font);
        panel.add(lbForUniversityName).setBounds(220,10,600,20);
        lbForFacultyName = new JLabel("Факультет информационных технологий и робототехники");
        lbForFacultyName.setFont(font);
        panel.add(lbForFacultyName).setBounds(200,50,600,20);
        lbForChairName = new JLabel("Кафедра программного обеспечения информационных систем и технологий");
        lbForChairName.setFont(font);
        panel.add(lbForChairName).setBounds(140,70,600,20);

        font = new Font("Verdana", Font.BOLD, 16);
        lbCourse = new JLabel("Курсовая работа");
        lbCourse.setFont(font);
        panel.add(lbCourse).setBounds(320,160,400,20);

        font = new Font("Verdana", Font.PLAIN, 14);
        lbJava = new JLabel("по дисциплине «Программирование на Java»");
        lbJava.setFont(font);
        panel.add(lbJava).setBounds(240,180,400,20);

        font = new Font("Verdana", Font.BOLD, 18);
        lbForCourseName = new JLabel("Поиск экстремумов функций методом золотого сечения");
        lbForCourseName.setFont(font);
        panel.add(lbForCourseName).setBounds(120,220,700,20);

        img = new ImageIcon("D:\\Study\\Course Java\\src\\pictures\\method.png");
        lbForImg = new JLabel(img);
        panel.add(lbForImg).setBounds(10,240,350,320);

        font = new Font("Verdana", Font.PLAIN, 14);
        lbForStudent = new JLabel("Выполнил: Студент группы 10702318");
        lbForStudent.setFont(font);
        panel.add(lbForStudent).setBounds(450,300,400,20);

        font = new Font("Verdana", Font.BOLD, 14);
        lbForStudentName = new JLabel("Милюк Вадим Павлович");
        lbForStudentName.setFont(font);
        panel.add(lbForStudentName).setBounds(450,320,400,20);

        font = new Font("Verdana", Font.PLAIN, 14);
        lbForTeacher = new JLabel("Преподаватель: к.ф.-м.н.доц.");
        lbForTeacher.setFont(font);
        panel.add(lbForTeacher).setBounds(450,420,400,20);

        font = new Font("Verdana", Font.BOLD, 14);
        lbForTeacherName = new JLabel("Сидорик Валерий Владимирович");
        lbForTeacherName.setFont(font);
        panel.add(lbForTeacherName).setBounds(450,440,400,20);

        lbMINSK = new JLabel("Минск, 2021");
        lbMINSK.setFont(font);
        panel.add(lbMINSK).setBounds(330,535,200,20);

        btnNext = new JButton("Далее");

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainWindow();
                frame.setVisible(false);
            }
        });

        btnNext.setFont(font);
        btnNext.setSize(200,30);
        panel.add(btnNext).setBounds(85,570,200,30);

        btnExit = new JButton("Выход");

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnExit.setFont(font);
        btnExit.setSize(200,30);
        panel.add(btnExit).setBounds(485,570,200,30);

        panel.setLayout(null);
        frame.add(panel);

        frame.setIconImage(new ImageIcon("D:\\Study\\Course Java\\src\\pictures\\icon.jpg").getImage());
        frame.setSize(800,650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
