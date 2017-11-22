package br.ifpb.edu.pod;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
	private static ArrayList<Usuario> clientes = new ArrayList<Usuario>();
	

	public static ArrayList<Usuario> getClientes() {
		return clientes;
	}
	
	public static void addCliente(Usuario cliente) {
		clientes.add(cliente);
	}

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(6800, 100);
			System.out.println("SIS: Servidor iniciado...");
			Receptor receptor = new Receptor(getClientes());		
			
			
			while(true) {
				Socket s = server.accept();
				System.out.println("SIS: "+s.getInetAddress()+" entrou...");
				Usuario u = new Usuario("default", s.getInetAddress(), s);
				System.out.println("Usuario "+u.getNome()+" criado...");
				addCliente(u);
				receptor.setUsuario(u);
				System.out.println("Setou o cliente no receptor...");
				receptor.start();
				System.out.println("SIS: Receptor startado...");
			}
				

		} catch (IOException ex) {
			//
		}
	}

}
