package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import core.permsCore;

/**
 *
 *  @author Dârkness
 *  @version 06.03.2018
 *
 */

public class cmdPing implements Command{


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {

        //Stuff

        return false;
    }



    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(permsCore.check(event))
            return;

        event.getTextChannel().sendMessage("Pong!").queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        System.out.println("[INFO] Command '!ping' wurde ausgeführt!");
    }

    @Override
    public String help() {
        return null;
    }
}
