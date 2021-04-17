package entities;

public class NhanVien {
	private String maNv, tenNv, ngaySinh, sDt;

	public NhanVien(String maNv, String tenNv, String ngaySinh, String sDt) {
		super();
		this.maNv = maNv;
		this.tenNv = tenNv;
		this.ngaySinh = ngaySinh;
		this.sDt = sDt;
	}

	public String getMaNv() {
		return maNv;
	}

	public String getTenNv() {
		return tenNv;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public String getsDt() {
		return sDt;
	}

}
