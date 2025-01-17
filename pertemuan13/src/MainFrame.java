import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class MainFrame {
    public static void main(String[] args) {
        // Membuat Frame Utama
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Contoh Konkurensi di Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new BorderLayout());

            // Label untuk Status
            JLabel statusLabel = new JLabel("Tekan tombol untuk memulai tugas berat", JLabel.CENTER);

            // Progress Bar
            JProgressBar progressBar = new JProgressBar(0, 100);
            progressBar.setValue(0);
            progressBar.setStringPainted(true);

            // Tombol aksi
            JButton startButton = new JButton("Mulai");
            startButton.addActionListener(e -> {
                startButton.setEnabled(false); // Nonaktifkan tombol saat proses berjalan
                statusLabel.setText("Proses berjalan...");

                // Buat SwingWorker untuk menangani tugas berat
                SwingWorker<Void, Integer> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        // Simulasi tugas berat
                        for (int i = 0; i <= 100; i++) {
                            Thread.sleep(50); // Simulasi delay
                            publish(i); // Perbarui progress
                        }
                        return null;
                    }

                    @Override
                    protected void process(List<Integer> chunks) {
                        // Perbarui progress bar
                        int latestProgress = chunks.get(chunks.size() - 1);
                        progressBar.setValue(latestProgress);
                    }

                    @Override
                    protected void done() {
                        // Aksi setelah tugas selesai
                        startButton.setEnabled(true);
                        statusLabel.setText("Proses selesai");
                    }
                };

                // Jalankan SwingWorker
                worker.execute();
            });

            // Tambahkan komponen ke frame
            frame.add(statusLabel, BorderLayout.NORTH);
            frame.add(progressBar, BorderLayout.CENTER);
            frame.add(startButton, BorderLayout.SOUTH);

            // Tampilkan frame
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
