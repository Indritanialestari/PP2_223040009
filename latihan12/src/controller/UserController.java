package controller;

import model.User;
import model.UserMapper;
import view.UserPdf;
import view.UserView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserController {
    private final UserView view;
    private final UserMapper mapper;
    private final UserPdf pdf;

    // Constructor
    public UserController(UserView view, UserMapper mapper, UserPdf pdf) {
        this.view = view;
        this.mapper = mapper;
        this.pdf = pdf;

        // Register listeners
        this.view.addExportListener(new ExportListener());
        this.view.addAddUserListener(new AddUserListener());
        this.view.addRefreshListener(new RefreshListener());
    }

    // Listener for adding a user
    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameInput();
            String email = view.getEmailInput();

            if (!name.isEmpty() && !email.isEmpty()) {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                mapper.insertUser(user);
                JOptionPane.showMessageDialog(view, "User added successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
            }
        }
    }

    // Listener for refreshing user list
    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<User> users = mapper.getAllUsers();
            String[] userArray = users.stream()
                .map(u -> u.getName() + " (" + u.getEmail() + ")")
                .toArray(String[]::new);
            view.setUserList(userArray);
        }
    }

    // Listener for exporting user list to PDF
    class ExportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<User> users = mapper.getAllUsers();
            pdf.exportPdf(users);
            JOptionPane.showMessageDialog(view, "PDF export completed.");
        }
    }
}
