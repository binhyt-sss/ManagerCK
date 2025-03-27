package com.cgm.circleK.ui;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.cgm.circleK.usecase.CheckHangHoaHetHanUseCase;

public class CheckHangHoaHetHanView extends JFrame {

    private JTable table;
    private CheckHanghoaPresenter presenter; 
    private JButton backButton;
    private ProductManagementView productManagementView; 

    // Constructor
    public CheckHangHoaHetHanView(ProductManagementView productManagementView) {
        this.productManagementView = productManagementView; 
        setTitle("Danh Sách Sản Phẩm Gần Hết Hạn");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setSize(800, 600);
        setLayout(new BorderLayout());

        CheckHangHoaHetHanUseCase useCase = new CheckHangHoaHetHanUseCase();
        presenter = new CheckHanghoaPresenter(this, useCase);

        // Setup UI components
        JPanel mainPanel = new JPanel(new BorderLayout());
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        backButton = new JButton("Quay Lại");
        backButton.addActionListener(e -> goBackToProductManagement());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH); 
        add(mainPanel, BorderLayout.CENTER);
        presenter.fetchAndDisplayExpiringProducts();
    }
    private void goBackToProductManagement() {
        this.setVisible(false); 
        productManagementView.setVisible(true); 
    }
    public void displayProducts(List<String[]> expiringProducts) {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Mã Hàng");
        columnNames.add("Tên Hàng");
        columnNames.add("Số Lượng Tồn");
        columnNames.add("Đơn Giá");
        columnNames.add("Phí VAT");
        columnNames.add("Ngày Hết Hạn");

        Vector<Vector<Object>> data = new Vector<>();
        for (String[] product : expiringProducts) {
            Vector<Object> row = new Vector<>();
            for (String detail : product) {
                row.add(detail.trim());
            }
            data.add(row);
        }

        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
