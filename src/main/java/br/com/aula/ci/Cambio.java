package br.com.aula.ci;

public enum Cambio {
	NEUTRO(0),
	PRIMEIRA_MARCA(10),
	SEGUNDA_MARCA(20),
	TERCEIRA_MARCA(30),
	QUARTA_MARCA(40),
	QUINTA_MARCA(50);
	
	private float capacidade;
	private float giros;
	
	private Cambio( float capacidade ) {
		this.capacidade = capacidade;
	}

	public float getCapacidade() {
		return capacidade;
	}
	
	public float calculaGiros(float forca) {
		if(forca > 0) {
			giros = forca*capacidade;
		} else {
			giros = 0;
		}
		return giros;
	}
}
