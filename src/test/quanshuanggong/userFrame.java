package test.quanshuanggong;
/*
 * 全双工通信
 * 服务器端
 * */

import javax.swing.*;
import java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

public class userFrame extends JFrame {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new userFrame();
	}

	PrintWriter pw;

	JTextArea jta = new JTextArea();
	JTextField jtf = new JTextField(25);
	JButton jb = new JButton("发送");
	JPanel jp = new JPanel();
	JScrollPane jsp = new JScrollPane(jta);

	userFrame() {

		// 初始化
		this.setTitle("聊天室-客户端");
		// this.setSize(400, 300);
		// this.setLocationRelativeTo(null);
		this.setBounds(680, 220, 400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		// 添加组件
		this.add(jsp, "Center");
		jtf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar()==e.VK_ENTER) {
					if (jtf.getText().equals("")) {
						JOptionPane.showMessageDialog(userFrame.this, "发送内容不能为空！");
					} else {
						jta.append("客户端：" + jtf.getText() + "\n");
						pw.println(jtf.getText());
						jtf.setText("");
					}
				}
			}
		});
		jp.add(jtf);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (jtf.getText().equals("")) {
					JOptionPane.showMessageDialog(userFrame.this, "发送内容不能为空！");
				} else {
					jta.append("客户端：" + jtf.getText() + "\n");
					pw.println(jtf.getText());
					jtf.setText("");
				}
			}
		});
		jp.add(jb);
		this.add(jp, "South");

		userSocket();

	}

	public void userSocket() {
		try {
			Socket s = new Socket("127.0.0.1", 9999);
			jta.append("已连接服务器......\n");

			pw = new PrintWriter(s.getOutputStream(), true);

			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			while (true) {
				jta.append("服务器：" + br.readLine() + "\n");
			}

		} catch (java.net.SocketException e1) {
			// TODO 自动生成的 catch 块
			// e1.printStackTrace();
			JOptionPane.showMessageDialog(this, "服务器连接中断！");
		} catch (IOException e2) {
			// TODO 自动生成的 catch 块
			e2.printStackTrace();
		}
	}

}
