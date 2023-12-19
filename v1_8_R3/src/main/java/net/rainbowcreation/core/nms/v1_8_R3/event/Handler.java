package net.rainbowcreation.core.nms.v1_8_R3.event;

import net.rainbowcreation.core.api.event.IEventHandler;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class Handler implements IEventHandler {
    @Override
    public void register(PluginManager manager, Plugin instance) {
        manager.registerEvents(new PlayerJoinEvent(), instance);
    }
}
