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
public class UsuarioInvalidoException extends Exception {

    private static final long serialVersionUID = 1L;

    public UsuarioInvalidoException(String message) {
        super(message);
    }
}
