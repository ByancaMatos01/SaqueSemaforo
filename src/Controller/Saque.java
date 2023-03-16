package Controller;

import java.util.concurrent.Semaphore;

public class Saque extends Thread {
	private int idconta;
	int id;
	private double saldo,valor;
	Semaphore semaforoSaque;
	Semaphore semaforoDesposito;
	
	public Saque(int id, int idconta, double saldo, double valor, Semaphore semaforoSaque,Semaphore semaforoDesposito  ) {
	this.id=id;
	this.idconta=idconta;
	this.saldo=saldo;
	this.valor=valor;
	this.semaforoDesposito=semaforoDesposito;
	this.semaforoSaque=semaforoSaque;
	}
	@Override
	public void run() {
	if(id==1) {
		try {
			semaforoSaque.acquire();
			transicaoS();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			semaforoSaque.release();
		}
	}
	else{
			try {
				semaforoDesposito.acquire();
				transicaoD();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				semaforoDesposito.release();
			}
					
	
		}
	}
	

	private void transicaoS() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(saldo<valor) {
			System.out.println("Oprecao que deseja realizar o deposito e"+id+"Sua conta e "+idconta+"seu saldo e "+ String.format("%,.2f", saldo)+ " o valor requerito para ser retirado e "+  String.format("%,.2f", valor)+" voce nao pode realizar esta transeferencia");
		}else {
		double valornew;
		valornew=(saldo-valor);
		System.out.println("Oprecao que deseja realizar o deposito e "+id+ " Sua conta e "+idconta+" seu saldo e "+ String.format("%,.2f", saldo)+ " o valor requerito para ser retirado e "+  String.format("%,.2f", valor)+" ao realizar esta transeferencia seu novo valor e de "+String.format("%,.2f", valornew));
		
		}
		
	}
	private void transicaoD() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double valornew;
		valornew=(saldo+valor);
		System.out.println(" oprecao que deseja realizar o deposito e "+id+ " codigo da sua conta deposito "+idconta + " seu saldo e "+ String.format("%,.2f", saldo)+" o valor requerito para ser retirado e "+  String.format("%,.2f", valor)+ " ao realizar esta transeferencia seu novo valor e de "+  String.format("%,.2f", valornew));
		
	}

	
	
	

}
