package test.banshuanggong;

/*
 * ��˫��ͨ�ţ�һ����������Ϣ��һ���ٷ�����Ϣ
 * ��������
 * */

import java.net.*;
import java.io.*;

public class server {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		new server();
	}

	server() {
		try {
			// ��9999�˿��ϼ���
			System.out.println("��������9999......");
			ServerSocket ss = new ServerSocket(9999);//��9999�Ŷ˿�����
			System.out.println("���ӳɹ�......");

			// �ȴ�����
			
			Socket s = ss.accept();//�ȴ�ĳ���ͻ��������ӣ����пͻ������ӣ��᷵��һ��socket��

			// �Ƚ��մӿͻ��˷�������Ϣ
			InputStreamReader isr1 = new InputStreamReader(s.getInputStream());
			BufferedReader br1 = new BufferedReader(isr1);
			
			// �ٴӿ���̨�������Ϣ
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);//PrintWriter(s.getOutputStream(),true);

			InputStreamReader isr2 = new InputStreamReader(System.in);
			BufferedReader br2 = new BufferedReader(isr2);


			while (true) {
				System.out.println("�ͻ��˷�����" + br1.readLine());
				System.out.println("����Կͻ���˵��");
				pw.println(br2.readLine());
			}
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}
}
