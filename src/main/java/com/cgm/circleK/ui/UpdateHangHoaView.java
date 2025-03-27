package com.cgm.circleK.ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.cgm.circleK.database.UpdateHangHoaDAOMSSQL;
import com.cgm.circleK.dto.UpdateHangHoaInPutDTO;
import com.cgm.circleK.entity.HangDienMay;
import com.cgm.circleK.entity.HangHoa;
import com.cgm.circleK.entity.HangSanhSu;
import com.cgm.circleK.entity.HangThucPham;
import com.toedter.calendar.JDateChooser;
import com.cgm.circleK.ui.ProductManagementView;
public class UpdateHangHoaView extends JFrame {
    private final UpdateHangHoaController updateHangHoaController;

    private JTextField maHangField;
    private JTextField tenHangField;
    private JTextField soLuongTonField;
    private JTextField donGiaField;
    private JRadioButton thucPhamRadioButton;
    private JRadioButton dienMayRadioButton;
    private JRadioButton sanhSuRadioButton;
    private JDateChooser ngaySanXuatChooser;
    private JDateChooser ngayHetHanChooser;
    private JTextField nhaCungCapField;
    private JTextField thoiGianBaoHanhField;
    private JTextField congSuatField;
    private JTextField nhaSanXuatField;
    private JDateChooser ngayNhapKhoChooser;
    private JButton updateButton;
    private JButton backButton; 
    private ProductManagementView productManagementView; 
    public UpdateHangHoaView(UpdateHangHoaController updateHangHoaController, int maHang) throws SQLException {
        this.updateHangHoaController = updateHangHoaController;
        initializeUI();
        loadProductDetails(maHang);
        backButton = new JButton("Quay Lại");
        backButton.addActionListener(e -> goBackToProductManagement());
        add(backButton); 
    }
    private void goBackToProductManagement() {
        if (productManagementView != null) {
            productManagementView.refreshTable(); 
            productManagementView.setVisible(true); 
        }
        this.dispose();
         
    }
    private void initializeUI() {
        setTitle("Cập Nhật Sản Phẩm");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        maHangField = new JTextField();
        tenHangField = new JTextField();
        soLuongTonField = new JTextField();
        donGiaField = new JTextField();

        thucPhamRadioButton = new JRadioButton("Thực Phẩm");
        dienMayRadioButton = new JRadioButton("Điện Máy");
        sanhSuRadioButton = new JRadioButton("Sành Sứ");

        ButtonGroup loaiHangGroup = new ButtonGroup();
        loaiHangGroup.add(thucPhamRadioButton);
        loaiHangGroup.add(dienMayRadioButton);
        loaiHangGroup.add(sanhSuRadioButton);

        ngaySanXuatChooser = new JDateChooser();
        ngayHetHanChooser = new JDateChooser();
        nhaCungCapField = new JTextField();
        thoiGianBaoHanhField = new JTextField();
        congSuatField = new JTextField();
        nhaSanXuatField = new JTextField();
        ngayNhapKhoChooser = new JDateChooser();
        updateButton = new JButton("Cập Nhật");

        add(new JLabel("Mã Hàng:"));
        add(maHangField);
        add(new JLabel("Tên Hàng:"));
        add(tenHangField);
        add(new JLabel("Số Lượng Tồn:"));
        add(soLuongTonField);
        add(new JLabel("Đơn Giá:"));
        add(donGiaField);

        add(new JLabel("Loại Hàng:"));
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(thucPhamRadioButton);
        radioPanel.add(dienMayRadioButton);
        radioPanel.add(sanhSuRadioButton);
        add(radioPanel);

        add(new JLabel("Ngày Sản Xuất:"));
        add(ngaySanXuatChooser);
        add(new JLabel("Ngày Hết Hạn:"));
        add(ngayHetHanChooser);
        add(new JLabel("Nhà Cung Cấp:"));
        add(nhaCungCapField);
        add(new JLabel("Thời Gian Bảo Hành:"));
        add(thoiGianBaoHanhField);
        add(new JLabel("Công Suất:"));
        add(congSuatField);
        add(new JLabel("Nhà Sản Xuất:"));
        add(nhaSanXuatField);
        add(new JLabel("Ngày Nhập Kho:"));
        add(ngayNhapKhoChooser);
        add(updateButton);

        updateButton.addActionListener(e -> updateProduct());
        
    }

    private void loadProductDetails(int maHang) throws SQLException {
        HangHoa product = getProductById(maHang);
        if (product != null) {
            maHangField.setText(String.valueOf(product.getMaHang()));
            tenHangField.setText(product.getTenHang());
            soLuongTonField.setText(String.valueOf(product.getSoLuongTon()));
            donGiaField.setText(String.valueOf(product.getDonGia()));

            if (product instanceof HangThucPham) {
                thucPhamRadioButton.setSelected(true);
                HangThucPham thucPham = (HangThucPham) product;
                ngaySanXuatChooser.setDate(thucPham.getNgaySanXuat());
                ngayHetHanChooser.setDate(thucPham.getNgayHetHan());
                nhaCungCapField.setText(thucPham.getNhaCungCap());
            }
            if (product instanceof HangDienMay) {
                dienMayRadioButton.setSelected(true);
                HangDienMay dienMay = (HangDienMay) product;
                thoiGianBaoHanhField.setText(String.valueOf(dienMay.getThoiGianBaoHanh()));
                congSuatField.setText(String.valueOf(dienMay.getCongSuat()));
            }
            else if (product instanceof HangSanhSu) {
                sanhSuRadioButton.setSelected(true);
                HangSanhSu sanhSu = (HangSanhSu) product;
                nhaSanXuatField.setText(sanhSu.getNhaSanXuat());
                ngayNhapKhoChooser.setDate(sanhSu.getNgayNhapKho());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Product not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private HangHoa getProductById(int maHang) throws SQLException {
    HangHoa product = UpdateHangHoaDAOMSSQL.findProductById(maHang);
        if (product != null) {
        return product;
    } else {
        throw new IllegalArgumentException("Product not found.");
    }
}

    private void updateProduct() {
        try {
            int maHang = Integer.parseInt(maHangField.getText().trim());
            String tenHang = tenHangField.getText().trim();
            int soLuongTon = Integer.parseInt(soLuongTonField.getText().trim());
            double donGia = Double.parseDouble(donGiaField.getText().trim());
            int loaiHangId = thucPhamRadioButton.isSelected() ? 1 : dienMayRadioButton.isSelected() ? 2 : 3;
            
            UpdateHangHoaInPutDTO dto;
            switch (loaiHangId) {
                case 1: // HangThucPham
                    Date ngaySanXuat = ngaySanXuatChooser.getDate();
                    Date ngayHetHan = ngayHetHanChooser.getDate();
                    String nhaCungCap = nhaCungCapField.getText().trim();
                    dto = new UpdateHangHoaInPutDTO(maHang, tenHang, soLuongTon, donGia, loaiHangId, ngaySanXuat, ngayHetHan, nhaCungCap);
                    break;
                case 2: // HangDienMay
                    int thoiGianBaoHanh = Integer.parseInt(thoiGianBaoHanhField.getText().trim());
                    double congSuatKW = Double.parseDouble(congSuatField.getText().trim());
                    dto = new UpdateHangHoaInPutDTO(maHang, tenHang, soLuongTon, donGia, loaiHangId, thoiGianBaoHanh, congSuatKW);
                    break;
                case 3: // HangSanhSu
                    String nhaSanXuat = nhaSanXuatField.getText().trim();
                    Date ngayNhapKho = ngayNhapKhoChooser.getDate();
                    dto = new UpdateHangHoaInPutDTO(maHang, tenHang, soLuongTon, donGia, loaiHangId, nhaSanXuat, ngayNhapKho);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid product type.");
            }
            updateHangHoaController.execute(dto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error updating product: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
