package test.banshuanggong;

/*
 * ��˫��ͨ�ţ�һ����������Ϣ��һ���ٷ�����Ϣ
 * �ͻ���
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class user {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		new user();
	}

	user() {
		try {
			// ���ӷ�����
			Socket s = new Socket("127.0.0.1", 9999);//����ֵ�ֱ�Ϊ������IP��ַ�Ͷ˿ں� //IP��ַ��127.x.x.x����127.0.0.0��127.1.1.1�⣩��ʾ��������IP
			
			// �ȴӿͻ��˷��͵���Ϣ
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);//ͨ�������pw��s��ӡ���ݣ�true��ʾ��ʱˢ��

			InputStreamReader isr1 = new InputStreamReader(System.in);
			BufferedReader br1 = new BufferedReader(isr1);

			// �ٽ��մӿ���̨��������Ϣ
			InputStreamReader isr2 = new InputStreamReader(s.getInputStream());
			BufferedReader br2 = new BufferedReader(isr2);


			while (true) {
				System.out.println("����Է�����˵��");
				pw.println(br1.readLine());
				System.out.println("������������" + br2.readLine());
			}
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
