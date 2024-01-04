package net.rainbowcreation.core.event.player;

import net.rainbowcreation.core.Core;
import net.rainbowcreation.core.api.utils.Action;
import net.rainbowcreation.core.api.utils.VersionInfo;
import net.rainbowcreation.core.utils.PlayerUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Team;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Core.getInstance().playerlog.put(event.getPlayer(), true);
        Action.spawnFirework(player.getLocation());

        VersionInfo version = VersionInfo.parseVersion(PlayerUtils.getVersion(player));
        if (version != null) {
            if (version.getMajor() == 1) {
                String url = "v1_";
                int minor = version.getMinor();
                if (minor < 11) {
                    // download manually
                } else {
                    if (minor <= 12)
                        url += "11";
                    else if (minor <= 14)
                        url += "13";
                    else if (minor <= 16)
                        url += "15";
                    else
                        url += String.valueOf(minor);
                    player.setResourcePack("https://github.com/RainBowCreation/resourcepack/releases/latest/download/RainBowCreation_" + url + "_lite.zip");
                }
            }
        }
        if (player.hasPermission("rbc.glow")) {
            String team = "";
            if (player.hasPermission("rbc.glow.red")) {
                team = "red";
            } else if (player.hasPermission("rbc.glow.purple")) {
                team = "purple";
            } else if (player.hasPermission("rbc.glow.aqua")) {
                team = "aqua";
            } else if (player.hasPermission("rbc.glow.green")) {
                team = "green";
            }
            if (team.isEmpty())
                return;
            Team pteam = Core.getInstance().getPlugin().getServer().getScoreboardManager().getMainScoreboard().getTeam(team);
            if (pteam != null)
                pteam.addPlayer(player);
        }
    }
}
