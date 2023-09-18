import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Captcha extends JFrame {

    private JLabel captchaLabel;
    private JTextField captchaTextField;
    private JButton generateButton;
    private String generatedCaptcha;
    private JButton clearButton;

    public Captcha() {
        setTitle("CAPTCHA Security Engine");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        captchaLabel = new JLabel();
        captchaLabel.setFont(new Font("Arial", Font.BOLD, 20));
        captchaLabel.setForeground(Color.BLACK);
        //captchaLabel.getBorder(Color.BLUE);
        captchaTextField = new JTextField(50);
        generateButton = new JButton("Generate ");
        generateButton.setForeground(Color.BLACK);
        generateButton.setFont(new Font("Arial", Font.ITALIC, 30));
        clearButton = new JButton("Clear ");
        clearButton.setForeground(Color.BLACK);
        clearButton.setFont(new Font("Arial", Font.ITALIC, 30));
       
        clearButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                captchaTextField.setText("");
                
                
             }
            
        });
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generatedCaptcha = generateCaptcha();
                captchaLabel.setText(generatedCaptcha);
           
            }
        });

        JPanel panel = new JPanel();
        panel.add(captchaLabel);
        panel.add(captchaTextField);
        panel.add(generateButton);
        panel.add(clearButton);

        add(panel);
    }

    private String generateCaptcha() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        StringBuilder captcha = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 7; i++) {
            char c = characters.charAt(rnd.nextInt(characters.length()));
            captcha.append(c);
        }

        return captcha.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Captcha().setVisible(true);
            }
        });
    }
}


