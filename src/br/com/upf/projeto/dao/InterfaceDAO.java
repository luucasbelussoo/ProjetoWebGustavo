package br.com.upf.projeto.dao;

import java.util.List;

public interface InterfaceDAO<T> {

	/**
	 * Método para inserir uma instância no banco de dados.
	 * @param instancia Instância a ser inserida no banco de dados.
	 * @throws Exception Possível exceção gerada ao realizar a operação.
	 */ 
	public void persist(T instancia) throws Exception;

	/**
	 * Método para sincronizar uma instância no banco de dados.
	 * @param instancia Instância a ser sincronizada no banco de dados.
	 * @throws Exception Possível exceção gerada ao realizar a operação.
	 * @return Instância sincronizada com o banco de dados.
	 */ 
	public T merge(T instancia) throws Exception;
	

	/**
	 * Método para excluir uma instância do banco de dados.
	 * @param instancia Instância a ser excluída do banco de dados.
	 * @throws Exception Possível exceção gerada ao realizar a operação.
	 */ 
	public void remove(T instancia) throws Exception;
	
	/**
	 * Método para excluir uma instância do banco de dados a partir de seu id.
	 * @param id Identificador da instância a ser excluída do banco de dados.
	 * @throws Exception Possível exceção gerada ao realizar a operação.
	 */ 
	public void remove(Integer id) throws Exception;
	
	/**
	 * Método para obter uma instância pelo código informado.
	 * @param id Código da instância a ser recuperada do banco de dados.
	 * @return Instância respectiva ou null caso o código não for 
	 * encontrado.
	 * @throws Exception Possível exceção gerada ao realizar a operação.
	 */
	public T getInstancia(Integer id) throws Exception;
	
	/**
	 * Método para obter uma lista de todas as instâncias contidas no 
	 * banco de dados.
	 * @return coleção com as instâncias encontradas. 
	 * Caso nenhuma instância for encontrada a coleção deverá ser vazia, mas inicializada.
	 * @throws Exception Possível exceção gerada ao realizar a operação.
	 */
	public List<T> getInstanciasList();

	/**
	 * Método para obter uma lista de todas as instâncias contidas no 
	 * banco de dados ordenadas pelo atributo informado no parâmetro atributoOrdem.
	 * @param atributoOrdem Nome do atributo para a ordenação. Pode ser mais de um, separado por vírgula.
	 * @return Coleção com as instâncias ordenadas. 
	 * Caso nenhuma instância for encontrada a coleção deverá ser vazia, mas inicializada.
	 */
	public List<T> getInstanciasList(String atributoOrdem);

	/**
	 * Método para obter uma lista de todas as instâncias contidas no 
	 * banco de dados ordenadas pelo atributo informado no parâmetro atributoOrdem  
	 * e filtrando os objetos que contém no atributoFiltro o conteúdo informado no valorFiltro.
	 * @param atributoOrdem Nome do atributo para a ordenação. Pode ser mais de um, separado por vírgula.
	 * @param atributoFiltro Atributo sobre o qual deve ser aplicado o filtro.
	 * @param valorFiltro Valor para o filtro. 
	 * @return Coleção com as instâncias ordenadas e filradas. 
	 * Caso nenhuma instância for encontrada a coleção deverá ser vazia, mas inicializada.
	 */    
	public List<T> getInstanciasList(String atributoOrdem, String atributoFiltro, String valorFiltro);
	
	/**
	 * Método para obter uma lista de todas as instâncias contidas no 
	 * banco de dados ordenadas pelo atributo informado no parâmetro atributoOrdem  
	 * e filtrando os objetos que contém no atributoFiltro o conteúdo informado no valorFiltro.
	 * Irá retornar os objetos com paginação.
	 * @param atributoOrdem Nome do atributo para a ordenação. Pode ser mais de um, separado por vírgula.
	 * @param atributoFiltro Atributo sobre o qual deve ser aplicado o filtro.
	 * @param valorFiltro Valor para o filtro. 
	 * @param numObjetos Quantidade de objetos para retornar da consulta.
	 * @param posInicial Posição inicial para o retorno dos objetos.
	 * @return Coleção com as instâncias ordenadas e filradas. 
	 * Caso nenhuma instância for encontrada a coleção deverá ser vazia, mas inicializada.
	 */    
	public List<T> getInstanciasList(String atributoOrdem, String atributoFiltro, String valorFiltro, Integer numObjetos, Integer posInicial );
	

}