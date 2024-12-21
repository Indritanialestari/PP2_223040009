package main;

import model.EmployeeMapper;
import model.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import view.EmployeeView;
import controller.EmployeeController;

public class Main {
    public static void main(String[] args) {
        // Membuka session MyBatis
        SqlSession session = MyBatisUtil.getSqlSession();
        
        try {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            // Membuat tampilan dan controller
            EmployeeView view = new EmployeeView();
            new EmployeeController(view, mapper);

            // Menampilkan tampilan GUI
            view.setVisible(true);
        } finally {
            MyBatisUtil.closeSqlSession(session);
        }
    }
}
