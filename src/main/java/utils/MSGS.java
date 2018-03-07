package utils;

import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;

/**
 *
 *  @author Dârkness
 *  @version 07.03.2018
 *
 */

public class MSGS {

    public static EmbedBuilder success() {
        return new EmbedBuilder().setColor(Color.green);
    }

    public static EmbedBuilder error() {
        return new EmbedBuilder().setColor(Color.red);
    }

}