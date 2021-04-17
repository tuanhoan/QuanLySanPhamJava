package entities;

public class Item {
	private SanPham sanPham;
	private int soLuong;

	public Item() {
		sanPham = new SanPham();
	}

	public Item(SanPham sanPham, int soLuong) {
		super();
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

	public int tongTien() {
		return sanPham.getDonGia() * soLuong;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
