package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.HoaDonDAO;
import views.HoaDonView;

public class HoaDonController extends JPanel {
	private HoaDonView view;
	private HoaDonDAO dao;

	public HoaDonController() {
		view = new HoaDonView();
		dao = new HoaDonDAO();
		view.ListSanPhamTrenTable(dao.getListHoaDon());
		view.ClickOnTable(new ShowChiTietHoaDon());
		this.setLayout(new BorderLayout());
		this.add(view, BorderLayout.CENTER);
	}

	// SHOW CHI TIẾT HÓA ĐƠN
	class ShowChiTietHoaDon implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			view.showListChiTietHoaDon(dao.danhSachCTHDhistory(view.layMaHoaDon()));
		}
	}

	public HoaDonView getView() {
		return view;
	}

	public void setView(HoaDonView view) {
		this.view = view;
	}

	public HoaDonDAO getDao() {
		return dao;
	}

	public void setDao(HoaDonDAO dao) {
		this.dao = dao;
	}

}
