package pildoras.es.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pildoras.es.controlador.entity.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Cliente> getClientes() {

		Session miSession = sessionFactory.getCurrentSession();
		
		Query<Cliente> query = miSession.createQuery("from Cliente", Cliente.class);
		
		List<Cliente> clientes = query.getResultList();
		
		return clientes;
	}

	@Override
	@Transactional
	public void insertarCliente(Cliente elCliente) {
		
		Session miSession = sessionFactory.getCurrentSession();
		
		miSession.save(elCliente);
					
	}

	
}
