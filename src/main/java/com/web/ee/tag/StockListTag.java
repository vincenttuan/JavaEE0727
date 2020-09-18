package com.web.ee.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class StockListTag implements BodyTag {

    private BodyContent bodyContent;
    private PageContext pageContext;
    private Tag parentTag;

    @Override
    public void setBodyContent(BodyContent bc) {
        bodyContent = bc;
    }

    @Override
    public void doInitBody() throws JspException {

    }

    @Override
    public int doAfterBody() throws JspException {
        JspWriter out = bodyContent.getEnclosingWriter();
        String content = bodyContent.getString().trim();
        String[] symbols = content.split(",");
        try {
            for (String symbol : symbols) {
                Stock stock = YahooFinance.get(symbol.trim());
                double price = stock.getQuote().getPrice().doubleValue();
                out.print("<tr>");
                out.print("<td>");
                out.print(symbol);
                out.print("</td>");
                out.print("<td align='right'>");
                out.print(String.format("$ %.2f", price));
                out.print("</td>");
                out.print("</tr>");
            }
        } catch (Exception e) {
        }

        return Tag.SKIP_BODY;
    }

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
