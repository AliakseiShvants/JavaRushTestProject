package com.shvants.crudtesttask.dao;

import com.shvants.crudtesttask.model.UserSearchCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAOServiceImpl implements UserDAOService{

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addUser(UserDAO userDAO) {
        em.persist(userDAO);
    }

    @Transactional
    public void updateUser(UserDAO userDAO) {
        em.merge(userDAO);
    }

    @Transactional
    public void removeUser(int id) {
       em.remove(findUser(id));
    }

    public List<UserDAO> getAllUsers() {
        return em.createQuery("from UserDAO", UserDAO.class).getResultList();
    }


    public UserDAO findUser(int id) {
        return em.find(UserDAO.class, id);
    }

    public List<UserDAO> searchUsers(UserSearchCriteria userCriteria) {

        String queryStringBegin = "select u from UserDAO u ";
        QueryBuilder response = new QueryBuilder(queryStringBegin);
        String queryString = response.getQueryString(userCriteria);


        TypedQuery<UserDAO> query = em.createQuery(queryString, UserDAO.class);
        if (userCriteria.getCurrentPage() != null && userCriteria.getPageSize() != null) {
            query.setFirstResult(10 * (userCriteria.getCurrentPage() - 1));
            query.setMaxResults(userCriteria.getPageSize());
        }

        for (Map.Entry<String, Object> entry : response.queryParameters.entrySet()){
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.getResultList();
    }

    public Integer countUsers(UserSearchCriteria userCriteria) {

        String queryStringBegin = "select count(u) from UserDAO u ";
        QueryBuilder response = new QueryBuilder(queryStringBegin);
        String queryString = response.getQueryString(userCriteria);

        TypedQuery<Long> query = em.createQuery(queryString, Long.class);

        return query.getSingleResult().intValue();
    }

    public class QueryBuilder{

        private String queryString = "";
        Map<String, Object> queryParameters = new HashMap<String, Object>();

        public QueryBuilder(String queryStringBegin) {
            this.queryString = queryStringBegin;
        }

        public String getQueryString(UserSearchCriteria userCriteria) {

            String queryWhere = "";

            if (userCriteria.getName() != null && !userCriteria.getName().equals("")) {
                queryWhere = queryWhere.concat("u.name like :name ");
                queryParameters.put("name", "%".concat(userCriteria.getName()).concat("%"));
            }

            if (userCriteria.getAge() != 0){
                if (!queryWhere.equals(""))
                    queryWhere = queryWhere.concat("and ");
                queryWhere = queryWhere.concat("u.age = :age ");
                queryParameters.put("age", userCriteria.getAge());
            }

            if (userCriteria.getAdmin() != null){
                if (!queryWhere.equals(""))
                    queryWhere = queryWhere.concat("and ");
                queryWhere = queryWhere.concat("u.isAdmin = :admin");
                queryParameters.put("admin", userCriteria.getAdmin());
            }

            if (!queryWhere.equals("")){
                queryString = queryString.concat("where ").concat(queryWhere);
            }

            return queryString;
        }
    }
}
