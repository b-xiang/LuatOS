package org.luatos.toolkit.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.luatos.toolkit.Luats;
import org.nutz.lang.Strings;

public class FnSign {

    /**
     * 原始的输入
     */
    private String rawText;

    private String summary;

    private FnModifier modifier;

    private String name;

    private List<FnReturn> returns;

    private List<FnParam> params;

    private List<FnExample> examples;

    public String toString() {
        String str = "";
        if (!Strings.isBlank(rawText)) {
            str += rawText + "\n-----------------------------\n";
        }
        if (null != summary) {
            str += "/*\n" + summary + "\n*/\n";
        }
        if (null != modifier) {
            str += this.modifier.toString().toLowerCase() + " ";
        }

        String pmStr = "";
        if (null != params) {
            List<String> pms = new ArrayList<>(params.size());
            for (FnParam pm : params) {
                pms.add(pm.toString());
            }
            pmStr = Strings.join(", ", pms);
        }

        String res = "";
        if (null != returns) {
            List<String> reList = new ArrayList<>(this.returns.size());
            for (FnReturn re : returns) {
                reList.add(re.getType());
            }
            res = Strings.join(",", reList);
        }

        str += String.format("%s %s(%s)", res, name, pmStr);

        return str;
    }

    public boolean equals(Object o) {
        if (o instanceof FnSign) {
            FnSign fn = (FnSign) o;
            return isSame(fn, true);
        }
        return false;
    }

    public boolean isSame(FnSign fn, boolean ignoreRawText) {
        if (!ignoreRawText) {
            if (!Luats.isSame(this.rawText, fn.rawText)) {
                return false;
            }
        }
        if (!Luats.isSame(this.modifier, fn.modifier))
            return false;

        if (!Luats.isSame(this.name, fn.name))
            return false;

        if (!Luats.isSameList(this.returns, fn.returns))
            return false;

        if (!Luats.isSameList(this.params, fn.params))
            return false;

        if (!Luats.isSameList(this.examples, fn.examples))
            return false;

        return true;
    }

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String comment) {
        this.summary = comment;
    }

    public boolean isLocal() {
        return FnModifier.LOCAL == this.modifier;
    }

    public boolean isStatic() {
        return FnModifier.STATIC == this.modifier;
    }

    public FnModifier getModifier() {
        return modifier;
    }

    public void setModifier(FnModifier modifier) {
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FnReturn> getReturns() {
        return returns;
    }

    public void setReturns(List<FnReturn> returns) {
        this.returns = returns;
    }

    public void addReturn(FnReturn fr) {
        if (null == this.returns) {
            this.returns = new LinkedList<>();
        }
        this.returns.add(fr);
    }

    public List<FnParam> getParams() {
        return params;
    }

    public void setParams(List<FnParam> params) {
        this.params = params;
    }

    public void addParam(FnParam param) {
        if (null == this.params) {
            this.params = new LinkedList<>();
        }
        this.params.add(param);
    }

    public List<FnExample> getExamples() {
        return examples;
    }

    public void setExamples(List<FnExample> examples) {
        this.examples = examples;
    }

    public void addExample(FnExample example) {
        if (null == this.examples) {
            this.examples = new LinkedList<>();
        }
        this.examples.add(example);
    }

}