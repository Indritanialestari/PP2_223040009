import javax.swing.*;
import java.awt.*;

public class BiodataForm extends JFrame {
    
    public BiodataForm() {
        setTitle("Form Biodata");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Letakkan di tengah layar

        // Panel untuk nama
        JPanel panelNama = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNama.add(new JLabel("Nama:"));
        panelNama.add(new JTextField(15));
        
        // Panel untuk nomor HP
        JPanel panelHP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelHP.add(new JLabel("Nomor HP:"));
        panelHP.add(new JTextField(15));
        
        // Panel untuk jenis kelamin
        JPanel panelJK = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelJK.add(new JLabel("Jenis Kelamin:"));
        
        JRadioButton rbLaki = new JRadioButton("Laki-Laki");
        JRadioButton rbPerempuan = new JRadioButton("Perempuan");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbLaki);
        bg.add(rbPerempuan);
        
        panelJK.add(rbLaki);
        panelJK.add(rbPerempuan);
        
        // Panel untuk warga negara asing
        JPanel panelWNA = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox cbWNA = new JCheckBox("Warga Negara Asing");
        panelWNA.add(cbWNA);
        
        // Panel tombol
        JPanel panelTombol = new JPanel();
        JButton btnSimpan = new JButton("Simpan");
        panelTombol.add(btnSimpan);
        
        // Panel utama untuk mengatur layout
        JPanel panelUtama = new JPanel(new GridLayout(5, 1, 10, 10));
        panelUtama.add(panelNama);
        panelUtama.add(panelHP);
        panelUtama.add(panelJK);
        panelUtama.add(panelWNA);
        panelUtama.add(panelTombol);
        
        // Tambahkan panel utama ke frame
        add(panelUtama);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new BiodataForm();
    }
}
