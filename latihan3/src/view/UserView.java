package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import model.User;

public class UserView extends JFrame {
    private JProgressBar progressBar;
    private JButton loadButton;
    private JLabel statusLabel;
    private JTable userTable;
    private DefaultTableModel tableModel;

    public UserView() {
        setTitle("User Management");
        setSize(600, 400); // Ukuran frame lebih besar untuk menampung tabel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Komponen
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        loadButton = new JButton("Load Users");

        statusLabel = new JLabel("Tekan tombol untuk mulai", JLabel.CENTER);

        // Tabel untuk menampilkan pengguna
        String[] columnNames = {"ID", "Nama", "Email"};
        tableModel = new DefaultTableModel(columnNames, 0);
        userTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(userTable);

        // Tambahkan komponen ke frame
        add(statusLabel, BorderLayout.NORTH);
        add(progressBar, BorderLayout.SOUTH);
        add(loadButton, BorderLayout.PAGE_END);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    public void updateProgress(int progress) {
        progressBar.setValue(progress);
        statusLabel.setText("Memuat data: " + progress + "% selesai");
    }

    public void showCompletionMessage(String message) {
        statusLabel.setText(message);
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public void displayUsers(List<User> users) {
        // Hapus semua baris yang ada sebelumnya
        tableModel.setRowCount(0);

        // Tambahkan data pengguna ke tabel
        for (User user : users) {
            Object[] row = {user.getId(), user.getName(), user.getEmail()};
            tableModel.addRow(row);
        }

        showCompletionMessage("Data berhasil dimuat (" + users.size() + " pengguna)");
    }
}
