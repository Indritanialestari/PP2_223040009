import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManajemenPelangganHotel extends JFrame {
    private JTextField txtNama, txtKontak;
    private JTextArea txtCatatan;
    private JRadioButton rbLaki, rbPerempuan;
    private JCheckBox cbLangganan;
    private JComboBox<String> cbTipePelanggan;
    private JList<String> listKamarno;
    private JTable tablePelanggan;
    private DefaultTableModel tableModel;
    private JSlider sliderKepuasan;
    private JSpinner spinnerTransaksi;

    public ManajemenPelangganHotel() {
        setTitle("Aplikasi Manajemen Data Pelanggan");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Navigasi");
        JMenuItem menuDashboard = new JMenuItem("Dashboard");
        JMenuItem menuLaporan = new JMenuItem("Laporan");
        menu.add(menuDashboard);
        menu.add(menuLaporan);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Panel Input
        JPanel panelInput = new JPanel(new GridLayout(11, 2));

        panelInput.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelInput.add(txtNama);

        panelInput.add(new JLabel("Kontak:"));
        txtKontak = new JTextField();
        panelInput.add(txtKontak);

        panelInput.add(new JLabel("Jenis Kelamin:"));
        JPanel panelGender = new JPanel();
        rbLaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");
        ButtonGroup bgGender = new ButtonGroup();
        bgGender.add(rbLaki);
        bgGender.add(rbPerempuan);
        panelGender.add(rbLaki);
        panelGender.add(rbPerempuan);
        panelInput.add(panelGender);

        panelInput.add(new JLabel("Langganan Bulanan:"));
        cbLangganan = new JCheckBox();
        panelInput.add(cbLangganan);

        panelInput.add(new JLabel("Tipe Pelanggan:"));
        cbTipePelanggan = new JComboBox<>(new String[]{"Reguler", "Premium"});
        panelInput.add(cbTipePelanggan);

        panelInput.add(new JLabel("Kamar No:"));
        listKamarno = new JList<>(new String[]{"Kamar 1", "Kamar 2", "Kamar 3"});
        listKamarno.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        panelInput.add(new JScrollPane(listKamarno));

        panelInput.add(new JLabel("Catatan:"));
        txtCatatan = new JTextArea(3, 20);
        panelInput.add(new JScrollPane(txtCatatan));

        panelInput.add(new JLabel("Tingkat Kepuasan:"));
        sliderKepuasan = new JSlider(0, 100, 50);  // nilai mulai dari 0 hingga 100, default di 50
        sliderKepuasan.setMajorTickSpacing(25);
        sliderKepuasan.setPaintTicks(true);
        sliderKepuasan.setPaintLabels(true);
        panelInput.add(sliderKepuasan);

        panelInput.add(new JLabel("Jumlah Transaksi:"));
        spinnerTransaksi = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1)); // nilai mulai dari 1 hingga 100
        panelInput.add(spinnerTransaksi);

        JButton btnTambah = new JButton("Tambah Data");
        JButton btnHapus = new JButton("Hapus Data");
        panelInput.add(btnTambah);
        panelInput.add(btnHapus);

        add(panelInput, BorderLayout.WEST);

        // Tabel
        String[] columnNames = {"Nama", "Kontak", "Jenis Kelamin", "Tipe", "Kamar No", "Catatan", "Kepuasan", "Transaksi"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tablePelanggan = new JTable(tableModel);
        add(new JScrollPane(tablePelanggan), BorderLayout.CENTER);

        // Aksi tombol Tambah Data
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txtNama.getText();
                String kontak = txtKontak.getText();
                String gender = rbLaki.isSelected() ? "Laki-laki" : rbPerempuan.isSelected() ? "Perempuan" : "";
                String tipe = (String) cbTipePelanggan.getSelectedItem();
                String kamarNo = String.join(", ", listKamarno.getSelectedValuesList());
                String catatan = txtCatatan.getText();
                int kepuasan = sliderKepuasan.getValue();
                int transaksi = (int) spinnerTransaksi.getValue();

                tableModel.addRow(new Object[]{nama, kontak, gender, tipe, kamarNo, catatan, kepuasan, transaksi});

                // Reset input fields
                txtNama.setText("");
                txtKontak.setText("");
                bgGender.clearSelection();
                cbLangganan.setSelected(false);
                cbTipePelanggan.setSelectedIndex(0);
                listKamarno.clearSelection();
                txtCatatan.setText("");
                sliderKepuasan.setValue(50);
                spinnerTransaksi.setValue(1);
            }
        });

        // Aksi tombol Hapus Data
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablePelanggan.getSelectedRow();
                if (selectedRow != -1) {  // Pastikan ada baris yang dipilih
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ManajemenPelangganHotel().setVisible(true);
        });
    }
}

