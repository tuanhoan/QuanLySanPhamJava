package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.NhanVienDAO;
import views.NhanVienView;
import views.QuanLiView;

public class NhanVienController extends JPanel {
	private NhanVienView view;
	private NhanVienDAO dao;

	public static void main(String[] args) {
		new QuanLiView();
	}

	public NhanVienController() {
		dao = new NhanVienDAO();
		view = new NhanVienView();
		view.showDanhSachNhanVien(dao.getListNhanVien());
		view.clearThongTinSp();
		view.ClickOnTable(new SetTextSanPham());
		view.themButton(new ThemSanPham());
		view.suaButton(new SuaSanPham());
		view.xoaButton(new XoaSanPham());
		view.clearButton(new ClearThongTinSp());
		view.timKiemSanPham(new TimKiemSanPham());
		view.refreshSanPham(new RefreshThongTin());
		this.setLayout(new BorderLayout());
		this.add(view, BorderLayout.CENTER);
	}

	// REFRESH THÔNG TIN
	class RefreshThongTin implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.showDanhSachNhanVien(dao.getListNhanVien());
			view.layNhanVienTimKiem().setText("");
		}
	}
	// TÌM KIẾM SẢN PHẨM

	class TimKiemSanPham implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!dao.danhSachNvTimKiem(view.layNhanVienTimKiem().getText()).isEmpty()) {
				view.showDanhSachNhanVien(dao.danhSachNvTimKiem(view.layNhanVienTimKiem().getText()));
			} else {
				view.showMessage("Không tồn tại nhân viên " + " " + view.layNhanVienTimKiem().getText());
			}

		}
	}

	// Khi click vào table sẽ settext vào các field
	class SetTextSanPham implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			view.hienThiNhanVienKhiClickTable();
		}
	}

	// Thêm một sản phẩm
	class ThemSanPham implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (dao.themNhanVien(view.GetTextSanPhamField()) != 0) {
				view.showDanhSachNhanVien(dao.getListNhanVien());
				view.clearThongTinSp();
				view.showMessage("Thêm thành công");
			} else {
				view.showMessage("Thêm thất bại");
			}
		}
	}

	// Sửa thông tin sản phẩm
	class SuaSanPham implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (dao.suaNhanVien(view.GetTextSanPhamKhiClickOnTable(), view.GetTextSanPhamField()) != 0) {
				view.showDanhSachNhanVien(dao.getListNhanVien());
				view.clearThongTinSp();
				view.showMessage("Sửa thành công");
			} else {
				view.showMessage("Sửa thất bại");
			}
		}
	}

	// XÓA MỘT SẢN PHẨM
	class XoaSanPham implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (dao.xoaNhanVien(view.GetTextSanPhamKhiClickOnTable()) != 0) {
				view.showDanhSachNhanVien(dao.getListNhanVien());
				view.clearThongTinSp();
				view.showMessage("Xóa thành công");
			} else {
				view.showMessage("Xóa thất bại");
			}

		}
	}

	class ClearThongTinSp implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.clearThongTinSp();
		}
	}
}
