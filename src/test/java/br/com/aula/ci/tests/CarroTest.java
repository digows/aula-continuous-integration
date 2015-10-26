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
	public void validaTrocadeMarchaNELTROparaPRIMEIRA() {
		final Carro carro = new Carro();

		// Liga e assegura que o carro está ligado !
		carro.ligar();
		Assert.assertTrue(carro.isLigado());

		// Assegura a troca de marcha do Neutro para Primeira marcha
		Assert.assertEquals(Cambio.NEUTRO, carro.getMarcha());
		carro.trocarMarcha(Cambio.PRIMEIRA_MARCA);

		// Acelera e Assegura que o carro está acelerando.
		Assert.assertEquals(Cambio.PRIMEIRA_MARCA, carro.getMarcha());
		carro.acelerar(10);
		Assert.assertEquals(10 * Cambio.PRIMEIRA_MARCA.getCapacidade(), carro.getGirosMotor(), 0);
		Assert.assertEquals(10 * Cambio.PRIMEIRA_MARCA.getCapacidade(), carro.getVelocidade(), 0);
		Assert.assertTrue(carro.getVelocidade() > 0);
	}

	@Test
	public void validaTrocadeMarchaPRIMERAparaSEGUNDA() {
		final Carro carro = new Carro();

		// Liga e assegura que o carro está ligado
		carro.ligar();
		Assert.assertTrue(carro.isLigado());

		// Assegura a troca de marcha da Primeira para a segunda
		Assert.assertEquals(Cambio.PRIMEIRA_MARCA, carro.getMarcha());
		carro.trocarMarcha(Cambio.SEGUNDA_MARCA);

		// Acelera e Assegura que o carro está acelerando.
		Assert.assertEquals(Cambio.SEGUNDA_MARCA, carro.getMarcha());
		
		carro.acelerar(10);

		Assert.assertEquals(10 * Cambio.SEGUNDA_MARCA.getCapacidade(), carro.getGirosMotor(), 0);
		Assert.assertEquals(10 * Cambio.SEGUNDA_MARCA.getCapacidade(), carro.getVelocidade(), 0);
		Assert.assertTrue(carro.getVelocidade() > 0);
	}

}
