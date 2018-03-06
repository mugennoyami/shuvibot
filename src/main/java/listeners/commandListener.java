package listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;
import core.*;

/**
 *
 *  @author Dârkness
 *  @version 06.03.2018
 *
 */

public class commandListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getMessage().getContentRaw().startsWith(STATIC.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()){
            commandHandler.handleCommand(commandHandler.parse.parser(event.getMessage().getContentRaw(), event));
        }

    }

}
