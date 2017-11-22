package br.ifpb.edu.pod;

import java.net.InetAddress;
import java.net.Socket;

public class Usuario {
	private String nome;
	private InetAddress ip;
	private Socket socket;
	
	public Usuario(String nome, InetAddress ip, Socket socket) {
		super();
		this.nome = nome;
		this.ip = ip;
		this.socket = socket;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public InetAddress getIp() {
		return ip;
	}
	
	public Socket getSocket() {
		return socket;
	}

	@Override
	public String toString() {
		String text = "\n==================================\n";
		text += "Usuario [nome=" + nome + ", ip=" + ip +"]\n";
		return text;
	}
	

}
