import java.util.Date;

import br.com.crud.dao.CompraDAO;
import br.com.crud.dao.ContatoDAO;
import br.com.crud.dao.DestinoDAO;
import br.com.crud.model.Compra;
import br.com.crud.model.Contato;
import br.com.crud.model.Destino;

public class Teste {

	public static void main(String[] args) {
		
		ContatoDAO contatoDAO = new ContatoDAO();
		
		Contato contato = new Contato();
		
		contato.setNome("Carlos");
		contato.setEmail("betica@gmail.com");
		contato.setMensagem("oiii");
		
		contatoDAO.save(contato);
		
	    Contato contato1 = new Contato();
		contato1.setId(1);
		contato1.setNome("NOVO NOME");
		contato1.setEmail("NOVO EMAIL");
		contato1.setMensagem("NOVA MENSAGEM");
		
		contatoDAO.Update(contato1);
		contatoDAO.removeById(1);
	
		for(Contato c : contatoDAO.getContatos())
			
		System.out.println("NOME: " + c.getNome());

	    DestinoDAO destinoDAO = new DestinoDAO();
	    Destino destino = new Destino();
	
	    destino.setLugar("Manaus");

	    destinoDAO.save(destino);
	
	    for(Destino d : destinoDAO.getDestinos())
		
		System.out.println("LUGAR: " + d.getLugar());
	    
	    
	    CompraDAO compraDAO = new CompraDAO();
	    Compra compra = new Compra();
	    
	    compra.setDataIda(new Date());
	    compra.setDataVolta(new Date());
	    compra.setValorCompra(100);
	    compra.setId_contato(2);
	    compra.setId_destino(10);
	    
	    compraDAO.save(compra);
	    
	    for(Compra p : compraDAO.getCompras())
			
			System.out.println("Total da Compra: " + p.getValorCompra());
		    
	}
}
