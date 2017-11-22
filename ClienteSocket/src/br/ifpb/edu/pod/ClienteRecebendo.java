package br.ifpb.edu.pod;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienteRecebendo extends Thread{

		public static void main(String[] args) {
			try {
				Socket s = new Socket("localhost",6800);
				ClienteEnviando Enviando = new ClienteEnviando(s);		
				Enviando.start();
				while(true) {
					DataInputStream in = new DataInputStream(s.getInputStream());
					String m = in.readUTF();
					System.out.println("Mensagem recebida: "+m);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		  
	
}

