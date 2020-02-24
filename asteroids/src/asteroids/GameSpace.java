package asteroids;
import java.util.Scanner;
import java.util.Arrays;

public class GameSpace {

	private int N;
	private int M;
	private int[][] spaceMatriz;
	private int pointGame;
	private int alcanceMisil;
	private int seed;
	private int numerosdeAsteroides;
	private int limiteAsteroides;
	private char [][] charMatriz ;
	private String [] b;
	public Asteroid astElemObj;
	public SpaceShip shipObj;
	public boolean ok;


	public GameSpace(int n,int m, int seed, int fireRange, int asteroides) {
		this.N=n;
		this.M=m;
		b = new String[getN()]; 
		this.pointGame=0;
		this.alcanceMisil=fireRange;
		this.numerosdeAsteroides=asteroides;
		this.astElemObj = new Asteroid();
		this.shipObj = new SpaceShip(getalcanceMisil());
		setSeed(seed);
		spaceMatriz = new int[getN()][getM()];
		charMatriz = new char[getN()][getM()];
		setOk(false);
		
		createSpace( n, m, asteroides,  fireRange, seed); 
		
	}
 	
	
	public void createSpace(int N, int M, int A, int L, int seed) {
		
		if(N>4 && N<13) {
			if(M>9 && M<13) {
				if(A==1 || (A>1 && A<4)) {
					if(L==1 || (L>1 && L<(N-2))) {
						if(seed>0) {
						setLimiteAsteroides(4);	
						createMatriz();
						setspaceMatriz(shipObj.creatShip(getspaceMatriz(), getN(), getM()));
						integraAsteroid();
						setOk(true);
						printSpace();
						
						}
					}
				}
			}
		}
	
		if(N>12 && N<23) {
			if(M>12 && M<23) {
				if(A==2 || (A>2 && A<5)) {
					if(L==5 || (L>5 && L<(N-2))) {
						if(seed>0) {
						setLimiteAsteroides(6);	
						createMatriz();
						setspaceMatriz(shipObj.creatShip(getspaceMatriz(), getN(), getM()));
						integraAsteroid();
						setOk(true);
						printSpace();
						}
					}
				}
			}
		}
	
		if(N>22 && N<33) {
			if(M>22 && M<33) {
				if(A==3 || (A>3 && A<6)) {
					if(L==10 || (L>10 && L<(N-2))) {
						if(seed>0) {
						setLimiteAsteroides(10);
						createMatriz();
						setspaceMatriz(shipObj.creatShip(getspaceMatriz(), getN(), getM()));
						integraAsteroid();
						setOk(true);
						printSpace();
						}
					}
				}
			}
		}
	
		if(N>32 ) {
			if(M>32 ) {
				if(A>6 && A<12) {
					if(L>20 && L<25) {
						if(seed>0) {
						setLimiteAsteroides(16);
						createMatriz();
						setspaceMatriz(shipObj.creatShip(getspaceMatriz(), getN(), getM()));
						integraAsteroid();
						setOk(true);
						printSpace();
						}
					}
				}
			}
		}
	
	
		else if(getOk()==false) {
					setOk(false);
				}
	}
	
	public int getSizeAsteroid() {
		return astElemObj.getElementosAsteroids().size();
	} 
	
	public boolean getOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public void showasteroid() {
		astElemObj.showListElement();
	}

	public int getLimiteAsteroides() {
		return limiteAsteroides;
	}

	public void setLimiteAsteroides(int limite) {
		this.limiteAsteroides=limite;
	}

	public void setLimiteAsteroides() {
		this.limiteAsteroides=(getLimiteAsteroides())-(getNumerosdeAsteroides());
	}

	private int getNumerosdeAsteroides() {
		return numerosdeAsteroides;
	}

	private int getSeed() {
		return seed;
	}

	private void setSeed(int seed) {
		this.seed = seed;
	}

	private void setalcanceMisil(int l) {
		this.alcanceMisil=l;
	}

	private int getalcanceMisil() {
		return alcanceMisil;
	}

	private int getN() {
		return N;
	}

	private void setN(int n) {
		N = n;
	}

	private int getM() {
		return M;
	}

	private void setM(int m) {
		M = m;
	}

	private int[][] getspaceMatriz() {
		return spaceMatriz;
	}

	private int getspaceMatriz(int i, int j) {
		return spaceMatriz[i][j];
	}

	private void setspaceMatriz(int[][] spaceMatriz) {
		this.spaceMatriz = spaceMatriz;
	}

	private void setspaceMatriz(int i,   int j, int valor) {
		this.spaceMatriz[i][j] = valor;
	}

	private int getPointGame() {
		return pointGame;
	}

	private void setPointGame() {
		this.pointGame = pointGame+1;
	}

	private void createMatriz(){
		for(int i=0;i<getN();i++) {
			for(int j=0;j<getM();j++) {
					setspaceMatriz(i,j,0);
				}
		}
	}

	public void mostrarPartida() {
			
		createMatriz();
		
		for(int i=0; i<shipObj.getElementShoot().size();i++){
			setspaceMatriz(shipObj.getElementShoot(i, 2),shipObj.getElementShoot(i, 3),shipObj.getElementShoot(i, 0));
		}
		
		astElemObj.showListElement();
		
		for(int j=0; j<astElemObj.getElementosAsteroids().size();j++){
			setspaceMatriz(astElemObj.getParam_Asteroid( j, 2),astElemObj.getParam_Asteroid( j, 3),astElemObj.getParam_Asteroid( j, 0));
		}
		
		setspaceMatriz(shipN(),shipM(),shipObj.getNameShip(0));
		
		System.out.println("Puntaje: "+getPointGame());
			
	}

	private void creatAsteroides(int i) {
		astElemObj.seedAsteroids(getN(), getM(), getSeed(), shipN(), shipM(), i);
	}

	public int shipN() {
		return shipObj.getNameShip(2);
	}

	public int shipM() {
		return shipObj.getNameShip(3);
	}

	public void gameLoop() {
		System.out.println("Actualizar partida: Ingrese un 1 ");
		System.out.println("Lanzar un proyectil: Ingrese un 2 ");
		System.out.println("Efectuar movimiento: Ingrese un 3 ");
		Scanner entrada = new Scanner(System.in);
		int accion=entrada.nextInt();
		if(accion==1) {
			moveElement( 1); 
		}
		if(accion==2) {
			moveElement( 2); 
		}
		if(accion==3) {
			System.out.println("Ingrese dirección de curso ");
			Scanner entrada2 = new Scanner(System.in);
			accion=entrada2.nextInt();
			moveElement( 3, accion);}
			
	}

	private void moveElement(int numero, int direccion) {
		if(numero==3) {
			caseMoveShip(direccion);
		}
	}

	private void moveElement(int numero) {
		
		if(numero==1) {
			caseTmas1();
		}
		if(numero==2) {
			caseShootTmas1();
		}
	}

	public void caseShootTmas1() {
		shipObj.shootElement();
		shootEvalNew();
		shipbeforeShoot();
		if(shipObj.getNameShip(5)!=1){
			
			deleteElement();
			spaceTimeAsteroid(); 
			shipObj.moveShip();
			shipt_Tmas1_Evaluacion();
			if(shipObj.getNameShip(5)!=1){

				shootVS_asteroidTmas1();
				deleteElement();
				moveShootforFireRange();
				integraAsteroid();
			}
			
		}
		deleteElement();
		
	} 

	public void caseTmas1() {
		
		spaceTimeAsteroid(); 
		shipObj.moveShip();
		shipt_Tmas1_Evaluacion();
		
		if(shipObj.getNameShip(5)!=1){
			shootVS_asteroidTmas1();
			deleteElement();
			moveShootforFireRange();
			integraAsteroid();
		}
		
		deleteElement();
	}

	public void caseMoveShip(int direccion) {
		
		spaceTimeAsteroid();
		shipObj.inicializarMoveShip(direccion);
		shipObj.moveShip();
		shipt_Tmas1_Evaluacion();
		
		if(shipObj.getNameShip(5)!=1){
			shootVS_asteroidTmas1();
			deleteElement();
			moveShootforFireRange();
			integraAsteroid();
		}
		
		deleteElement();
	}

	public void integraAsteroid() {
		if(getLimiteAsteroides()>0) {
			creatAsteroides(getNumerosdeAsteroides());
			setLimiteAsteroides();
		}
	}

	public int getStateShip() {
		return shipObj.getNameShip(5);
	}

	private void spaceTimeAsteroid() {

		for(int j=0;j<astElemObj.getElementosAsteroids().size();j++) {
			
			
			if(astElemObj.getParam_Asteroid( j, 1)==0) {
				
				if((getM()-1)==astElemObj.getParam_Asteroid( j, 3)) {
					astElemObj.setElementosAsteroids(j, 3,0);
				}
				else {
					astElemObj.setElementosAsteroids(j, 3,(astElemObj.getParam_Asteroid( j, 3))+1);
				}
				
			}
			
			if(astElemObj.getParam_Asteroid( j, 1)==90) {
				if(0==astElemObj.getParam_Asteroid( j, 2)) {
					astElemObj.setElementosAsteroids(j, 2,(getN()-1));
				}
				else {
					astElemObj.setElementosAsteroids(j, 2,(astElemObj.getParam_Asteroid( j, 2))-1);
				}
			}
			
			if(astElemObj.getParam_Asteroid( j, 1)==180) {
				if(0==astElemObj.getParam_Asteroid( j, 3)) {
					astElemObj.setElementosAsteroids(j, 3,(getM()-1));
				}
				else {
					astElemObj.setElementosAsteroids(j, 3,(astElemObj.getParam_Asteroid( j, 3))-1);
				}	
			}
			
			if(astElemObj.getParam_Asteroid( j, 1)==270) {
				if((getN()-1)==astElemObj.getParam_Asteroid( j, 2)) {
					astElemObj.setElementosAsteroids(j, 2,0);
				}
				else {
					astElemObj.setElementosAsteroids(j, 2,(astElemObj.getParam_Asteroid( j, 2))+1);
				}
			}
		}
	}

	private void shootEvalNew() {
		
		for(int i=0;i<astElemObj.getElementosAsteroids().size();i++) {
			if(shipObj.getElementShoot((shipObj.getElementShoot().size()-1), 2)==astElemObj.getParam_Asteroid(i,2) &&
					shipObj.getElementShoot((shipObj.getElementShoot().size()-1), 3)==astElemObj.getParam_Asteroid(i,3)) 
			{
				shipObj.setElementShoot( (shipObj.getElementShoot().size()-1), 5, 1);
				astElemObj.setElementosAsteroids(i,4,1);
				
				setPointGame();
			}
		}
		for(int j=0;j<(shipObj.getElementShoot().size()-1);j++) {
			if(shipObj.getElementShoot((shipObj.getElementShoot().size()-1), 2)==shipObj.getElementShoot(j, 2) &&
					shipObj.getElementShoot((shipObj.getElementShoot().size()-1), 3)==shipObj.getElementShoot(j, 3))  
			{
				shipObj.setElementShoot( (shipObj.getElementShoot().size()-1), 5, 1);
				shipObj.setElementShoot (j, 5, 1);
			}
			
		}
		
	}
	
	//4.2
	//evalua la nave con todos los asteroides
	//evalua la nave con todo los proyectiles
	private void shipt_Tmas1_Evaluacion(){
		//4.2
		for(int i=0;i<astElemObj.getElementosAsteroids().size();i++) 
		{
			if(shipObj.getNameShip(2)==astElemObj.getParam_Asteroid(i,2) && shipObj.getNameShip(3)==astElemObj.getParam_Asteroid(i,3)) 
				{
				shipObj.setNameShip( 5,1);
				astElemObj.setElementosAsteroids(i,4,1);
			}	
		}
		
		for(int j=0;j<shipObj.getElementShoot().size();j++) 
		{
			if(shipObj.getNameShip(2)==shipObj.getElementShoot(j, 2) && shipObj.getNameShip(3)==shipObj.getElementShoot(j, 3)) 
				{
				shipObj.setNameShip( 5,1);
				shipObj.setElementShoot (j, 5, 1);
			}	
		}
			
	}
	
	//4.3
	//evalua los proyectiles contra todos los asteroides
	//evalua todos los asteroides contra todos los asteroides
	private void shootVS_asteroidTmas1(){
		//4.3
		for(int i=0; i<shipObj.getElementShoot().size();i++){
				for(int j=0;j<astElemObj.getElementosAsteroids().size();j++){
					if(shipObj.getElementShoot(i, 2)==astElemObj.getParam_Asteroid(j,2) && shipObj.getElementShoot(i, 3)==astElemObj.getParam_Asteroid(j,3)){
						shipObj.setElementShoot (i, 5, 1);
						astElemObj.setElementosAsteroids(j,4,1);
						setPointGame();
					}
				}
			}
		
		for(int x=0;x<astElemObj.getElementosAsteroids().size();x++) {
			for(int z=0;z<astElemObj.getElementosAsteroids().size();z++) {
					if(astElemObj.getParam_Asteroid(x, 2)==astElemObj.getParam_Asteroid(z, 2) &&
							astElemObj.getParam_Asteroid(x, 3)==astElemObj.getParam_Asteroid(z, 3) && 
							astElemObj.getParam_Asteroid(x, 0)!=astElemObj.getParam_Asteroid(z, 0))
					{
						
								astElemObj.setElementosAsteroids(x,4,1);
								astElemObj.setElementosAsteroids(z,4,1);
					}
			}
		}
		
	}
	
	//3
	//evalua la nave después de moverse al lanzar un proyectil
	//evalua si colisiona contra asteroides o proyectiles
	private void shipbeforeShoot(){ 
		
			for(int i=0;i<astElemObj.getElementosAsteroids().size();i++) 
			{
				if(shipObj.getNameShip(2)==astElemObj.getParam_Asteroid(i,2) && shipObj.getNameShip(3)==astElemObj.getParam_Asteroid(i,3)) 
				{
					shipObj.setNameShip( 5,1);
					astElemObj.setElementosAsteroids(i,4,1);
				}	
			}
			
			for(int j=0;j<shipObj.getElementShoot().size()-1;j++) 
			{
				if(shipObj.getNameShip(2)==shipObj.getElementShoot(j, 2) && shipObj.getNameShip(3)==shipObj.getElementShoot(j, 3)) 
				{
					shipObj.setNameShip( 5,1);
					shipObj.setElementShoot (j, 5, 1);
				}	
			}
		
	}
	
	//4.4
	//elimina los elementos dectectamos como colisionados
	private void deleteElement() {
		//astElemObj.getElementosAsteroids().remove(i);
		//tendré que hacer un prueba entre dos clases o 3 para eleminar parametros de una arreglo como en esta ocasión mientras se recorre el for
		//i:astElemObj.getElementosAsteroids().size()  
		for(int i=0;i<astElemObj.getElementosAsteroids().size();i++) {
			if(astElemObj.getParam_Asteroid(i, 4)==1) {
				astElemObj.getElementosAsteroids().remove(i);
				i=-1;
			}
		}
		
		for(int j=0;j<shipObj.getElementShoot().size();j++) {
			if(shipObj.getElementShoot(j, 5)==1) {
				shipObj.getElementShoot().remove(j);
				j=-1;
			}
		}
	}
	
	//4.5
	//mueve los proyectiles según los movimientos que le quedan 
	//evalua si la nave a colisionado 
	private void moveShootforFireRange() {
		//4.5
		for(int i=0;i<3;i++) 
		{
				for(int j=0;j<shipObj.getElementShoot().size();j++) 
				{
						if(shipObj.getNameShip(5)!=1) 
						{
								if(shipObj.getElementShoot(j, 4)>0) 
								{
									shipObj.moveShootforElement(j);
									shipObj.setElementShoot( j, 4, shipObj.getElementShoot(j, 4)-1);
									if(!(shipObj.getElementShoot( j, 2)==shipObj.getNameShip(2) &&
											shipObj.getElementShoot( j, 3)==shipObj.getNameShip(3))) 
									{
											for(int h=0;h<astElemObj.getElementosAsteroids().size();h++) 
												{
													if(shipObj.getElementShoot(j, 2)==astElemObj.getParam_Asteroid(h, 2) &&
															shipObj.getElementShoot(j, 3)==astElemObj.getParam_Asteroid(h, 3)) 
														{
															setPointGame();
															astElemObj.setElementosAsteroids(h,4,1);
															shipObj.setElementShoot (j, 5, 1);
														}
												}
									}
									if(shipObj.getElementShoot( j, 2)==shipObj.getNameShip(2) &&
											shipObj.getElementShoot( j, 3)==shipObj.getNameShip(3)) 
									{
											shipObj.setElementShoot (j, 5, 1);
											shipObj.setNameShip( 5,1);
									}
								}
						}
				}	
		}
		
		for(int a=0;a<astElemObj.getElementosAsteroids().size();a++) {
			if(astElemObj.getParam_Asteroid(a, 4)==1) {
				astElemObj.getElementosAsteroids().remove(a);
				a=-1;
			}
		}
		
		for(int b=0;b<shipObj.getElementShoot().size();b++) {
			if(shipObj.getElementShoot(b, 5)==1) {
				shipObj.getElementShoot().remove(b);
				b=-1;
			}
		}
		
		for(int c=0;c<shipObj.getElementShoot().size();c++) {
			if(shipObj.getElementShoot(c, 4)==0) {
				shipObj.getElementShoot().remove(c);
				c=-1;
			}
		}
		
	}
			
	private void mostrarMatriz() {
		for(int i=0;i<getN();i++) {
			for(int j=0;j<getM();j++) {
				System.out.print(" "+getspaceMatriz( i, j));
			}
			System.out.println();
		}
	}
	
	public void mostrarproyectiles() {
		
		for(int j=0;j<shipObj.getElementShoot().size();j++) {
			System.out.println();
			System.out.print(" "+ shipObj.getElementShoot(j, 0));
			System.out.print(" "+ shipObj.getElementShoot(j, 1));
			System.out.print(" "+ shipObj.getElementShoot(j, 2));
			System.out.print(" "+ shipObj.getElementShoot(j, 3));
			System.out.print(" "+ shipObj.getElementShoot(j, 4));
		}
		
	}
	
	public void mostrarnave() {
		System.out.println();
		System.out.print(" "+ shipObj.getNameShip(0));
		System.out.print(" "+ shipObj.getNameShip(1));
		System.out.print(" "+ shipObj.getNameShip(2));
		System.out.print(" "+ shipObj.getNameShip(3));
		System.out.print(" "+ shipObj.getNameShip(4));
		System.out.println();
	}
	
	public void textifySpace() {
				
		for(int i=0;i<getN();i++) {
			for(int j=0;j<getM();j++) {
					
				if(getspaceMatriz( i, j)>=1 ) {
					this.charMatriz[i][j]='O';
				}
				
				if(getspaceMatriz( i, j)<-98) {
					this.charMatriz[i][j]='*';
				}
				
				if(getspaceMatriz( i, j)==0) {
					this.charMatriz[i][j]=' ';
				}
					
				if(getspaceMatriz( i, j)==-1) {
					this.charMatriz[i][j]='N';
				}
					
			}
		}
		
		for(int h=0;h<getN();h++) {
			b[h]="";
		}
		
		for(int i=0;i<getN();i++) {
			for(int j=0;j<getM();j++) {
				b[i]=b[i]+" "+charMatriz[i][j];
			}
		}
		
	}
	
	public void viaciartext() {
		for(int i=0;i<getN();i++) {
			for(int j=0;j<getM();j++) {
				charMatriz[i][j]=' ';
			}
		}
	}
	
	public void printSpace() {
		mostrarPartida();
		viaciartext();
		textifySpace();
		for(int h=0;h<getN();h++) {
			System.out.println(b[h]);
		}
	}
	
	
}