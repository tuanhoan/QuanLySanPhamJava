package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import entities.HoaDon;
import entities.Item;
import entities.NhanVien;
import entities.SanPham;

public class BanSanPhamView extends JPanel implements ActionListener {

	// PHẦN HIỂN THỊ THÔNG TIN
	private JLabel maSpLb, tenSpLb, soLuongspLb, donGiaSpLb, ngayNhapLb, hanDungLb;
	private JLabel maSpLb1, tenSpLb1, donGiaSpLb1, ngayNhapLb1, hanDungLb1;
	private JTextField soLuongTf;
	private JButton chonBtn;

	// PHẦN CHI TIẾT HÓA ĐƠN
	private JLabel tongTienLb, tongTienLb1;
	private JButton thanhToanBtn, xoaBtn;
	private JTable tableChiTietHD;
	private String[] collumnChiTietHD = { "Stt", "Tên sản phẩm", "Số lượng", "Thành tiền" };
	private Object[][] dataChiTietHD = new Object[][] {};

	// THÔNG TIN CHO TABLE
	private JTable SanPhamTable;
	private String[] collumnSanPham = { "Stt", "Mã Sp", "Tên Sp", "Số lượng", "Đơn giá", "Ngày nhập", "Hạn dùng" };
	private Object[][] data = new Object[][] {};

	public BanSanPhamView() {
		View();
	}

	public static void main(String[] args) {
		new QuanLiView();
	}

	private void View() {
		// ĐIỀN THÔNG TIN VÉ
		JPanel thongTinSpJpanel = new JPanel();
		thongTinSpJpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),
				"Thông tin sản phẩm", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Tahoma", Font.BOLD, 12)));
		Font font = new Font("Tahoma", Font.ITALIC, 14);
		Font font2 = new Font("Tahoma", Font.BOLD, 14);
		maSpLb = new JLabel("Mã sản phẩm: ");
		maSpLb.setFont(font2);
		tenSpLb = new JLabel("Tên sản phẩm: ");
		tenSpLb.setFont(font2);
		soLuongspLb = new JLabel("Số lượng: ");
		soLuongspLb.setFont(font2);
		donGiaSpLb = new JLabel("Đơn giá: ");
		donGiaSpLb.setFont(font2);
		ngayNhapLb = new JLabel("Ngày nhập: ");
		ngayNhapLb.setFont(font2);
		hanDungLb = new JLabel("Hạn dùng: ");
		hanDungLb.setFont(font2);
		maSpLb1 = new JLabel("Mã sản phẩm: ");
		maSpLb1.setFont(font);
		tenSpLb1 = new JLabel("Tên sản phẩm: ");
		tenSpLb1.setFont(font);
		donGiaSpLb1 = new JLabel("Đơn giá: ");
		donGiaSpLb1.setFont(font);
		ngayNhapLb1 = new JLabel("Ngày nhập: ");
		ngayNhapLb1.setFont(font);
		hanDungLb1 = new JLabel("Hạn dùng: ");
		hanDungLb1.setFont(font);
		soLuongTf = new JTextField(8);
		chonBtn = new JButton("Thêm vào giỏ");

		thongTinSpJpanel.add(maSpLb);
		thongTinSpJpanel.add(tenSpLb);
		thongTinSpJpanel.add(soLuongspLb);
		thongTinSpJpanel.add(donGiaSpLb);
		thongTinSpJpanel.add(ngayNhapLb);
		thongTinSpJpanel.add(hanDungLb);
		thongTinSpJpanel.add(maSpLb1);
		thongTinSpJpanel.add(tenSpLb1);
		thongTinSpJpanel.add(soLuongTf);
		thongTinSpJpanel.add(donGiaSpLb1);
		thongTinSpJpanel.add(ngayNhapLb1);
		thongTinSpJpanel.add(hanDungLb1);
		thongTinSpJpanel.add(chonBtn);

		SpringLayout thongTinSPLayout = new SpringLayout();
		thongTinSpJpanel.setLayout(thongTinSPLayout);
		thongTinSPLayout.putConstraint(SpringLayout.NORTH, maSpLb, 12, SpringLayout.NORTH, thongTinSpJpanel);
		thongTinSPLayout.putConstraint(SpringLayout.NORTH, tenSpLb, 30, SpringLayout.NORTH, maSpLb);
		thongTinSPLayout.putConstraint(SpringLayout.NORTH, donGiaSpLb, 60, SpringLayout.NORTH, maSpLb);
		thongTinSPLayout.putConstraint(SpringLayout.NORTH, ngayNhapLb, 90, SpringLayout.NORTH, maSpLb);
		thongTinSPLayout.putConstraint(SpringLayout.NORTH, hanDungLb, 120, SpringLayout.NORTH, maSpLb);
		thongTinSPLayout.putConstraint(SpringLayout.NORTH, soLuongspLb, 150, SpringLayout.NORTH, maSpLb);

		thongTinSPLayout.putConstraint(SpringLayout.WEST, maSpLb, 70, SpringLayout.WEST, thongTinSpJpanel);
		thongTinSPLayout.putConstraint(SpringLayout.WEST, tenSpLb, 0, SpringLayout.WEST, maSpLb);
		thongTinSPLayout.putConstraint(SpringLayout.WEST, donGiaSpLb, 0, SpringLayout.WEST, maSpLb);
		thongTinSPLayout.putConstraint(SpringLayout.WEST, ngayNhapLb, 0, SpringLayout.WEST, maSpLb);
		thongTinSPLayout.putConstraint(SpringLayout.WEST, hanDungLb, 0, SpringLayout.WEST, maSpLb);
		thongTinSPLayout.putConstraint(SpringLayout.WEST, soLuongspLb, 0, SpringLayout.WEST, maSpLb);

		thongTinSPLayout.putConstraint(SpringLayout.NORTH, maSpLb1, 0, SpringLayout.NORTH, maSpLb);
		thongTinSPLayout.putConstraint(SpringLayout.NORTH, tenSpLb1, 30, SpringLayout.NORTH, maSpLb1);
		thongTinSPLayout.putConstraint(SpringLayout.NORTH, donGiaSpLb1, 60, SpringLayout.NORTH, maSpLb1);
		thongTinSPLayout.putConstraint(SpringLayout.NORTH, ngayNhapLb1, 90, SpringLayout.NORTH, maSpLb1);
		thongTinSPLayout.putConstraint(SpringLayout.NORTH, hanDungLb1, 120, SpringLayout.NORTH, maSpLb1);
		thongTinSPLayout.putConstraint(SpringLayout.NORTH, soLuongTf, 150, SpringLayout.NORTH, maSpLb1);

		thongTinSPLayout.putConstraint(SpringLayout.WEST, maSpLb1, 150, SpringLayout.WEST, maSpLb);
		thongTinSPLayout.putConstraint(SpringLayout.WEST, tenSpLb1, 0, SpringLayout.WEST, maSpLb1);
		thongTinSPLayout.putConstraint(SpringLayout.WEST, donGiaSpLb1, 0, SpringLayout.WEST, maSpLb1);
		thongTinSPLayout.putConstraint(SpringLayout.WEST, ngayNhapLb1, 0, SpringLayout.WEST, maSpLb1);
		thongTinSPLayout.putConstraint(SpringLayout.WEST, hanDungLb1, 0, SpringLayout.WEST, maSpLb1);
		thongTinSPLayout.putConstraint(SpringLayout.WEST, soLuongTf, 0, SpringLayout.WEST, maSpLb1);

		thongTinSPLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, chonBtn, 0, SpringLayout.HORIZONTAL_CENTER,
				thongTinSpJpanel);
		thongTinSPLayout.putConstraint(SpringLayout.SOUTH, chonBtn, -2, SpringLayout.SOUTH, thongTinSpJpanel);

		// DANH SÁCH VÉ
		JPanel danhSachSPJpanel = new JPanel();
		danhSachSPJpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),
				"Danh sách sản phẩm", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Tahoma", Font.BOLD, 12)));
		// Tạo bảng sp
		SanPhamTable = new JTable();
		JScrollPane SanPhamTableJscroll = new JScrollPane();
		SanPhamTable.setModel(new DefaultTableModel(data, collumnSanPham));
		SanPhamTableJscroll.setViewportView(SanPhamTable);
		danhSachSPJpanel.setLayout(new BorderLayout());
		danhSachSPJpanel.add(SanPhamTableJscroll, BorderLayout.CENTER);
		// CHi TIẾT HÓA ĐƠN

		JPanel chiTietHoaDonJpanel = new JPanel();
		chiTietHoaDonJpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),
				"Giỏ hàng", TitledBorder.CENTER, TitledBorder.CENTER, new Font("Tahoma", Font.BOLD, 12)));
		tableChiTietHD = new JTable();
		JScrollPane SanPhamTableJscroll2 = new JScrollPane();
		tableChiTietHD.setModel(new DefaultTableModel(dataChiTietHD, collumnChiTietHD));
		SanPhamTableJscroll2.setViewportView(tableChiTietHD);
		chiTietHoaDonJpanel.setLayout(new BorderLayout());
		chiTietHoaDonJpanel.add(SanPhamTableJscroll2, BorderLayout.CENTER);

		hoaDonJpanel = new JPanel();
		hoaDonCardLayout = new CardLayout();
		hoaDonJpanel.setLayout(hoaDonCardLayout);
		hoaDonJpanel.add(chiTietHoaDonJpanel, "cthd");
		hoaDonJpanel.add(dienMaNVJpanel(), "dtt");

		// TỔNG TIỀN VÀ THANH TOÁN HÓA ĐƠN
		tongTienLb = new JLabel("Tổng tiền:");
		tongTienLb1 = new JLabel("80000000");
		thanhToanBtn = new JButton("Thanh toán");
		thanhToanBtn.addActionListener(this);
		// Khung chính
		JPanel mainJpanel = new JPanel();
		mainJpanel.add(thongTinSpJpanel);
		mainJpanel.add(danhSachSPJpanel);
		mainJpanel.add(hoaDonJpanel);
		mainJpanel.add(tongTienLb);
		mainJpanel.add(tongTienLb1);
		mainJpanel.add(thanhToanBtn);

		SpringLayout mainLayout = new SpringLayout();
		mainJpanel.setLayout(mainLayout);

		mainLayout.putConstraint(SpringLayout.NORTH, thongTinSpJpanel, 0, SpringLayout.NORTH, mainJpanel);
		mainLayout.putConstraint(SpringLayout.WEST, thongTinSpJpanel, 0, SpringLayout.WEST, mainJpanel);
		mainLayout.putConstraint(SpringLayout.EAST, thongTinSpJpanel, -60, SpringLayout.HORIZONTAL_CENTER, mainJpanel);
		mainLayout.putConstraint(SpringLayout.SOUTH, thongTinSpJpanel, 0, SpringLayout.VERTICAL_CENTER, mainJpanel);

		mainLayout.putConstraint(SpringLayout.NORTH, danhSachSPJpanel, 0, SpringLayout.NORTH, mainJpanel);
		mainLayout.putConstraint(SpringLayout.WEST, danhSachSPJpanel, 0, SpringLayout.EAST, thongTinSpJpanel);
		mainLayout.putConstraint(SpringLayout.EAST, danhSachSPJpanel, 0, SpringLayout.EAST, mainJpanel);
		mainLayout.putConstraint(SpringLayout.SOUTH, danhSachSPJpanel, 0, SpringLayout.SOUTH, mainJpanel);

		mainLayout.putConstraint(SpringLayout.NORTH, hoaDonJpanel, 0, SpringLayout.SOUTH, thongTinSpJpanel);
		mainLayout.putConstraint(SpringLayout.WEST, hoaDonJpanel, 0, SpringLayout.WEST, mainJpanel);
		mainLayout.putConstraint(SpringLayout.EAST, hoaDonJpanel, -60, SpringLayout.HORIZONTAL_CENTER, mainJpanel);
		mainLayout.putConstraint(SpringLayout.SOUTH, hoaDonJpanel, -30, SpringLayout.SOUTH, mainJpanel);

		mainLayout.putConstraint(SpringLayout.SOUTH, tongTienLb, -5, SpringLayout.SOUTH, mainJpanel);
		mainLayout.putConstraint(SpringLayout.WEST, tongTienLb, 5, SpringLayout.WEST, mainJpanel);

		mainLayout.putConstraint(SpringLayout.WEST, tongTienLb1, 100, SpringLayout.WEST, tongTienLb);
		mainLayout.putConstraint(SpringLayout.VERTICAL_CENTER, tongTienLb1, 0, SpringLayout.VERTICAL_CENTER,
				tongTienLb);

		mainLayout.putConstraint(SpringLayout.WEST, thanhToanBtn, 100, SpringLayout.WEST, tongTienLb1);
		mainLayout.putConstraint(SpringLayout.VERTICAL_CENTER, thanhToanBtn, 0, SpringLayout.VERTICAL_CENTER,
				tongTienLb1);

		this.setLayout(new BorderLayout());
		this.add(mainJpanel);
	}

	// KHUNG ĐIỀN MÃ NHÂN VIÊN
	private JLabel maNvLb;
	private JTextField maNvTf;
	private JButton xongBtn, thoatBtn;

	public JPanel dienMaNVJpanel() {
		maNvLb = new JLabel("Nhập mã NV");
		maNvTf = new JTextField(10);
		xongBtn = new JButton("Xong");
		thoatBtn = new JButton("Thoát");
		thoatBtn.addActionListener(this);
		JPanel groupButton = new JPanel();
		groupButton.setLayout(new GridLayout(1, 2, 5, 5));
		groupButton.add(xongBtn);
		groupButton.add(thoatBtn);
		JPanel dienMaNvJpanel = new JPanel();
		dienMaNvJpanel.add(maNvLb);
		dienMaNvJpanel.add(maNvTf);
		dienMaNvJpanel.add(groupButton);

		SpringLayout layout = new SpringLayout();
		dienMaNvJpanel.setLayout(layout);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, maNvLb, 0, SpringLayout.HORIZONTAL_CENTER, dienMaNvJpanel);
		layout.putConstraint(SpringLayout.NORTH, maNvLb, 20, SpringLayout.NORTH, dienMaNvJpanel);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, maNvTf, 0, SpringLayout.HORIZONTAL_CENTER, dienMaNvJpanel);
		layout.putConstraint(SpringLayout.NORTH, maNvTf, 20, SpringLayout.SOUTH, maNvLb);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, groupButton, 0, SpringLayout.HORIZONTAL_CENTER,
				dienMaNvJpanel);
		layout.putConstraint(SpringLayout.NORTH, groupButton, 20, SpringLayout.SOUTH, maNvTf);
		dienMaNvJpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "",
				TitledBorder.CENTER, TitledBorder.CENTER, new Font("Tahoma", Font.BOLD, 12)));
		return dienMaNvJpanel;
	}

	/**
	 * CÁC HÀM HỖ TRỢ XỬ LÝ SỰ KIỆN
	 */
	// XỬ LÝ THANH TOÁN HÓA ĐƠN

	private CardLayout hoaDonCardLayout;
	private JPanel hoaDonJpanel;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == thanhToanBtn) {
			hoaDonCardLayout.show(hoaDonJpanel, "dtt");
		}
		if (e.getSource() == thoatBtn) {
			hoaDonCardLayout.show(hoaDonJpanel, "cthd");
		}
	}

	// LẤY DANH SÁCH SẢN PHẨM TỪ DATABASE VÀO TABLE
	public void listHoaDon(ArrayList<Item> list) {
		int size = list.size();

		Object[][] sv = new Object[size][4];
		for (int i = 0; i < size; i++) {
			sv[i][0] = i + 1;
			sv[i][1] = list.get(i).getSanPham().getTenSp();
			sv[i][2] = list.get(i).getSoLuong();
			sv[i][3] = list.get(i).tongTien();

		}
		tableChiTietHD.setModel(new DefaultTableModel(sv, collumnChiTietHD));
	}

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
			maSpLb1.setText(String.valueOf(SanPhamTable.getModel().getValueAt(rows, 1)));
			tenSpLb1.setText(String.valueOf(SanPhamTable.getModel().getValueAt(rows, 2)));
			donGiaSpLb1.setText(String.valueOf(SanPhamTable.getModel().getValueAt(rows, 4)));
			ngayNhapLb1.setText(String.valueOf(SanPhamTable.getModel().getValueAt(rows, 5)));
			hanDungLb1.setText(String.valueOf(SanPhamTable.getModel().getValueAt(rows, 6)));
		}

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

	// LẤY THÔNG TIN Item
	public Item layThongTinItem() {
		String maSp = String.valueOf(maSpLb1.getText());
		String tenSp = String.valueOf(tenSpLb1.getText());
		int soLuong = Integer.parseInt(String.valueOf(soLuongTf.getText()));
		int donGia = Integer.parseInt(String.valueOf(donGiaSpLb1.getText()));
		String ngayNhap = String.valueOf(ngayNhapLb1.getText());
		String hanDung = String.valueOf(hanDungLb1.getText());
		SanPham sp = new SanPham(maSp, tenSp, donGia, ngayNhap, hanDung);
		return new Item(sp, soLuong);
	}

	// LẤY NÚT THOÁT
	public JButton layNutThoat() {
		return thoatBtn;
	}

	public JTextField layMaNhanVien() {
		return maNvTf;
	}

	public boolean checkThongTinNhanVien(ArrayList<NhanVien> list, String tenNv) {
		for (NhanVien temp : list) {
			if (temp.getMaNv().equals(tenNv)) {
				return true;
			}
		}
		return false;
	}

	public JLabel layTongTien() {
		return tongTienLb1;
	}

	// CLear THÔNG TIN
	public void clearThongTin() {
		maSpLb1.setText("");
		tenSpLb1.setText("");
		donGiaSpLb1.setText("");
		ngayNhapLb1.setText("");
		hanDungLb1.setText("");
		soLuongTf.setText("");
	}

	/**
	 * THÊM SỰ KIỆN CHO CÁC NÚT
	 * 
	 */
	public void ClickOnTable(ListSelectionListener l) {
		SanPhamTable.getSelectionModel().addListSelectionListener(l);
	}

	public void chonItem(ActionListener l) {
		chonBtn.addActionListener(l);
	}

	public void thanhToanBtn(ActionListener l) {
		thanhToanBtn.addActionListener(l);
	}

	public void xongBtn(ActionListener l) {
		xongBtn.addActionListener(l);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
