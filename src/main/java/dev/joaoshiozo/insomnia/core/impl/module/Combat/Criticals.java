package dev.joaoshiozo.insomnia.core.impl.module.Combat;

import dev.joaoshiozo.insomnia.core.api.module.Category;
import dev.joaoshiozo.insomnia.core.api.module.Module;
import dev.joaoshiozo.insomnia.core.impl.event.PacketSendEvent;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Criticals extends Module
{
	public Criticals(String name, String description, Category category)
	{
		super(name, description, category);
	}

	@SubscribeEvent
	public void onPacketSend(PacketSendEvent event)
	{
        if (nullCheck()) return;

		if (event.getPacket() instanceof CPacketUseEntity && ((CPacketUseEntity) event.getPacket()).getAction() == CPacketUseEntity.Action.ATTACK && mc.player.onGround)
		{
			mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.1, mc.player.posZ, false));
			mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY, mc.player.posZ, false));
		}
	}
}