package br.com.aula.ci.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.aula.ci.Cambio;
import br.com.aula.ci.Carro;

public class CarroTest {
	
	@Test
	public void validaEstadoInicialDevePassar() {
		final Carro carro = new Carro();
		
		Assert.assertEquals( 0, carro.getDirecao(), 0 );
		Assert.assertEquals( 0, carro.getVelocidade(), 0 );
		Assert.assertEquals( 0, carro.getGirosMotor(), 0 );
		Assert.assertFalse( carro.isLigado() );
		Assert.assertEquals( Cambio.NEUTRO, carro.getMarcha());
	}
	
	@Test
	public void aceleracaoDevePassar() {
		final Carro carro = new Carro();
		
		carro.ligar();
		carro.acelerar(80f);
		
		Assert.assertTrue(carro.isLigado());
		Assert.assertEquals(carro.getMarcha(), Cambio.NEUTRO);
		Assert.assertNull(carro.getVelocidade());
		Assert.assertEquals (1600f, carro.getGirosMotor(), 0);
		
		
		carro.trocarMarcha(Cambio.SEGUNDA_MARCA);
		carro.acelerar(90f);
		
		Assert.assertTrue(carro.isLigado());
		Assert.assertEquals(carro.getMarcha(), Cambio.SEGUNDA_MARCA);
		Assert.assertNotNull(carro.getVelocidade());
		Assert.assertEquals (1800f, carro.getGirosMotor(), 0);
		Assert.assertEquals(1800f/10f, carro.getVelocidade(), 0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void aceleracaoValorMaiorQue100DeveFalhar(){
		final Carro carro = new Carro();
		carro.ligar();
		carro.acelerar(110f);
		
		Assert.fail("O acelerador é maior que 100 e passou.");
	}
	@Test(expected=IllegalArgumentException.class)
	public void aceleracaoValorMenorQue0DeveFalhar(){
		final Carro carro = new Carro();
		carro.ligar();
		carro.acelerar(-90f);
		
		Assert.fail("O acelerador é menor que 0 e passou.");
	}
	@Test(expected=IllegalStateException.class)
	public void aceleracaoCarroDesligadoDeveFalhar(){
		final Carro carro = new Carro();
		carro.acelerar(90f);
		
		Assert.fail("O carro foi acelerado mesmo desligado e passou.");
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
	
	/**
	 * Osmar
	 *Teste ligar o carro
	 */
	@Test
	public void validaEstadoParaLigar(){
		final Carro carro = new Carro();
		// 1 senario liga primeira vez
		//liga o carro
		carro.ligar();
		//deve passar
		Assert.assertTrue(carro.isLigado());
		
		// 2 senario ligar segunda vez
		//Deve lancar uma excessao informando: "O carro deve estar desligado!"
		carro.ligar();	
		//o carro deve continuar ligado
		Assert.assertTrue(carro.isLigado());
		
		// 3 senario desliga e liga novamente 
		//desliga o carro
		carro.desligar();
	  //deve passar
		Assert.assertTrue( !carro.isLigado());
		//deve passar
		carro.ligar();
		//deve passar
		Assert.assertTrue(carro.isLigado());
	}
	
	@Test
	public void validaCarroEstarMovimento(){
		final Carro carro = new Carro();
		carro.ligar();
		Assert.assertTrue(carro.isLigado());
		
		Assert.assertEquals(Cambio.NEUTRO, carro.getMarcha());
		
		carro.trocarMarcha(Cambio.PRIMEIRA_MARCA);
		carro.acelerar(10);
		
		Assert.assertTrue(carro.getVelocidade() > 0);
	}
	
	@Test
	public void validaCarroFrearEmDezPorcentoENaoVaiParar(){
		final Carro carro = new Carro();
		carro.ligar();
		Assert.assertTrue(carro.isLigado());
		Assert.assertEquals(Cambio.NEUTRO, carro.getMarcha());
		
		carro.trocarMarcha(Cambio.PRIMEIRA_MARCA);
		carro.acelerar(10);
		
		carro.freiar(1);
		Assert.assertTrue(carro.getVelocidade() == 90);
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
	
	@Test
	public void calculaGirosMotorDevePassar() {
		Cambio c = Cambio.PRIMEIRA_MARCA;
		c.calculaGiros(10);
		Assert.assertEquals(0, c.calculaGiros(10), 100);
	}
}