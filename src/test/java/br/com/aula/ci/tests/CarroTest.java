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
		Assert.assertEquals( Cambio.NEUTRO, carro.getMarcha());
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
	
	
}
