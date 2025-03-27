CREATE DATABASE QuanLyHangHoa;
GO

USE QuanLyHangHoa;
GO

-- Bảng Loại Hàng
CREATE TABLE LoaiHang (
    LoaiHangId INT PRIMARY KEY IDENTITY(1,1),
    TenLoai NVARCHAR(50) NOT NULL UNIQUE -- 'ThucPham', 'DienMay', 'SanhSu'
);

-- Bảng Hàng Hóa
CREATE TABLE HangHoa (
    MaHang INT PRIMARY KEY IDENTITY(1,1),
    TenHang NVARCHAR(100) NOT NULL,
    SoLuongTon INT,
    DonGia DECIMAL(18, 2),
    LoaiHangId INT NOT NULL,
	PhiVAT DECIMAL(18, 2),
    FOREIGN KEY (LoaiHangId) REFERENCES LoaiHang(LoaiHangId)
);

-- Bảng Hàng Thực Phẩm
CREATE TABLE HangThucPham (
    MaHang int PRIMARY KEY,
    NgaySanXuat DATE NOT NULL,
    NgayHetHan DATE NOT NULL,
    NhaCungCap NVARCHAR(100),
    FOREIGN KEY (MaHang) REFERENCES HangHoa(MaHang)
);

-- Bảng Hàng Điện Máy
CREATE TABLE HangDienMay (
    MaHang int PRIMARY KEY,
    ThoiGianBaoHanh INT,
    CongSuatKW DECIMAL(18, 2),
    FOREIGN KEY (MaHang) REFERENCES HangHoa(MaHang)
);

-- Bảng Hàng Sành Sứ
CREATE TABLE HangSanhSu (
    MaHang int PRIMARY KEY,
    NhaSanXuat NVARCHAR(100),
    NgayNhapKho DATE NOT NULL,
    FOREIGN KEY (MaHang) REFERENCES HangHoa(MaHang)
);

-- Thêm dữ liệu mẫu vào bảng LoaiHang
INSERT INTO LoaiHang (TenLoai) VALUES ('ThucPham'), ('DienMay'), ('SanhSu');