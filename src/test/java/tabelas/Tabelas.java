package tabelas;

import javax.persistence.Persistence;

public class Tabelas {
	
	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("FinanceiroPU");
		
	}

}
