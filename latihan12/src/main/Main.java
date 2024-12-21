package main;

import model.MyBatisUtil;
import model.UserMapper;
import org.apache.ibatis.session.SqlSession;
import view.UserView;
import view.UserPdf;
import controller.UserController;

public class Main {
    public static void main(String[] args) {
        // Membuka sesi MyBatis
        SqlSession session = MyBatisUtil.getSqlSession();

        // Mendapatkan mapper dari sesi MyBatis
        UserMapper mapper = session.getMapper(UserMapper.class);

        // Membuat instance UserView, UserPdf, dan UserController
        UserView view = new UserView();
        UserPdf pdf = new UserPdf();
        new UserController(view, mapper, pdf);

        // Menampilkan UserView
        view.setVisible(true);
    }
}
