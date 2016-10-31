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
		
		if (graus < -90 || graus > -1) {
			//exceção
		}
		
		if (!this.desligar()){
			
			this.velocidade = this.velocidade * ( (graus * -1) / 100);
			
			}	
	}

	public void virarDireita(float graus) {
		
		if (graus < 1 || graus > 90) {
			//exceção
		}
		
		if (!this.desligar()){
			
			this.velocidade = this.velocidade * (graus / 100);
			
			}
	}

	public void trocarMarcha(Cambio cambio) {
		// TODO Auto-generated method stub
	}

	public boolean ligar() {
		// TODO Auto-generated method stub
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
