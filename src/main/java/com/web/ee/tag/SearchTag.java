package com.web.ee.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

public class SearchTag implements BodyTag {
    private PageContext pageContext;
    private Tag parentTag;
    private BodyContent bodyContent;
    private String key, key2;
    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parentTag = tag;
    }
    
    @Override
    public void setBodyContent(BodyContent bc) {
        bodyContent = bc;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    @Override
    public void doInitBody() throws JspException {
        
    }

    @Override
    public int doAfterBody() throws JspException {
        String content = bodyContent.getString();
        String new_content = content.replaceAll(key, 
                String.format("<font color=red><b>%s</b></font>", key));
        if(key2 != null) {
            new_content = new_content.replaceAll(key2, 
                String.format("<font color=blue><b>%s</b></font>", key2));
        }
        JspWriter out = bodyContent.getEnclosingWriter();
        try {
            out.print(new_content);
        } catch (Exception e) {
        }
        return Tag.SKIP_BODY;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    public String getKey() {
        return key;
    }
    
    public String getKey2() {
        return key2;
    }
    
    @Override
    public int doStartTag() throws JspException {
        return BodyTag.EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        
    }
    
}
