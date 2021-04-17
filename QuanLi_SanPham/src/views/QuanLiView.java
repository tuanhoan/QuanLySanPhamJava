package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;

import controller.BanHangController;
import controller.HoaDonController;
import controller.NhanVienController;
import controller.SanPhamController;
import dao.SanPhamDAO;

public class QuanLiView extends JFrame implements ActionListener {
	private JPanel main_Panel, header_Panel, left_Panel, center_Panel;
	private JButton button1_LeftPanel, button2_LeftPanel, button3_LeftPanel, button4_LeftPanel;
	private JLabel tilte_HeaderPanel;

	private SanPhamController sanPhamView;
	private NhanVienController nhanVienView;
	private BanHangController banSanPhamView;
	private HoaDonController hoaDonController;
	private JPanel centerPanelCardLayout;
	private CardLayout card_Layout;

	public static void main(String[] args) {
		new QuanLiView();
	}

	public QuanLiView() {

		View();
	}

	public void View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		header_Panel = headerPanel();

		left_Panel = leftPanel();

		center_Panel = centerPanel();

		main_Panel = new JPanel();
		main_Panel.add(header_Panel);
		main_Panel.add(left_Panel);
		main_Panel.add(center_Panel);
		SpringLayout main_Layout = new SpringLayout();
		main_Panel.setLayout(main_Layout);

		main_Layout.putConstraint(SpringLayout.WEST, header_Panel, 0, SpringLayout.WEST, main_Panel);
		main_Layout.putConstraint(SpringLayout.EAST, header_Panel, 0, SpringLayout.EAST, main_Panel);
		main_Layout.putConstraint(SpringLayout.HEIGHT, header_Panel, 80, SpringLayout.NORTH, main_Panel);

		main_Layout.putConstraint(SpringLayout.SOUTH, left_Panel, 0, SpringLayout.SOUTH, main_Panel);
		main_Layout.putConstraint(SpringLayout.NORTH, left_Panel, 0, SpringLayout.SOUTH, header_Panel);
		main_Layout.putConstraint(SpringLayout.WIDTH, left_Panel, 120, SpringLayout.WEST, main_Panel);

		main_Layout.putConstraint(SpringLayout.NORTH, center_Panel, 0, SpringLayout.SOUTH, header_Panel);
		main_Layout.putConstraint(SpringLayout.WEST, center_Panel, 0, SpringLayout.EAST, left_Panel);
		main_Layout.putConstraint(SpringLayout.SOUTH, center_Panel, 0, SpringLayout.SOUTH, main_Panel);
		main_Layout.putConstraint(SpringLayout.EAST, center_Panel, 0, SpringLayout.EAST, main_Panel);

		this.setSize(1100, 600);
		centerWindow();
		this.setVisible(true);
		getContentPane().add(main_Panel);
	}

	public JPanel headerPanel() {
		JPanel header_Panel = new JPanel();
		header_Panel.setLayout(new BorderLayout());
		tilte_HeaderPanel = new JLabel("QUẢN LÍ SẢN PHẨM", JLabel.CENTER);
		tilte_HeaderPanel.setFont(new Font("Tahoma", Font.BOLD, 25));
		tilte_HeaderPanel.setForeground(Color.white);
		header_Panel.add(tilte_HeaderPanel);
		header_Panel.setBackground(new Color(204, 51, 0));
		return header_Panel;
	}

	public void centerWindow() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
		setLocation(x, y);
	}

	public JPanel leftPanel() {
		JPanel left_Panel = new JPanel();
		button1_LeftPanel = new JButton("Sản Phẩm");
		button1_LeftPanel.setForeground(Color.WHITE);
		button1_LeftPanel.setFont(new Font("Tahoma", Font.BOLD, 14));
		button1_LeftPanel.setBackground(new Color(255, 102, 51));
		button1_LeftPanel.setBorder(null);
		button1_LeftPanel.addActionListener(this);

		button2_LeftPanel = new JButton("Nhân viên");
		button2_LeftPanel.setForeground(Color.WHITE);
		button2_LeftPanel.setFont(new Font("Tahoma", Font.BOLD, 14));
		button2_LeftPanel.setBorder(null);
		button2_LeftPanel.setBackground(new Color(255, 102, 51));
		button2_LeftPanel.addActionListener(this);

		button3_LeftPanel = new JButton("Bán hàng");
		button3_LeftPanel.setForeground(Color.WHITE);
		button3_LeftPanel.setFont(new Font("Tahoma", Font.BOLD, 14));
		button3_LeftPanel.setBorder(null);
		button3_LeftPanel.setBackground(new Color(255, 102, 51));
		button3_LeftPanel.addActionListener(this);

		button4_LeftPanel = new JButton("Hóa Đơn");
		button4_LeftPanel.setForeground(Color.WHITE);
		button4_LeftPanel.setFont(new Font("Tahoma", Font.BOLD, 14));
		button4_LeftPanel.setBorder(null);
		button4_LeftPanel.setBackground(new Color(255, 102, 51));
		button4_LeftPanel.addActionListener(this);

		JPanel groupButton = new JPanel();
		groupButton.setLayout(new GridLayout(4, 1, 0, 0));
		groupButton.add(button1_LeftPanel);
		groupButton.add(button2_LeftPanel);
		groupButton.add(button3_LeftPanel);
		groupButton.add(button4_LeftPanel);
		SpringLayout left_layout = new SpringLayout();
		left_Panel.setLayout(left_layout);
		left_Panel.add(groupButton);
		left_layout.putConstraint(SpringLayout.WIDTH, groupButton, 0, SpringLayout.WIDTH, left_Panel);
		left_layout.putConstraint(SpringLayout.HEIGHT, groupButton, 280, SpringLayout.NORTH, left_Panel);
		left_Panel.setBackground(new Color(255, 102, 51));
		return left_Panel;
	}

	// Phần nội dung ở giữa
	public JPanel centerPanel() {
		centerPanelCardLayout = new JPanel();
		nhanVienView = new NhanVienController();
		sanPhamView = new SanPhamController();
		banSanPhamView = new BanHangController();
		hoaDonController = new HoaDonController();

		card_Layout = new CardLayout();
		centerPanelCardLayout.setLayout(card_Layout);
		centerPanelCardLayout.add(sanPhamView, "sanPham");
		centerPanelCardLayout.add(nhanVienView, "nhanVien");
		centerPanelCardLayout.add(banSanPhamView, "banHang");
		centerPanelCardLayout.add(hoaDonController, "hoaDon");
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		main.add(centerPanelCardLayout);
		return main;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1_LeftPanel) {
			card_Layout.show(centerPanelCardLayout, "sanPham");
			sanPhamView.getListSp();
//			button1_LeftPanel.setBackground(new Color(0, 153, 255));
//			button1_LeftPanel.setForeground(Color.white);
//			button2_LeftPanel.setBackground(new Color(255, 102, 51));
//			button2_LeftPanel.setForeground(Color.black);
		}
		if (e.getSource() == button2_LeftPanel) {
			card_Layout.show(centerPanelCardLayout, "nhanVien");
//			button1_LeftPanel.setBackground(new Color(255, 102, 51));
//			button1_LeftPanel.setForeground(Color.black);
//			button2_LeftPanel.setBackground(new Color(0, 153, 255));
//			button2_LeftPanel.setForeground(Color.white);
		}
		if (e.getSource() == button3_LeftPanel) {
			card_Layout.show(centerPanelCardLayout, "banHang");
			banSanPhamView.getListSp();
//			button1_LeftPanel.setBackground(new Color(255, 102, 51));
//			button1_LeftPanel.setForeground(Color.black);
//			button2_LeftPanel.setBackground(new Color(0, 153, 255));
//			button2_LeftPanel.setForeground(Color.white);
		}
		if (e.getSource() == button4_LeftPanel) {
			card_Layout.show(centerPanelCardLayout, "hoaDon");
			hoaDonController.getView().ListSanPhamTrenTable(hoaDonController.getDao().getListHoaDon());
//			button1_LeftPanel.setBackground(new Color(255, 102, 51));
//			button1_LeftPanel.setForeground(Color.black);
//			button2_LeftPanel.setBackground(new Color(0, 153, 255));
//			button2_LeftPanel.setForeground(Color.white);
		}
	}
}
