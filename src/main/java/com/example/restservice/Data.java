package com.example.restservice;


import lombok.Builder;

import java.util.List;

@Builder
public class Data {

    private List<Result> results;
    private Info info;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString(){
        return "[results="+results+",info="+info+"]";
    }

}
