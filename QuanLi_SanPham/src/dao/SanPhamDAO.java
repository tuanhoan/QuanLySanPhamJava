package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.jdi.connect.spi.Connection;

import controller.MyConnect;
import entities.SanPham;

public class SanPhamDAO {
	public SanPhamDAO() {
	}

	public ArrayList<SanPham> getListSanPham() {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		java.sql.Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return null;
		} else {
			try {
				String sql = "SELECT * FROM SANPHAM";
				PreparedStatement ps = cn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String maSp = rs.getString(1);
					String tenSp = rs.getString(2);
					int soLuong = rs.getInt(3);
					int donGia = rs.getInt(4);
					String ngayNhap = rs.getString(5);
					String hanDung = rs.getString(6);
					SanPham sp = new SanPham(maSp, tenSp, soLuong, donGia, ngayNhap, hanDung);
					list.add(sp);
				}
				cn.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public static SanPham getListSanPhamTheoMaSp(String MASP) {
		SanPham sp = null;
		java.sql.Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return null;
		} else {
			try {
				String sql = "SELECT * FROM SANPHAM where MASP=?";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setString(1, MASP);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					String maSp = rs.getString(1);
					String tenSp = rs.getString(2);
					int soLuong = rs.getInt(3);
					int donGia = rs.getInt(4);
					String ngayNhap = rs.getString(5);
					String hanDung = rs.getString(6);
					sp = new SanPham(maSp, tenSp, soLuong, donGia, ngayNhap, hanDung);
				}
				cn.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sp;
	}

	public int themSanPham(SanPham sp) {
		int kq = 0;
		java.sql.Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return kq;
		} else {
			try {
				String sql = "INSERT INTO SANPHAM VALUES(?,?,?,?,?,?)";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setString(1, sp.getMaSp());
				ps.setString(2, sp.getTenSp());
				ps.setInt(3, sp.getSoLuong());
				ps.setInt(4, sp.getDonGia());
				ps.setString(5, sp.getNgayNhap());
				ps.setString(6, sp.getHanDung());
				kq = ps.executeUpdate();
				ps.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kq;
	}

	public int xoaSanPham(SanPham sp) {
		int kq = 0;
		java.sql.Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return kq;
		} else {
			try {
				String sql = "DELETE SANPHAM WHERE MASP = ?";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setString(1, sp.getMaSp());
				kq = ps.executeUpdate();
				ps.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kq;
	}

	public int suaSanPham(SanPham sp, SanPham new_sp) {
		int kq = 0;
		java.sql.Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return kq;
		} else {
			try {
				String sql = "UPDATE SANPHAM SET MASP=?,TENSP=?,SOLUONG=?,DONGIA=?,NGAYNHAP=?,HANDUNG=? WHERE MASP = ?";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setString(1, new_sp.getMaSp());
				ps.setString(2, new_sp.getTenSp());
				ps.setInt(3, new_sp.getSoLuong());
				ps.setInt(4, new_sp.getDonGia());
				ps.setString(5, new_sp.getNgayNhap());
				ps.setString(6, new_sp.getHanDung());
				ps.setString(7, sp.getMaSp());
				kq = ps.executeUpdate();
				ps.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kq;
	}

	public static int suaSoLuongSanPham(SanPham sp, int soLuong) {
		int kq = 0;
		java.sql.Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return kq;
		} else {
			try {
				String sql = "UPDATE SANPHAM SET SOLUONG=? WHERE MASP = ?";
				PreparedStatement ps = cn.prepareStatement(sql);
				sp.setSoLuong(sp.getSoLuong() - soLuong);
				ps.setInt(1, sp.getSoLuong());
				ps.setString(2, sp.getMaSp());
				kq = ps.executeUpdate();
				ps.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kq;
	}

	public ArrayList<SanPham> danhSachSpTimKiem(String tenSp) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		for (SanPham temp : new SanPhamDAO().getListSanPham()) {
			if (temp.getTenSp().contains(tenSp)) {
				list.add(temp);
			}
		}
		return list;
	}
}
