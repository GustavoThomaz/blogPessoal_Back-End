package org.generation.blogPessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private Usuario user;
	//private Usuario userAlter;
	
	@BeforeAll
	public void start() {
		user = new Usuario("Ester","12345678","Esterz");
		//userAlter = new Usuario("Ester","23456789");
	}
	
	@Disabled
	@Test
	void testaRetornoSalvarUsuarioEStatus201() {
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(user);
		
		ResponseEntity<Usuario> resposta = testRestTemplate.exchange("/usuario/cadastrar",HttpMethod.POST,request,Usuario.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
}
