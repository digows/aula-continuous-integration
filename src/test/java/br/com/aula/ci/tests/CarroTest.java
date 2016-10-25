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
	
	@Test(expected = IllegalArgumentException.class)
	public void ValidaAceleracaoEntreZeroECem() {
		final Carro carro = new Carro();
		
		carro.ligar();
		Assert.assertEquals(true, carro.isLigado());
		carro.acelerar(0);
		Assert.assertEquals(0, carro.getVelocidade(), 0);
		carro.acelerar(101);
		Assert.assertNotEquals(101, carro.getVelocidade());
		carro.acelerar(-1);
		Assert.assertNotEquals(-1, carro.getVelocidade());
	}
	
}
