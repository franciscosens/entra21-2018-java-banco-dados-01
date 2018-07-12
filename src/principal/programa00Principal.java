package principal;


import view.ClienteListaCadastro;
import java.awt.EventQueue;

/**
 * @author Henrique Silva
 */
public class programa00Principal {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ClienteListaCadastro();
            }
        });
    }

}
