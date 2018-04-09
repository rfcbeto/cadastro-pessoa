package br.com.cadastro.model;

public class Customer {

	private String name;
	private int age;
	private Pessoa pessoa;

	public Customer(Pessoa pessoa){
		this.setPessoa(pessoa);
	}
	
	public Customer(String name, int age){
		this.setName(name);
		this.setAge(age);
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
