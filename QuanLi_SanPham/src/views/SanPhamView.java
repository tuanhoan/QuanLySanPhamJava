package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.SanPhamController;
import dao.SanPhamDAO;
import entities.SanPham;

public class SanPhamView extends JPanel implements ListSelectionListener, ActionListener {

	// KHUNG ĐIỀN THÔNG TIN SẢN PHẨM
	private JLabel maSpLb, tenSpLb, soLuongspLb, donGiaSpLb, ngayNhapLb, hanDungLb;
	private JTextField maSpTf, tenSpTf, soLuongspTf, donGiaSpTf, ngayNhapTf, hanDungTf;
	private JButton themBtn, suaBtn, xoaBtn, clearBtn;

	// KHUNG SHOW DANH SÁCH SẢN PHẨM
	private JTable SanPhamTable;
	private JScrollPane SanPhamTableJscroll;
	private String[] collumnSanPham = { "Stt", "Mã Sp", "Tên Sp", "Số lượng", "Đơn giá", "Ngày nhập", "Hạn dùng" };
	private Object[][] data = new Object[][] {};

	// KHUNG TÌM KIẾM SẢN PHẨM
	private JLabel tkTenSpLb;
	private JTextField tkTenSpTf;
	private JButton timKiemBtn, refreshBtn;

	public static void main(String[] args) {
		new QuanLiView();
	}

	public SanPhamView() {
		init();
	}

//	public void centerWindow() {
//		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//		int x = (int) ((dimension.getWidth() - getWidth()) / 2);
//		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
//		setLocation(x, y);
//	}

	private void init() {

		JPanel pnLeft = new JPanel();
		maSpLb = new JLabel("Mã");
		tenSpLb = new JLabel("Tên");
		soLuongspLb = new JLabel("Số lượng");
		donGiaSpLb = new JLabel("Đơn giá");
		ngayNhapLb = new JLabel("Ngày nhập");
		hanDungLb = new JLabel("Hạn dùng");
		maSpTf = new JTextField(12);
		tenSpTf = new JTextField(12);
		soLuongspTf = new JTextField(12);
		donGiaSpTf = new JTextField(12);
		ngayNhapTf = new JTextField(12);
		hanDungTf = new JTextField(12);

		themBtn = new JButton("Thêm");
		suaBtn = new JButton("Sửa");
		xoaBtn = new JButton("Xóa");
		clearBtn = new JButton("Clear");
		// Tạo bảng sp
		SanPhamTable = new JTable();
		SanPhamTableJscroll = new JScrollPane();
		SanPhamTable.setModel(new DefaultTableModel(data, collumnSanPham));
		SanPhamTableJscroll.setViewportView(SanPhamTable);

		JPanel groupButton = new JPanel();
		groupButton.setLayout(new GridLayout(1, 4, 5, 5));
		groupButton.add(themBtn);
		groupButton.add(suaBtn);
		groupButton.add(xoaBtn);
		groupButton.add(clearBtn);

		// Khung điền thông tin sản phẩm
		JPanel dienThongTinSanPham = new JPanel();
		dienThongTinSanPham.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
				"Điền thông tin", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Tahoma", Font.BOLD, 12)));

		SpringLayout layout = new SpringLayout();
		dienThongTinSanPham.setLayout(layout);
		dienThongTinSanPham.add(maSpLb);
		dienThongTinSanPham.add(tenSpLb);
		dienThongTinSanPham.add(soLuongspLb);
		dienThongTinSanPham.add(donGiaSpLb);
		dienThongTinSanPham.add(ngayNhapLb);
		dienThongTinSanPham.add(hanDungLb);

		dienThongTinSanPham.add(maSpTf);
		dienThongTinSanPham.add(tenSpTf);
		dienThongTinSanPham.add(soLuongspTf);
		dienThongTinSanPham.add(donGiaSpTf);
		dienThongTinSanPham.add(ngayNhapTf);
		dienThongTinSanPham.add(hanDungTf);
		dienThongTinSanPham.add(groupButton);

		layout.putConstraint(SpringLayout.EAST, maSpLb, -100, SpringLayout.HORIZONTAL_CENTER, dienThongTinSanPham);
		layout.putConstraint(SpringLayout.WEST, tenSpLb, 0, SpringLayout.WEST, maSpLb);
		layout.putConstraint(SpringLayout.WEST, soLuongspLb, 0, SpringLayout.WEST, maSpLb);
		layout.putConstraint(SpringLayout.WEST, donGiaSpLb, 0, SpringLayout.WEST, maSpLb);
		layout.putConstraint(SpringLayout.WEST, ngayNhapLb, 0, SpringLayout.WEST, maSpLb);
		layout.putConstraint(SpringLayout.WEST, hanDungLb, 0, SpringLayout.WEST, maSpLb);

		layout.putConstraint(SpringLayout.NORTH, maSpLb, 50, SpringLayout.NORTH, dienThongTinSanPham);
		layout.putConstraint(SpringLayout.NORTH, tenSpLb, 50, SpringLayout.NORTH, maSpLb);
		layout.putConstraint(SpringLayout.NORTH, soLuongspLb, 100, SpringLayout.NORTH, maSpLb);
		layout.putConstraint(SpringLayout.NORTH, donGiaSpLb, 150, SpringLayout.NORTH, maSpLb);
		layout.putConstraint(SpringLayout.NORTH, ngayNhapLb, 200, SpringLayout.NORTH, maSpLb);
		layout.putConstraint(SpringLayout.NORTH, hanDungLb, 250, SpringLayout.NORTH, maSpLb);

		layout.putConstraint(SpringLayout.WEST, maSpTf, 0, SpringLayout.HORIZONTAL_CENTER, dienThongTinSanPham);
		layout.putConstraint(SpringLayout.WEST, tenSpTf, 0, SpringLayout.WEST, maSpTf);
		layout.putConstraint(SpringLayout.WEST, soLuongspTf, 0, SpringLayout.WEST, maSpTf);
		layout.putConstraint(SpringLayout.WEST, donGiaSpTf, 0, SpringLayout.WEST, maSpTf);
		layout.putConstraint(SpringLayout.WEST, ngayNhapTf, 0, SpringLayout.WEST, maSpTf);
		layout.putConstraint(SpringLayout.WEST, hanDungTf, 0, SpringLayout.WEST, maSpTf);

		layout.putConstraint(SpringLayout.NORTH, maSpTf, 0, SpringLayout.NORTH, maSpLb);
		layout.putConstraint(SpringLayout.NORTH, tenSpTf, 0, SpringLayout.NORTH, tenSpLb);
		layout.putConstraint(SpringLayout.NORTH, soLuongspTf, 0, SpringLayout.NORTH, soLuongspLb);
		layout.putConstraint(SpringLayout.NORTH, donGiaSpTf, 0, SpringLayout.NORTH, donGiaSpLb);
		layout.putConstraint(SpringLayout.NORTH, ngayNhapTf, 0, SpringLayout.NORTH, ngayNhapLb);
		layout.putConstraint(SpringLayout.NORTH, hanDungTf, 0, SpringLayout.NORTH, hanDungLb);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, groupButton, 0, SpringLayout.HORIZONTAL_CENTER,
				dienThongTinSanPham);
		layout.putConstraint(SpringLayout.NORTH, groupButton, 50, SpringLayout.NORTH, hanDungTf);

		// KHUNG TÌM KIẾM SẢN PHẨM
		JPanel timKiemSPJpanel = new JPanel();
		timKiemSPJpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
				"Tìm kiếm sản phẩm", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Tahoma", Font.BOLD, 12)));
		tkTenSpLb = new JLabel("Nhập tên sản phẩm");
		tkTenSpTf = new JTextField(12);
		timKiemBtn = new JButton("Tìm kiếm");
		refreshBtn = new JButton("Refresh");
		timKiemSPJpanel.add(tkTenSpLb);
		timKiemSPJpanel.add(tkTenSpTf);
		timKiemSPJpanel.add(timKiemBtn);
		timKiemSPJpanel.add(refreshBtn);
		SpringLayout timKiemLayout = new SpringLayout();
		timKiemSPJpanel.setLayout(timKiemLayout);
		timKiemLayout.putConstraint(SpringLayout.EAST, tkTenSpLb, -100, SpringLayout.HORIZONTAL_CENTER,
				timKiemSPJpanel);
		timKiemLayout.putConstraint(SpringLayout.VERTICAL_CENTER, tkTenSpLb, 0, SpringLayout.VERTICAL_CENTER,
				timKiemSPJpanel);

		timKiemLayout.putConstraint(SpringLayout.WEST, tkTenSpTf, 20, SpringLayout.EAST, tkTenSpLb);
		timKiemLayout.putConstraint(SpringLayout.VERTICAL_CENTER, tkTenSpTf, 0, SpringLayout.VERTICAL_CENTER,
				tkTenSpLb);

		timKiemLayout.putConstraint(SpringLayout.WEST, timKiemBtn, 20, SpringLayout.EAST, tkTenSpTf);
		timKiemLayout.putConstraint(SpringLayout.VERTICAL_CENTER, timKiemBtn, 0, SpringLayout.VERTICAL_CENTER,
				tkTenSpTf);
		timKiemLayout.putConstraint(SpringLayout.WEST, refreshBtn, 10, SpringLayout.EAST, timKiemBtn);
		timKiemLayout.putConstraint(SpringLayout.VERTICAL_CENTER, refreshBtn, 0, SpringLayout.VERTICAL_CENTER,
				timKiemBtn);
		// Khung danh sách sản phẩm

		JPanel danhSachSPJpanel = new JPanel();
		danhSachSPJpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
				"Danh sách sản phẩm", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Tahoma", Font.BOLD, 12)));
		danhSachSPJpanel.setLayout(new BorderLayout());
		danhSachSPJpanel.add(SanPhamTableJscroll, BorderLayout.CENTER);

		JPanel mainJpanel = new JPanel();
		mainJpanel.add(dienThongTinSanPham);
		mainJpanel.add(timKiemSPJpanel);
		mainJpanel.add(danhSachSPJpanel);
		SpringLayout mainLayout = new SpringLayout();
		mainJpanel.setLayout(mainLayout);
		mainLayout.putConstraint(SpringLayout.WEST, dienThongTinSanPham, 0, SpringLayout.WEST, mainJpanel);
		mainLayout.putConstraint(SpringLayout.SOUTH, dienThongTinSanPham, 0, SpringLayout.SOUTH, mainJpanel);
		mainLayout.putConstraint(SpringLayout.EAST, dienThongTinSanPham, 0, SpringLayout.HORIZONTAL_CENTER, mainJpanel);
		mainLayout.putConstraint(SpringLayout.NORTH, dienThongTinSanPham, 0, SpringLayout.NORTH, mainJpanel);

		mainLayout.putConstraint(SpringLayout.WEST, timKiemSPJpanel, 0, SpringLayout.EAST, dienThongTinSanPham);
		mainLayout.putConstraint(SpringLayout.SOUTH, timKiemSPJpanel, 100, SpringLayout.NORTH, mainJpanel);
		mainLayout.putConstraint(SpringLayout.EAST, timKiemSPJpanel, 0, SpringLayout.EAST, mainJpanel);
		mainLayout.putConstraint(SpringLayout.NORTH, timKiemSPJpanel, 0, SpringLayout.NORTH, mainJpanel);

		mainLayout.putConstraint(SpringLayout.WEST, danhSachSPJpanel, 0, SpringLayout.WEST, timKiemSPJpanel);
		mainLayout.putConstraint(SpringLayout.SOUTH, danhSachSPJpanel, 0, SpringLayout.SOUTH, mainJpanel);
		mainLayout.putConstraint(SpringLayout.EAST, danhSachSPJpanel, 0, SpringLayout.EAST, mainJpanel);
		mainLayout.putConstraint(SpringLayout.NORTH, danhSachSPJpanel, 0, SpringLayout.SOUTH, timKiemSPJpanel);
		this.setLayout(new BorderLayout());
		this.add(mainJpanel, BorderLayout.CENTER);
	}

	/**
	 * CÁC HÀM HỖ TRỢ XỬ LÍ SỰ KIỆN
	 * 
	 */
	// LẤY DANH SÁCH SẢN PHẨM TỪ DATABASE VÀO TABLE
	public void ListSanPhamTrenTable(ArrayList<SanPham> list) {
		int size = list.size();

		Object[][] sv = new Object[size][7];
		for (int i = 0; i < size; i++) {
			sv[i][0] = i + 1;
			sv[i][1] = list.get(i).getMaSp();
			sv[i][2] = list.get(i).getTenSp();
			sv[i][3] = list.get(i).getSoLuong();
			sv[i][4] = list.get(i).getDonGia();
			sv[i][5] = list.get(i).getNgayNhap();
			sv[i][6] = list.get(i).getHanDung();
		}
		SanPhamTable.setModel(new DefaultTableModel(sv, collumnSanPham));
	}

	// HIỂN THỊ THÔNG TIN KHI CLICK VÀO TABLE
	public void SetTextSanPhamKhiClickOnTable() {
		int rows = SanPhamTable.getSelectedRow();
		if (rows >= 0) {
			maSpTf.setText(String.valueOf(SanPhamTable.getModel().getValueAt(rows, 1)));
			tenSpTf.setText(String.valueOf(SanPhamTable.getModel().getValueAt(rows, 2)));
			soLuongspTf.setText(String.valueOf(SanPhamTable.getModel().getValueAt(rows, 3)));
			donGiaSpTf.setText(String.valueOf(SanPhamTable.getModel().getValueAt(rows, 4)));
			ngayNhapTf.setText(String.valueOf(SanPhamTable.getModel().getValueAt(rows, 5)));
			hanDungTf.setText(String.valueOf(SanPhamTable.getModel().getValueAt(rows, 6)));
		}
		xoaBtn.setEnabled(true);
		suaBtn.setEnabled(true);
	}

	// LẤY THÔNG SẢN PHẨM TẠI HÀNG ĐƯỢC CHỌN
	public SanPham GetTextSanPhamKhiClickOnTable() {
		int rows = SanPhamTable.getSelectedRow();
		String maSp = String.valueOf(SanPhamTable.getModel().getValueAt(rows, 1));
		String tenSp = String.valueOf(SanPhamTable.getModel().getValueAt(rows, 2));
		int soLuong = Integer.parseInt(String.valueOf(SanPhamTable.getModel().getValueAt(rows, 3)));
		int donGia = Integer.parseInt(String.valueOf(SanPhamTable.getModel().getValueAt(rows, 4)));
		String ngayNhap = String.valueOf(SanPhamTable.getModel().getValueAt(rows, 5));
		String hanDung = String.valueOf(SanPhamTable.getModel().getValueAt(rows, 6));
		return new SanPham(maSp, tenSp, soLuong, donGia, ngayNhap, hanDung);
	}

	// LẤY THÔNG TIN SẢM PHẨM TRÊN CÁC FEILD
	public SanPham GetTextSanPhamField() {
		String maSp = String.valueOf(maSpTf.getText());
		String tenSp = String.valueOf(tenSpTf.getText());
		int soLuong = Integer.parseInt(String.valueOf(soLuongspTf.getText()));
		int donGia = Integer.parseInt(String.valueOf(donGiaSpTf.getText()));
		String ngayNhap = String.valueOf(ngayNhapTf.getText());
		String hanDung = String.valueOf(hanDungTf.getText());
		return new SanPham(maSp, tenSp, soLuong, donGia, ngayNhap, hanDung);
	}

	// CLEAR THÔNG TIN TRÊN FEILD

	public void clearThongTinSp() {
		maSpTf.setText("");
		tenSpTf.setText("");
		soLuongspTf.setText("");
		donGiaSpTf.setText("");
		ngayNhapTf.setText("");
		hanDungTf.setText("");
		
		themBtn.setEnabled(true);
		xoaBtn.setEnabled(false);
		suaBtn.setEnabled(false);
		clearBtn.setEnabled(true);
	}

	public JTextField layTenSpTimKiem() {
		return tkTenSpTf;
	}

	/**
	 * THÊM SỰ KIỆN CHO CÁC NÚT
	 * 
	 * @param l
	 */

	public void ClickOnTable(ListSelectionListener l) {
		SanPhamTable.getSelectionModel().addListSelectionListener(l);
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
		refreshBtn.addActionListener(l);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
