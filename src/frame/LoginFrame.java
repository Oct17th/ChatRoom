package frame;

import java.awt.FlowLayout;

import javax.swing.*;

public class LoginFrame extends JFrame {
	JLabel jl1, jl2, jl3, jl4;
	JTextField jt1, jt2;
	JCheckBox jc1, jc2;
	JButton jb1, jb2;

	LoginFrame() {
		this.setTitle("��½����");
		this.setSize(400, 300);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		jl1 = new JLabel("�˺�");
		jl2 = new JLabel("����");
		jt1 = new JTextField(20);
		jt2 = new JTextField(20);
		this.add(jl1);
		this.add(jt1);
		this.add(jl2);
		this.add(jt2);
	}

	public static void main(String[] args) {
		new LoginFrame();
	}
}
