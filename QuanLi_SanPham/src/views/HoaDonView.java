package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import entities.ChiTietHoaDonHistory;
import entities.HoaDon;
import entities.SanPham;

public class HoaDonView extends JPanel {
	// PHẦN HÓA ĐƠN
	private JTable hoaDonTable;
	String[] columns = { "Stt", "Mã HD", "Ngày mua", "Mã nhân viên", "Tổng tiền" };
	Object[][] data = new Object[][] {};

	// PHẦN CHI TIẾT HÓA ĐƠN
	private JTable chiTietHDTable;
	String[] columns2 = { "Stt", "Tên SP", "Đơn giá", "Số lượng", "Thành tiền" };
	Object[][] data2 = new Object[][] {};

	public static void main(String[] args) {
		new QuanLiView();
	}

	public HoaDonView() {
		JPanel mainJpanel = new JPanel();
		hoaDonTable = new JTable();
		hoaDonTable.setModel(new DefaultTableModel(data, columns));
		JScrollPane jScrollPaneHoaDon = new JScrollPane();
		jScrollPaneHoaDon.setViewportView(hoaDonTable);
		jScrollPaneHoaDon.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
				"Danh sách hóa đơn", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Tahoma", Font.BOLD, 14)));
		chiTietHDTable = new JTable();
		chiTietHDTable.setModel(new DefaultTableModel(data2, columns2));
		JScrollPane jScrollPaneHoaDon2 = new JScrollPane();
		jScrollPaneHoaDon2.setViewportView(chiTietHDTable);
		jScrollPaneHoaDon2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
				"Chi tiết hóa đơn", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Tahoma", Font.BOLD, 14)));
		SpringLayout layout = new SpringLayout();
		mainJpanel.setLayout(layout);
		mainJpanel.add(jScrollPaneHoaDon);
		mainJpanel.add(jScrollPaneHoaDon2);

		layout.putConstraint(SpringLayout.WEST, jScrollPaneHoaDon, 0, SpringLayout.WEST, mainJpanel);
		layout.putConstraint(SpringLayout.NORTH, jScrollPaneHoaDon, 0, SpringLayout.NORTH, mainJpanel);
		layout.putConstraint(SpringLayout.SOUTH, jScrollPaneHoaDon, 0, SpringLayout.SOUTH, mainJpanel);
		layout.putConstraint(SpringLayout.EAST, jScrollPaneHoaDon, 100, SpringLayout.HORIZONTAL_CENTER, mainJpanel);

		layout.putConstraint(SpringLayout.WEST, jScrollPaneHoaDon2, 10, SpringLayout.EAST, jScrollPaneHoaDon);
		layout.putConstraint(SpringLayout.NORTH, jScrollPaneHoaDon2, 0, SpringLayout.NORTH, mainJpanel);
		layout.putConstraint(SpringLayout.SOUTH, jScrollPaneHoaDon2, -200, SpringLayout.SOUTH, mainJpanel);
		layout.putConstraint(SpringLayout.EAST, jScrollPaneHoaDon2, 0, SpringLayout.EAST, mainJpanel);
		this.setLayout(new BorderLayout());
		this.add(mainJpanel, BorderLayout.CENTER);
	}

	// Show DANH SÁCH SẢN PHẨM TỪ DATABASE VÀO TABLE
	public void ListSanPhamTrenTable(ArrayList<HoaDon> list) {
		int size = list.size();
		Object[][] sv = new Object[size][5];
		for (int i = 0; i < size; i++) {
			sv[i][0] = i + 1;
			sv[i][1] = list.get(i).getMaHd();
			sv[i][2] = list.get(i).getNgayMua();
			sv[i][3] = list.get(i).getMaNv();
			sv[i][4] = list.get(i).getTongTien();
		}
		hoaDonTable.setModel(new DefaultTableModel(sv, columns));
	}

	// Show DANH SÁCH SẢN PHẨM TỪ DATABASE VÀO TABLE
	public void showListChiTietHoaDon(ArrayList<ChiTietHoaDonHistory> list) {
		int size = list.size();
		Object[][] sv = new Object[size][5];
		for (int i = 0; i < size; i++) {
			sv[i][0] = i + 1;
			sv[i][1] = list.get(i).getTenSp();
			sv[i][2] = list.get(i).getDonGia();
			sv[i][3] = list.get(i).getSoLuong();
			sv[i][4] = list.get(i).getThanhTien();
		}
		chiTietHDTable.setModel(new DefaultTableModel(sv, columns2));
	}

	// LẤY MÃ HÓA ĐƠN
	public int layMaHoaDon() {
		int rows = hoaDonTable.getSelectedRow();
		int maHd = 0;
		if (rows >= 0) {
			maHd = Integer.parseInt(String.valueOf(hoaDonTable.getModel().getValueAt(rows, 1)));
		}
		return maHd;
	}

	public void ClickOnTable(ListSelectionListener l) {
		hoaDonTable.getSelectionModel().addListSelectionListener(l);
	}

}
