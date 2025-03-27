package com.cgm.circleK.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import com.cgm.circleK.dto.SumTypeInputDTO;
import com.cgm.circleK.database.SumTypeDAOMSSQL;

public class SumTypeView extends JFrame {
    private JComboBox<String> categoryComboBox;
    private JButton calculateButton;
    private JLabel resultLabel;
    private final SumTypeController controller;
    private final SumTypeDAOMSSQL dao;

    public SumTypeView(SumTypeController controller, SumTypeDAOMSSQL dao) {
        this.controller = controller;
        this.dao = dao;
        initializeUI();
        loadCategories();
    }

    private void initializeUI() {
        setTitle("Tính Tổng Sản Phẩm Theo Loại");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

       
        categoryComboBox = new JComboBox<>();

        
        calculateButton = new JButton("Tính Tổng");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String category = (String) categoryComboBox.getSelectedItem();
                SumTypeInputDTO inputDTO = new SumTypeInputDTO(category);
                controller.calculateTotalQuantity(inputDTO);
            }
        });

        
        resultLabel = new JLabel("Kết quả sẽ hiển thị ở đây");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Chọn Loại Hàng:"));
        inputPanel.add(categoryComboBox);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(calculateButton);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        resultPanel.add(resultLabel);

        
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);
    }

    private void loadCategories() {
        List<String> categories = dao.getAllCategories();
        for (String category : categories) {
            categoryComboBox.addItem(category);
        }
    }
    public void displayMessage(String message) {
        resultLabel.setText(message);
    }
    
}
