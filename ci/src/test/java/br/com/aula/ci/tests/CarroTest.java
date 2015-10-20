package br.com.aula.ci.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.aula.ci.Carro;

public class CarroTest {
	
	@Test
	public void validaChassiDevePassar() {
		final Carro carro = new Carro();
		carro.setChassi("2008aAFDSFAS4203492");
		
		Assert.assertNotNull( carro.getChassi() );
		Assert.assertNotNull( carro.getAno() );
		Assert.assertEquals("2008", carro.getAno());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void validaChassiDeveFalhar() {
		final Carro carro = new Carro();
		carro.setChassi("INVALIDO");
		
		Assert.fail("O chassi está invalido e passou.");
	}
}
