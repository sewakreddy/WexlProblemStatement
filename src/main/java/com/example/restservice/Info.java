package com.example.restservice;

public class Info {

    private String seed;
    private int results;
    private int page;
    private float version;
    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    @Override
    public String toString(){
        return "[seed="+seed+",results="+results+",page="+page+",version"+version+"]";
    }
}
