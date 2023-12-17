package com.heastie.swgoh.automation.bean;

public class Shard {
    private Integer tab;
    private String node;
    private Integer refreshes = 0;

    public Shard() {}

    public Shard(final Integer tab, final String node,
        final Integer refreshes) {
        this.tab = tab;
        this.node = node;
        this.refreshes = refreshes;
    }

    public Integer getTab() {
        return tab;
    }

    public void setTab(Integer tab) {
        this.tab = tab;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Integer getRefreshes() {
        return refreshes;
    }

    public void setRefreshes(Integer refreshes) {
        this.refreshes = refreshes;
    }
}
