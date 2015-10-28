package br.com.aula.ci;

public class Carro implements Veiculo {

	// --------
	// ATRIBUTOS
	// --------
	private float girosMotor = 0;
	private float velocidade = 0;
	private float direcao = 0;
	private Cambio marcha = Cambio.NEUTRO;
	private boolean ligado = false;

	// --------
	// COMPORTAMENTOS
	// --------
	public void acelerar(float forca) {
		if (isLigado())
			if (forca >= 0 && forca <= 100) {
				girosMotor = marcha.getCapacidade() * forca;
				velocidade = girosMotor / 10f;
			} else
				throw new IllegalArgumentException(
						"Valor para aceleracao invalido!");
		else
			throw new IllegalArgumentException(
					"O caro esta sendo acelerado enquanto esta desligado!");
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

	public void ligar() {
		if (!this.isLigado()) {
			this.ligado = true;
		} else {
			throw new IllegalStateException("O carro deve estar desligado!");
		}
	}

	public void desligar() {
		if (this.isLigado()) {

			if (this.getVelocidade() > 0) {
				throw new IllegalStateException(
						"O carro precisa estar parado para poder ser desligado!");
			} else {
				this.ligado = false;
			}

		} else {
			throw new IllegalStateException(
					"O carro precisa estar ligado para poder ser desligado!");
		}
	}

	// --------
	// GETTERS
	// --------
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
