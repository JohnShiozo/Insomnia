package dev.joaoshiozo.insomnia.core.impl.command;

import dev.joaoshiozo.insomnia.InsomniaMod;
import dev.joaoshiozo.insomnia.core.api.command.Command;
import dev.joaoshiozo.insomnia.core.api.util.LoggerUtil;

public class Help extends Command
{
    public Help(String name, String[] alias, String usage)
    {
        super(name, alias, usage);
    }

    @Override
    public void onTrigger(String arguments)
    {
        LoggerUtil.sendMessage("Insomnia 0.1.1");

        for (Command command : InsomniaMod.commandManager.getCommands())
        {
            LoggerUtil.sendMessage(command.getName() + " - " + command.getUsage());
        }
    }

    public void onRun(String arguments) {

    }

}