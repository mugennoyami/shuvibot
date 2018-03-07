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
                    send(":large_blue_diamond: This is a Direct Message :large_blue_diamond:",event);
                    break;

                case "private":
                    send(":large_orange_diamond: This is a Private Message :large_orange_diamond:",event);
                    break;

                default:
                    send(":warning: **WARNING** :warning:" +"\n:arrow_forward: "+ event.getAuthor().getAsMention() +", please use !poke <direct/private>" +"\n:warning: **WARNING** :warning:",event);
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

    public void send(String msg, MessageReceivedEvent event){   event.getTextChannel().sendMessage(msg).queue();}

}
