package dev.joaoshiozo.insomnia;

import dev.joaoshiozo.insomnia.mixin.InsomniaMixinLoader;
import dev.joaoshiozo.insomnia.core.api.EventHandler;
import dev.joaoshiozo.insomnia.core.api.command.CommandManager;
import dev.joaoshiozo.insomnia.core.api.gui.clickgui.ClickGUI;
import dev.joaoshiozo.insomnia.core.api.manager.FriendManager;
import dev.joaoshiozo.insomnia.core.api.module.ModuleManager;
import dev.joaoshiozo.insomnia.core.api.Setting.SettingManager;
import dev.joaoshiozo.insomnia.core.api.util.font.CustomFontRenderer;
import dev.joaoshiozo.insomnia.core.api.manager.ConfigManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;
import java.io.IOException;

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
    public static ModuleManager moduleManager;
    public static SettingManager settingManager;
    public static CustomFontRenderer customFontRenderer;
    public static ClickGUI clickGUI;
    public static CommandManager commandManager;
    public static FriendManager friendManager;

    @Mod.Instance(MOD_ID)
    public static InsomniaMod INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        loader = new InsomniaMixinLoader();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) throws IOException {
        commandManager = new CommandManager();
        settingManager = new SettingManager();
        moduleManager = new ModuleManager();
        friendManager = new FriendManager();
        customFontRenderer = new CustomFontRenderer(new Font("Verdana", Font.PLAIN, 19), true, false);
        clickGUI = new ClickGUI();

        ConfigManager.loadConfig();

        Runtime.getRuntime().addShutdownHook(new ConfigManager());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
    public static ModuleManager getModuleManager()
    {
        return moduleManager;
    }
    public static FriendManager getFriendManager()
    {
        return friendManager;
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
