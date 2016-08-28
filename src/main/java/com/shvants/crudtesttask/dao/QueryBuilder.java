package com.shvants.crudtesttask.dao;


import com.shvants.crudtesttask.model.UserSearchCriteria;

import java.util.HashMap;
import java.util.Map;

public class QueryBuilder {

    private String queryString = "";

    public String getQueryString() {
        return queryString;
    }

    private Map<String, Object> queryParameters = new HashMap<String, Object>();

    public Map<String, Object> getQueryParameters() {
        return queryParameters;
    }

    public QueryBuilder(String queryStringBegin, UserSearchCriteria userCriteria) {
        this.queryString = queryStringBegin;
        formQueryString(userCriteria);

    }

    private void formQueryString(UserSearchCriteria userCriteria) {

        String queryWhere = "";

        if (userCriteria.getName() != null && !userCriteria.getName().equals("")) {
            queryWhere = queryWhere.concat("u.name like :name ");
            getQueryParameters().put("name", "%".concat(userCriteria.getName()).concat("%"));
        }

        if (userCriteria.getAge() != 0){
            if (!queryWhere.equals(""))
                queryWhere = queryWhere.concat("and ");
            queryWhere = queryWhere.concat("u.age = :age ");
            getQueryParameters().put("age", userCriteria.getAge());
        }

        if (userCriteria.getAdmin() != null){
            if (!queryWhere.equals(""))
                queryWhere = queryWhere.concat("and ");
            queryWhere = queryWhere.concat("u.isAdmin = :admin");
            getQueryParameters().put("admin", userCriteria.getAdmin());
        }

        if (!queryWhere.equals("")){
            queryString = queryString.concat("where ").concat(queryWhere);
        }
    }
}
