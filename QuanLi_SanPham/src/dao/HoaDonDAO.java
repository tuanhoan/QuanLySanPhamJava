package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.MyConnect;
import entities.ChiTietHoaDon;
import entities.ChiTietHoaDonHistory;
import entities.HoaDon;
import views.QuanLiView;

public class HoaDonDAO {
	public static void main(String[] args) {
		new QuanLiView();
	}

	public ArrayList<HoaDon> getListHoaDon() {
		ArrayList<HoaDon> list = new ArrayList<HoaDon>();
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return null;
		} else {
			try {
				String sql = "SELECT * FROM HOADON";
				PreparedStatement ps = cn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					int maHd = rs.getInt(1);
					String ngayMua = rs.getString(2);
					String maNv = rs.getString(3);
					int tongTien = rs.getInt(4);
					HoaDon hd = new HoaDon(maHd, ngayMua, maNv, tongTien);
					list.add(hd);
				}
				cn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// THÊM HÓA ĐƠN
	public int themHD(HoaDon hd) {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return kq;
		} else {
			try {
				String sql = "INSERT INTO HOADON VALUES(?,?,?)";
				PreparedStatement ps = cn.prepareStatement(sql);
				System.out.println(hd.getNgayMua());
				ps.setString(1, hd.getNgayMua());
				ps.setString(2, hd.getMaNv());
				ps.setInt(3, hd.getTongTien());
				kq = ps.executeUpdate();
				cn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kq;
	}

	public int xoaHD(HoaDon hd) {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return kq;
		} else {
			try {
				String sql = "DELETE FROM HOADON WHERE MAHD = ?";
				PreparedStatement ps = cn.prepareStatement(sql);
				System.out.println(hd.getNgayMua());
				ps.setInt(1, hd.getMaHd());
				kq = ps.executeUpdate();
				cn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kq;
	}

	// DANH SÁCH CHI TIẾT HÓA ĐƠN ĐÃ THÊM
	public ArrayList<ChiTietHoaDonHistory> danhSachCTHDhistory(int maHd) {
		ArrayList<ChiTietHoaDonHistory> list = new ArrayList<ChiTietHoaDonHistory>();
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return null;
		} else {
			try {
				String sql = "SELECT sp.TENSP,sp.DONGIA,cthd.SOLUONG, cthd.THANHTIEN FROM dbo.CHITIETHOADON cthd, dbo.HOADON hd, dbo.SANPHAM sp "
						+ "WHERE hd.MAHD = ? AND hd.MAHD = cthd.MAHD AND sp.MASP = cthd.MASP";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setInt(1, maHd);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String tenSp = rs.getString(1);
					int donGia = rs.getInt(2);
					int soLuong = rs.getInt(3);
					int thanhTien = rs.getInt(4);
					ChiTietHoaDonHistory ct = new ChiTietHoaDonHistory(tenSp, soLuong, donGia, thanhTien);
					list.add(ct);
				}
				cn.close();
				ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// LẤY MÃ HÓA ĐƠN GẦN NHẤT
	public int getNewestIdHoadon() {
		Connection cn = new MyConnect().getcn();
		int MaxID = 0;
		if (cn == null)
			return 0;
		try {
			String sql = "select MAX(MAHD) from HOADON";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				MaxID = rs.getInt(1);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MaxID;
	}

}
