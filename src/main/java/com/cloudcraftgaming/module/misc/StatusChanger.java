package com.cloudcraftgaming.module.misc;

import com.cloudcraftgaming.Main;
import sx.blah.discord.handle.obj.Status;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 * Created by Nova Fox on 3/5/2017.
 * Website: www.cloudcraftgaming.com
 * For Project: DisCal
 */
public class StatusChanger extends TimerTask {
    private final ArrayList<String> statuses = new ArrayList<>();
    private Integer index;

    StatusChanger() {
        statuses.add("DisCal | Discord Calendar");
        statuses.add("Use !discal for help");
        statuses.add("Created by NovaFox161");
        statuses.add("Official calendar bot!");
        statuses.add("Used on %count% servers!");
        statuses.add("Version " + Main.version);
        index = 0;
    }

    @Override
    public void run() {
        String statusOr = statuses.get(index);
        String status = statusOr;
        if (statusOr.contains("%count%")) {
            status = statusOr.replaceAll("%count%", String.valueOf(Main.client.getGuilds().size()));
        }
        Main.client.changeStatus(Status.game(status));

        //Set new index.
        if (index + 1 > statuses.size() - 1) {
            index = 0;
        } else {
            index++;
        }
    }
}