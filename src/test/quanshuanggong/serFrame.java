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
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;

public class serFrame extends JFrame {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		new serFrame();
	}

	// �����������jta�ڵ��ı����͵�socket�ˣ�Ӧ��Ϊȫ�ֱ���
	PrintWriter pw;

	JTextArea jta = new JTextArea();
	JTextField jtf = new JTextField(25);
	JButton jb = new JButton("����");
	JPanel jp = new JPanel();
	JScrollPane jsp = new JScrollPane(jta);// ���ı���������������

	serFrame() {

		// ��ʼ��
		this.setTitle("������-������");
		// this.setSize(400, 300);
		// this.setLocationRelativeTo(null);
		this.setBounds(250, 220, 400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		// ������
		this.add(jsp, "Center");
		jtf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar()==e.VK_ENTER) {
					if (jtf.getText().equals("")) {
						JOptionPane.showMessageDialog(serFrame.this, "�������ݲ���Ϊ�գ�");
					} else {
						jta.append("��������" + jtf.getText() + "\n");
						pw.println(jtf.getText());
						jtf.setText("");
					}
				}
			}
		});
		jp.add(jtf);
		// ����"����"����������������Ϣ���͵��ͻ���
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if (jtf.getText().equals("")) {
					JOptionPane.showMessageDialog(serFrame.this, "�������ݲ���Ϊ�գ�");
				} else {
					jta.append("��������" + jtf.getText() + "\n");
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
			ServerSocket ss = new ServerSocket(9999);// ���÷������˿�
			jta.append("�ȴ��ͻ��˷���......\n");
			Socket s = ss.accept();
			jta.append("�����ӿͻ���......\n");

			pw = new PrintWriter(s.getOutputStream(), true);

			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			// ʵʱ��ȡ�ͻ��˴�������Ϣ
			while (true) {
				jta.append("�ͻ��ˣ�" + br.readLine() + "\n");
			}

		} catch (java.net.BindException e1) {
			// TODO �Զ����ɵ� catch ��
			// e1.printStackTrace();
			mes = "�ö˿ں��ѱ�ʹ�ã�";
		} catch (java.net.SocketException e2) {
			// TODO �Զ����ɵ� catch ��
			// e2.printStackTrace();
			mes = "�ͻ��������жϣ�";
		} catch (IOException e3) {
			// TODO �Զ����ɵ� catch ��
			e3.printStackTrace();
		} finally {
			jop.showMessageDialog(this, mes);
		}
	}

}
