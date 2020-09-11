package com.web.ee.async;

import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.AsyncContext;

public class LongJob implements Runnable {
    private AsyncContext ctx;

    public LongJob(AsyncContext ctx) {
        this.ctx = ctx;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(10_000); // 停 10 秒
            PrintWriter out = ctx.getResponse().getWriter();
            out.print("LongJob 任務完成, 時間:" + new Date() + "<p/>");
            out.flush();
            ctx.complete(); // 非同步的工作完成
        } catch (Exception e) {
        }
    }
    
}
