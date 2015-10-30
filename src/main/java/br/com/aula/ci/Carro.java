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
				if (marcha.getCapacidade() != 0.0f) {
					girosMotor = marcha.getCapacidade() * forca;
					velocidade = girosMotor / 10f;
				} else {
					girosMotor = forca;
					velocidade = 0f;
				}

			} else
				throw new IllegalArgumentException(
						"Valor para aceleracao invalido!");
		else
			throw new IllegalStateException(
					"O caro esta sendo acelerado enquanto esta desligado!");
	}

	public void freiar(float forca) {
		if (velocidade > 0) {
			if (forca >= 0 && forca <= 100)
				velocidade = velocidade - ((velocidade / 100) * forca);
			else
				throw new IllegalArgumentException(
						"Valor para freiar invalido!");
		} else
			throw new IllegalArgumentException("O carro não está em movimento!");
	}

	public void virar(float graus) {
		if ((graus >= -90 && graus <= 90)) {
			if (graus >= -90 && graus < 0)
				graus = graus * -1;
			if (velocidade > 0) {
				velocidade = velocidade - ((velocidade / 100) * graus);
				girosMotor = girosMotor - ((girosMotor / 100) * graus);
			} else
				throw new IllegalArgumentException(
						"O carro não está em movimento!");
		} else
			throw new IllegalArgumentException("Valor para virar invalido!");
	}

	public void virarEsquerda(float graus) {
		// TODO Auto-generated method stub
	}

	public void virarDireita(float graus) {
		// TODO Auto-generated method stub
	}

	public void trocarMarcha(Cambio cambio) {
		if (isLigado())
			marcha = cambio;
		else
			throw new IllegalStateException("O caro não esta ligado!");
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
