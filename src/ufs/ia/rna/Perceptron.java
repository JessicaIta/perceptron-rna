package ufs.ia.rna;

import javax.swing.JOptionPane;

public class Perceptron {
	
	double w0, w1, w2, w3, w4, w5, w6, w7, w8, w9,valor,taxaAprendizado, sinalT, sinalH;
	int padraoDT, padraoDH;
	int [][] letra;
	
	public Perceptron(double taxaAprendizado){
		letra = new int [3][3];
		this.taxaAprendizado = taxaAprendizado;
		w0 = -0.5;
		w1 = 0.4;
		w2 = 0.6;
		w3 = 0.6;
		w4 = -0.3;
		w5 = 0.5;
		w6 = -0.4;
		w7 = 0.4;
		w8 = 0.7;
		w9 = 0.4;
	}
	
	private void treinarNeuronio(){
		do{
		//Treinamento do padrão do T = 111010010
		// d = -1
		padraoDT = -1;
		valor = w0*1 + w1*1 + w2*1 + w3*1 + w4*0 +
				w5*1 + w6*0 + w7*0 + w8*1 + w9*0;
		
		if (valor>0)
			sinalT = 1;
		else
			sinalT = -1;
		
		if (sinalT != padraoDT){
			//Atualiza��o do peso dos neur�nios
			w0 = w0 + taxaAprendizado*1*(padraoDT - sinalT);
			w1 = w1 + taxaAprendizado*1*(padraoDT - sinalT);
			w2 = w2 + taxaAprendizado*1*(padraoDT - sinalT);
			w3 = w3 + taxaAprendizado*1*(padraoDT - sinalT);
			w4 = w4 + taxaAprendizado*0*(padraoDT - sinalT);
			w5 = w5 + taxaAprendizado*1*(padraoDT - sinalT);
			w6 = w6 + taxaAprendizado*0*(padraoDT - sinalT);
			w7 = w7 + taxaAprendizado*0*(padraoDT - sinalT);
			w8 = w8 + taxaAprendizado*1*(padraoDT - sinalT);
			w9 = w9 + taxaAprendizado*0*(padraoDT - sinalT);
		}
		
		//Treinamento do padr�o do H = 101111101
		// d = 1
		padraoDH = 1;
		valor = w0*1 + w1*1 + w2*0 + w3*1 + w4*1 +
				w5*1 + w6*1 + w7*1 + w8*0 + w9*1;
		
		if (valor > 0)
			sinalH = 1;
		else
			sinalH = -1;
		
		if (sinalH != padraoDH){
			//Atualização do peso dos neurônios
			w0 = w0 + taxaAprendizado*1*(padraoDH - sinalH);
			w1 = w1 + taxaAprendizado*1*(padraoDH - sinalH);
			w2 = w2 + taxaAprendizado*0*(padraoDH - sinalH);
			w3 = w3 + taxaAprendizado*1*(padraoDH - sinalH);
			w4 = w4 + taxaAprendizado*1*(padraoDH - sinalH);
			w5 = w5 + taxaAprendizado*1*(padraoDH - sinalH);
			w6 = w6 + taxaAprendizado*1*(padraoDH - sinalH);
			w7 = w7 + taxaAprendizado*1*(padraoDH - sinalH);
			w8 = w8 + taxaAprendizado*0*(padraoDH - sinalH);
			w9 = w9 + taxaAprendizado*1*(padraoDH - sinalH);
		}
		}while ((padraoDT == sinalT)|| (padraoDH == sinalH));
	}
	
	// Teste de reconhecimento dos caracteres T e H
	public void testarNeuronio(int [][] letraTela){
		
		//Treinamento do neurônio feito antes do teste
		treinarNeuronio();
		
		for (int i = 0; i < letra.length; i++) {
			for (int j = 0; j < letra.length; j++) {
				letra[i][j] = letraTela[i][j];
			}
		}
		
		//teste para reconhecimento do caracter após treinamento
		valor = w0*1 + w1*letra[0][0] + w2*letra[0][1] + w3*letra[0][2] + w4*letra[1][0] +
				w5*letra[1][1] + w6*letra[1][2] + w7*letra[2][0] + w8*letra[2][1] + w9*letra[2][2];
		if (valor < 0){
			sinalT = -1;
			JOptionPane.showMessageDialog(null, "O caracter é a letra T!");
		}else{
			sinalH = 1;
			JOptionPane.showMessageDialog(null, "O caracter é a letra H!");
		}
	}

}
