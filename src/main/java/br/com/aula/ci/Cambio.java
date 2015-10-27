package br.com.aula.ci;

public enum Cambio {
	NEUTRO(0),
	PRIMEIRA_MARCA(10),
	SEGUNDA_MARCA(20),
	TERCEIRA_MARCA(30),
	QUARTA_MARCA(40),
	QUINTA_MARCA(50);
	
	private float capacidade;
	
	private Cambio( float capacidade ) {
		this.capacidade = capacidade;
	}

	public float getCapacidade() {
		return capacidade;
	}
	
	public float calculaGiros(float forca) {
		if(forca > 0) {
			return forca*capacidade;
		} else {
			return 0;
		}
	}
}
