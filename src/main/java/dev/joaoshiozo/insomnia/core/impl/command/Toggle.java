package dev.joaoshiozo.insomnia.core.impl.command;

import dev.joaoshiozo.insomnia.InsomniaMod;
import dev.joaoshiozo.insomnia.core.api.command.Command;
import dev.joaoshiozo.insomnia.core.api.module.Module;

public class Toggle extends Command
{
    public Toggle(String name, String[] alias, String usage)
    {
        super(name, alias, usage);
    }


    @Override
    public void onTrigger(String arguments)
    {

        Module m = InsomniaMod.moduleManager.getModule(arguments);
        if (m != null)
        {
            m.toggle();
            return;
        }

        printUsage();

    }

    @Override
    public void onRun(String arguments) {

    }
}