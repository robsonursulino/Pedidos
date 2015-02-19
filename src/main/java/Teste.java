import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Endereco;
import com.algaworks.pedidovenda.model.TipoPessoa;


public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager m = factory.createEntityManager();

		EntityTransaction trx = m.getTransaction();

		trx.begin();

		Cliente cliente = new Cliente();
		cliente.setNome("João das couves");
		cliente.setEmail("joao@couver.com");
		cliente.setDocumentoReceitaFederal("123.123.123-12");
		cliente.setTipo(TipoPessoa.FISICA);

		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua da couve");
		endereco.setNumero("12");
		endereco.setCidade("Santo Andre");
		endereco.setUf("SP");
		endereco.setCep("03315-000");
		endereco.setCliente(cliente);

		cliente.getEnderecos().add(endereco);

		m.persist(cliente);

		trx.commit();
	}
}
