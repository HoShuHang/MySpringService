package com.selab.model;

import org.springframework.web.client.RestTemplate;

import java.util.Timer;
import java.util.TimerTask;

public class Model {
    private static final int DELAY_IN_SEC = 0;
    private static final int PERIOD_IN_SEC = 60;
    private static final int MILLISECOND = 1000;

    public void execute() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Model.this.getData();
            }
        }, DELAY_IN_SEC, PERIOD_IN_SEC * MILLISECOND);
    }

    public void getData() {
//	    final String URI = "https://beta-ssp.tenmax.io/supply/mobile/native/rmax-ad?rmaxSpaceId=55ba76bca772421f&dpid=bd4b9b7903cf40ce&v=1";
    }
}
