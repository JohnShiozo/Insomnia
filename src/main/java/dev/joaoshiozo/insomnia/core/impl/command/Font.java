package dev.joaoshiozo.insomnia.core.impl.command;

import dev.joaoshiozo.insomnia.InsomniaMod;
import dev.joaoshiozo.insomnia.core.api.command.Command;
import dev.joaoshiozo.insomnia.core.api.util.LoggerUtil;
import dev.joaoshiozo.insomnia.core.api.util.font.CustomFontRenderer;
import dev.joaoshiozo.insomnia.core.api.util.font.FontUtil;


public class Font extends Command
{
    public Font(String name, String[] alias, String usage)
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

        if (FontUtil.validateFont(arguments))
        {
            try
            {
                InsomniaMod.customFontRenderer = new CustomFontRenderer(new java.awt.Font(arguments, java.awt.Font.PLAIN, 19), true, false);
                LoggerUtil.sendMessage("New font set to " + arguments);
            }
            catch (Exception e)
            {
                LoggerUtil.sendMessage("Failed to set font");
            }
        }
        else
        {
            LoggerUtil.sendMessage("Invalid font");
        }
    }

    public void onRun(String arguments) {

    }
}