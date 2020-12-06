package br.com.bamt.rest;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;


import br.com.bamt.modelo.Funcionario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestAlterarFuncionario {
	private String url = "https://inm-api-test.herokuapp.com/empregado/alterar/";
	Funcionario funcionario = new Funcionario();
	JSONObject requestParams = new JSONObject();
	private Integer id;
	
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
	public void cadastrarFuncionario() {
		inicializaObjetos();
		RestAssured.baseURI ="https://inm-api-test.herokuapp.com/empregado";
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao");
		requestParams.put("admissao", funcionario.getDataAdmissao());
		requestParams.put("cargo", funcionario.getCargo());
		requestParams.put("comissao", funcionario.getComissao());
		requestParams.put("cpf", funcionario.getCpf());
		requestParams.put("departamentoId", funcionario.getEmpregadoId());
		requestParams.put("nome", funcionario.getNome());
		requestParams.put("salario", funcionario.getSalario());
		requestParams.put("sexo", funcionario.getSexo());
		requestParams.put("tipoContratacao", funcionario.getTipoContratacao());
		request.body(requestParams.toJSONString());
		Response response = request.post("/cadastrar");
		id = response.jsonPath().getInt("empregadoId");
	}
	
	@Test
	public void alterarDataAdmissaoUsuarioCadastrado() {
		requestParams.put("admissao", "01/01/1998");
		requestParams.put("cargo", funcionario.getCargo());
		requestParams.put("comissao", funcionario.getComissao());
		requestParams.put("cpf", funcionario.getCpf());
		requestParams.put("departamentoId", funcionario.getEmpregadoId());
		requestParams.put("nome", funcionario.getNome());
		requestParams.put("salario", funcionario.getSalario());
		requestParams.put("sexo", funcionario.getSexo());
		requestParams.put("tipoContratacao", funcionario.getTipoContratacao());
		given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
		when().put(url+id).
		then().statusCode(202).body("admissao", Matchers.is("01/01/1998"));		
	}
	
	@Test
	public void alterarCargoUsuarioCadastrado() {
		requestParams.put("admissao", funcionario.getDataAdmissao());
		requestParams.put("cargo", "Corretor");
		requestParams.put("comissao", funcionario.getComissao());
		requestParams.put("cpf", funcionario.getCpf());
		requestParams.put("departamentoId", funcionario.getEmpregadoId());
		requestParams.put("nome", funcionario.getNome());
		requestParams.put("salario", funcionario.getSalario());
		requestParams.put("sexo", funcionario.getSexo());
		requestParams.put("tipoContratacao", funcionario.getTipoContratacao());
		given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
		when().put(url+id).
		then().statusCode(202).body("cargo", Matchers.is("Corretor"));
	}
	
	@Test
	public void alterarComissaoUsuarioCadastrado() {
		requestParams.put("admissao", funcionario.getDataAdmissao());
		requestParams.put("cargo", funcionario.getCargo());
		requestParams.put("comissao", "5.999,99");
		requestParams.put("cpf", funcionario.getCpf());
		requestParams.put("departamentoId", funcionario.getEmpregadoId());
		requestParams.put("nome", funcionario.getNome());
		requestParams.put("salario", funcionario.getSalario());
		requestParams.put("sexo", funcionario.getSexo());
		requestParams.put("tipoContratacao", funcionario.getTipoContratacao());
		given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
		when().put(url+id).
		then().statusCode(202).body("comissao", Matchers.is("5.999,99"));	
	}
	
	@Test
	public void alterarCpfUsuarioCadastrado() {
		requestParams.put("admissao", funcionario.getDataAdmissao());
		requestParams.put("cargo", funcionario.getCargo());
		requestParams.put("comissao", funcionario.getComissao());
		requestParams.put("cpf", "111.111.111-11");
		requestParams.put("departamentoId", funcionario.getEmpregadoId());
		requestParams.put("nome", funcionario.getNome());
		requestParams.put("salario", funcionario.getSalario());
		requestParams.put("sexo", funcionario.getSexo());
		requestParams.put("tipoContratacao", funcionario.getTipoContratacao());
		given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
		when().put(url+id).
		then().statusCode(202).body("cpf", Matchers.is("111.111.111-11"));	
	}
	
	@Test
	public void alterarDepartamentoUsuarioCadastrado() {
		requestParams.put("admissao", funcionario.getDataAdmissao());
		requestParams.put("cargo", funcionario.getCargo());
		requestParams.put("comissao", funcionario.getComissao());
		requestParams.put("cpf", funcionario.getCpf());
		requestParams.put("departamentoId", 1);
		requestParams.put("nome", funcionario.getNome());
		requestParams.put("salario", funcionario.getSalario());
		requestParams.put("sexo", funcionario.getSexo());
		requestParams.put("tipoContratacao", funcionario.getTipoContratacao());
		given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
		when().put(url+id).
		then().statusCode(202);
	}
	
	@Test
	public void alterarNomeUsuarioCadastrado() {
		requestParams.put("admissao", funcionario.getDataAdmissao());
		requestParams.put("cargo", funcionario.getCargo());
		requestParams.put("comissao", funcionario.getComissao());
		requestParams.put("cpf", funcionario.getCpf());
		requestParams.put("departamentoId", funcionario.getEmpregadoId());
		requestParams.put("nome", "Alterar Dado");
		requestParams.put("salario", funcionario.getSalario());
		requestParams.put("sexo", funcionario.getSexo());
		requestParams.put("tipoContratacao", funcionario.getTipoContratacao());
		given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
		when().put(url+id).
		then().statusCode(202).body("nome", Matchers.is("Alterar Dado"));
	}
	
	@Test
	public void alterarSalarioUsuarioCadastrado() {
		requestParams.put("admissao", funcionario.getDataAdmissao());
		requestParams.put("cargo", funcionario.getCargo());
		requestParams.put("comissao", funcionario.getComissao());
		requestParams.put("cpf", funcionario.getCpf());
		requestParams.put("departamentoId", funcionario.getEmpregadoId());
		requestParams.put("nome", funcionario.getNome());
		requestParams.put("salario","25.000,99");
		requestParams.put("sexo", funcionario.getSexo());
		requestParams.put("tipoContratacao", funcionario.getTipoContratacao());
		given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
		when().put(url+id).
		then().statusCode(202).body("salario", Matchers.is("25.000,99"));
	}
	
	@Test
	public void alterarSexoUsuarioCadastrado() {
		requestParams.put("admissao", funcionario.getDataAdmissao());
		requestParams.put("cargo", funcionario.getCargo());
		requestParams.put("comissao", funcionario.getComissao());
		requestParams.put("cpf", funcionario.getCpf());
		requestParams.put("departamentoId", funcionario.getEmpregadoId());
		requestParams.put("nome", funcionario.getNome());
		requestParams.put("salario","25.000,99");
		requestParams.put("sexo", "f");
		requestParams.put("tipoContratacao", funcionario.getTipoContratacao());
		given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
		when().put(url+id).
		then().statusCode(202).body("sexo", Matchers.is("f"));
	}
	
	@Test
	public void alterarTipoContratacaoUsuarioCadastrado() {
		requestParams.put("admissao", funcionario.getDataAdmissao());
		requestParams.put("cargo", funcionario.getCargo());
		requestParams.put("comissao", funcionario.getComissao());
		requestParams.put("cpf", funcionario.getCpf());
		requestParams.put("departamentoId", funcionario.getEmpregadoId());
		requestParams.put("nome", funcionario.getNome());
		requestParams.put("salario","25.000,99");
		requestParams.put("sexo", funcionario.getSexo());
		requestParams.put("tipoContratacao", "pj");
		given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
		when().put(url+id).
		then().statusCode(202).body("tipoContratacao", Matchers.is("pj"));
	}
}
