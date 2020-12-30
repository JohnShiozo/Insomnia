package dev.joaoshiozo.insomnia.core.impl.command;

import dev.joaoshiozo.insomnia.core.api.command.Command;
import dev.joaoshiozo.insomnia.core.api.util.LoggerUtil;
import dev.joaoshiozo.insomnia.core.api.util.SessionUtil;


public class Login extends Command {
    public Login(String name, String[] alias, String usage) {
        super(name, alias, usage);
    }

    @Override
    public void onTrigger(String arguments) {
        String[] split = arguments.split(" ");
        try {
            if (split[0].equals("") || split[1].equals("")) {
                printUsage();
                return;
            }
        } catch (Exception ignored) {
            printUsage();
            return;
        }

        if (SessionUtil.login(split[0], split[1])) {
            LoggerUtil.sendMessage("Logged in to " + SessionUtil.getSession().getUsername());
        } else {
            LoggerUtil.sendMessage("Failed to log in");
        }
    }

    public void onRun(String arguments) {

    }
}