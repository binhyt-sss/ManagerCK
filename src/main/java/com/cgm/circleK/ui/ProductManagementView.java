package com.cgm.circleK.ui;

import com.cgm.circleK.usecase.AddHangHoaUseCase;
import com.cgm.circleK.usecase.DeleteHangHoaInPutBoundary;
import com.cgm.circleK.usecase.DeleteHangHoaUseCase;
import com.cgm.circleK.usecase.SumTypeUseCase;
import com.cgm.circleK.usecase.UpdateHangHoaInPutBoundary;
import com.cgm.circleK.usecase.UpdateHangHoaUseCase;
import com.cgm.circleK.database.AddHangHoaDAOMSSQL;
import com.cgm.circleK.database.ConnectDBMSSQL;
import com.cgm.circleK.database.DeleteHangHoaDAOMSSQL;
import com.cgm.circleK.database.SumTypeDAOMSSQL;
import com.cgm.circleK.database.UpdateHangHoaDAOMSSQL;
import com.cgm.circleK.ui.AddHangHoaPresenter;
import com.cgm.circleK.ui.AddHangHoaController;
import com.cgm.circleK.ui.DeleteHangHoaController;
import com.cgm.circleK.ui.UpdateHangHoaController;
import com.cgm.circleK.ui.SumTypeController;
import com.cgm.circleK.ui.SumTypeView;
import com.cgm.circleK.ui.SumTypePresenter;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class ProductManagementView extends JFrame {
    private JTable productTable;
    private JButton addButton;
    private JButton sumButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton checkExpireBtn;
    private SumTypeView sumTypeView;
    private final AddHangHoaPresenter addHangHoaPresenter;
    private final AddHangHoaView addHangHoaView;
    private CheckHangHoaHetHanView checkHangHoaHetHanView;
    private final AddHangHoaDAOMSSQL dao;
    private final DeleteHangHoaController deleteHangHoaController;
    private final UpdateHangHoaController updateHangHoaController;


    public ProductManagementView(AddHangHoaPresenter addHangHoaPresenter, AddHangHoaController addHangHoaController, DeleteHangHoaController deleteHangHoaController, UpdateHangHoaController updateHangHoaController,CheckHangHoaHetHanView checkHangHoaHetHanView) {
        this.addHangHoaPresenter = addHangHoaPresenter;
        
        this.dao = new AddHangHoaDAOMSSQL();
        List<String> loaiHangList = dao.getLoaiHangList();
        this.addHangHoaView = new AddHangHoaView(addHangHoaController,loaiHangList);
        this.deleteHangHoaController = deleteHangHoaController;
        this.updateHangHoaController = updateHangHoaController;
        this.checkHangHoaHetHanView = checkHangHoaHetHanView;

        initializeUI();
    }

    private void initializeUI() {
        setTitle("Quản Lý Sản Phẩm");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());

        addButton = new JButton("Thêm");
        editButton = new JButton("Sửa");
        deleteButton = new JButton("Xóa");
        sumButton = new JButton("Tính Tổng");
        checkExpireBtn = new JButton("Kiểm Tra Hết Hạn");
    
        checkExpireBtn.addActionListener(e -> {
            this.setVisible(false); // Hide current window
            checkHangHoaHetHanView.setVisible(true); // Show the "Check Hang Hoa Het Han" view
        });

        addButton.addActionListener(e -> {
            this.setVisible(true);
            addHangHoaView.setVisible(true);
        });
        editButton.addActionListener(e -> {
            try {
                editProduct();
            } catch (SQLException ex) {
                // Hiển thị thông báo lỗi khi xảy ra vấn đề
                ex.printStackTrace(); // In lỗi ra console để kiểm tra
                JOptionPane.showMessageDialog(null, 
                    "Error while editing product: " + ex.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        deleteButton.addActionListener(e -> deleteProduct());
        sumButton.addActionListener(e -> openSumTypeView());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(sumButton);
        buttonPanel.add(checkExpireBtn);

        productTable = new JTable();
        loadTableData();
        JScrollPane tableScrollPane = new JScrollPane(productTable);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void editProduct() throws SQLException {
        if (productTable.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No products available to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product to edit.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        Object maHangObj = productTable.getValueAt(selectedRow, 0);
        if (maHangObj instanceof Integer) {
            int maHang = (Integer) maHangObj;
            UpdateHangHoaView updateView = new UpdateHangHoaView(updateHangHoaController, maHang);
            updateView.setVisible(true);
    
            updateView.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    refreshTable();
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "Invalid data type for MaHang.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteProduct() {
        if (deleteHangHoaController == null) {
            return;
        }
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow != -1) {
            int maHang = (int) productTable.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this product?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                deleteHangHoaController.execute(maHang);
                loadTableData();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void loadTableData() {
        try {
            DefaultTableModel model = dao.loadProductData();
            if (model != null) {
                productTable.setModel(model);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to load product data", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        private void openSumTypeView() {
            if (sumTypeView == null) {
                ConnectDBMSSQL connectDB = new ConnectDBMSSQL();
                try {
                    SumTypeDAOMSSQL sumTypeDAO = new SumTypeDAOMSSQL(connectDB.getConnection());  
                    SumTypePresenter sumTypePresenter = new SumTypePresenter(null);  
                    SumTypeUseCase sumTypeUseCase = new SumTypeUseCase(sumTypeDAO, sumTypePresenter);  
                    SumTypeController sumTypeController = new SumTypeController(sumTypeUseCase);  
                          
                    sumTypeView = new SumTypeView(sumTypeController, sumTypeDAO); 
                    sumTypePresenter.setView(sumTypeView);  
                    sumTypeUseCase.setOutputBoundary(sumTypePresenter);  
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi kết nối cơ sở dữ liệu: " + e.getMessage(), "Lỗi CSDL", JOptionPane.ERROR_MESSAGE);
                }
            }
            sumTypeView.setVisible(true);
        }
        
    public void refreshTable() {
        loadTableData();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AddHangHoaDAOMSSQL dao = new AddHangHoaDAOMSSQL();
            AddHangHoaPresenter presenter = new AddHangHoaPresenter( null);
            AddHangHoaUseCase useCase = new AddHangHoaUseCase(dao, presenter);
            AddHangHoaController addHangHoaController = new AddHangHoaController(useCase);

            DeleteHangHoaInPutBoundary deleteBoundary = new DeleteHangHoaUseCase(new DeleteHangHoaDAOMSSQL(), new DeleteHangHoaPresenter());
            DeleteHangHoaController deleteHangHoaController = new DeleteHangHoaController(deleteBoundary);
            UpdateHangHoaInPutBoundary updateBoundary = new UpdateHangHoaUseCase(new UpdateHangHoaDAOMSSQL(), new UpdateHangHoaPresenter());
            UpdateHangHoaController updateHangHoaController = new UpdateHangHoaController(updateBoundary);

            ProductManagementView productManagementView = new ProductManagementView(presenter, addHangHoaController, deleteHangHoaController, updateHangHoaController,null);
            CheckHangHoaHetHanView checkHangHoaHetHanView = new CheckHangHoaHetHanView(productManagementView);
            productManagementView.checkHangHoaHetHanView = checkHangHoaHetHanView;
            productManagementView.setVisible(true);
        });
    }
}
