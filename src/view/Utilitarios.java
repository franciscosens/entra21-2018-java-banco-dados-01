package view;

/**
 * @author Alunos
 */
public class Utilitarios {
  
  public static String obterPadraoAmericano(String dataBR) {
    dataBR = dataBR.replace("/", "");
    return dataBR.substring(4, dataBR.length()) + "-"
            + dataBR.substring(2, 4) + "-"
            + dataBR.substring(0, 2);
  }

  public static String obterPadraoBr(String dataUS) {
    String[] posicoes = dataUS.split("-");
    return posicoes[2] + posicoes[1] + posicoes[0];
  }

}
