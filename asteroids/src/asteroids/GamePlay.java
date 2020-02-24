package asteroids;

import java.util.Scanner;

public class GamePlay {
	
	
	public static void main(String[] args) {
		
		int N;
		int M;
		int seed;
		int proyectil;
		int asteroides;
		int limite;
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el valor para N: ");
		N = entrada.nextInt();

		Scanner entrada2 = new Scanner(System.in);
		System.out.print("Ingrese el valor para M: ");
		M = entrada2.nextInt();

		Scanner entrada3 = new Scanner(System.in);
		System.out.print("Ingrese el valor para el Seed: ");
		seed=entrada3.nextInt();
		
		System.out.print("Ingrese el valor para el fireRange: ");
		Scanner entrada4 = new Scanner(System.in);
		proyectil=entrada4.nextInt();
		
		System.out.print("Ingrese el valor para el número de Asteroides: ");
		Scanner entrada5 = new Scanner(System.in);
		asteroides=entrada5.nextInt();

		
		GameSpace juego = new GameSpace(N,M,seed,proyectil,asteroides);
		

		if(juego.getOk()) {

			while(juego.getStateShip()==0 && juego.getSizeAsteroid()>0 ) {
				juego.gameLoop();
	
				juego.printSpace();
	
				System.out.println("Playing");
			}
		}

		if(juego.getOk()) {
			if(juego.getStateShip()==1) {
				System.out.print("Defeat");	
			}
			if(juego.getSizeAsteroid()==0 && juego.getStateShip()==0) {
				System.out.println("Victory");
			}
		}
		
		if(juego.getOk()==false) {
			System.out.print("Introducir valores correctos");
		}
		
	}	
		
	
}
