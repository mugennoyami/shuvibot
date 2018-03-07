package core;

import commands.cmdClear;
import commands.cmdPing;
import commands.cmdPoke;
import listeners.commandListener;
import listeners.readyListener;
import listeners.voiceListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import util.SECRETS;

import javax.security.auth.login.LoginException;

/**
 *
 *  @author Dârkness
 *  @version 06.03.2018
 *
 */

public class Main {

    public static JDABuilder builder;

    public static JDA jda;

    public static void main(String[] Args){

        builder = new JDABuilder(AccountType.BOT)
            .setToken(SECRETS.TOKEN)
            .setAutoReconnect(true)
            .setStatus(OnlineStatus.ONLINE);

        builder.setGame(Game.of(Game.GameType.LISTENING,"the Dârkness"));


        loadCommands();
        loadListeners();

        try {
            jda = builder.buildBlocking();
        }catch (LoginException | InterruptedException e){
            e.printStackTrace();
        }

    }

    private static void loadCommands(){
        commandHandler.commands.put("ping", new cmdPing());
        commandHandler.commands.put("poke", new cmdPoke());
        commandHandler.commands.put("clear", new cmdClear());
    }

    private static void loadListeners(){
        builder.addEventListener(new readyListener());
        builder.addEventListener(new voiceListener());
        builder.addEventListener(new commandListener());
    }

}