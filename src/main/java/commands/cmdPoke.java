package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdPoke implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(args.length ==1) {

            switch (args[0]) {

                case "direct":
                    event.getTextChannel().sendMessage(":large_blue_diamond: This is a Direct Message :large_blue_diamond:").queue();
                    break;

                case "private":
                    event.getTextChannel().sendMessage(":large_orange_diamond: This is a Private Message :large_orange_diamond:").queue();
                    break;

                default:
                    event.getTextChannel().sendMessage(":warning: **WARNING** :warning:" +"\n:arrow_forward: "+ event.getAuthor().getAsMention() +", please use !poke <direct/private>" +"\n:warning: **WARNING** :warning:").queue();
            }
        }else if(args.length ==0){
            event.getTextChannel().sendMessage(":mega: This is the Default Message").queue();
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
