package br.com.crud.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Compra;
import br.com.crud.model.Contato;
import br.com.crud.model.Destino;


public class CompraDAO {
	
public void save (Compra compra) {
		
		String sql = "INSERT INTO compras(DataIda, DataVolta, ValorCompra, Id_contato, Id_destino)" + "VALUES(?,?,?,?,?)"; 	
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = conn.prepareStatement(sql);
		
		pstm.setDate(1, new Date(compra.getDataIda().getTime()));
		pstm.setDate(2, new Date(compra.getDataVolta().getTime()));
		pstm.setDouble(3, compra.getValorCompra());
		pstm.setInt(4, compra.getId_contato());
		pstm.setInt(5, compra.getId_destino());
		
		pstm.execute(); 
    	 
        } catch (Exception e) {
			
			e.printStackTrace(); 
			
		} finally {
			
		try {
			
		if(pstm != null) {
			
			pstm.close();
		}
		
		if(conn != null) {
 			conn.close();
 		}
		
		} catch(Exception e) {
			
		   e.printStackTrace();
		}	
      }
    }
      public void removeById(int id) {
	   
	  String sql = "DELETE FROM compras WHERE id = ?";
	  
	  Connection conn = null;
	  PreparedStatement pstm = null; 
	  
	  try {
    
		  conn = ConnectionFactory.createConnectionToMySQL();
		  pstm = conn.prepareStatement(sql);
		  
		  pstm.setInt(1, id);
		  
		  pstm.execute();    	  
	
	  } catch (Exception e) {
		  
		  e.printStackTrace();
	  }  finally {
		
			try {
				
			if(pstm != null) {
				
				pstm.close();
			}
			
			if(conn != null) {
     			conn.close();
     		}
			
			} catch(Exception e) {
				
			   e.printStackTrace();
			}	
	      }
	   }
      
          public void Update(Compra compra) {
   	   
     	  String sql = "UPDATE compra SET DataIda = ?, DataVolta = ?, ValorCompra = ?, Id_contato = ?, Id_destino = ?" + "WHERE id = ?";
     	  
     	  Connection conn = null;
     	  PreparedStatement pstm = null; 
     	  
     	   try {
 			
     		conn = ConnectionFactory.createConnectionToMySQL();
     		pstm = conn.prepareStatement(sql);
     		
     		pstm.setDate(1, new Date(compra.getDataIda().getTime()));
    		pstm.setDate(2, new Date(compra.getDataVolta().getTime()));
    		pstm.setDouble(3, compra.getValorCompra());
    		pstm.setInt(4, compra.getId_contato());
    		pstm.setInt(5, compra.getId_destino());
    		pstm.setInt(6, compra.getId());
    		
    		pstm.execute(); 
     			
     		} catch (Exception e) {
     			
     			e.printStackTrace(); 
     			
     		} finally {
     			
     		try {
     			
     		if(pstm != null) {
     			pstm.close();
     		}
     		
     		if(conn != null) {
     			conn.close();
     		}
     		
     		} catch(Exception e) {
     			
     		   e.printStackTrace();
     		}	
           }
         }
          
          public List<Compra> getCompras(){
       	   
        	  String sql = "select l.Id, l.DataIda, l.DataVolta, l.ValorCompra, a.Id, a.Nome, a.Email, e.Id, e.Lugar from Compras as l inner join Contatos as a on l.Id_contato = a.Id inner join Destinos as e on l.Id_destino = e.Id";
       	   
       	   List<Compra> compras = new ArrayList<Compra>();
       	   
       	       Connection conn = null;
         	   PreparedStatement pstm = null;
         	   ResultSet rset = null;
         	   
         	 try {
     			
         		conn = ConnectionFactory.createConnectionToMySQL();
         		pstm = conn.prepareStatement(sql);
         		
         		rset = pstm.executeQuery();
         		
         		while(rset.next()) {
         			
         			Compra compra = new Compra();
         			Contato contato = new Contato();
         			Destino destino = new Destino();
         			
         			compra.setId(rset.getInt("Id"));
         			compra.setDataIda(rset.getDate("DataIda"));
         			compra.setDataVolta(rset.getDate("DataVolta"));
         			compra.setValorCompra(rset.getDouble("ValorCompra"));
         			
         			contato.setId(rset.getInt("Id_contato"));
    				
    				contato.setNome(rset.getString("Nome"));
    				
    				contato.setEmail(rset.getString("Email"));
    				
    				compra.setContato(contato);
    				
    				destino.setId(rset.getInt("Id_destino"));
    				
    				destino.setLugar(rset.getString("Destino"));
    				
    				compra.setDestino(destino);
         			
         			compras.add(compra);
         			
         		}
          
          } catch (Exception e) {
       	   
       	   e.printStackTrace(); 
   			
   		} finally {
   			
   		try {
   			
   		if(pstm != null) {
   			pstm.close();
   		}
   		
   		if(conn != null) {
   			conn.close();
   		}
   			
   		} catch(Exception e) {
   			
   		   e.printStackTrace();
   		}	
         }
         	 
         	 return compras;
       }
}

		
