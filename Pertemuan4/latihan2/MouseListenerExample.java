import java.awt.event.*;
import javax.swing.*;

public class MouseListenerExample {
    public static void main(String[] args) {
        //Membuat frame
        JFrame frame = new JFrame("MouseListener Example");

        //Membuat label untuk menampilkan pesan
        JLabel label = new JLabel("Arahkan dan klik mouse pada area ini.");
        label.setBounds(50, 50, 300, 30);

        //Menambahkan MouseListener ke label
        label.addMouseListener(new MouseListener() {
            //Dijalankan ketika mouse diklik (klik kiri, kanan atau tengah)
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked at: ("+ e.getX() + ", " + e.getY() + ")");
            }

            //Dijalankan ketika mouse ditekan (tanpa dilepaskan)
            @Override
            public void mousePressed(MouseEvent e) {
                label.setText("Mouse Pressed at: ("+ e.getX() + ", " + e.getY() + ")");
            }

            //Dijalankan ketika mouse dilepaskan setelah ditekan
            @Override
            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse Released at: ("+ e.getX() + ", " + e.getY() + ")");
            }

            //Dijalankan ketika mouse masuk ke area komponen
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse Entered at: ("+ e.getX() + ", " + e.getY() + ")");
            }

            //Dijalankan ketika mouse keluar dari area komponen
            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("Mouse Exited at: ("+ e.getX() + ", " + e.getY() + ")");
            }
        });

        //Menambahkan label ke frame
        frame.add(label);

        //setting frame
        frame.setSize(400,200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
