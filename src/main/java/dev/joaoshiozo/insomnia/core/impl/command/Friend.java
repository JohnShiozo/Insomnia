package dev.joaoshiozo.insomnia.core.impl.command;

import dev.joaoshiozo.insomnia.InsomniaMod;
import dev.joaoshiozo.insomnia.core.api.command.Command;
import dev.joaoshiozo.insomnia.core.api.util.FriendUtil;
import dev.joaoshiozo.insomnia.core.api.util.LoggerUtil;

public class Friend extends Command
{
    public Friend(String name, String[] alias, String usage)
    {
        super(name, alias, usage);
    }

    @Override
    public void onTrigger(String arguments) {
        super.onTrigger(arguments);
    }

    @Override
    public void onRun(String arguments) {

    }

    public void run(String arguments)
    {
        String[] split = arguments.split(" ");


        if (split[0].equalsIgnoreCase("add"))
        {
            if (InsomniaMod.friendManager.isFriend(split[1]))
            {
                LoggerUtil.sendMessage("User is already a friend");
            }
            else
            {
                InsomniaMod.friendManager.addFriend(split[1]);
                LoggerUtil.sendMessage("Added " + split[1]);
            }
            return;
        }
        if (split[0].equalsIgnoreCase("remove") || split[0].equalsIgnoreCase("del"))
        {
            if (InsomniaMod.friendManager.isFriend(split[1]))
            {
                InsomniaMod.friendManager.delFriend(split[1]);
                LoggerUtil.sendMessage("Removed " + split[1]);
            }
            else
            {
                LoggerUtil.sendMessage("User is not your friend");
            }
            return;
        }
        if (split[0].equalsIgnoreCase("list"))
        {
            if (InsomniaMod.friendManager.getFriends().size() == 0)
            {
                LoggerUtil.sendMessage("No friends");
                return;
            }
            for (FriendUtil friend : InsomniaMod.friendManager.getFriends())
            {
                LoggerUtil.sendMessage(friend.getName());
            }
            return;
        }

        printUsage();
    }
}