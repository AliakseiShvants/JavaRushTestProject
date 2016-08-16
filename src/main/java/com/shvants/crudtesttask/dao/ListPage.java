package com.shvants.crudtesttask.dao;

import java.util.List;

public class ListPage {
    private int page;

    private List<UserDAO> data;

    private int total;

    private int maxPerPage;

    public ListPage(List<UserDAO> data, int page, int total, int maxPerPage) {
        this.data = data;
        this.page = page;
        this.total = total;
        this.maxPerPage = maxPerPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<UserDAO> getData() {
        return data;
    }

    public void setData(List<UserDAO> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getMaxPerPage() {
        return maxPerPage;
    }

    public void setMaxPerPage(int maxPerPage) {
        this.maxPerPage = maxPerPage;
    }
}
