package test.quanshuanggong;
/*
 * ȫ˫��ͨ��
 * ��������
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
		// TODO �Զ����ɵķ������
		new userFrame();
	}

	PrintWriter pw;

	JTextArea jta = new JTextArea();
	JTextField jtf = new JTextField(25);
	JButton jb = new JButton("����");
	JPanel jp = new JPanel();
	JScrollPane jsp = new JScrollPane(jta);

	userFrame() {

		// ��ʼ��
		this.setTitle("������-�ͻ���");
		// this.setSize(400, 300);
		// this.setLocationRelativeTo(null);
		this.setBounds(680, 220, 400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		// ������
		this.add(jsp, "Center");
		jtf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar()==e.VK_ENTER) {
					if (jtf.getText().equals("")) {
						JOptionPane.showMessageDialog(userFrame.this, "�������ݲ���Ϊ�գ�");
					} else {
						jta.append("�ͻ��ˣ�" + jtf.getText() + "\n");
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
				// TODO �Զ����ɵķ������
				if (jtf.getText().equals("")) {
					JOptionPane.showMessageDialog(userFrame.this, "�������ݲ���Ϊ�գ�");
				} else {
					jta.append("�ͻ��ˣ�" + jtf.getText() + "\n");
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
			jta.append("�����ӷ�����......\n");

			pw = new PrintWriter(s.getOutputStream(), true);

			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			while (true) {
				jta.append("��������" + br.readLine() + "\n");
			}

		} catch (java.net.SocketException e1) {
			// TODO �Զ����ɵ� catch ��
			// e1.printStackTrace();
			JOptionPane.showMessageDialog(this, "�����������жϣ�");
		} catch (IOException e2) {
			// TODO �Զ����ɵ� catch ��
			e2.printStackTrace();
		}
	}

}
