package net.rainbowcreation.core.v1_8_R3.utils;


import de.sportkanone123.clientdetector.spigot.packetevents.PacketEvents;
import org.bukkit.entity.Player;

public class PlayerUtils {
    public static String getVersion(Player player) {
        return PacketEvents.getAPI().getPlayerManager().getClientVersion(player).name().replace("V_", "v");
    }
}
