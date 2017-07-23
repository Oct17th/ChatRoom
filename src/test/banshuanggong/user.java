package test.banshuanggong;

/*
 * 半双工通信：一方发送完消息另一方再发送消息
 * 客户端
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class user {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new user();
	}

	user() {
		try {
			// 连接服务器
			Socket s = new Socket("127.0.0.1", 9999);//参数值分别为服务器IP地址和端口号 //IP地址：127.x.x.x（除127.0.0.0和127.1.1.1外）表示连接自身IP
			
			// 先从客户端发送的信息
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);//通过输出流pw向s打印数据，true表示即时刷新

			InputStreamReader isr1 = new InputStreamReader(System.in);
			BufferedReader br1 = new BufferedReader(isr1);

			// 再接收从控制台发来的信息
			InputStreamReader isr2 = new InputStreamReader(s.getInputStream());
			BufferedReader br2 = new BufferedReader(isr2);


			while (true) {
				System.out.println("你想对服务器说：");
				pw.println(br1.readLine());
				System.out.println("服务器发来：" + br2.readLine());
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
