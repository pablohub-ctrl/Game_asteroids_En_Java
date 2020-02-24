package asteroids;

import java.util.ArrayList;
import java.util.Random;

public class Asteroid {
	
	private ArrayList<int[]> elementosAsteroids;
	private int nameAsteroid;
	
	public Asteroid() {
		this.nameAsteroid=1;
		elementosAsteroids = new ArrayList<int[]>();
	}
		
	public ArrayList<int[]> getElementosAsteroids() {
		return elementosAsteroids;
	}

	public int getParam_Asteroid(int l,int i) {
		return elementosAsteroids.get(l)[i];
	}
	
	public void setElementAincrement() {elementosAsteroids.add(new int[5]);}

	public void setElementosAsteroids(int l, int i, int parametro) {
		this.elementosAsteroids.get(l)[i]=parametro;
	}

	public int getNameAsteroid() {
		return nameAsteroid;
	}

	public void setNameAsteroid() {
		this.nameAsteroid = nameAsteroid+1;
	}
	
	
	private void creatAsteroid(int limiteI, int limiteS, int gradosDirecc,int nNave, int mNave, int supORinf){
		 
		int l=elementosAsteroids.size();
		//System.out.println(l);
		int numeroAleatorioN;
		int numeroAleatorioM;
		setElementAincrement();
		 
		Random rnd = new Random();
	    //numeroAleatorioN = 1 + rnd.nextInt(limiteS - limiteI);
		if(supORinf==0) {
			
			numeroAleatorioN = 1 + rnd.nextInt( limiteI);
			numeroAleatorioM = rnd.nextInt(limiteS);
		
			while((numeroAleatorioN==nNave && numeroAleatorioM==mNave) || numeroAleatorioN>limiteI) {
				 numeroAleatorioN = rnd.nextInt(limiteS );
				 numeroAleatorioM = rnd.nextInt(limiteS);	
			}
	    }
	    
	    else {
	    	 //numeroAleatorioN = limiteI + rnd.nextInt(limiteS - limiteI);
	    	 numeroAleatorioN = limiteI + rnd.nextInt(limiteS);
	    	 //numeroAleatorioM = rnd.nextInt(limiteS - limiteI + 3);
			 numeroAleatorioM = rnd.nextInt(limiteS );
			
			 while((numeroAleatorioN==nNave && numeroAleatorioM==mNave) || numeroAleatorioN>limiteI) {
				//numeroAleatorioN = limiteI + rnd.nextInt(limiteS - limiteI); 
				 numeroAleatorioN = rnd.nextInt(limiteI);
				 numeroAleatorioM = rnd.nextInt(limiteS);	
			}
		}
	    
	    
		setElementosAsteroids(l,0,getNameAsteroid());
		setElementosAsteroids(l,1,gradosDirecc);
		setElementosAsteroids(l,2,numeroAleatorioN);
		setElementosAsteroids(l,3,numeroAleatorioM);
		setElementosAsteroids(l,4,0);
		setNameAsteroid();
		
		

}
	
	
	private void construcAst(int fila, int columna,int gradosDirecc, int nNave, int mNave) {
		
		if((getNameAsteroid()%2)==0) {
			creatAsteroid( (fila-1),  (columna-1),  gradosDirecc, nNave,  mNave,0);
		}
		else{
			creatAsteroid( (fila-1),  (columna-1),  gradosDirecc, nNave,  mNave,1);
		}
		
	     
	}

	
	public void seedAsteroids(int N,int  M,int seed, int  nNave, int mNave, int numerosdeAst) {
		int i=0;
		int valorAleatorio=0;
		Random seeD = new Random();
		while(i<numerosdeAst) {
			//valorAleatorio=direccAleatoria((seeD.nextInt(seed)/seed)%seed);
			valorAleatorio=direccAleatoria(seeD.nextInt(seed)%seed);
			
			construcAst( N-1,  M-1, valorAleatorio,  nNave,  mNave);
			i++;
		}
	}
	
	private int direccAleatoria(int num) {
		//if(num<= 2 && num>=0) {return 0;}
		if(num< 2) {return 0;}
		if(num== 3) {return 90;}
		if(num== 4) {return 180;}
		if(num== 5) {return 270;}
		if(num== 6) {return 0;}
		if(num== 7) {return 90;}
		if(num== 8) {return 180;}
		if(num== 9) {return 270;}
		if(num>9 && num<20) {return 90;}
		else {return 270;}
	}
	
	public void showListElement(){
		for(int j=0;j<getElementosAsteroids().size();j++) {
			System.out.println();
			System.out.print(" "+ getParam_Asteroid( j, 0));
			System.out.print(" "+ getParam_Asteroid( j, 1));
			System.out.print(" "+ getParam_Asteroid( j, 2));
			System.out.print(" "+ getParam_Asteroid( j, 3));
			System.out.print(" "+ getParam_Asteroid( j, 4));
		}
		System.out.println();
	}
	
	
	
}
