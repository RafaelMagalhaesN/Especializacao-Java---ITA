package models;

import java.util.Scanner;

import fabricas.FabricaMecanicaDoJogo;
import interfaces.MecanicaDoJogo;

public class Principal {

	public static void main(String[] args) {
		MecanicaDoJogo mecanicaDoJogo;
		FabricaMecanicaDoJogo fabricaMecanicaDoJogo = new FabricaMecanicaDoJogo();
		mecanicaDoJogo = fabricaMecanicaDoJogo.retornaUmaMecanicaRandomica();
		Scanner scanner = new Scanner(System.in);

		System.out.println(mecanicaDoJogo.tipoDeJogo());

		do {
			mecanicaDoJogo.reiniciar();
			do {
				System.out.println("Vidas/Chances: " + mecanicaDoJogo.quantasChancesVidas());
				System.out.println("Pontos: " + mecanicaDoJogo.quantosPontos());
				System.out.println("Acerte a seguinte palavra embaralhada: " + mecanicaDoJogo.palavra());
				if (mecanicaDoJogo.tentativa(scanner.nextLine())) {
					System.out.println("PARABENS! VOC� ACERTOU E GANHOU UM PONTO!\n");
				} else {
					System.out.println("ERRooOuuU!(VOZ DO FAUSTAO) VOC� PERDEU UM PONTO/VIDA!");
					System.out.println("Palavra Certa: " + mecanicaDoJogo.palavraCerta() + "\n");
				}

			} while (mecanicaDoJogo.fimDeJogo());

			if (mecanicaDoJogo.quantosPontos() <= 5) {
				System.out.println("Pontua��o pessima!: " + mecanicaDoJogo.quantosPontos());
			}
			if (mecanicaDoJogo.quantosPontos() >= 6 && mecanicaDoJogo.quantosPontos() <= 20) {
				System.out.println("Pontua��o mediana!: " + mecanicaDoJogo.quantosPontos());
			}
			if (mecanicaDoJogo.quantosPontos() >= 21 && mecanicaDoJogo.quantosPontos() <= 80) {
				System.out.println("Pontua��o boa!: " + mecanicaDoJogo.quantosPontos());
			}
			if (mecanicaDoJogo.quantosPontos() >= 81) {
				System.out.println("Flawless victory!: " + mecanicaDoJogo.quantosPontos());
			}

			System.out.println("Quer continuar jogando? Digite Sim ou N�o");
		} while (scanner.nextLine().equalsIgnoreCase("Sim"));
		scanner.close();
	}

}
