package core;

import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.util.Arrays;

public class permsCore {

    public static boolean check(MessageReceivedEvent event){

        for (Role r : event.getGuild().getMember(event.getAuthor()).getRoles()){

            if(Arrays.stream(STATIC.PERMS).parallel().anyMatch(r.getName()::contains))
                return false;
            else
                event.getTextChannel().sendMessage(":warning:  Sorry, "+event.getAuthor().getAsMention() + ", you don´t have the permissions to execute this command.").queue();

        }
        return true;
    }
}
