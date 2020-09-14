package com.web.ee.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloUserTag implements Tag {
    private PageContext pageContext;
    private Tag parentTag;
    private String name;
    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parentTag = tag;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    @Override
    public int doStartTag() throws JspException {
        
        return Tag.SKIP_BODY;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("Hello " + name);
        } catch (Exception e) {
        }
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        
    }
    
}
