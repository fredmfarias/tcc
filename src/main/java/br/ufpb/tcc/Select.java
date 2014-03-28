package br.ufpb.tcc;

import br.ufpb.tcc.dao.ClienteDAO;
import br.ufpb.tcc.model.Pessoa;
import br.ufpb.tcc.util.Bancos;
import br.ufpb.tcc.util.DAOFactory;
import br.ufpb.tcc.util.TccException;

public class Select {

	public static void main(String[] args){
		
		long inicio = System.currentTimeMillis();
		
		ClienteDAO cd;
		try {
			cd = DAOFactory.criarClienteDAO(Bancos.POSTGRES.ordinal());
			
			Pessoa pessoa = cd.findCliente("99455864382", "6181336235");
			System.out.println(pessoa.toString());
		} catch (TccException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long fim = System.currentTimeMillis();
		
		System.out.println(fim -inicio);
		
	}
}
