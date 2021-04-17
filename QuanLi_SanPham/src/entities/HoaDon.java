package entities;

public class HoaDon {
	private String ngayMua, maNv;
	private int tongTien, maHd;

	public HoaDon(int maHd, String ngayMua, String maNv, int tongTien) {
		super();
		this.maHd = maHd;
		this.ngayMua = ngayMua;
		this.maNv = maNv;
		this.tongTien = tongTien;
	}

	public HoaDon(String ngayMua, String maNv, int tongTien) {
		super();
		this.ngayMua = ngayMua;
		this.maNv = maNv;
		this.tongTien = tongTien;
	}

	public int getMaHd() {
		return maHd;
	}

	public String getNgayMua() {
		return ngayMua;
	}

	public String getMaNv() {
		return maNv;
	}

	public int getTongTien() {
		return tongTien;
	}

}
