package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import entities.NhanVien;
import entities.SanPham;

public class NhanVienView extends JPanel {

	// Điền thông tin nhân viên
	private JLabel maNvLb, tenNvLb, ngaySinhLb, soDtLb;
	private JTextField maNvTf, tenNvTf, ngaySinhTf, soDtTf;
	private JButton themBtn, suaBtn, xoaBtn, clearBtn;
	// Show thông tin nhân viên
	private JTable tableNhanVien;
	// Tìm kiếm thông tin nhân viên
	private JLabel tkTenNvLb;
	private JTextField tkTenNvTf;
	private JButton timKiemBtn, reFreshBtn;
	private String[] columns = { "Stt", "Mã", "Tên", "Ngày sinh", "Số đt" };
	private Object[][] data = new Object[][] {};

	public NhanVienView() {
		View();
	}

	private void View() {

		// Điền thông tin
		maNvLb = new JLabel("Mã số");
		tenNvLb = new JLabel("Tên");
		ngaySinhLb = new JLabel("Ngày sinh");
		soDtLb = new JLabel("Số điện thoại");

		maNvTf = new JTextField(12);
		tenNvTf = new JTextField(12);
		ngaySinhTf = new JTextField(12);
		soDtTf = new JTextField(12);

		themBtn = new JButton("Thêm");
		suaBtn = new JButton("Sửa");
		xoaBtn = new JButton("Xóa");
		clearBtn = new JButton("Clear");
		JPanel groupJbutton = new JPanel();
		groupJbutton.setLayout(new GridLayout(1, 4, 5, 5));
		groupJbutton.add(themBtn);
		groupJbutton.add(suaBtn);
		groupJbutton.add(xoaBtn);
		groupJbutton.add(clearBtn);

		JPanel dienThongTinNhanVien = new JPanel();
		dienThongTinNhanVien.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
				"Điền thông tin nhân viên", TitledBorder.CENTER, TitledBorder.CENTER,
				new Font("Tahoma", Font.BOLD, 12)));
		dienThongTinNhanVien.add(maNvLb);
		dienThongTinNhanVien.add(tenNvLb);
		dienThongTinNhanVien.add(ngaySinhLb);
		dienThongTinNhanVien.add(soDtLb);
		dienThongTinNhanVien.add(maNvTf);
		dienThongTinNhanVien.add(tenNvTf);
		dienThongTinNhanVien.add(ngaySinhTf);
		dienThongTinNhanVien.add(soDtTf);
		dienThongTinNhanVien.add(groupJbutton);

		SpringLayout dienThongTinlayout = new SpringLayout();
		dienThongTinNhanVien.setLayout(dienThongTinlayout);

		// Set layout cho các thành phần trong phần điền thông tin nhân viên
		dienThongTinlayout.putConstraint(SpringLayout.EAST, maNvLb, -100, SpringLayout.HORIZONTAL_CENTER,
				dienThongTinNhanVien);
		dienThongTinlayout.putConstraint(SpringLayout.WEST, tenNvLb, 0, SpringLayout.WEST, maNvLb);
		dienThongTinlayout.putConstraint(SpringLayout.WEST, ngaySinhLb, 0, SpringLayout.WEST, maNvLb);
		dienThongTinlayout.putConstraint(SpringLayout.WEST, soDtLb, 0, SpringLayout.WEST, maNvLb);

		dienThongTinlayout.putConstraint(SpringLayout.NORTH, maNvLb, 100, SpringLayout.NORTH, dienThongTinNhanVien);
		dienThongTinlayout.putConstraint(SpringLayout.NORTH, tenNvLb, 50, SpringLayout.NORTH, maNvLb);
		dienThongTinlayout.putConstraint(SpringLayout.NORTH, ngaySinhLb, 100, SpringLayout.NORTH, maNvLb);
		dienThongTinlayout.putConstraint(SpringLayout.NORTH, soDtLb, 150, SpringLayout.NORTH, maNvLb);

		dienThongTinlayout.putConstraint(SpringLayout.WEST, maNvTf, 0, SpringLayout.HORIZONTAL_CENTER,
				dienThongTinNhanVien);
		dienThongTinlayout.putConstraint(SpringLayout.WEST, tenNvTf, 0, SpringLayout.WEST, maNvTf);
		dienThongTinlayout.putConstraint(SpringLayout.WEST, ngaySinhTf, 0, SpringLayout.WEST, maNvTf);
		dienThongTinlayout.putConstraint(SpringLayout.WEST, soDtTf, 0, SpringLayout.WEST, maNvTf);

		dienThongTinlayout.putConstraint(SpringLayout.NORTH, maNvTf, 0, SpringLayout.NORTH, maNvLb);
		dienThongTinlayout.putConstraint(SpringLayout.NORTH, tenNvTf, 50, SpringLayout.NORTH, maNvTf);
		dienThongTinlayout.putConstraint(SpringLayout.NORTH, ngaySinhTf, 100, SpringLayout.NORTH, maNvTf);
		dienThongTinlayout.putConstraint(SpringLayout.NORTH, soDtTf, 150, SpringLayout.NORTH, maNvTf);

		dienThongTinlayout.putConstraint(SpringLayout.NORTH, groupJbutton, 50, SpringLayout.NORTH, soDtTf);
		dienThongTinlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, groupJbutton, 0,
				SpringLayout.HORIZONTAL_CENTER, dienThongTinNhanVien);

		// Tạo bảng Nhân Viên
		tableNhanVien = new JTable();
		tableNhanVien.setModel(new DefaultTableModel(data, columns));
		JScrollPane jScrollPaneNhanVien = new JScrollPane();
		jScrollPaneNhanVien.setViewportView(tableNhanVien);
		JPanel tableNhanVienJpanel = new JPanel();
		tableNhanVienJpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
				"Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Tahoma", Font.BOLD, 12)));
		tableNhanVienJpanel.setLayout(new BorderLayout());
		tableNhanVienJpanel.add(jScrollPaneNhanVien, BorderLayout.CENTER);

		// khung tìm kiếm nhân viên
		tkTenNvLb = new JLabel("Nhập tên");
		tkTenNvTf = new JTextField(12);
		timKiemBtn = new JButton("Tìm");
		reFreshBtn = new JButton("Refresh");
		JPanel timKiemJpanel = new JPanel();
		timKiemJpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
				"Tìm kiếm nhân viên", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Tahoma", Font.BOLD, 12)));
		timKiemJpanel.add(tkTenNvLb);
		timKiemJpanel.add(tkTenNvTf);
		timKiemJpanel.add(timKiemBtn);
		timKiemJpanel.add(reFreshBtn);
		SpringLayout timKiemLayout = new SpringLayout();
		timKiemJpanel.setLayout(timKiemLayout);
		timKiemLayout.putConstraint(SpringLayout.EAST, tkTenNvLb, -100, SpringLayout.HORIZONTAL_CENTER, timKiemJpanel);
		timKiemLayout.putConstraint(SpringLayout.VERTICAL_CENTER, tkTenNvLb, 0, SpringLayout.VERTICAL_CENTER,
				timKiemJpanel);

		timKiemLayout.putConstraint(SpringLayout.WEST, tkTenNvTf, 20, SpringLayout.EAST, tkTenNvLb);
		timKiemLayout.putConstraint(SpringLayout.VERTICAL_CENTER, tkTenNvTf, 0, SpringLayout.VERTICAL_CENTER,
				tkTenNvLb);

		timKiemLayout.putConstraint(SpringLayout.WEST, timKiemBtn, 20, SpringLayout.EAST, tkTenNvTf);
		timKiemLayout.putConstraint(SpringLayout.VERTICAL_CENTER, timKiemBtn, 0, SpringLayout.VERTICAL_CENTER,
				tkTenNvTf);
		timKiemLayout.putConstraint(SpringLayout.WEST, reFreshBtn, 10, SpringLayout.EAST, timKiemBtn);
		timKiemLayout.putConstraint(SpringLayout.VERTICAL_CENTER, reFreshBtn, 0, SpringLayout.VERTICAL_CENTER,
				timKiemBtn);

		JPanel mainJpanel = new JPanel();
		mainJpanel.add(dienThongTinNhanVien);
		mainJpanel.add(timKiemJpanel);
		mainJpanel.add(tableNhanVienJpanel);
		SpringLayout mainLayout = new SpringLayout();
		mainJpanel.setLayout(mainLayout);
		mainLayout.putConstraint(SpringLayout.WEST, dienThongTinNhanVien, 0, SpringLayout.WEST, mainJpanel);
		mainLayout.putConstraint(SpringLayout.SOUTH, dienThongTinNhanVien, 0, SpringLayout.SOUTH, mainJpanel);
		mainLayout.putConstraint(SpringLayout.EAST, dienThongTinNhanVien, 0, SpringLayout.HORIZONTAL_CENTER,
				mainJpanel);
		mainLayout.putConstraint(SpringLayout.NORTH, dienThongTinNhanVien, 0, SpringLayout.NORTH, mainJpanel);

		mainLayout.putConstraint(SpringLayout.WEST, timKiemJpanel, 0, SpringLayout.EAST, dienThongTinNhanVien);
		mainLayout.putConstraint(SpringLayout.SOUTH, timKiemJpanel, 100, SpringLayout.NORTH, mainJpanel);
		mainLayout.putConstraint(SpringLayout.EAST, timKiemJpanel, 0, SpringLayout.EAST, mainJpanel);
		mainLayout.putConstraint(SpringLayout.NORTH, timKiemJpanel, 0, SpringLayout.NORTH, mainJpanel);

		mainLayout.putConstraint(SpringLayout.WEST, tableNhanVienJpanel, 0, SpringLayout.WEST, timKiemJpanel);
		mainLayout.putConstraint(SpringLayout.SOUTH, tableNhanVienJpanel, 0, SpringLayout.SOUTH, mainJpanel);
		mainLayout.putConstraint(SpringLayout.EAST, tableNhanVienJpanel, 0, SpringLayout.EAST, mainJpanel);
		mainLayout.putConstraint(SpringLayout.NORTH, tableNhanVienJpanel, 0, SpringLayout.SOUTH, timKiemJpanel);

		this.setLayout(new BorderLayout());
		this.add(mainJpanel);
	}

	/**
	 * CÁC HÀM HỖ TRỢ XỬ LÝ SỰ KIỆN
	 * 
	 * @param args
	 */

	// SHOW DANH SÁCH NHÂN VIÊN LÊN TABLE
	public void showDanhSachNhanVien(ArrayList<NhanVien> list) {
		int size = list.size();

		Object[][] sv = new Object[size][5];
		for (int i = 0; i < size; i++) {
			sv[i][0] = i + 1;
			sv[i][1] = list.get(i).getMaNv();
			sv[i][2] = list.get(i).getTenNv();
			sv[i][3] = list.get(i).getNgaySinh();
			sv[i][4] = list.get(i).getsDt();
		}
		tableNhanVien.setModel(new DefaultTableModel(sv, columns));
	}

	// HIỂN THỊ THÔNG TIN NHÂN VÊN KHI CLICK VÀO TABLE
	public void hienThiNhanVienKhiClickTable() {
		int rows = tableNhanVien.getSelectedRow();
		if (rows >= 0) {
			maNvTf.setText(String.valueOf(tableNhanVien.getModel().getValueAt(rows, 1)));
			tenNvTf.setText(String.valueOf(tableNhanVien.getModel().getValueAt(rows, 2)));
			ngaySinhTf.setText(String.valueOf(tableNhanVien.getModel().getValueAt(rows, 3)));
			soDtTf.setText(String.valueOf(tableNhanVien.getModel().getValueAt(rows, 4)));
		}
		xoaBtn.setEnabled(true);
		suaBtn.setEnabled(true);
	}

	// LẤY THÔNG NHÂN VIÊN TẠI HÀNG ĐƯỢC CHỌN TRÊN TABLE
	public NhanVien GetTextSanPhamKhiClickOnTable() {
		int rows = tableNhanVien.getSelectedRow();
		String maNv = String.valueOf(tableNhanVien.getModel().getValueAt(rows, 1));
		String tenNv = String.valueOf(tableNhanVien.getModel().getValueAt(rows, 2));
		String ngaySinh = String.valueOf(tableNhanVien.getModel().getValueAt(rows, 3));
		String sDt = String.valueOf(tableNhanVien.getModel().getValueAt(rows, 4));
		return new NhanVien(maNv, tenNv, ngaySinh, sDt);
	}

	// LẤY THÔNG TIN NHÂN VIÊN TRÊN CÁC FEILD
	public NhanVien GetTextSanPhamField() {
		String maNv = String.valueOf(maNvTf.getText());
		String tenNv = String.valueOf(tenNvTf.getText());
		String ngaySinh = String.valueOf(ngaySinhTf.getText());
		String sDt = String.valueOf(soDtTf.getText());
		return new NhanVien(maNv, tenNv, ngaySinh, sDt);
	}

	// CLEAR THÔNG TIN TRÊN FEILD

	public void clearThongTinSp() {
		maNvTf.setText("");
		tenNvTf.setText("");
		ngaySinhTf.setText("");
		soDtTf.setText("");

		themBtn.setEnabled(true);
		xoaBtn.setEnabled(false);
		suaBtn.setEnabled(false);
		clearBtn.setEnabled(true);
	}

	public JTextField layNhanVienTimKiem() {
		return tkTenNvTf;
	}

	/**
	 * THÊM SỰ KIỆN CHO CÁC NÚT
	 * 
	 * @param args
	 */
	public void ClickOnTable(ListSelectionListener l) {
		tableNhanVien.getSelectionModel().addListSelectionListener(l);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	public void themButton(ActionListener l) {
		themBtn.addActionListener(l);
	}

	public void suaButton(ActionListener l) {
		suaBtn.addActionListener(l);
	}

	public void xoaButton(ActionListener l) {
		xoaBtn.addActionListener(l);
	}

	public void clearButton(ActionListener l) {
		clearBtn.addActionListener(l);
	}

	public void timKiemSanPham(ActionListener l) {
		timKiemBtn.addActionListener(l);
	}

	public void refreshSanPham(ActionListener l) {
		reFreshBtn.addActionListener(l);
	}

	public static void main(String[] args) {
		new QuanLiView();
	}

}
