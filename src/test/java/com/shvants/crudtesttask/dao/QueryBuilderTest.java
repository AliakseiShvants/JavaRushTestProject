package com.shvants.crudtesttask.dao;

import com.shvants.crudtesttask.model.UserSearchCriteria;
import org.junit.Test;

public class QueryBuilderTest {

    @Test
    public void testQueryBuilder(){
        UserSearchCriteria userSearchCriteria = new UserSearchCriteria();
        userSearchCriteria.setName("name");

        QueryBuilder queryBuilder = new QueryBuilder("select count(u) from UserDAO u ", userSearchCriteria);

        queryBuilder.getQueryString();
        queryBuilder.getQueryParameters();
    }
}
