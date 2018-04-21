package br.com.cadastro.enuns;

public enum TipoEndereco {

	ENTREGA(1), CADASTRO(2);
	
	public int tipoEndereco;
	
	TipoEndereco(int tipoEndereco){
		this.tipoEndereco = tipoEndereco;
	}
	
	public int getTipoEndereco(){
		return this.tipoEndereco;
	}
}
