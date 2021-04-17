package dao;

import java.util.ArrayList;
import java.util.HashMap;

import entities.Item;
import entities.SanPham;
import views.QuanLiView;

public class GioHangDAO {
	HashMap<String, Item> gioHang;

	public GioHangDAO() {
		gioHang = new HashMap<String, Item>();
	}

	public static void main(String[] args) {
		new QuanLiView();
	}

	public boolean addList(String masp, int soLuong) {
		System.out.println(SanPhamDAO.getListSanPhamTheoMaSp(masp).getSoLuong());
		if (SanPhamDAO.getListSanPhamTheoMaSp(masp).getSoLuong() < soLuong) {
			return false;
		} else {
			if (gioHang.containsKey(masp)) {
				// sản phẩm đã tồn tại trong giỏ hàng => tăng số lượng đặt hàng cho sản phẩm đó

				Item item = gioHang.get(masp);
				SanPhamDAO.suaSoLuongSanPham(SanPhamDAO.getListSanPhamTheoMaSp(masp), soLuong);
				item.setSoLuong(item.getSoLuong() + soLuong);
			} else {
				// sản phẩm chua có trong giỏ hàng=> them sản mới vào giỏ hàng
				SanPham sanpham = new SanPhamDAO().getListSanPhamTheoMaSp(masp);
				SanPhamDAO.suaSoLuongSanPham(sanpham, soLuong);
				Item item = new Item(sanpham, soLuong);
				gioHang.put(masp, item);
			}
		}
		return true;
	}

	public void removeProduct(String masp) {
		gioHang.remove(masp);
	}

	public void removeAll() {
		gioHang.clear();
	}

	public int totalList() {
		int total = 0;
		for (Item item : gioHang.values()) {
			total = total + (item.getSanPham().getDonGia() * item.getSoLuong());
		}
		return total;
	}

	public ArrayList<Item> getListItems() {
		ArrayList<Item> listItems = new ArrayList<>();
		for (Item i : gioHang.values()) {
			listItems.add(i);
		}
		return listItems;
	}
}
