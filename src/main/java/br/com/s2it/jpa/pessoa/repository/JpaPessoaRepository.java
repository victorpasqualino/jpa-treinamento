package br.com.s2it.jpa.pessoa.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.s2it.jpa.entity.Cliente;
import br.com.s2it.jpa.entity.Pessoa;
import br.com.s2it.jpa.repository.AbstractJpaRepository;

public class JpaPessoaRepository extends AbstractJpaRepository<Long, Pessoa> implements PessoaRepository {
	
	public JpaPessoaRepository(EntityManager entityManager) {
		super(entityManager, Pessoa.class);
	}
	
	@Override
	public Pessoa findByCodigo(String codigo) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
		Root<Cliente> cliente = cq.from(Cliente.class);
		Fetch<Cliente, Pessoa> fetch = cliente.fetch("pessoa", JoinType.INNER);
		cq.select(cliente);
		cq.where(
				cb.and()
		);
		return getEntityManager().createQuery(cq).getSingleResult();
		
//		Query query = getEntityManager().createQuery("select o from Cliente o inner join fetch o.pessoa p where o.codigo = :codigo");
		Query query = getEntityManager().createNamedQuery("selectPessoasByCodigo");
		query.setParameter("codigo", codigo);
		//O getSingleResult() pode lançar duas exceções comuns NoResultException e o NonUniqueResultException
		return (Pessoa) query.getSingleResult();
	}
	
}
