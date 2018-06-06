package br.ifrn.xacml.pip.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import br.edu.ifrn.pip.AtributosConstantes;
import br.edu.ifrn.pip.connectors.Connector;
import br.edu.ifrn.pip.factory.Factory;

public class TestPostgres {

	@Test
	public void testAtributoDonoTicket() {
		Connector connector = Factory.getInstance().criarConnector(AtributosConstantes.ATRIB_CENTRALSERV_DONOTICKET);
		String valorAtributo = connector.recuperarValorDeAtributo("1");
		assertEquals("O resultado não foi esperado", "01199881430", valorAtributo);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAtributoVazio() {
		Connector connector = Factory.getInstance().criarConnector(AtributosConstantes.ATRIB_CENTRALSERV_DONOTICKET);
		connector.recuperarValorDeAtributo("");
		fail("Deveria ter lançado exceção IllegalArgumentException");
	}
}
