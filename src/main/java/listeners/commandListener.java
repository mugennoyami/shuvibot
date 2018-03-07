package listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import utils.STATIC;
import core.*;

import java.io.IOException;
import java.text.ParseException;

/**
 *
 *  @author Dârkness
 *  @version 06.03.2018
 *
 */

public class commandListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getMessage().getContentRaw().startsWith(STATIC.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()){
            try {
                commandHandler.handleCommand(commandHandler.parse.parser(event.getMessage().getContentRaw(), event));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

}
