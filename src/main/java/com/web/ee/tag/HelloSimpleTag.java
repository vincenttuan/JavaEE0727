package com.web.ee.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloSimpleTag extends SimpleTagSupport{
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = this.getJspContext().getOut();
        out.print("我是一個很簡單的 Tag, msg: " + msg);
    }
    
}
