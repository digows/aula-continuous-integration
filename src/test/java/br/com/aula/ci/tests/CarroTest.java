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
}
