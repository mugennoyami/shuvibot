package listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 *  @author Dârkness
 *  @version 06.03.2018
 *
 */

public class readyListener extends ListenerAdapter{

    public void onReady(ReadyEvent event){

        String out = "\nThis bot is running on following servers: \n";

        for (Guild g : event.getJDA().getGuilds()){
            out += g.getName() + " ("+ g.getId() + ") \n";
        }
        System.out.println(out);

        for (Guild g : event.getJDA().getGuilds()){
            g.getTextChannels().get(0).sendMessage(
                    ":cherry_blossom:Shuvi-chan is now ready to serve you:cherry_blossom:"
            ).queue();
        }
    }
}
