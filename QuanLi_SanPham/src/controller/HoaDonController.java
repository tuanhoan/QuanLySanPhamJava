package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.BanHangController.ThemItemVaoGioHang;
import dao.HoaDonDAO;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.fill.JasperReportSource;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
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
//				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				Connection con = (Connection) DriverManager.getConnection(
//						"jdbc:sqlserver://localhost:1433;databaseName=QUANLISANPHAM",
//						"tuanhoan", "1");
// 
//				JasperReport jr = JasperCompileManager
//						.compileReport("C:\\Users\\Administrator\\git\\QuanLySanPhamJava\\QuanLi_SanPham\\report_HoaDon.jrxml");
//				JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap(), con);
//				JasperViewer.viewReport(jp);
//				JasperExportManager.exportReportToPdfFile(jp,
//						"D:\\report1.pdf");
//			} catch (ClassNotFoundException | SQLException | JRException e1) {
//				JOptionPane.showMessageDialog(null, "Cannot show report" + ((Throwable) e1).getMessage());
//			}

			JasperReport jasperReport;
			try {
				Connection con = (Connection) DriverManager.getConnection(
						"jdbc:sqlserver://localhost:1433;databaseName=QUANLISANPHAM",
						"tuanhoan", "1");
				  InputStream in = new FileInputStream("report_HoaDon.jrxml");
				  JasperDesign jDesign = JRXmlLoader.load(in);
				  String sql = "Select HOADON.MAHD, HOADON.NGAYMUA, SANPHAM.TENSP, CHITIETHOADON.SOLUONG, SANPHAM.DONGIA, NHANVIEN.TENNV from CHITIETHOADON, HOADON, SANPHAM, NHANVIEN\r\n"
				  		+ "where CHITIETHOADON.MAHD = HOADON.MAHD and HOADON.MANV = NHANVIEN.MANV and CHITIETHOADON.MASP = SANPHAM.MASP";
				  JRDesignQuery nQuery = new JRDesignQuery();
				  nQuery.setText(sql);
				  jDesign.setQuery(nQuery);
				  JasperReport jr = JasperCompileManager.compileReport(jDesign);
				  HashMap para = new HashMap();
				  JasperPrint j = JasperFillManager.fillReport(jr, para, con);
				  JasperViewer.viewReport(j,false);
				  System.out.println("vvv");
			} catch (JRException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

}
