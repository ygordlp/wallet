package br.edu.unifor.ewallet.controllers;

import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

import br.edu.unifor.ewallet.models.Categoria;
import br.edu.unifor.ewallet.models.Conta;
import br.edu.unifor.ewallet.models.TipoConta;

/**
 * Created by Naldo on 2/11/2017.
 */

public class CategoriaController {
    public static List<Categoria> getAll() {
        return Conta.listAll(Categoria.class);
    }

    public static Categoria getById(Long id) {
        return Categoria.findById(Categoria.class, id);
    }

    public static Categoria getByDescricao(String descricao) {
        Categoria categoria = Select.from(Categoria.class).where(Condition.prop("descricao").eq(descricao)).first();
        if (categoria != null) {
            return categoria;
        }
        return null;
    }

    public static Long insert(Categoria categoria) {
        return categoria.save();
    }

    public static Long update(Categoria categoria, Long id) {
        Categoria categoriaAtual = getById(id);
        categoriaAtual.setDescricao(categoria.getDescricao());
        categoriaAtual.setIcone(categoria.getIcone());
        return categoriaAtual.save();
    }

    public static boolean delete(Long id) {
        Categoria categoriaAtual = getById(id);
        return categoriaAtual.delete();
    }
}
