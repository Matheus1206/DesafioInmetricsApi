package br.com.bamt.rest;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.bamt.modelo.Funcionario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TestPesquisaFuncionario {
	
	private String url = "https://inm-api-test.herokuapp.com/empregado/list/";
	Funcionario funcionario = new Funcionario();
	JSONObject requestParams = new JSONObject();
	private int id;
	
	
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
	public void setup() {
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
	public void pesquisarFuncionarioCadastrado() {
		given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
		when().get(url+id).
		then().statusCode(202).body("cpf", Matchers.is(funcionario.getCpf()));
		
	}
	
	@Test
	public void pesquisarFuncionarioInexistente() {
		given().contentType(ContentType.JSON).auth().basic("inmetrics", "automacao").body(requestParams.toJSONString()).
		when().get(url+555).
		then().statusCode(400).body(Matchers.is("Empregado não cadastrado"));
		
	}
	

}
