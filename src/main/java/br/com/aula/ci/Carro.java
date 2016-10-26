package br.com.aula.ci;

public class Carro implements Veiculo {

	//--------
	// ATRIBUTOS
	//--------
	private float girosMotor = 0;
	private float velocidade = 0;
	private float direcao = 0;
	private Cambio marcha = Cambio.NEUTRO;
	private boolean ligado = false;
	
	//--------
	// COMPORTAMENTOS
	//--------
	public void acelerar(float forca) {
		// TODO Auto-generated method stub
	}

	public void freiar(float forca) {
		// TODO Auto-generated method stub
	}

	public void virarEsquerda(float graus)     {
		
		if (graus < -91 || graus < 0) {
			//soltaria a excessão
		}
		
		if (!this.desligar()){
			
			this.velocidade = this.velocidade * (graus/100);
			
			}
		
	}

	public void virarDireita(float graus) {
		
		if (graus > 0 || graus < 91) {
			//soltaria a excessão
		}
		
		if (!this.desligar()){
			
			this.velocidade = this.velocidade * (graus/100);
			
			}
	}

	public void trocarMarcha(Cambio cambio) {
		// TODO Auto-generated method stub
		if(cambio.getCapacidade() == this.marcha.getCapacidade()+10 || this.marcha.getCapacidade() == cambio.getCapacidade()-10)
		this.marcha = cambio;
		
	}

	public boolean ligar() {
        if (this.ligado == false){
            this.ligado = true;
            return true;
        }
		return false;
	}

	public boolean desligar() {
		// TODO Auto-generated method stub
		return false;
	}
	
	//--------
	// GETTERS
	//--------
	public float getVelocidade() {
		return velocidade;
	}

	public float getDirecao() {
		return direcao;
	}

	public Cambio getMarcha() {
		return marcha;
	}

	public boolean isLigado() {
		return ligado;
	}

	public float getGirosMotor() {
		return girosMotor;
	}
}
