package com.cgm.circleK.ui;

import com.cgm.circleK.dto.AddHangHoaInPutDTO;
import com.cgm.circleK.database.AddHangHoaDAOMSSQL;
import com.cgm.circleK.usecase.AddHangHoaUseCase;
import com.cgm.circleK.usecase.AddHangHoaDBBoundary;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class AddHangHoaView extends JFrame {
    private JTextField tenHangField;
    private JTextField soLuongTonField;
    private JTextField donGiaField;
    private JComboBox<String> loaiHangComboBox;
    private JDateChooser ngaySanXuatChooser;
    private JDateChooser ngayHetHanChooser;
    private JTextField nhaCungCapField;
    private JTextField thoiGianBaoHanhField;
    private JTextField congSuatField;
    private JTextField nhaSanXuatField;
    private JDateChooser ngayNhapKhoChooser;
    private JButton addButton;
    private JButton backButton; 
    private ProductManagementView productManagementView; 
    private final AddHangHoaController controller;

    public AddHangHoaView(AddHangHoaController controller, List<String> loaiHangList) {
        
        this.controller = controller;
        setTitle("Add Hang Hoa");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(12, 2));

        tenHangField = new JTextField();
        soLuongTonField = new JTextField();
        donGiaField = new JTextField();
        loaiHangComboBox = new JComboBox<>(loaiHangList.toArray(new String[0]));
        ngaySanXuatChooser = new JDateChooser();
        ngayHetHanChooser = new JDateChooser();
        nhaCungCapField = new JTextField();
        thoiGianBaoHanhField = new JTextField();
        congSuatField = new JTextField();
        nhaSanXuatField = new JTextField();
        ngayNhapKhoChooser = new JDateChooser();
        addButton = new JButton("Add");

        add(new JLabel("Ten Hang:"));
        add(tenHangField);
        add(new JLabel("So Luong Ton:"));
        add(soLuongTonField);
        add(new JLabel("Don Gia:"));
        add(donGiaField);
        add(new JLabel("Loai Hang:"));
        add(loaiHangComboBox);
        add(new JLabel("Ngay San Xuat:"));
        add(ngaySanXuatChooser);
        add(new JLabel("Ngay Het Han:"));
        add(ngayHetHanChooser);
        add(new JLabel("Nha Cung Cap:"));
        add(nhaCungCapField);
        add(new JLabel("Thoi Gian Bao Hanh:"));
        add(thoiGianBaoHanhField);
        add(new JLabel("Cong Suat:"));
        add(congSuatField);
        add(new JLabel("Nha San Xuat:"));
        add(nhaSanXuatField);
        add(new JLabel("Ngay Nhap Kho:"));
        add(ngayNhapKhoChooser);
        add(addButton);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> goBackToProductManagement());
    add(backButton); 

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String tenHang = tenHangField.getText();
                    int soLuongTon = Integer.parseInt(soLuongTonField.getText());
                    double donGia = Double.parseDouble(donGiaField.getText());
                    int loaiHangId = loaiHangComboBox.getSelectedIndex() + 1;

                    AddHangHoaInPutDTO hangHoaDTO;

                    if (loaiHangId == 1) { // ThucPham
                        Date ngaySanXuat = ngaySanXuatChooser.getDate();
                        Date ngayHetHan = ngayHetHanChooser.getDate();
                        String nhaCungCap = nhaCungCapField.getText();
                        hangHoaDTO = new AddHangHoaInPutDTO(tenHang, soLuongTon, donGia, loaiHangId, ngaySanXuat, ngayHetHan, nhaCungCap);
                    } else if (loaiHangId == 2) { // DienMay
                        int thoiGianBaoHanh = Integer.parseInt(thoiGianBaoHanhField.getText());
                        double congSuat = Double.parseDouble(congSuatField.getText());
                        hangHoaDTO = new AddHangHoaInPutDTO(tenHang, soLuongTon, donGia, loaiHangId, thoiGianBaoHanh, congSuat);
                    } else { // SanhSu
                        String nhaSanXuat = nhaSanXuatField.getText();
                        Date ngayNhapKho = ngayNhapKhoChooser.getDate();
                        hangHoaDTO = new AddHangHoaInPutDTO(tenHang, soLuongTon, donGia, loaiHangId, nhaSanXuat, ngayNhapKho);
                    }
                    controller.addHangHoa(hangHoaDTO);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddHangHoaView.this, "Please enter valid numbers for quantity and price.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    private void goBackToProductManagement() {
        this.setVisible(false);  
        productManagementView.setVisible(true);  
    }

    private void resetFields() {
        tenHangField.setText("");
        soLuongTonField.setText("");
        donGiaField.setText("");
        loaiHangComboBox.setSelectedIndex(0);
        ngaySanXuatChooser.setDate(null);
        ngayHetHanChooser.setDate(null);
        nhaCungCapField.setText("");
        thoiGianBaoHanhField.setText("");
        congSuatField.setText("");
        nhaSanXuatField.setText("");
        ngayNhapKhoChooser.setDate(null);
    }

    public static void main(String[] args) {
        // Create an instance of the DAO
        AddHangHoaDBBoundary dbBoundary = new AddHangHoaDAOMSSQL();

        // Create the presenter
        AddHangHoaPresenter presenter = new AddHangHoaPresenter(null); // Pass null or the parent frame if needed

        // Create the use case with the DAO and presenter
        AddHangHoaUseCase useCase = new AddHangHoaUseCase(dbBoundary, presenter);

        // Create a controller with the use case
        AddHangHoaController controller = new AddHangHoaController(useCase);

        // Fetch the list of product types from the database
        List<String> loaiHangList = dbBoundary.getLoaiHangList();

        // Create and display the view
        SwingUtilities.invokeLater(() -> {
            AddHangHoaView view = new AddHangHoaView(controller, loaiHangList);
            view.setVisible(true);
        });
    }
} 