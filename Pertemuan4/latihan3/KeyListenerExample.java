import javax.swing.*;
import java.awt.event.*;

public class KeyListenerExample {
    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame(title: "KeyListener Example");

        // Membuat label untuk menampilkan pesan
        JLabel label = new JLabel(text: "Tekan tombol pada keyboard.");
        label.setBounds(x: 50, y: 50, width: 300, height: 30);

        // Membuat text field untuk fokus keyboard
        JTextField textField = new JTextField();
        textField.setBounds(x: 50, y: 100, width: 200, height: 30);

        // Menambahkan KeyListener ke text field
        textField.addKeyListener(new KeyListener() {
            // Dijalankan ketika tombol ditekan
            public void keyPressed(KeyEvent e) {
                label.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            // Dijalankan ketika tombol dilepaskan
            public void keyReleased(KeyEvent e) {
                label.setText("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            // Dijalankan ketika tombol ditekan dan dilepaskan (sama dengan mengetik karakter)
            public void keyTyped(KeyEvent e) {
                label.setText("Key Typed: " + e.getKeyChar());
            }
        });

        // Menambahkan komponen ke frame
        frame.add(label);
        frame.add(textField);

        // Setting frame
        frame.setSize(width: 400, height: 200);
        frame.setLayout(null);
        frame.setVisible(b: true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
