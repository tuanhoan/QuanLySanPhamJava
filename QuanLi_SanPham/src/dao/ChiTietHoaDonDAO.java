package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.MyConnect;
import entities.ChiTietHoaDon;

public class ChiTietHoaDonDAO {
	public ArrayList<ChiTietHoaDon> getListCTHD() {
		ArrayList<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return null;
		} else {
			try {
				String sql = "SELECT * FROM CHITIETHOADON";
				PreparedStatement ps = cn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					int maCt = rs.getInt(1);
					String maSp = rs.getString(2);
					int soLuong = rs.getInt(3);
					int maHd = rs.getInt(4);
					int thanhTien = rs.getInt(5);
					ChiTietHoaDon cthd = new ChiTietHoaDon(maCt, maSp, soLuong, maHd, thanhTien);
					list.add(cthd);
				}
				cn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int themCTHD(ChiTietHoaDon cthd) {
		int kq = 0;
		Connection cn = new MyConnect().getcn();
		if (cn == null) {
			return kq;
		} else {
			try {
				String sql = "INSERT INTO CHITIETHOADON VALUES(?,?,?,?)";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setString(1, cthd.getMaSp());
				ps.setInt(2, cthd.getSoLuong());
				ps.setInt(3, cthd.getMaHd());
				ps.setInt(4, cthd.getThanhTien());
				kq = ps.executeUpdate();
				cn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kq;
	}
}
