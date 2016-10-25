package br.com.aula.ci;

public enum Cambio {
	NEUTRO(0),
	PRIMEIRA_MARCHA(10),
	SEGUNDA_MARCHA(20),
	TERCEIRA_MARCHA(30),
	QUARTA_MARCHA(40),
	QUINTA_MARCHA(50);
	
	private float capacidade;
	private float giros;
	
	private Cambio( float capacidade ) {
		this.capacidade = capacidade;
	}

	public float getCapacidade() {
		return capacidade;
	}
	
	/**
	 * Este método tem por objetivo calcular quantidade de giros do motor de acordo com a força aplicada na marcha selecionada
	 * 
	 * @author Diogo
	 * @param forca
	 * @return quantidade de giros
	 */
	public float calculaGiros(float forca) {
		return this.capacidade * forca;
	}
}
