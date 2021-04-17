package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.MyConnect;
import entities.NhanVien;
import entities.SanPham;

public class NhanVienDAO {

	// LAY DANH SACH NHAN VIEN
	public ArrayList<NhanVien> getListNhanVien() {
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return null;
		} else {
			try {
				String sql = "SELECT * FROM NHANVIEN";
				PreparedStatement ps = cn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String maNv = rs.getString(1);
					String tenNv = rs.getString(2);
					String ngaySinh = rs.getString(3);
					String sDt = rs.getString(4);
					NhanVien nv = new NhanVien(maNv, tenNv, ngaySinh, sDt);
					list.add(nv);
				}
				cn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// THEM NHAN VIEN
	public int themNhanVien(NhanVien nv) {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return kq;
		} else {
			try {
				String sql = "INSERT INTO NHANVIEN VALUES(?,?,?,?)";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setString(1, nv.getMaNv());
				ps.setString(2, nv.getTenNv());
				ps.setString(3, nv.getNgaySinh());
				ps.setString(4, nv.getsDt());
				kq = ps.executeUpdate();
				cn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kq;
	}

	// XOA NHAN VIEN
	public int xoaNhanVien(NhanVien nv) {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return kq;
		} else {
			try {
				String sql = "DELETE NHANVIEN WHERE MANV=?";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setString(1, nv.getMaNv());
				kq = ps.executeUpdate();
				cn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kq;
	}

	// SỬA NHAN VIEN
	public int suaNhanVien(NhanVien nv_Old, NhanVien nv_New) {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return kq;
		} else {
			try {
				String sql = "UPDATE NHANVIEN SET MANV=?,TENNV=?,NGAYSINH=?,SDT=? WHERE MANV=?";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setString(1, nv_New.getMaNv());
				ps.setString(2, nv_New.getTenNv());
				ps.setString(3, nv_New.getNgaySinh());
				ps.setString(4, nv_New.getsDt());
				ps.setString(5, nv_Old.getMaNv());
				kq = ps.executeUpdate();
				cn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kq;
	}

	// TÌM KIẾM NHÂN VIÊN
	public ArrayList<NhanVien> danhSachNvTimKiem(String tenSp) {
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		for (NhanVien temp : new NhanVienDAO().getListNhanVien()) {
			if (temp.getTenNv().contains(tenSp)) {
				list.add(temp);
			}
		}
		return list;
	}
}
