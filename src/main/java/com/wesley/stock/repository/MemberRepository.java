package com.wesley.stock.repository;

import com.wesley.stock.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public long count() {
        return em.createQuery("select count(*) from Member m", Long.class)
                .getSingleResult();
    };

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> selectMemberByPaging(Map parameterMap) {
        int pageLimit = (int) parameterMap.get("pageLimit");
        int startIdx = ((int) parameterMap.get("currentPage") - 1) * pageLimit;

        return em.createQuery("select m from Member m", Member.class)
                .setFirstResult(startIdx)
                .setMaxResults(pageLimit)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
