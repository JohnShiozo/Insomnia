package dev.joaoshiozo.insomnia.impl.module.Misc;

import dev.joaoshiozo.insomnia.api.discord.Discord;
import dev.joaoshiozo.insomnia.api.discord.RPCBuilder;
import dev.joaoshiozo.insomnia.api.module.Category;
import dev.joaoshiozo.insomnia.api.module.Module;

public class RPC extends Module {

    public RPC(String name, String description, Category category)
    {
        super(name, description, category);
    }

    public static Discord discordRPC = new RPCBuilder("768932827797913611").withDetails("Version 0.1.1a").withState("").withLargeImageKey("logo").withLargeImageText("Insomnia").build();

    @Override
    public void onEnable()
    {
        discordRPC.start();
    }

    @Override
    public void onDisable()
    {
        discordRPC.stop();
    }

}
