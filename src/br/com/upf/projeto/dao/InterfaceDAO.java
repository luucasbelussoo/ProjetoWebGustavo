package br.com.upf.projeto.dao;

import java.util.List;

public interface InterfaceDAO<T> {

	/**
	 * M�todo para inserir uma inst�ncia no banco de dados.
	 * @param instancia Inst�ncia a ser inserida no banco de dados.
	 * @throws Exception Poss�vel exce��o gerada ao realizar a opera��o.
	 */ 
	public void persist(T instancia) throws Exception;

	/**
	 * M�todo para sincronizar uma inst�ncia no banco de dados.
	 * @param instancia Inst�ncia a ser sincronizada no banco de dados.
	 * @throws Exception Poss�vel exce��o gerada ao realizar a opera��o.
	 * @return Inst�ncia sincronizada com o banco de dados.
	 */ 
	public T merge(T instancia) throws Exception;
	

	/**
	 * M�todo para excluir uma inst�ncia do banco de dados.
	 * @param instancia Inst�ncia a ser exclu�da do banco de dados.
	 * @throws Exception Poss�vel exce��o gerada ao realizar a opera��o.
	 */ 
	public void remove(T instancia) throws Exception;
	
	/**
	 * M�todo para excluir uma inst�ncia do banco de dados a partir de seu id.
	 * @param id Identificador da inst�ncia a ser exclu�da do banco de dados.
	 * @throws Exception Poss�vel exce��o gerada ao realizar a opera��o.
	 */ 
	public void remove(Integer id) throws Exception;
	
	/**
	 * M�todo para obter uma inst�ncia pelo c�digo informado.
	 * @param id C�digo da inst�ncia a ser recuperada do banco de dados.
	 * @return Inst�ncia respectiva ou null caso o c�digo n�o for 
	 * encontrado.
	 * @throws Exception Poss�vel exce��o gerada ao realizar a opera��o.
	 */
	public T getInstancia(Integer id) throws Exception;
	
	/**
	 * M�todo para obter uma lista de todas as inst�ncias contidas no 
	 * banco de dados.
	 * @return cole��o com as inst�ncias encontradas. 
	 * Caso nenhuma inst�ncia for encontrada a cole��o dever� ser vazia, mas inicializada.
	 * @throws Exception Poss�vel exce��o gerada ao realizar a opera��o.
	 */
	public List<T> getInstanciasList();

	/**
	 * M�todo para obter uma lista de todas as inst�ncias contidas no 
	 * banco de dados ordenadas pelo atributo informado no par�metro atributoOrdem.
	 * @param atributoOrdem Nome do atributo para a ordena��o. Pode ser mais de um, separado por v�rgula.
	 * @return Cole��o com as inst�ncias ordenadas. 
	 * Caso nenhuma inst�ncia for encontrada a cole��o dever� ser vazia, mas inicializada.
	 */
	public List<T> getInstanciasList(String atributoOrdem);

	/**
	 * M�todo para obter uma lista de todas as inst�ncias contidas no 
	 * banco de dados ordenadas pelo atributo informado no par�metro atributoOrdem  
	 * e filtrando os objetos que cont�m no atributoFiltro o conte�do informado no valorFiltro.
	 * @param atributoOrdem Nome do atributo para a ordena��o. Pode ser mais de um, separado por v�rgula.
	 * @param atributoFiltro Atributo sobre o qual deve ser aplicado o filtro.
	 * @param valorFiltro Valor para o filtro. 
	 * @return Cole��o com as inst�ncias ordenadas e filradas. 
	 * Caso nenhuma inst�ncia for encontrada a cole��o dever� ser vazia, mas inicializada.
	 */    
	public List<T> getInstanciasList(String atributoOrdem, String atributoFiltro, String valorFiltro);
	
	/**
	 * M�todo para obter uma lista de todas as inst�ncias contidas no 
	 * banco de dados ordenadas pelo atributo informado no par�metro atributoOrdem  
	 * e filtrando os objetos que cont�m no atributoFiltro o conte�do informado no valorFiltro.
	 * Ir� retornar os objetos com pagina��o.
	 * @param atributoOrdem Nome do atributo para a ordena��o. Pode ser mais de um, separado por v�rgula.
	 * @param atributoFiltro Atributo sobre o qual deve ser aplicado o filtro.
	 * @param valorFiltro Valor para o filtro. 
	 * @param numObjetos Quantidade de objetos para retornar da consulta.
	 * @param posInicial Posi��o inicial para o retorno dos objetos.
	 * @return Cole��o com as inst�ncias ordenadas e filradas. 
	 * Caso nenhuma inst�ncia for encontrada a cole��o dever� ser vazia, mas inicializada.
	 */    
	public List<T> getInstanciasList(String atributoOrdem, String atributoFiltro, String valorFiltro, Integer numObjetos, Integer posInicial );
	

}