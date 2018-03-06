package core;

import commands.cmdPing;
import listeners.commandListener;
import listeners.readyListener;
import listeners.voiceListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
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
    }

    private static void loadListeners(){
        builder.addEventListener(new readyListener());
        builder.addEventListener(new voiceListener());
        builder.addEventListener(new commandListener());
    }

}