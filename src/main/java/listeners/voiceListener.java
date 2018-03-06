package listeners;

import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 *  @author Dârkness
 *  @version 06.03.2018
 *
 */

public class voiceListener extends ListenerAdapter{

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event){
        event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(
                "Member " + event.getVoiceState().getMember().getNickname() + " joined Voice Channel: " +event.getChannelJoined().getName() + "."
        ).queue();
    }
}
