package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.BanHangController.ThemItemVaoGioHang;
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
		view.report(new Report());
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

	class Report implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
//			try {
//				InputStream inputStream = new FileInputStream(new File(""));
//				JasperReport jr = JasperCompileManager.compileReport(reportPath);
//				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
//				JasperViewer.viewReport(jp);
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}

		}
	}

}
