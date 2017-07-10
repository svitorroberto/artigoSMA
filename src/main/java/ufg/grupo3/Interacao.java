package ufg.grupo3;

public class Interacao {
	
	private String mensagem;
	private Boolean ok;
	
	public Interacao(String mensagem) {
		this.mensagem = mensagem;
	}
	public Interacao(Boolean ok) {
		this.ok = ok;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Boolean getOk() {
		return ok;
	}
	public void setOk(Boolean ok) {
		this.ok = ok;
	}
	

}
