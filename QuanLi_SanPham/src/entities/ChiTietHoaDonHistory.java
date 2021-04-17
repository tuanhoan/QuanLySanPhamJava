package entities;

public class ChiTietHoaDonHistory {
	private String tenSp;
	private int soLuong;
	private int donGia, thanhTien;

	public ChiTietHoaDonHistory() {
	}

	public ChiTietHoaDonHistory(String tenSp, int soLuong, int donGia, int thanhTien) {
		super();
		this.tenSp = tenSp;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
	}

	public String getTenSp() {
		return tenSp;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public int getDonGia() {
		return donGia;
	}

	public int getThanhTien() {
		return thanhTien;
	}

}
