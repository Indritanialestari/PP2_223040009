import controller.UserController;
import model.MyBatisUtil;
import model.UserMapper;
import view.UserView;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserView view = new UserView();
            UserController controller = new UserController(view);
            
            // Aksi tombol untuk memuat pengguna
            view.getLoadButton().addActionListener(e -> controller.loadUsers());

            view.setVisible(true);
        });
    }
}
