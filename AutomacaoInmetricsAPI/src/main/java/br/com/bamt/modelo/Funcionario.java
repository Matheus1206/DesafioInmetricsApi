package br.com.bamt.modelo;

public class Funcionario {
	
	private Integer empregadoId;
	private String nome;
	private String sexo;
	private String cpf;
	private String cargo;
	private String dataAdmissao;
	private String salario;
	private String comissao;
	private String tipoContratacao;
	public Integer getEmpregadoId() {
		return empregadoId;
	}
	public void setEmpregadoId(Integer empregadoId) {
		this.empregadoId = empregadoId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getComissao() {
		return comissao;
	}
	public void setComissao(String comissao) {
		this.comissao = comissao;
	}
	public String getTipoContratacao() {
		return tipoContratacao;
	}
	public void setTipoContratacao(String tipoContratacao) {
		this.tipoContratacao = tipoContratacao;
	}
	
	@Override
	public String toString() {
		return "Funcionario: " + empregadoId + " "+ nome + " " + sexo + " " + cpf + " " +
				cargo + "  "+ dataAdmissao + " " + salario + " " + comissao + " "+ tipoContratacao;
	}
}
