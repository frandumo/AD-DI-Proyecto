package Controlador;

public class Muelle {
	
	int muelle = 0;
	int ocupado = 0;
	
	public Muelle (){}
	
	public Muelle (int muelle){
		this.muelle = muelle;
	}

	public Integer getMuelle() {
		return this.muelle;
	}

	public void setMuelle(Integer muelle) {
		this.muelle = muelle;
	}
	
	public Integer getOcupado() {
		return this.ocupado;
	}

	public void setOcupado(Integer ocupado) {
		this.ocupado = ocupado;
	}
	
}
