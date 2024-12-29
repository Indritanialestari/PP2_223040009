package controller;

import model.MyBatisUtil;
import model.User;
import model.UserMapper;
import view.UserView;

import javax.swing.SwingWorker;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class UserController {
    private UserView view;

    public UserController(UserView view) {
        this.view = view;
    }

    public void loadUsers() {
        // Gunakan SwingWorker untuk menjalankan proses berat di latar belakang
        SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            private List<User> users;
            private Exception error;

            @Override
            protected Void doInBackground() throws Exception {
                try (SqlSession session = MyBatisUtil.getSession()) {
                    UserMapper mapper = session.getMapper(UserMapper.class);

                    // Ambil semua data dari database
                    users = mapper.getAllUsers();

                    int totalUsers = (users != null) ? users.size() : 0;
                    if (totalUsers > 0) {
                        for (int i = 0; i < totalUsers; i++) {
                            // Simulasi proses berat
                            Thread.sleep(50); // Simulasi waktu proses
                            publish((i + 1) * 100 / totalUsers); // Publikasikan progres
                        }
                    } else {
                        publish(100); // Progres selesai meskipun tidak ada data
                    }
                } catch (Exception e) {
                    error = e; // Simpan error untuk ditangani di `done`
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                // Perbarui progres di view
                int progress = chunks.get(chunks.size() - 1);
                view.updateProgress(progress);
            }

            @Override
            protected void done() {
                if (error != null) {
                    error.printStackTrace();
                    view.showCompletionMessage("Terjadi kesalahan: " + error.getMessage());
                } else if (users != null && !users.isEmpty()) {
                    view.displayUsers(users);
                    view.showCompletionMessage("Data berhasil dimuat!");
                } else {
                    view.showCompletionMessage("Tidak ada data pengguna ditemukan.");
                }
            }
        };

        worker.execute(); // Jalankan worker
    }
}
