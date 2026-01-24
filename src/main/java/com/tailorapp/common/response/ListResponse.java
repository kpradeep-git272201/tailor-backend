package com.tailorapp.common.response;

import java.util.List;

public class ListResponse<T> {
    private List<T> items;
    private int count;

    public ListResponse(List<T> items) {
        this.items = items;
        this.count = items != null ? items.size() : 0;
    }

    public List<T> getItems() { return items; }
    public int getCount() { return count; }
}
