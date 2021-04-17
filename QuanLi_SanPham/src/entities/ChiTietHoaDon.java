package entities;

public class ChiTietHoaDon {
	private String maSp;
	private int soLuong, maCt;
	private int maHd, thanhTien;

	public ChiTietHoaDon(int maCt, String maSp, int soLuong, int maHd, int thanhTien) {
		super();
		this.maSp = maSp;
		this.soLuong = soLuong;
		this.maCt = maCt;
		this.maHd = maHd;
		this.thanhTien = thanhTien;
	}

	public ChiTietHoaDon(String maSp, int soLuong, int maHd, int thanhTien) {
		super();
		this.maSp = maSp;
		this.soLuong = soLuong;
		this.maHd = maHd;
		this.thanhTien = thanhTien;
	}

	public ChiTietHoaDon(String maSp, int soLuong, int maHd) {
		super();
		this.maSp = maSp;
		this.soLuong = soLuong;
		this.maHd = maHd;
	}

	public String getMaSp() {
		return maSp;
	}

	public void setMaSp(String maSp) {
		this.maSp = maSp;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getMaCt() {
		return maCt;
	}

	public void setMaCt(int maCt) {
		this.maCt = maCt;
	}

	public int getMaHd() {
		return maHd;
	}

	public void setMaHd(int maHd) {
		this.maHd = maHd;
	}

	public int getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}

}
