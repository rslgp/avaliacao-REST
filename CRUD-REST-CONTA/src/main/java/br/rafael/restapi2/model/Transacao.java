package br.rafael.restapi2.model;

import java.util.Date;

public class Transacao {
	private Long id;
	private Conta conta;
	private TipoOperacao tipo_operacao;
	private Long valor;
	private Date data;
}
