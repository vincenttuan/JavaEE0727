package com.web.ee.async;

import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.AsyncContext;

public class LongJob implements Runnable {
    private AsyncContext ctx = null;
    public LongJob(AsyncContext ctx){
        this.ctx = ctx;
    }
    public void run(){
        try {
            // 等待10秒鐘，用來模擬任務所需要的時間
            for(int i=1;i<=10;i++) {
                Thread.sleep(1000);
                PrintWriter out = ctx.getResponse().getWriter();
                out.println(i + ".任務處理完畢的時間：" + new Date() + ".<p>");
                out.flush();
            }
            ctx.complete(); // 任務完成
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
