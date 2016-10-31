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
	public void calculaGirosMotorDevePassar() {
		Cambio c = Cambio.PRIMEIRA_MARCA;
		c.calculaGiros(10);
		Assert.assertEquals(0, c.calculaGiros(10), 100);
	}
	
	@Test //Teste feito por @eliezersqr
	public void validaFreiar() {
		
		final Carro carro = new Carro();
		
		carro.acelerar(100);
		carro.freiar(50);

		Assert.assertEquals( 5, carro.getVelocidade(), 5 );
	}
	
	@Test //Teste feito por @eliezersqr
	public void validaFreiarAteParar() {
		
		final Carro carro = new Carro();
		
		carro.acelerar(30);
		carro.freiar(30);

		Assert.assertEquals( 0, carro.getVelocidade(), 0 );
		Assert.assertEquals( 0, carro.getGirosMotor(), 0 );
		Assert.assertEquals( Cambio.NEUTRO, carro.getMarcha());
	}

	
}
