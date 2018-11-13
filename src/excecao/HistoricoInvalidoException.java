/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecao;

/**
 *
 * @author hiarl
 */
public class HistoricoInvalidoException  extends Exception{

    private static final long serialVersionUID = 1L;

    public HistoricoInvalidoException(String message) {
        super(message);
    }
}
