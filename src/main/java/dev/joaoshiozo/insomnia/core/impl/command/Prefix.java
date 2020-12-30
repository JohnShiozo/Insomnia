package dev.joaoshiozo.insomnia.core.impl.command;

import dev.joaoshiozo.insomnia.InsomniaMod;
import dev.joaoshiozo.insomnia.core.api.command.Command;
import dev.joaoshiozo.insomnia.core.api.util.LoggerUtil;

public class Prefix extends Command
{
    public Prefix(String name, String[] alias, String usage)
    {
        super(name, alias, usage);
    }

    @Override
    public void onTrigger(String arguments)
    {
        if (arguments.equals(""))
        {
            printUsage();
            return;
        }

        InsomniaMod.commandManager.setPrefix(arguments);
        LoggerUtil.sendMessage("Prefix set to " + arguments);
    }

    public void onRun(String arguments) {

    }
}