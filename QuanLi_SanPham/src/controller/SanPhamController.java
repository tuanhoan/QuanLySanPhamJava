package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.SanPhamDAO;
import views.QuanLiView;
import views.SanPhamView;

public class SanPhamController extends JPanel implements ActionListener {
	private SanPhamView view;
	private SanPhamDAO dao;

	public SanPhamController() {
		view = new SanPhamView();
		dao = new SanPhamDAO();
		view.ListSanPhamTrenTable(dao.getListSanPham());
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

	public void getListSp() {
		view.ListSanPhamTrenTable(dao.getListSanPham());
	}

	public static void main(String[] args) {
		new QuanLiView();
	}

	// REFRESH THÔNG TIN
	class RefreshThongTin implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.ListSanPhamTrenTable(dao.getListSanPham());
			view.layTenSpTimKiem().setText("");
		}
	}
	// TÌM KIẾM SẢN PHẨM

	class TimKiemSanPham implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!dao.danhSachSpTimKiem(view.layTenSpTimKiem().getText()).isEmpty()) {
				view.ListSanPhamTrenTable(dao.danhSachSpTimKiem(view.layTenSpTimKiem().getText()));
			} else {
				view.showMessage("Không tồn tại sản phẩm " + " " + view.layTenSpTimKiem().getText());
			}

		}
	}

	// Khi click vào table sẽ settext vào các field
	class SetTextSanPham implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			view.SetTextSanPhamKhiClickOnTable();
		}
	}

	// Thêm một sản phẩm
	class ThemSanPham implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (dao.themSanPham(view.GetTextSanPhamField()) != 0) {
				view.ListSanPhamTrenTable(dao.getListSanPham());
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
			if (dao.suaSanPham(view.GetTextSanPhamKhiClickOnTable(), view.GetTextSanPhamField()) != 0) {
				view.ListSanPhamTrenTable(dao.getListSanPham());
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
			if (dao.xoaSanPham(view.GetTextSanPhamKhiClickOnTable()) != 0) {
				view.ListSanPhamTrenTable(dao.getListSanPham());
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
