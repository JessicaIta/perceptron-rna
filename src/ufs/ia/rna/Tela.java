package ufs.ia.rna;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Tela {
	
	int letra[][];
	
	public Tela(){
		letra = new int[3][3]; 
	}
	
	private void preencheMatriz(){
		for (int i = 0; i < letra.length; i++) {
			for (int j = 0; j < letra.length; j++) {
				letra[i][j] = 0;
			}
			
		}
	}

	public void inicializaComponentes(){
		
	JFrame.setDefaultLookAndFeelDecorated(true);
	
	JFrame tela = new JFrame("Perceptron Reconhecedor");
	tela.setSize(400, 400);
	tela.setLocation(200, 200);
	tela.getContentPane().setLayout(new BorderLayout());
	
	JPanel painel = new JPanel();
	JPanel botao = new JPanel();
	botao.setLayout(new FlowLayout());
	painel.setLayout(new GridLayout(3,3));
	painel.setBorder(new EmptyBorder(15,15,15,15));
	
	JLabel texto = new JLabel("Clique nos botões para desenhar a figura e clique em analisar.");
	texto.setBorder(new EmptyBorder(15,15,15,15));
	tela.getContentPane().add(texto, BorderLayout.NORTH);
	
	tela.getContentPane().add(painel,BorderLayout.CENTER );
	
	
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	JButton btn4 = new JButton("4");
	JButton btn5 = new JButton("5");
	JButton btn6 = new JButton("6");
	JButton btn7 = new JButton("7");
	JButton btn8 = new JButton("8");
	JButton btn9 = new JButton("9");
	JButton analisar = new JButton("Analisar");
	JButton limpar = new JButton("Limpar");
	
	preencheMatriz();
	
	painel.add(btn1);
	btn1.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			btn1.setBackground(Color.RED);
			letra[0][0] = 1;
		}
	});
	
	painel.add(btn2);
	btn2.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			btn2.setBackground(Color.RED);
			letra[0][1] = 1;
		}
	});
	painel.add(btn3);
	btn3.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			btn3.setBackground(Color.RED);
			letra[0][2] = 1;
		}
	});
	painel.add(btn4);
	btn4.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			btn4.setBackground(Color.RED);
			letra[1][0] = 1;
		}
	});
	painel.add(btn5);
	btn5.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			btn5.setBackground(Color.RED);
			letra[1][1] = 1;
		}
	});
	painel.add(btn6);
	btn6.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			btn6.setBackground(Color.RED);
			letra[1][2] = 1;
		}
	});
	painel.add(btn7);
	btn7.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			btn7.setBackground(Color.RED);
			letra[2][0] = 1;
		}
	});
	painel.add(btn8);
	btn8.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			btn8.setBackground(Color.RED);
			letra[2][1] = 1;
		}
	});
	painel.add(btn9);
	btn9.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			btn9.setBackground(Color.RED);
			letra[2][2] = 1;
		}
	});
	
	tela.add(botao, BorderLayout.SOUTH);
	
	botao.add(analisar);
	analisar.setSize(50, 10);
	analisar.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// Método da classe Perceptron para analisar a letra
			double taxa = Double.parseDouble(JOptionPane.showInputDialog("Informe a taxa de aprendizado do neurônio:"));
			Perceptron neuronio = new Perceptron(taxa);
			neuronio.testarNeuronio(letra);
		}
	});
	
	botao.add(limpar);
	limpar.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			preencheMatriz();
			btn1.setBackground(null);
			btn2.setBackground(null);
			btn3.setBackground(null);
			btn4.setBackground(null);
			btn5.setBackground(null);
			btn6.setBackground(null);
			btn7.setBackground(null);
			btn8.setBackground(null);
			btn9.setBackground(null);
		}
	});
	
	tela.setVisible(true);
	
}
	
	
}