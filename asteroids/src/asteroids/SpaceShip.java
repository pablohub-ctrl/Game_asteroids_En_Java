package asteroids;

import java.util.ArrayList;

public class SpaceShip {
     
	
	private int fireRange;
	private ArrayList<int[]> elementShoot;
	private int nameShoot;
	private int [] nameShip;
	private int N;
	private int M;
	private int sizeArray;
	
		
	public int getSizeArray() {
		return sizeArray;
	}

	public void setSizeArray() {
		this.sizeArray = getSizeArray()+1;
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

	public int getM() {
		return M;
	}

	public void setM(int m) {
		M = m;
	}

	public SpaceShip(int alcanceDisparo) {
		this.sizeArray=0;
		nameShip = new int[6];
		setNameShip( 0,-1);
		setNameShip( 1,90);
		setNameShip( 2,5);
		setNameShip( 3,10);
		setNameShip( 4,0);
		setNameShip( 5,0);
    	this.fireRange=alcanceDisparo;
    	this.nameShoot=-99;
    	elementShoot = new ArrayList<int[]>();
    } 
		
    public int[] getNameShip() {
		return nameShip;
	}
    
    public int getNameShip(int i) {
		return nameShip[i];
	}

	public void setNameShip(int i, int parametro) {
		this.nameShip[i] = parametro;
	}

	public ArrayList<int[]> getElementShoot() {
		return elementShoot;
	}
    
    public int getElementShoot(int l,int i) {
		return elementShoot.get(l)[i];
	}
    
    public void setElementShootincrement() {
    	elementShoot.add(new int[6]);
    }

	public void setElementShoot(int l, int i, int parametro) {
		this.elementShoot.get(l)[i]=parametro;
	}
	
	public int getNameShoot() {
		return nameShoot;
	}

	public void setNameShootincrement() {
		this.nameShoot = nameShoot-1;
	}

	public int getfireRange() {
		return fireRange;
	}
			
	public void inicializarMoveShip(int direccion) {
		setNameShip(1, direccion);
		setNameShip(4, 3);
	}
	
	public void shootElement() {
		setElementShootincrement();
		setNameShip(4, getNameShip(4)+1);
		moveShip();
		setElementShoot((elementShoot.size()-1), 0, getNameShoot());
		setElementShoot((elementShoot.size()-1), 1, getNameShip(1));
		setElementShoot((elementShoot.size()-1), 2, getNameShip(2)); //los getN son del tablero, hay que contener
		setElementShoot((elementShoot.size()-1), 3, getNameShip(3));
		setElementShoot((elementShoot.size()-1), 4, getfireRange());
		setElementShoot((elementShoot.size()-1), 5, 0);
		setNameShootincrement(); 
		setSizeArray();
		moveShipbyShoot();
		moveShipbyShoot();
		 		
	}
		
	public void moveShipbyShoot() {
		
		if(getNameShip(1)==0) {
			if(0==getNameShip(3)){
				setNameShip(3, (getM()-1));
			}
			else {
				setNameShip(3,getNameShip(3)-1);
			}
		}
    	if(getNameShip(1)==45) {
    		if((getN()-1)==getNameShip(2) && 0==getNameShip(3)){
				setNameShip(2,0);
				setNameShip(3, (getM()-1));
    		}
    		if((getN()-1)==getNameShip(2)){
    			setNameShip(2,0);
    			setNameShip(3, getNameShip(3)-1);
    		}
    		if(0==getNameShip(3)){
    			setNameShip(2,getNameShip(2)+1);
    			setNameShip(3, (getM()-1));
    		}
    		else {
    			setNameShip(2,getNameShip(2)+1);
    			setNameShip(3, getNameShip(3)-1);
    		}
		}	
    	if(getNameShip(1)==90) {
			if((getN()-1)==getNameShip(2)){
				setNameShip(2, 0);
			}
			else{
				setNameShip(2,getNameShip(2)+1);
			}
		}
    	
    	if(getNameShip(1)==135) {
			if((getN()-1)==getNameShip(2) && (getM()-1)==getNameShip(3)){
				setNameShip(2,0);
				setNameShip(3, 0);
			}
			if((getN()-1)==getNameShip(2)){
				setNameShip(2,0);
				setNameShip(3, getNameShip(3)+1);
			}
			if((getM()-1)==getNameShip(3)){
				setNameShip(2,getNameShip(2)+1);
				setNameShip(3, 0);
			}
			else {
				setNameShip(2,getNameShip(2)+1);
				setNameShip(3, getNameShip(3)+1);
			}
		}
    	
    	if(getNameShip(1)==180) {
			if((getM()-1)==getNameShip(3)){
				setNameShip(3, 0);
			}
			else {
				setNameShip(3,getNameShip(3)+1);
			}
		}
    	if(getNameShip(1)==225) {
			if(0==getNameShip(2) && (getM()-1)==getNameShip(3)){
				setNameShip(2,(getN()-1));
				setNameShip(3, 0);
			}
			if(0==getNameShip(2)){
				setNameShip(2,(getN()-1));
				setNameShip(3, getNameShip(3)+1);
			}
			if((getM()-1)==getNameShip(3)){
				setNameShip(2,getNameShip(2)-1);
				setNameShip(3, 0);
			}
			else {
				setNameShip(2,getNameShip(2)-1);
				setNameShip(3, getNameShip(3)+1);
			}
		}
    	
    	if(getNameShip(1)==270) {
			if(0==getNameShip(2)){
				setNameShip(2, (getN()-1));
			}
			else {
				setNameShip(2,getNameShip(2)-1);
			}
		}
    	
    	if(getNameShip(1)==315) {
			if(0==getNameShip(2) && 0==getNameShip(3)){
				setNameShip(2,(getN()-1));
				setNameShip(3, (getM()-1));
			}
			if(0==getNameShip(2)){
				setNameShip(2,(getN()-1));
				setNameShip(3, getNameShip(3)-1);
			}
			if(0==getNameShip(3)){
				setNameShip(2,getNameShip(2)-1);
				setNameShip(3, (getM()-1));
			}
			else {
				setNameShip(2,getNameShip(2)-1);
				setNameShip(3, getNameShip(3)-1);
			}
		}
	}
		
	public void moveShootforElement(int element) {
		
		if(getElementShoot(element, 1)==0) {
			if((getM()-1)==getElementShoot(element,3)){
				setElementShoot( element, 3, 0);	
			}
			else {
				setElementShoot(element, 3,getElementShoot(element,3)+1);
			}
		}
		
		if(getElementShoot(element, 1)==45) {
		
			if(0==getElementShoot(element,2) && (getM()-1)==getElementShoot(element,3)){
				setElementShoot(element,2,(getN()-1));
				setElementShoot(element,3, 0);
			}
			if(0==getElementShoot(element,2)){
				setElementShoot(element,2,(getN()-1));
				setElementShoot(element, 3,getElementShoot(element,3)+1);
			}
			if((getM()-1)==getElementShoot(element,3)){
				setElementShoot(element,2,getElementShoot(element,2)-1);
				setElementShoot(element,3, 0);
			}
			else {
				setElementShoot(element,2,getElementShoot(element,2)-1);
				setElementShoot(element, 3,getElementShoot(element,3)+1);
				}
		}

		if(getElementShoot(element, 1)==90) {
			
			if(0==getElementShoot(element,2)){
				setElementShoot( element, 2, (getN()-1));	
			}
			else {
				setElementShoot(element, 2,getElementShoot(element,2)-1);
			}
		}
		
		if(getElementShoot(element, 1)==135) {
			
			if(0==getElementShoot(element,2) && 0==getElementShoot(element,3)){
				setElementShoot(element,2,(getN()-1));
				setElementShoot(element,3, (getM()-1));
			}
			if(0==getElementShoot(element,2)){
				setElementShoot(element,2,(getN()-1));
				setElementShoot(element, 3,getElementShoot(element,3)-1);
				
			}
			if(0==getElementShoot(element,3)){
				setElementShoot(element,2,getElementShoot(element,2)-1);
				setElementShoot(element,3, (getM()-1));
			}
			else {
				setElementShoot(element,2,getElementShoot(element,2)-1);
				setElementShoot(element, 3,getElementShoot(element,3)-1);
			}
		}
		
		if(getElementShoot(element, 1)==180) {
			if(0==getElementShoot(element,3)){
				setElementShoot( element, 3, (getM()-1));	
			}
			else {
				setElementShoot(element, 3,getElementShoot(element,3)-1);
			}
		}
		
		if(getElementShoot(element, 1)==225) {
			if((getN()-1)==getElementShoot(element,2) && 0==getElementShoot(element,3)){
				setElementShoot(element,2,0);
				setElementShoot(element,3, (getM()-1));
			}
			if((getN()-1)==getElementShoot(element,2)){
				setElementShoot(element,2,0);
				setElementShoot(element, 3,getElementShoot(element,3)-1);
			}
			if(0==getElementShoot(element,3)){
				setElementShoot(element,2,getElementShoot(element,2)+1);
				setElementShoot(element,3, (getM()-1));
			}
			else {
				setElementShoot(element,2,getElementShoot(element,2)+1);
				setElementShoot(element, 3,getElementShoot(element,3)-1);
				}
		}
		
		if(getElementShoot(element, 1)==270) {
			
			if((getN()-1)==getElementShoot(element,2)){
				setElementShoot( element, 2, 0);	
			}
			else {
				setElementShoot(element, 2,getElementShoot(element,2)+1);
			}
		}
		
		if(getElementShoot(element, 1)==315) {
			
			if((getN()-1)==getElementShoot(element,2) && (getM()-1)==getElementShoot(element,3)){
				setElementShoot(element,2,0);
				setElementShoot(element,3, 0);
			}
			if((getN()-1)==getElementShoot(element,2)){
				setElementShoot(element,2,0);
				setElementShoot(element, 3,getElementShoot(element,3)+1);
			}
			if((getM()-1)==getElementShoot(element,3)){
				setElementShoot(element,2,getElementShoot(element,2)+1);
				setElementShoot(element,3, 0);
				
			}
			else {
				setElementShoot(element,2,getElementShoot(element,2)+1);
				setElementShoot(element, 3,getElementShoot(element,3)+1);
			}
		}
		
	}
		
    public void moveShip() {
    	//setNameShip(i, parametroN);
		if(getNameShip(4)>0) {	
			
			if(getNameShip(1)==0) {
				if((getM()-1)==getNameShip(3)){
					setNameShip(3, 0);
					setNameShip(4, getNameShip(4)-1);
				}
				else {
					setNameShip(3,getNameShip(3)+1);
					setNameShip(4, getNameShip(4)-1);
					}
			}
			
			if(getNameShip(1)==45) {
				if(0==getNameShip(2) && (getM()-1)==getNameShip(3)){
					setNameShip(2,(getN()-1));
					setNameShip(3, 0);
					setNameShip(4, getNameShip(4)-1);
				}
				if(0==getNameShip(2)){
					setNameShip(2,(getN()-1));
					setNameShip(3, getNameShip(3)+1);
					setNameShip(4, getNameShip(4)-1);
				}
				if((getM()-1)==getNameShip(3)){
					setNameShip(2,getNameShip(2)-1);
					setNameShip(3, 0);
					setNameShip(4, getNameShip(4)-1);
				}
				else {
					setNameShip(2,getNameShip(2)-1);
					setNameShip(3, getNameShip(3)+1);
					setNameShip(4, getNameShip(4)-1);
				}
			}
				
			if(getNameShip(1)==90) {
				if(0==getNameShip(2)){
					setNameShip(2, (getN()-1));
					setNameShip(4, getNameShip(4)-1);
				}
				else {
					setNameShip(2,getNameShip(2)-1);
					setNameShip(4, getNameShip(4)-1);
				}
			}
			
			if(getNameShip(1)==135) {
				if(0==getNameShip(2) && 0==getNameShip(3)){
					setNameShip(2,(getN()-1));
					setNameShip(3, (getM()-1));
					setNameShip(4, getNameShip(4)-1);
				}
				if(0==getNameShip(2)){
					setNameShip(2,(getN()-1));
					setNameShip(3, getNameShip(3)-1);
					setNameShip(4, getNameShip(4)-1);
				}
				if(0==getNameShip(3)){
					setNameShip(2,getNameShip(2)-1);
					setNameShip(3, (getM()-1));
					setNameShip(4, getNameShip(4)-1);
				}
				else {
					setNameShip(2,getNameShip(2)-1);
					setNameShip(3, getNameShip(3)-1);
					setNameShip(4, getNameShip(4)-1);
				}
			}
			
			if(getNameShip(1)==180) {
				if(0==getNameShip(3)){
					setNameShip(3, (getM()-1));
					setNameShip(4, getNameShip(4)-1);
				}
				else {
					setNameShip(3,getNameShip(3)-1);
					setNameShip(4, getNameShip(4)-1);
				}
			}
			
			if(getNameShip(1)==225) {
				
				if((getN()-1)==getNameShip(2) && 0==getNameShip(3)){
					setNameShip(2,0);
					setNameShip(3, (getM()-1));
					setNameShip(4, getNameShip(4)-1);
				}
				if((getN()-1)==getNameShip(2)){
					setNameShip(2,0);
					setNameShip(3, getNameShip(3)-1);
					setNameShip(4, getNameShip(4)-1);
				}
				if(0==getNameShip(3)){
					setNameShip(2,getNameShip(2)+1);
					setNameShip(3, (getM()-1));
					setNameShip(4, getNameShip(4)-1);
				}
				else {
					setNameShip(2,getNameShip(2)+1);
					setNameShip(3, getNameShip(3)-1);
					setNameShip(4, getNameShip(4)-1);
				}
			}
			
			if(getNameShip(1)==270) {
				
				if((getN()-1)==getNameShip(2)){
					setNameShip(2, 0);
					setNameShip(4, getNameShip(4)-1);
				}
				else {
					setNameShip(2,getNameShip(2)+1);
					setNameShip(4, getNameShip(4)-1);
				}
			}
			
			if(getNameShip(1)==315) {
				if((getN()-1)==getNameShip(2) && (getM()-1)==getNameShip(3)){
					setNameShip(2,0);
					setNameShip(3, 0);
					setNameShip(4, getNameShip(4)-1);
				}
				if((getN()-1)==getNameShip(2)){
					setNameShip(2,0);
					setNameShip(3, getNameShip(3)+1);
					setNameShip(4, getNameShip(4)-1);
				}
				if((getM()-1)==getNameShip(3)){
					setNameShip(2,getNameShip(2)+1);
					setNameShip(3, 0);
					setNameShip(4, getNameShip(4)-1);
				}
				else {
					setNameShip(2,getNameShip(2)+1);
					setNameShip(3, getNameShip(3)+1);
					setNameShip(4, getNameShip(4)-1);
				}
			}
	
		}
    
    }
	
    public int[][] creatShip(int[][] matriz, int N, int M){
    	 
    	 setN(N);
    	 setM(M);
    	 
    	 
    	 if(((N%2)==0) && ((M%2)==0)) {
    		 matriz[(N/2)-1][(M/2)-1]=getNameShip(0);
    		 setNameShip(2,(N/2)-1);
			 setNameShip(3, (M/2)-1);
    	}
 		
 		if(((N%2)==0) && ((M%2)!=0)) {
 			matriz[(N/2)-1][M/2]=getNameShip(0);
 			setNameShip(2,(N/2)-1);
			setNameShip(3, M/2);
 		}
 		
 		if(((N%2)!=0) && ((M%2)==0)) {
 			matriz[(N/2)][(M/2)-1]=getNameShip(0);
 			setNameShip(2,(N/2));
			setNameShip(3,(M/2)-1);
 		}
 		
 		if(((N%2)!=0) && ((M%2)!=0)) {
 			matriz[(N/2)][(M/2)]=getNameShip(0);
 			setNameShip(2,(N/2));
			setNameShip(3,(M/2));
 		}
 		
    	return matriz;
    }
     
    public int[][] creatShipNxM(int[][] matriz, int N, int M){
    	 	
    	 	matriz[N][M]=getNameShip(0);
    	 
    	 	return matriz; 
     }

}
