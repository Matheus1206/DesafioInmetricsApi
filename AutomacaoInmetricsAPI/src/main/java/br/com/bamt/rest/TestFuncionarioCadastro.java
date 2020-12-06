package br.com.bamt.rest;

import static  org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import br.com.bamt.modelo.Funcionario;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;



public class TestFuncionarioCadastro {
	
		private String url = "https://inm-api-test.herokuapp.com/empregado/cadastrar";
		Funcionario funcionario = new Funcionario();
		JSONObject requestParams = new JSONObject();
		
		public void inicializaObjetos() {
			funcionario.setEmpregadoId(2);
			funcionario.setNome("Matheus Oliveira");
			funcionario.setSexo("m");
			funcionario.setCpf("867.656.270-10");
			funcionario.setCargo("Analista de QA");
			funcionario.setDataAdmissao("08/12/2020");
			funcionario.setSalario("1.000,00");
			funcionario.setComissao("1.000,00");
			funcionario.setTipoContratacao("clt");	
		}
		
		
		@Before
		public void inicializaFuncionario() {
			inicializaObjetos();
		}
		
		@Test
		public void cadastrarFuncionario() {
			
			requestParams.put("admissao", funcionario.getDataAdmissao());
			requestParams.put("cargo", funcionario.getCargo());
			requestParams.put("comissao", funcionario.getComissao());
			requestParams.put("cpf", funcionario.getCpf());
			requestParams.put("departamentoId", funcionario.getEmpregadoId());
			requestParams.put("nome", funcionario.getNome());
			requestParams.put("salario", funcionario.getSalario());
			requestParams.put("sexo", funcionario.getSexo());
			requestParams.put("tipoContratacao", funcionario.getTipoContratacao());
			
			given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
			when().post(url).
			then().statusCode(202);
		}
		
		@Test
		public void validarAdmissaoFuncionario() {
			requestParams.put("admissao", "20012000");
			requestParams.put("cargo", funcionario.getCargo());
			requestParams.put("comissao", funcionario.getComissao());
			requestParams.put("cpf", funcionario.getCpf());
			requestParams.put("departamentoId", funcionario.getEmpregadoId());
			requestParams.put("nome", funcionario.getNome());
			requestParams.put("salario", funcionario.getSalario());
			requestParams.put("sexo", funcionario.getSexo());
			requestParams.put("tipoContratacao", funcionario.getTipoContratacao());
			
			given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
			when().post(url).
			then().statusCode(400);
		
		}
		
		@Test
		public void validarComissaoFuncionario() {
			requestParams.put("admissao", "20012000");
			requestParams.put("cargo", funcionario.getCargo());
			requestParams.put("comissao", funcionario.getComissao());
			requestParams.put("cpf", funcionario.getCpf());
			requestParams.put("departamentoId", funcionario.getEmpregadoId());
			requestParams.put("nome", funcionario.getNome());
			requestParams.put("salario", funcionario.getSalario());
			requestParams.put("sexo", funcionario.getSexo());
			requestParams.put("tipoContratacao", funcionario.getTipoContratacao());
			
			given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
			when().post(url).
			then().statusCode(400);
		}
		
		@Test
		public void validarDepartamentoFuncionario() {
			requestParams.put("admissao", funcionario.getDataAdmissao());
			requestParams.put("cargo", funcionario.getCargo());
			requestParams.put("comissao", funcionario.getComissao());
			requestParams.put("cpf", funcionario.getCpf());
			requestParams.put("departamentoId", 1555522);
			requestParams.put("nome", funcionario.getNome());
			requestParams.put("salario", funcionario.getSalario());
			requestParams.put("sexo", funcionario.getSexo());
			requestParams.put("tipoContratacao", funcionario.getTipoContratacao());
			
			given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
			when().post(url).
			then().statusCode(400).body(is("Departamento não cadastrado"));
		}
		
		@Test
		public void validarSalarioFuncionario() {
			requestParams.put("admissao", funcionario.getDataAdmissao());
			requestParams.put("cargo", funcionario.getCargo());
			requestParams.put("comissao", funcionario.getComissao());
			requestParams.put("cpf", funcionario.getCpf());
			requestParams.put("departamentoId", funcionario.getEmpregadoId());
			requestParams.put("nome", funcionario.getNome());
			requestParams.put("salario", "10000");
			requestParams.put("sexo", funcionario.getSexo());
			requestParams.put("tipoContratacao", funcionario.getTipoContratacao());
			
			given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
			when().post(url).
			then().statusCode(400);
		}
		
		@Test
		public void validarSexoFuncionario() {
			requestParams.put("admissao", funcionario.getDataAdmissao());
			requestParams.put("cargo", funcionario.getCargo());
			requestParams.put("comissao", funcionario.getComissao());
			requestParams.put("cpf", funcionario.getCpf());
			requestParams.put("departamentoId", funcionario.getEmpregadoId());
			requestParams.put("nome", funcionario.getNome());
			requestParams.put("salario", funcionario.getSalario());
			requestParams.put("sexo", "masculino");
			requestParams.put("tipoContratacao", funcionario.getTipoContratacao());
			
			given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
			when().post(url).
			then().statusCode(400);
		}
		
		@Test
		public void validarTipoContratacaoFuncionario() {
			requestParams.put("admissao", funcionario.getDataAdmissao());
			requestParams.put("cargo", funcionario.getCargo());
			requestParams.put("comissao", funcionario.getComissao());
			requestParams.put("cpf", funcionario.getCpf());
			requestParams.put("departamentoId", funcionario.getEmpregadoId());
			requestParams.put("nome", funcionario.getNome());
			requestParams.put("salario", funcionario.getSalario());
			requestParams.put("sexo", funcionario.getSexo());
			requestParams.put("tipoContratacao", "Contratado");
			
			given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
			when().post(url).
			then().statusCode(400);
		}
		
		
}
