package br.ifpb.edu.pod;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Receptor extends Thread {
	private Usuario u;
	private ArrayList<Usuario> clientes = new ArrayList<Usuario>();
	boolean cont=true;
	
	public Receptor(ArrayList<Usuario> clientes) {
		super();
		this.clientes = clientes;
	}

	public void run() {
		try {
			System.out.println("SIS: Receptor rodando...");
			
			while(cont) {
				//System.out.println("Entrou no while do receptor...");
				DataInputStream in = new DataInputStream(this.u.getSocket().getInputStream());
				String m = in.readUTF();

				this.verifica(m);

			}

			//}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setUsuario(Usuario u) {
		this.u = u;
		System.out.println("SIS: Receptor recebeu um novo socket");
	}
	
	public void send(String param) {
		
	}
	
	public void rename(String nome) {
		this.u.setNome(nome);
	}
	
	@SuppressWarnings("deprecation")
	public void bye() {
		try {
			this.clientes.remove(this.u);
			u.getSocket().close();
			System.out.println("SIS: Cliente "+u.getIp()+" saiu...");
			this.cont = false;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void list() {
		for (Usuario u : this.clientes) {
			System.out.println(u);
		}
	}
	
	public void verifica(String comando) {
		if (comando.contains("send -all ")) {
			//
		} else if (comando.contains("send -user ")) {
			//
		} else if (comando.equals("bye")) {
			this.bye();
		} else if (comando.equals("list")) {
			this.list();
		} else if (comando.contains("rename ")) {
			String nome = comando.substring(7);
			this.rename(nome);
		} else {
			System.out.println("Comando inválido ");
			System.out.println("=======================");
		}
	}
}
