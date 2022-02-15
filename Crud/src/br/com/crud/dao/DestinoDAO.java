package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Destino;

public class DestinoDAO {
	
	public void save (Destino destino) {
		
		String sql = "INSERT INTO destinos(lugar)" + "VALUES(?)"; 	
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destino.getLugar());
			
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
   	   
    	  String sql = "DELETE FROM destinos WHERE id = ?";
    	  
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
    	  
	  public void Update(Destino destino) {
   	   
     	  String sql = "UPDATE destinos SET lugar = ?" + "WHERE id = ?";
     	  
     	  Connection conn = null;
     	  PreparedStatement pstm = null; 
     	  
     	 try {
 			
     		conn = ConnectionFactory.createConnectionToMySQL();
     		pstm = conn.prepareStatement(sql);
     		
     		pstm.setString(1, destino.getLugar());
     		pstm.setInt(2, destino.getId());
     		
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
       
	  public List<Destino> getDestinos(){
   	   
   	   String sql = "SELECT * FROM destinos";
   	   
   	   List<Destino> destinos = new ArrayList<Destino>();
   	   
   	       Connection conn = null;
     	   PreparedStatement pstm = null;
     	   ResultSet rset = null;
     	   
     	 try {
 			
     		conn = ConnectionFactory.createConnectionToMySQL();
     		pstm = conn.prepareStatement(sql);
     		
     		rset = pstm.executeQuery();
     		
     		while(rset.next()) {
     			
     			Destino destino = new Destino();
     			
     			destino.setId(rset.getInt("id"));
     			destino.setLugar(rset.getString("lugar"));
     			
     			destinos.add(destino);
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
     	 
     	 return destinos;
   }  
	
	}
	
	
	
	
	

		


