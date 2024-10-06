package Tugas2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankRegistrationForm {

    // Components
    private static JTextField nameField;
    private static JList<String> savingsTypeList;
    private static JSpinner transactionFrequencySpinner;
    private static JPasswordField passwordField;
    private static JPasswordField confirmPasswordField;
    private static JSpinner birthDateSpinner;
    private static JTextArea outputArea;

    private static void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Bank Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        resetMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(resetMenuItem);
        menu.add(exitMenuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // Form Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        // Name input
        panel.add(new JLabel("Name:"));
        nameField = new JTextField(20);
        panel.add(nameField);

        // Savings Type input
        panel.add(new JLabel("Savings Type:"));
        String[] savingsTypes = {"Regular", "Premium", "Student", "Business"};
        savingsTypeList = new JList<>(savingsTypes);
        savingsTypeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(new JScrollPane(savingsTypeList));

        // Transaction Frequency input
        panel.add(new JLabel("Transactions per month:"));
        SpinnerModel transactionFrequencyModel = new SpinnerNumberModel(1, 1, 100, 1);
        transactionFrequencySpinner = new JSpinner(transactionFrequencyModel);
        panel.add(transactionFrequencySpinner);

        // Password input
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(20);
        panel.add(passwordField);

        // Confirm Password input
        panel.add(new JLabel("Confirm Password:"));
        confirmPasswordField = new JPasswordField(20);
        panel.add(confirmPasswordField);

        // Birth Date input
        panel.add(new JLabel("Birth Date:"));
        SpinnerDateModel birthDateModel = new SpinnerDateModel();
        birthDateSpinner = new JSpinner(birthDateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(birthDateSpinner, "dd/MM/yyyy");
        birthDateSpinner.setEditor(dateEditor);
        panel.add(birthDateSpinner);

        // Output Area
        outputArea = new JTextArea(5, 30);
        outputArea.setEditable(false);

        // Button to Submit the Form
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });

        // Adding components to the frame
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(new JScrollPane(outputArea), BorderLayout.SOUTH);
        frame.getContentPane().add(submitButton, BorderLayout.NORTH);

        // Display the frame
        frame.setVisible(true);
    }

    // Method to handle form submission
    private static void submitForm() {
        String name = nameField.getText();
        String savingsType = savingsTypeList.getSelectedValue();
        int transactionFrequency = (int) transactionFrequencySpinner.getValue();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (password.equals(confirmPassword)) {
            outputArea.setText("Registration Successful!\n");
            outputArea.append("Name: " + name + "\n");
            outputArea.append("Savings Type: " + savingsType + "\n");
            outputArea.append("Transactions per month: " + transactionFrequency + "\n");
            outputArea.append("Birth Date: " + birthDateSpinner.getValue() + "\n");
        } else {
            outputArea.setText("Passwords do not match!\n");
        }
    }

    // Method to reset the form
    private static void resetForm() {
        nameField.setText("");
        savingsTypeList.clearSelection();
        transactionFrequencySpinner.setValue(1);
        passwordField.setText("");
        confirmPasswordField.setText("");
        birthDateSpinner.setValue(new java.util.Date());
        outputArea.setText("");
    }

    public static void main(String[] args) {
        // Schedule a job for the event dispatch thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
