package bean;

/**
 * @author Henrique Silva
 */
public class ClienteBean {

  private int id;
  private String nome, data, cpf;
  private boolean ativo;

  public ClienteBean() {
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the nome
   */
  public String getNome() {
    return nome;
  }

  /**
   * @param nome the nome to set
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * @return the data
   */
  public String getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(String data) {
    this.data = data;
  }

  /**
   * @return the cpf
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * @param cpf the cpf to set
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * @return the ativo
   */
  public boolean isAtivo() {
    return ativo;
  }

  /**
   * @param ativo the ativo to set
   */
  public void setAtivo(boolean ativo) {
    this.ativo = ativo;
  }

}
