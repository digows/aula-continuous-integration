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

	public void virarEsquerda(float graus) {
		// TODO Auto-generated method stub
	}

	public void virarDireita(float graus) {
		// TODO Auto-generated method stub
	}

	public void trocarMarcha(Cambio cambio) {
		// TODO Auto-generated method stub
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
