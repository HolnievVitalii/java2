import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author holni
 * @version dated August 26, 2019
 */
public class TestChatWindow extends JFrame {

    /**
     * create simple chat window
     */

    public TestChatWindow() {
        setTitle("test chat");
        setBounds(650, 100, 600, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        textArea.setEditable(false);
        textArea.setBackground(Color.green);
        textArea.setToolTipText("your messages will be located here".toUpperCase());
        add(textArea, BorderLayout.CENTER);

        JTextField textField = new JTextField();
        add(textField, BorderLayout.PAGE_END);
        textField.setBackground(Color.green);
        textField.setToolTipText("ENTER YOUR MESSAGE HERE");
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("*Your nickname*: " + textField.getText() + "\n");
                textField.setText("");
            }
        });

        JButton sendButton = new JButton("SEND");
        add(sendButton, BorderLayout.EAST);
        sendButton.setToolTipText("or press ENTER");
        sendButton.setBackground(Color.red);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("*Your nickname*: " + textField.getText() + "\n");
                textField.setText("");
            }
        });
        setVisible(true);

    }
    public static void main(String[] args) {
    new TestChatWindow();
    }
}
