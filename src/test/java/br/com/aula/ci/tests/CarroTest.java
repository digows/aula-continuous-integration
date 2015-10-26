package br.com.aula.ci.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.aula.ci.Cambio;
import br.com.aula.ci.Carro;

public class CarroTest {

	@Test
	public void validaEstadoInicialDevePassar() {
		final Carro carro = new Carro();

		Assert.assertEquals(0, carro.getDirecao(), 0);
		Assert.assertEquals(0, carro.getVelocidade(), 0);
		Assert.assertEquals(0, carro.getGirosMotor(), 0);
		Assert.assertEquals(Cambio.NEUTRO, carro.getMarcha());
	}

	
	/**
	 * @author Thiago tadashi
	 * 
	 * O carro deve estar ligado para poder ser desligado. Obs: deve passar.
	 */
	@Test
	public void validaCarroDeveEstarDesligadoPassar() {
		final Carro carro = new Carro();
		carro.ligar();
		carro.desligar();
	}
	
	/**
	 * @author Thiago tadashi
	 * 
	 * O carro deve estar ligado para poder ser desligado. Obs: deve reprovar.
	 */
	@Test
	public void validaCarroDeveEstarDesligadoReprovar() {
		final Carro carro = new Carro();
		carro.desligar();
	}

	/**
	 * @author Thiago tadashi
	 * 
	 * O carro deve estar parado para poder ser desligado. Obs: deve passar.
	 */
	@Test
	public void validaCarroDeveEstarParadoPassar() {
		final Carro carro = new Carro();
		carro.acelerar(100);
		carro.freiar(100);
		carro.desligar();
	}

	/**
	 * @author Thiago tadashi
	 * 
	 * O carro deve estar parado para poder ser desligado. Obs: deve reprovar.
	 */
	@Test
	public void validaCarroDeveEstarParadoReprovar() {
		final Carro carro = new Carro();
		carro.acelerar(100);
		
		carro.desligar();
	}

}
