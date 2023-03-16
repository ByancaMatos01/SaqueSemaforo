package view;

import java.util.concurrent.Semaphore;

import Controller.Saque;

public class Principal {
	public static void main(String[] args) {
		int permissao=1;
		Semaphore semaforoSaque= new Semaphore(permissao);
		Semaphore semaforoDeposito= new Semaphore(permissao);
		for (int i = 0; i < 20; i++) {
			int id = (int)((Math.random() * 2) + 1);
			int idconta = (int)(Math.random() * 101);
			double saldo = (Math.random() * 1001);
			double valor = (Math.random() * 501);
			Thread Transacao = new Saque (id, idconta, saldo, valor,semaforoSaque,semaforoDeposito);
			Transacao.start();
		}
	}
}
