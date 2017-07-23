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
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;

public class serFrame extends JFrame {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new serFrame();
	}

	// 输入流与接收jta内的文本发送到socket端，应设为全局变量
	PrintWriter pw;

	JTextArea jta = new JTextArea();
	JTextField jtf = new JTextField(25);
	JButton jb = new JButton("发送");
	JPanel jp = new JPanel();
	JScrollPane jsp = new JScrollPane(jta);// 将文本域放至滚动面板里

	serFrame() {

		// 初始化
		this.setTitle("聊天室-服务器");
		// this.setSize(400, 300);
		// this.setLocationRelativeTo(null);
		this.setBounds(250, 220, 400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		// 添加组件
		this.add(jsp, "Center");
		jtf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar()==e.VK_ENTER) {
					if (jtf.getText().equals("")) {
						JOptionPane.showMessageDialog(serFrame.this, "发送内容不能为空！");
					} else {
						jta.append("服务器：" + jtf.getText() + "\n");
						pw.println(jtf.getText());
						jtf.setText("");
					}
				}
			}
		});
		jp.add(jtf);
		// 按下"发送"键将服务器输入信息发送到客户端
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (jtf.getText().equals("")) {
					JOptionPane.showMessageDialog(serFrame.this, "发送内容不能为空！");
				} else {
					jta.append("服务器：" + jtf.getText() + "\n");
					pw.println(jtf.getText());
					jtf.setText("");
				}
			}
		});
		jp.add(jb);
		this.add(jp, "South");
		serSocket();

	}

	public void serSocket() {

		String mes = null;
		JOptionPane jop = null;
		try {
			ServerSocket ss = new ServerSocket(9999);// 设置服务器端口
			jta.append("等待客户端访问......\n");
			Socket s = ss.accept();
			jta.append("已连接客户端......\n");

			pw = new PrintWriter(s.getOutputStream(), true);

			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			// 实时读取客户端传来的信息
			while (true) {
				jta.append("客户端：" + br.readLine() + "\n");
			}

		} catch (java.net.BindException e1) {
			// TODO 自动生成的 catch 块
			// e1.printStackTrace();
			mes = "该端口号已被使用！";
		} catch (java.net.SocketException e2) {
			// TODO 自动生成的 catch 块
			// e2.printStackTrace();
			mes = "客户端连接中断！";
		} catch (IOException e3) {
			// TODO 自动生成的 catch 块
			e3.printStackTrace();
		} finally {
			jop.showMessageDialog(this, mes);
		}
	}

}
