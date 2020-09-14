package com.web.ee.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class StockTag implements Tag {
    private PageContext pageContext;
    private Tag parentTag;
    String symbol;
    Integer qty;
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

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            Stock stock = YahooFinance.get(symbol);
            double price = stock.getQuote().getPrice().doubleValue();
            if(qty == null) {
                out.print(symbol + " price: " + price);
            } else {
                out.print(symbol + " price: " + price + ", cost: " + (price * qty));
            }
            
        } catch (Exception e) {
        }
        
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
