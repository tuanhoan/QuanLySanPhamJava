package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.ChiTietHoaDonDAO;
import dao.GioHangDAO;
import dao.HoaDonDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.Item;
import entities.NhanVien;
import views.BanSanPhamView;
import views.QuanLiView;

public class BanHangController extends JPanel {
	private BanSanPhamView view;
	private SanPhamDAO spDao;
	private GioHangDAO gHDao;
	private HoaDonDAO hdDao;
	private ChiTietHoaDonDAO cthdDao;
	private NhanVienDAO nvDao;

	public static void main(String[] args) {
		new QuanLiView();
	}

	public BanHangController() {
		view = new BanSanPhamView();
		spDao = new SanPhamDAO();
		gHDao = new GioHangDAO();
		hdDao = new HoaDonDAO();
		cthdDao = new ChiTietHoaDonDAO();
		nvDao = new NhanVienDAO();
		view.ListSanPhamTrenTable(spDao.getListSanPham());
		view.clearThongTin();
		view.chonItem(new ThemItemVaoGioHang());
		view.ClickOnTable(new ShowThongTinSanPham());
		view.xongBtn(new ThanhToan());
		this.setLayout(new BorderLayout());
		this.add(view, BorderLayout.CENTER);
	}

	public void getListSp() {
		view.ListSanPhamTrenTable(spDao.getListSanPham());
	}

	// THANH TOÁN
	class ThanhToan implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (view.checkThongTinNhanVien(nvDao.getListNhanVien(), view.layMaNhanVien().getText())) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Calendar cal = Calendar.getInstance();
				String ngaydh = String.valueOf(dateFormat.format(cal.getTime()).replace("/", "-"));
				System.out.println(ngaydh);
				HoaDon hd = new HoaDon(ngaydh, view.layMaNhanVien().getText(), gHDao.totalList());
				hdDao.themHD(hd);
				int maHd = hdDao.getNewestIdHoadon();
				for (Item temp : gHDao.getListItems()) {
					ChiTietHoaDon cthd = new ChiTietHoaDon(temp.getSanPham().getMaSp(), temp.getSoLuong(), maHd,
							temp.tongTien());
					cthdDao.themCTHD(cthd);
				}
				view.layNutThoat().doClick();
				gHDao.removeAll();
				view.listHoaDon(gHDao.getListItems());
				view.clearThongTin();
				view.showMessage("thanh toán thành công");
			} else {
				view.showMessage("Không tồn tại nhân viên");
			}

		}
	}

	// THÊM THÔNG TIN VÀO GIỎ HÀNG
	class ThemItemVaoGioHang implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (gHDao.addList(view.layThongTinItem().getSanPham().getMaSp(), view.layThongTinItem().getSoLuong())) {
				view.listHoaDon(gHDao.getListItems());
				view.layTongTien().setText(String.valueOf(gHDao.totalList()));
				view.ListSanPhamTrenTable(spDao.getListSanPham());
			} else {
				view.showMessage("Không đủ số lượng");
			}

		}
	}

	class ShowThongTinSanPham implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			view.SetTextSanPhamKhiClickOnTable();
		}
	}
}
