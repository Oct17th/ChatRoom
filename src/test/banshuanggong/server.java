package test.banshuanggong;

/*
 * 半双工通信：一方发送完消息另一方再发送消息
 * 服务器端
 * */

import java.net.*;
import java.io.*;

public class server {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new server();
	}

	server() {
		try {
			// 在9999端口上监听
			System.out.println("正在连接9999......");
			ServerSocket ss = new ServerSocket(9999);//在9999号端口连接
			System.out.println("连接成功......");

			// 等待连接
			
			Socket s = ss.accept();//等待某个客户端来连接，若有客户端连接，会返回一个socket类

			// 先接收从客户端发来的信息
			InputStreamReader isr1 = new InputStreamReader(s.getInputStream());
			BufferedReader br1 = new BufferedReader(isr1);
			
			// 再从控制台输入的信息
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);//PrintWriter(s.getOutputStream(),true);

			InputStreamReader isr2 = new InputStreamReader(System.in);
			BufferedReader br2 = new BufferedReader(isr2);


			while (true) {
				System.out.println("客户端发来：" + br1.readLine());
				System.out.println("你想对客户端说：");
				pw.println(br2.readLine());
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
}
