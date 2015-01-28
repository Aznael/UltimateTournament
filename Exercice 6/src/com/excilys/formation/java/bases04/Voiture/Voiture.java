package com.excilys.formation.java.bases04.Voiture;

public class Voiture {
	
	private final int NOMBRE_ROUES=4;
	
	protected float prixSP98;
	protected float prixSP95;
	protected float prixDiesel;
	protected float prixGPL;
	
	public enum EnumCarburant{
		SANS_PLOMB_98,
		SANS_PLOMB_95,
		DIESEL,
		GPL;
	};
	private EnumCarburant carburant;
	 
	public Voiture(EnumCarburant Carburant){
		this.carburant=Carburant;
	}
	
	public Voiture(EnumCarburant Carburant, float prixSP98, float prixSP95, float prixDIESEL, float prixGPL){
		this.carburant=Carburant;
		this.prixSP98=prixSP98;
		this.prixSP95=prixSP95;
		this.prixDiesel=prixDIESEL;
		this.prixGPL=prixGPL;
	}
	
	public float getPrixSP98() {
		return prixSP98;
	}

	public void setPrixSP98(float prixSP98) {
		this.prixSP98 = prixSP98;
	}

	public float getPrixSP95() {
		return prixSP95;
	}

	public void setPrixSP95(float prixSP95) {
		this.prixSP95 = prixSP95;
	}

	public float getPrixDiesel() {
		return prixDiesel;
	}

	public void setPrixDiesel(float prixDiesel) {
		this.prixDiesel = prixDiesel;
	}

	public float getPrixGPL() {
		return prixGPL;
	}

	public void setPrixGPL(float prixGPL) {
		this.prixGPL = prixGPL;
	}

	public EnumCarburant getCarburant() {
		return carburant;
	}

	public int getNOMBRE_ROUES() {
		return NOMBRE_ROUES;
	}
	public static void service(){
		float prixSP98=1;
		float prixSP95=2;
		float prixDiesel=3;
		float prixGPL=4;	
		Voiture.EnumCarburant carburant1= EnumCarburant.DIESEL;
		Voiture car1 = new Voiture(carburant1,prixSP98,prixSP95,prixDiesel,prixGPL );
		Voiture.EnumCarburant carburant2= EnumCarburant.SANS_PLOMB_95;
		Voiture car2 = new Voiture(carburant2,prixSP98,prixSP95,prixDiesel,prixGPL );
		System.out.println("Première voiture");
		car1.getCarburant();
		car1.getNOMBRE_ROUES();
		car1.getPrixDiesel();
		car1.getPrixGPL();
		car1.getPrixSP95();
		car1.getPrixSP98();
		
		System.out.println("Deuxième voiture  ");
		System.out.print(car2.getCarburant()+" ");
		car2.getNOMBRE_ROUES();
		car2.getPrixDiesel();
		car2.getPrixGPL();
		car2.getPrixSP95();
		car2.getPrixSP98();
		
		prixSP98=10;
		prixSP95=20;
		prixDiesel=30;
		prixGPL=40;
		Voiture.EnumCarburant carburant3 = 
	}
	
}
