package entities;

public class SanPham {
	private String maSp, tenSp;
	private int soLuong, donGia;
	private String ngayNhap, hanDung;

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanPham(String maSp, String tenSp, int soLuong, int donGia, String ngayNhap, String hanDung) {
		super();
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.ngayNhap = ngayNhap;
		this.hanDung = hanDung;
	}

	public SanPham(String maSp, String tenSp, int donGia, String ngayNhap, String hanDung) {
		super();
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.donGia = donGia;
		this.ngayNhap = ngayNhap;
		this.hanDung = hanDung;
	}

	public String getMaSp() {
		return maSp;
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

	public String getNgayNhap() {
		return ngayNhap;
	}

	public String getHanDung() {
		return hanDung;
	}

	public void setMaSp(String maSp) {
		this.maSp = maSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public void setHanDung(String hanDung) {
		this.hanDung = hanDung;
	}

}
