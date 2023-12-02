USE [master]
GO
/****** Object:  Database [DuAntest]    Script Date: 11/17/2023 12:13:37 AM ******/
CREATE DATABASE [DuAntest]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DuAntest', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DuAntest.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DuAntest_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DuAntest_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [DuAntest] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DuAntest].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DuAntest] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DuAntest] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DuAntest] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DuAntest] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DuAntest] SET ARITHABORT OFF 
GO
ALTER DATABASE [DuAntest] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DuAntest] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DuAntest] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DuAntest] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DuAntest] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DuAntest] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DuAntest] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DuAntest] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DuAntest] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DuAntest] SET  ENABLE_BROKER 
GO
ALTER DATABASE [DuAntest] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DuAntest] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DuAntest] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DuAntest] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DuAntest] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DuAntest] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DuAntest] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DuAntest] SET RECOVERY FULL 
GO
ALTER DATABASE [DuAntest] SET  MULTI_USER 
GO
ALTER DATABASE [DuAntest] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DuAntest] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DuAntest] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DuAntest] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DuAntest] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DuAntest] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'DuAntest', N'ON'
GO
ALTER DATABASE [DuAntest] SET QUERY_STORE = OFF
GO
USE [DuAntest]
GO
/****** Object:  Table [dbo].[ChatLieu]    Script Date: 11/17/2023 12:13:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChatLieu](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChitietSP]    Script Date: 11/17/2023 12:13:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChitietSP](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [nvarchar](10) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
	[IdNsx] [int] NULL,
	[IdMauSac] [int] NULL,
	[IdDMuc] [int] NULL,
	[IdKC] [int] NULL,
	[IdCL] [int] NULL,
	[IdTH] [int] NULL,
	[IdKM] [int] NULL,
	[MoTa] [nvarchar](50) NULL,
	[SoLuongTon] [int] NULL,
	[GiaNhap] [decimal](20, 0) NULL,
	[GiaBan] [decimal](20, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[chitietSP1]    Script Date: 11/17/2023 12:13:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chitietSP1](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [nvarchar](10) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
	[Nsx] [nvarchar](100) NULL,
	[MauSac] [nvarchar](100) NULL,
	[DanhMuc] [nvarchar](100) NULL,
	[KichCo] [nvarchar](100) NULL,
	[ChatLieu] [nvarchar](100) NULL,
	[ThuongHieu] [nvarchar](100) NULL,
	[KhuyenMai] [nvarchar](100) NULL,
	[MoTa] [nvarchar](50) NULL,
	[SoLuongTon] [int] NULL,
	[GiaNhap] [decimal](20, 0) NULL,
	[GiaBan] [decimal](20, 0) NULL,
 CONSTRAINT [PK_chitietSP] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 11/17/2023 12:13:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMucSP]    Script Date: 11/17/2023 12:13:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMucSP](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/17/2023 12:13:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[IdKH] [int] NULL,
	[IdNV] [int] NULL,
	[Ma] [varchar](20) NULL,
	[NgayTao] [date] NULL,
	[NgayThanhToan] [date] NULL,
	[TinhTrang] [bit] NULL,
	[Ghichu] [varchar](255) NULL,
	[TongTien] [decimal](18, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 11/17/2023 12:13:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[IdHD] [int] NOT NULL,
	[IdCTSP] [int] NOT NULL,
	[Soluong] [int] NOT NULL,
	[Dongia] [decimal](18, 0) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHD] ASC,
	[IdCTSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/17/2023 12:13:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](30) NOT NULL,
	[TenDem] [nvarchar](30) NULL,
	[Ho] [nvarchar](30) NULL,
	[Gioitinh] [bit] NULL,
	[NgaySinh] [date] NULL,
	[Email] [varchar](max) NOT NULL,
	[Sdt] [varchar](30) NULL,
	[Diemthuong] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 11/17/2023 12:13:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
	[Ngaybatdau] [date] NOT NULL,
	[Ngayketthuc] [date] NOT NULL,
	[HinhthucKM] [nvarchar](50) NOT NULL,
	[Giatrigiam] [decimal](18, 0) NULL,
	[Trangthai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KichCo]    Script Date: 11/17/2023 12:13:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KichCo](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 11/17/2023 12:13:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NSX]    Script Date: 11/17/2023 12:13:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NSX](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThuongHieu]    Script Date: 11/17/2023 12:13:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThuongHieu](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 11/17/2023 12:13:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](30) NOT NULL,
	[TenDem] [nvarchar](30) NULL,
	[Ho] [nvarchar](30) NULL,
	[NgaySinh] [date] NULL,
	[Gioitinh] [bit] NULL,
	[Sdt] [varchar](30) NULL,
	[IdCV] [int] NULL,
	[TaiKhoan] [varchar](max) NULL,
	[MatKhau] [varchar](max) NULL,
	[Email] [varchar](max) NOT NULL,
	[TrangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ChatLieu] ON 
GO
INSERT [dbo].[ChatLieu] ([Id], [Ten]) VALUES (1, N'cotton')
GO
INSERT [dbo].[ChatLieu] ([Id], [Ten]) VALUES (2, N'cvc')
GO
INSERT [dbo].[ChatLieu] ([Id], [Ten]) VALUES (3, N'nhung tăm')
GO
INSERT [dbo].[ChatLieu] ([Id], [Ten]) VALUES (4, N'Áo khoác')
GO
SET IDENTITY_INSERT [dbo].[ChatLieu] OFF
GO
SET IDENTITY_INSERT [dbo].[ChitietSP] ON 
GO
INSERT [dbo].[ChitietSP] ([Id], [Ma], [Ten], [IdNsx], [IdMauSac], [IdDMuc], [IdKC], [IdCL], [IdTH], [IdKM], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan]) VALUES (1, N'SP001', N'Áo Polo', 1, 1, 1, 1, 1, 2, 1, N'Mô tả sản phẩm 1', 90, CAST(500000 AS Decimal(20, 0)), CAST(700000 AS Decimal(20, 0)))
GO
INSERT [dbo].[ChitietSP] ([Id], [Ma], [Ten], [IdNsx], [IdMauSac], [IdDMuc], [IdKC], [IdCL], [IdTH], [IdKM], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan]) VALUES (2, N'SP002', N'Quần đùi ', 1, 1, 1, 1, 1, 3, 1, N'Mô tả sản phẩm 2', 142, CAST(800000 AS Decimal(20, 0)), CAST(1000010 AS Decimal(20, 0)))
GO
INSERT [dbo].[ChitietSP] ([Id], [Ma], [Ten], [IdNsx], [IdMauSac], [IdDMuc], [IdKC], [IdCL], [IdTH], [IdKM], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan]) VALUES (3, N'SP003', N'Áo khoác tránh fa', 1, 2, 1, 3, 1, 1, NULL, N'Mua đi kẻo hết', 100, CAST(50000 AS Decimal(20, 0)), CAST(300000 AS Decimal(20, 0)))
GO
INSERT [dbo].[ChitietSP] ([Id], [Ma], [Ten], [IdNsx], [IdMauSac], [IdDMuc], [IdKC], [IdCL], [IdTH], [IdKM], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan]) VALUES (6, N'SP002', N'Quần đùi ', 1, 1, 1, 1, 1, 1, 1, N'Mô tả sản phẩm 2', 142, CAST(800000 AS Decimal(20, 0)), CAST(1000010 AS Decimal(20, 0)))
GO
INSERT [dbo].[ChitietSP] ([Id], [Ma], [Ten], [IdNsx], [IdMauSac], [IdDMuc], [IdKC], [IdCL], [IdTH], [IdKM], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan]) VALUES (7, N'SP003', N'Quần đùi ', 1, 1, 1, 1, 1, 1, 1, N'Mô tả sản phẩm 2', 142, CAST(800000 AS Decimal(20, 0)), CAST(1000010 AS Decimal(20, 0)))
GO
SET IDENTITY_INSERT [dbo].[ChitietSP] OFF
GO
SET IDENTITY_INSERT [dbo].[chitietSP1] ON 
GO
INSERT [dbo].[chitietSP1] ([Id], [Ma], [Ten], [Nsx], [MauSac], [DanhMuc], [KichCo], [ChatLieu], [ThuongHieu], [KhuyenMai], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan]) VALUES (1, N'sp01', N'ao thun nam g63', N'vietnam', N'blue', N'category1', N'XL', N'cotton', N'gucci', N'khong', N'mota 1', 12, CAST(20000 AS Decimal(20, 0)), CAST(32000 AS Decimal(20, 0)))
GO
INSERT [dbo].[chitietSP1] ([Id], [Ma], [Ten], [Nsx], [MauSac], [DanhMuc], [KichCo], [ChatLieu], [ThuongHieu], [KhuyenMai], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan]) VALUES (2, N'ao 1', N'ao thun g71', N'GucciVietNam', N'Blue', N'Category1', N'S', N'Cotton', N'Gucci', N'ko khuyen mai', N'ao xin', 12, CAST(20000 AS Decimal(20, 0)), CAST(37800 AS Decimal(20, 0)))
GO
INSERT [dbo].[chitietSP1] ([Id], [Ma], [Ten], [Nsx], [MauSac], [DanhMuc], [KichCo], [ChatLieu], [ThuongHieu], [KhuyenMai], [MoTa], [SoLuongTon], [GiaNhap], [GiaBan]) VALUES (3, N'w3', N'ao 4', N'GucciVietNam', N'Blue', N'Category1', N'S', N'Thun', N'Gucci', N'ko khuyen mai', N'12abc', 12345, CAST(21111 AS Decimal(20, 0)), CAST(22222 AS Decimal(20, 0)))
GO
SET IDENTITY_INSERT [dbo].[chitietSP1] OFF
GO
SET IDENTITY_INSERT [dbo].[ChucVu] ON 
GO
INSERT [dbo].[ChucVu] ([Id], [Ten]) VALUES (1, N'Quản lý')
GO
INSERT [dbo].[ChucVu] ([Id], [Ten]) VALUES (2, N'Nhân viên bán hàng')
GO
SET IDENTITY_INSERT [dbo].[ChucVu] OFF
GO
SET IDENTITY_INSERT [dbo].[DanhMucSP] ON 
GO
INSERT [dbo].[DanhMucSP] ([Id], [Ten]) VALUES (1, N'Áo ')
GO
INSERT [dbo].[DanhMucSP] ([Id], [Ten]) VALUES (2, N'Quần')
GO
SET IDENTITY_INSERT [dbo].[DanhMucSP] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 
GO
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [Ma], [NgayTao], [NgayThanhToan], [TinhTrang], [Ghichu], [TongTien]) VALUES (3, 2, 1, N'HD-1989779134', CAST(N'2023-11-11' AS Date), CAST(N'2023-11-11' AS Date), 1, N'', CAST(1000000 AS Decimal(18, 0)))
GO
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [Ma], [NgayTao], [NgayThanhToan], [TinhTrang], [Ghichu], [TongTien]) VALUES (4, 3, 1, N'HD1580757942', CAST(N'2023-11-11' AS Date), CAST(N'2023-11-13' AS Date), 1, N'', CAST(3400000 AS Decimal(18, 0)))
GO
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [Ma], [NgayTao], [NgayThanhToan], [TinhTrang], [Ghichu], [TongTien]) VALUES (5, 2, 2, N'HD-1726865223', CAST(N'2023-11-13' AS Date), CAST(N'2023-11-13' AS Date), 1, N'', CAST(8500000 AS Decimal(18, 0)))
GO
INSERT [dbo].[HoaDon] ([Id], [IdKH], [IdNV], [Ma], [NgayTao], [NgayThanhToan], [TinhTrang], [Ghichu], [TongTien]) VALUES (6, 2, 2, N'HD-54218651', CAST(N'2023-11-13' AS Date), NULL, 0, NULL, NULL)
GO
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
INSERT [dbo].[HoaDonChiTiet] ([IdHD], [IdCTSP], [Soluong], [Dongia]) VALUES (3, 2, 1, CAST(1000000 AS Decimal(18, 0)))
GO
INSERT [dbo].[HoaDonChiTiet] ([IdHD], [IdCTSP], [Soluong], [Dongia]) VALUES (4, 1, 2, CAST(700000 AS Decimal(18, 0)))
GO
INSERT [dbo].[HoaDonChiTiet] ([IdHD], [IdCTSP], [Soluong], [Dongia]) VALUES (4, 2, 2, CAST(1000000 AS Decimal(18, 0)))
GO
INSERT [dbo].[HoaDonChiTiet] ([IdHD], [IdCTSP], [Soluong], [Dongia]) VALUES (5, 1, 5, CAST(700000 AS Decimal(18, 0)))
GO
INSERT [dbo].[HoaDonChiTiet] ([IdHD], [IdCTSP], [Soluong], [Dongia]) VALUES (5, 2, 5, CAST(1000000 AS Decimal(18, 0)))
GO
INSERT [dbo].[HoaDonChiTiet] ([IdHD], [IdCTSP], [Soluong], [Dongia]) VALUES (6, 1, 3, CAST(700000 AS Decimal(18, 0)))
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 
GO
INSERT [dbo].[KhachHang] ([Id], [Ten], [TenDem], [Ho], [Gioitinh], [NgaySinh], [Email], [Sdt], [Diemthuong]) VALUES (1, N'Le', N'Minh', N'C', 1, CAST(N'1995-08-03' AS Date), N'le.c@example.com', N'555555555', 50)
GO
INSERT [dbo].[KhachHang] ([Id], [Ten], [TenDem], [Ho], [Gioitinh], [NgaySinh], [Email], [Sdt], [Diemthuong]) VALUES (2, N'Phương', N'Minh', N'Trần', 0, CAST(N'2004-05-03' AS Date), N'phuong@gmail.com', N'0321456789', 85)
GO
INSERT [dbo].[KhachHang] ([Id], [Ten], [TenDem], [Ho], [Gioitinh], [NgaySinh], [Email], [Sdt], [Diemthuong]) VALUES (3, N'Thành', N'Xuân', N'Trần', 0, CAST(N'2004-10-01' AS Date), N'thanh@gmail.com', N'0123654987', 34)
GO
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[KhuyenMai] ON 
GO
INSERT [dbo].[KhuyenMai] ([Id], [Ten], [Ngaybatdau], [Ngayketthuc], [HinhthucKM], [Giatrigiam], [Trangthai]) VALUES (1, N'Khuy?n mãi A', CAST(N'2023-01-01' AS Date), CAST(N'2023-01-31' AS Date), N'Gi?m giá', CAST(0 AS Decimal(18, 0)), 1)
GO
INSERT [dbo].[KhuyenMai] ([Id], [Ten], [Ngaybatdau], [Ngayketthuc], [HinhthucKM], [Giatrigiam], [Trangthai]) VALUES (2, N'Khuy?n mãi B', CAST(N'2023-02-01' AS Date), CAST(N'2023-02-28' AS Date), N'T?ng quà', CAST(0 AS Decimal(18, 0)), 1)
GO
SET IDENTITY_INSERT [dbo].[KhuyenMai] OFF
GO
SET IDENTITY_INSERT [dbo].[KichCo] ON 
GO
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (1, N'M')
GO
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (2, N'L')
GO
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (3, N'XL')
GO
INSERT [dbo].[KichCo] ([Id], [Ten]) VALUES (4, N'XXL')
GO
SET IDENTITY_INSERT [dbo].[KichCo] OFF
GO
SET IDENTITY_INSERT [dbo].[MauSac] ON 
GO
INSERT [dbo].[MauSac] ([Id], [Ten]) VALUES (1, N'Ðỏ')
GO
INSERT [dbo].[MauSac] ([Id], [Ten]) VALUES (2, N'Xanh')
GO
INSERT [dbo].[MauSac] ([Id], [Ten]) VALUES (3, N'Vàng')
GO
INSERT [dbo].[MauSac] ([Id], [Ten]) VALUES (4, N'Hồng')
GO
INSERT [dbo].[MauSac] ([Id], [Ten]) VALUES (5, N'Cam')
GO
SET IDENTITY_INSERT [dbo].[MauSac] OFF
GO
SET IDENTITY_INSERT [dbo].[NSX] ON 
GO
INSERT [dbo].[NSX] ([Id], [Ten]) VALUES (1, N'Công ty A')
GO
INSERT [dbo].[NSX] ([Id], [Ten]) VALUES (2, N'Công ty B')
GO
INSERT [dbo].[NSX] ([Id], [Ten]) VALUES (3, N'Công ty C')
GO
SET IDENTITY_INSERT [dbo].[NSX] OFF
GO
SET IDENTITY_INSERT [dbo].[ThuongHieu] ON 
GO
INSERT [dbo].[ThuongHieu] ([Id], [Ten]) VALUES (1, N'FPL')
GO
INSERT [dbo].[ThuongHieu] ([Id], [Ten]) VALUES (2, N'Nike')
GO
INSERT [dbo].[ThuongHieu] ([Id], [Ten]) VALUES (3, N'Sony')
GO
SET IDENTITY_INSERT [dbo].[ThuongHieu] OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON 
GO
INSERT [dbo].[Users] ([Id], [Ten], [TenDem], [Ho], [NgaySinh], [Gioitinh], [Sdt], [IdCV], [TaiKhoan], [MatKhau], [Email], [TrangThai]) VALUES (1, N'Huỳnh', N'Viết Lưu', N'Đỗ', CAST(N'2004-05-15' AS Date), 0, N'0123456789', 2, N'huynh', N'123', N'huynh@gmail.com', 1)
GO
INSERT [dbo].[Users] ([Id], [Ten], [TenDem], [Ho], [NgaySinh], [Gioitinh], [Sdt], [IdCV], [TaiKhoan], [MatKhau], [Email], [TrangThai]) VALUES (2, N'Phong', N'Hồng', N'Nguyễn', CAST(N'2004-06-22' AS Date), 1, N'0987654321', 1, N'phonghehe', N'123456', N'phong@gmail.com', 1)
GO
INSERT [dbo].[Users] ([Id], [Ten], [TenDem], [Ho], [NgaySinh], [Gioitinh], [Sdt], [IdCV], [TaiKhoan], [MatKhau], [Email], [TrangThai]) VALUES (3, N'Dũng', N'Công', N'Bạch', CAST(N'2005-11-10' AS Date), 1, N'0123456788', 2, N'dungcongtu', N'123456', N'dung@gmail.com', 1)
GO
INSERT [dbo].[Users] ([Id], [Ten], [TenDem], [Ho], [NgaySinh], [Gioitinh], [Sdt], [IdCV], [TaiKhoan], [MatKhau], [Email], [TrangThai]) VALUES (4, N'Dương', N'Quang', N'Nguyễn', CAST(N'2004-05-01' AS Date), 1, N'0321455555', 2, N'duongnguyen', N'12345678', N'duong@gmail.com', 1)
GO
INSERT [dbo].[Users] ([Id], [Ten], [TenDem], [Ho], [NgaySinh], [Gioitinh], [Sdt], [IdCV], [TaiKhoan], [MatKhau], [Email], [TrangThai]) VALUES (5, N'Thành', N'Xuân', N'Trần', CAST(N'2004-01-01' AS Date), 0, N'0333333333', 2, N'thanhtran', N'00000', N'thanh@gmail.com', 1)
GO
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__HoaDon__3214CC9EE23E53CB]    Script Date: 11/17/2023 12:13:37 AM ******/
ALTER TABLE [dbo].[HoaDon] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChitietSP] ADD  DEFAULT (NULL) FOR [MoTa]
GO
ALTER TABLE [dbo].[ChitietSP] ADD  DEFAULT ((0)) FOR [GiaNhap]
GO
ALTER TABLE [dbo].[ChitietSP] ADD  DEFAULT ((0)) FOR [GiaBan]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [NgayTao]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [NgayThanhToan]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [TinhTrang]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [TenDem]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [Ho]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [NgaySinh]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [Sdt]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [Diemthuong]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT ((0)) FOR [Giatrigiam]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT ((0)) FOR [Trangthai]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT (NULL) FOR [TenDem]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT (NULL) FOR [Ho]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT (NULL) FOR [NgaySinh]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT (NULL) FOR [Sdt]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT (NULL) FOR [TaiKhoan]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT (NULL) FOR [MatKhau]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[ChitietSP]  WITH CHECK ADD FOREIGN KEY([IdCL])
REFERENCES [dbo].[ChatLieu] ([Id])
GO
ALTER TABLE [dbo].[ChitietSP]  WITH CHECK ADD FOREIGN KEY([IdDMuc])
REFERENCES [dbo].[DanhMucSP] ([Id])
GO
ALTER TABLE [dbo].[ChitietSP]  WITH CHECK ADD FOREIGN KEY([IdKC])
REFERENCES [dbo].[KichCo] ([Id])
GO
ALTER TABLE [dbo].[ChitietSP]  WITH CHECK ADD FOREIGN KEY([IdKM])
REFERENCES [dbo].[KhuyenMai] ([Id])
GO
ALTER TABLE [dbo].[ChitietSP]  WITH CHECK ADD FOREIGN KEY([IdMauSac])
REFERENCES [dbo].[MauSac] ([Id])
GO
ALTER TABLE [dbo].[ChitietSP]  WITH CHECK ADD FOREIGN KEY([IdNsx])
REFERENCES [dbo].[NSX] ([Id])
GO
ALTER TABLE [dbo].[ChitietSP]  WITH CHECK ADD FOREIGN KEY([IdTH])
REFERENCES [dbo].[ThuongHieu] ([Id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IdKH])
REFERENCES [dbo].[KhachHang] ([Id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IdNV])
REFERENCES [dbo].[Users] ([Id])
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD FOREIGN KEY([IdCTSP])
REFERENCES [dbo].[ChitietSP] ([Id])
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD FOREIGN KEY([IdHD])
REFERENCES [dbo].[HoaDon] ([Id])
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD FOREIGN KEY([IdCV])
REFERENCES [dbo].[ChucVu] ([Id])
GO
USE [master]
GO
ALTER DATABASE [DuAntest] SET  READ_WRITE 
GO
