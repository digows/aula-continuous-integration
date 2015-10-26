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
}
