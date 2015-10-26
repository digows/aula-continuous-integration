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

	@Test
	public void validaCarroDeveEstarDesligadoPassar() {
		final Carro carro = new Carro();
		carro.ligar();
		carro.desligar();
	}

	@Test
	public void validaCarroDeveEstarDesligadoReprovar() {
		final Carro carro = new Carro();
		carro.desligar();
	}

	@Test
	public void validaCarroDeveEstarParadoPassar() {
		final Carro carro = new Carro();
		carro.acelerar(100);
		carro.freiar(100);
		carro.desligar();
	}

	@Test
	public void validaCarroDeveEstarParadoReprovar() {
		final Carro carro = new Carro();
		carro.acelerar(100);
		
		carro.desligar();
	}

}
