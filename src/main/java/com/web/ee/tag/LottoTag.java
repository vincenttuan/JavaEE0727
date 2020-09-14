package com.web.ee.tag;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class LottoTag implements Tag {
    private PageContext pageContext;
    private Tag parentTag;
    private Integer amount;
    
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

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public int doStartTag() throws JspException {
        
        return Tag.EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        Set<Integer> lotto = new LinkedHashSet<>();
        while(lotto.size() < amount) lotto.add(new Random().nextInt(49) + 1);
        
        JspWriter out = pageContext.getOut();
        try {
            out.print(lotto);
        } catch (Exception e) {
        }
        
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        
    }
    
}
