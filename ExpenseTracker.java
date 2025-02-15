import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ExpenseTracker extends JFrame {
    private JTextField binaryInput, decimalOutput;
    private JTextField amountInput, categoryInput, dateInput;
    private JTextArea reportArea;
    private List<String> expenses;

    public ExpenseTracker() {
        setTitle("Binary Converter & Expense Manager");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        expenses = new ArrayList<>();

        // Binary Converter Panel
        JPanel binaryPanel = new JPanel();
        binaryPanel.add(new JLabel("Binary:"));
        binaryInput = new JTextField(10);
        binaryPanel.add(binaryInput);
        JButton convertButton = new JButton("Convert");
        binaryPanel.add(convertButton);
        decimalOutput = new JTextField(10);
        decimalOutput.setEditable(false);
        binaryPanel.add(new JLabel("Decimal:"));
        binaryPanel.add(decimalOutput);
        convertButton.addActionListener(e -> convertBinary());
        add(binaryPanel);

        // Expense Management Panel
        JPanel expensePanel = new JPanel();
        expensePanel.add(new JLabel("Amount:"));
        amountInput = new JTextField(5);
        expensePanel.add(amountInput);
        expensePanel.add(new JLabel("Category:"));
        categoryInput = new JTextField(10);
        expensePanel.add(categoryInput);
        expensePanel.add(new JLabel("Date:"));
        dateInput = new JTextField(10);
        expensePanel.add(dateInput);
        JButton addExpenseButton = new JButton("Add Expense");
        expensePanel.add(addExpenseButton);
        addExpenseButton.addActionListener(e -> addExpense());
        add(expensePanel);

        // Report Panel
        JPanel reportPanel = new JPanel();
        reportArea = new JTextArea(5, 30);
        reportPanel.add(new JScrollPane(reportArea));
        JButton generateReportButton = new JButton("Generate Report");
        reportPanel.add(generateReportButton);
        generateReportButton.addActionListener(e -> generateReport());
        add(reportPanel);
    }

    private void convertBinary() {
        try {
            int decimal = Integer.parseInt(binaryInput.getText(), 2);
            decimalOutput.setText(String.valueOf(decimal));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid binary number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addExpense() {
        String expense = "Amount: " + amountInput.getText() + ", Category: " + categoryInput.getText() + ", Date: " + dateInput.getText();
        expenses.add(expense);
        JOptionPane.showMessageDialog(this, "Expense added successfully");
    }

    private void generateReport() {
        StringBuilder report = new StringBuilder("Expenses:\n");
        for (String expense : expenses) {
            report.append(expense).append("\n");
        }
        reportArea.setText(report.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ExpenseTracker().setVisible(true));
    }
}