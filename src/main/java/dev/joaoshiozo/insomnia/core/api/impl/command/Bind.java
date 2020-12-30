package dev.joaoshiozo.insomnia.core.api.impl.command;

import dev.joaoshiozo.insomnia.InsomniaMod;
import dev.joaoshiozo.insomnia.core.api.command.Command;
import dev.joaoshiozo.insomnia.core.api.module.Module;
import dev.joaoshiozo.insomnia.core.api.util.LoggerUtil;
import org.lwjgl.input.Keyboard;

public class Bind extends Command
{
    public Bind(String name, String[] alias, String usage) {
        super(name, alias, usage);
    }

    @Override
    public void onTrigger(String arguments)
    {
        String[] split = arguments.split(" " );

        Module module = InsomniaMod.getModuleManager().getModule(split[0]);

        if (module != null)
        {
            try
            {
                module.setBind(Keyboard.getKeyIndex(split[1].toUpperCase()));
                LoggerUtil.sendMessage(String.format("Bound %s to %s", module.getName(), split[1].toUpperCase()));
                return;
            }
            catch (Exception ignored)
            {
            }
        }

        printUsage();
    }

    public void onRun(String arguments) {

    }

}