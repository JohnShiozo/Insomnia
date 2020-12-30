package dev.joaoshiozo.insomnia;

import dev.joaoshiozo.insomnia.mixin.InsomniaMixinLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(
        modid = InsomniaMod.MOD_ID,
        name = InsomniaMod.MOD_NAME,
        version = InsomniaMod.VERSION
)
public class InsomniaMod {
    public static final String MOD_ID = "InsomniaMod";
    public static final String MOD_NAME = "Insomnia";
    public static final String VERSION = "0.1.1";

    public static InsomniaMixinLoader loader;

    @Mod.Instance(MOD_ID)
    public static InsomniaMod INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        loader = new InsomniaMixinLoader();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
