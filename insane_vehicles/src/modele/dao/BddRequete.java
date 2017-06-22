package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class BddRequete {
	
	public void user (String nom){

		try {

	    Statement state = BoulderDashBDDConnector.getInstance().createStatement();


	    ResultSet result = state.executeQuery("SELECT * FROM players");
	    
	    //On r�cup�re les MetaData
	    ResultSetMetaData resultMeta = result.getMetaData();
	    
	    int ID = 0;
	    String nomBDD = " ";
	    int nbrcolumn = 0;
	    
	    
	    result.last();
	    nbrcolumn = result.getRow();
	
	    // next() r�cupere la ligne
	    result.beforeFirst();
		    do{
		    	result.next();
		    	ID = result.getInt(1);
		    	nomBDD =result.getString(2);
		    }while(!(nom.equals(nomBDD)) && (ID != nbrcolumn));

		   //String sql = "{call insert_player("+nom+")}";
		    
			if(!nom.equals(nomBDD)){
				System.out.println("ERROR");
				Statement state2 = BoulderDashBDDConnector.getInstance().createStatement();

			    state2.executeUpdate("INSERT INTO players (player_name) VALUES ('"+nom+"') ");
				
			}
			else{
				System.out.println("Trouv�");
			}
	       
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
	}
	
	public void selectTable(String level){
		char[][]chars = new char[20][35];
		try{
				
				Statement st; // L'objet Statement permet d'ex�cuter des instructions SQL (Il interroge la base de donn�e et retourne les r�sultats)
				ResultSet rst; // L'objet ResultSet stocke les r�sultats de Statement (soit les donn�es de la BDD)
				
				st = BoulderDashBDDConnector.getInstance().createStatement();
				rst = st.executeQuery("SELECT (map_code) From maps WHERE map_name = '"+level+"'"); // Execution 
				String texte;
				char finale = ' ';
				int i = 0;
				int j = 0;
				int s = 0;
					rst.next();
					texte=(rst.getString("map_code"));
				
					while(finale != '|'){
						
						while(finale != ';' && finale != '|'){
							finale = texte.charAt(s); //
							s++;
							if(finale != ';' && finale != '|'){
								//chars[j]=finale;
								chars[i][j]=finale;
								//System.out.print(chars[j]);
								System.out.print(chars[i][j]);
								j++;
							}
						}
						
						System.out.println(" ");
						
						if(finale == ';'){
							j=0;
							i++;
							finale = texte.charAt(s);
							s++;
							chars[i][j]=finale;
							System.out.print(chars[i][j]);
							
						}
					}
				
			}catch (Exception ex){
				ex.printStackTrace();
			}
		
	}
}