package br.ifpb.edu.pod;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClienteEnviando extends Thread{
	private Socket s;
	
	public void run() {	
        try {
            while(true) {
            	 DataOutputStream out = new DataOutputStream(s.getOutputStream());
            	 String m = JOptionPane.showInputDialog("Digite a sua mensagem:");
            	 out.writeUTF(m);
                 if (m.equals("bye")) {
                	 this.s.close();
                	 System.out.println("Fechando conexão...");
                	 this.destroy();
                 }
            }
        } catch (IOException ex) {
            //
        }
    }

	public ClienteEnviando(Socket s) {
		super();
		this.s = s;
	}
	
}
