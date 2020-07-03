package org.luatos.toolkit.bean;

import java.util.LinkedList;
import java.util.List;

public class LuDocument {

    private String path;

    private LuDocHeader title;

    private List<FnSign> functions;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LuDocHeader getTitle() {
        return title;
    }

    public void setTitle(LuDocHeader title) {
        this.title = title;
    }

    public List<FnSign> getFunctions() {
        return functions;
    }

    public void setFunctions(List<FnSign> functions) {
        this.functions = functions;
    }

    public void addFunctions(FnSign func) {
        if (null == this.functions) {
            this.functions = new LinkedList<>();
        }
        this.functions.add(func);
    }

}