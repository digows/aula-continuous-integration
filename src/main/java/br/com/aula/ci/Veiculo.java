package br.com.aula.ci;

public interface Veiculo {
	public void acelerar( float forca );
	public void freiar( float forca );
	public void virarEsquerda( float graus );
	public void virarDireita( float graus );
	public void trocarMarcha( Cambio cambio );
	public void ligar();
	public boolean desligar();
}
