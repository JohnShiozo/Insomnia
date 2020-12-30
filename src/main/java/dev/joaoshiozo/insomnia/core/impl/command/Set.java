package dev.joaoshiozo.insomnia.core.impl.command;


import dev.joaoshiozo.insomnia.InsomniaMod;
import dev.joaoshiozo.insomnia.core.api.command.Command;
import dev.joaoshiozo.insomnia.core.api.module.Module;
import dev.joaoshiozo.insomnia.core.api.Setting.Setting;
import dev.joaoshiozo.insomnia.core.api.util.LoggerUtil;

public class Set extends Command
{
    public Set(String name, String[] alias, String usage)
    {
        super(name, alias, usage);
    }


    @Override
    public void onTrigger(String arguments)
    {
        String[] args = arguments.split(" ");

        for (Module module : InsomniaMod.moduleManager.getModules())
        {
            if (module.getName().equalsIgnoreCase(args[0]))
            {

                for (Setting setting : InsomniaMod.settingManager.getSettings())
                {
                    if (setting.getModule().equals(module) && args[1].equalsIgnoreCase(setting.getName()))
                    {

                        if (setting.isInteger() && (setting.getMinIntegerValue() - 1) < Integer.parseInt(args[2].toLowerCase()) && (setting.getMaxIntegerValue() + 1) > Integer.parseInt(args[2].toLowerCase()))
                        {
                            setting.setIntegerValue(Integer.parseInt(args[2].toLowerCase()));
                            LoggerUtil.sendMessage("Set " + setting.getName() + " to " + setting.getIntegerValue());
                            return;
                        }
                        else if (setting.isBoolean())
                        {
                            setting.setBooleanValue(args[2].equalsIgnoreCase("on") || args[2].equalsIgnoreCase("true"));
                            LoggerUtil.sendMessage("Set " + setting.getName() + " to " + setting.getBooleanValue());
                            return;
                        }
                        else if (setting.isEnum())
                        {
                            for (String string : setting.getEnumValues())
                            {
                                if (args[2].equalsIgnoreCase(string)) setting.setEnumValue(string);
                            }
                            LoggerUtil.sendMessage("Set " + setting.getName() + " to " + setting.getEnumValue());
                            return;
                        }
                    }
                }
            }
        }

        printUsage();
    }
    @Override
    public void onRun(String arguments) {

    }
}