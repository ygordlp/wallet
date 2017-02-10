package br.edu.unifor.ewallet.controllers;

import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

import br.edu.unifor.ewallet.models.Usuarios;

/**
 * Created by maycon on 2/10/17.
 */

public class UsuarioController {

    public static List<Usuarios> getAll() {
        return Usuarios.listAll(Usuarios.class);
    }

    public static Usuarios getById(Long id) {
        return Usuarios.findById(Usuarios.class, id);
    }

    public static Usuarios getByEmailSenha(String email, String senha) {
        Usuarios usuarios = Select.from(Usuarios.class).where(Condition.prop("email").eq(email), Condition.prop("senha").eq(senha)).first();
        if (usuarios != null) {
            return usuarios;
        }
        return null;
    }

    public static Long insert(Usuarios usuario) {
        return usuario.save();
    }

    public static Long update(Usuarios usuario, Long id) {
        Usuarios usuarioAtual = getById(id);
        usuarioAtual.setNome(usuario.getNome());
        usuarioAtual.setEmail(usuario.getEmail());
        usuarioAtual.setSenha(usuario.getSenha());
        return usuarioAtual.save();
    }

    public static boolean delete(Long id) {
        Usuarios usuarioAtual = getById(id);
        return usuarioAtual.delete();
    }
}
