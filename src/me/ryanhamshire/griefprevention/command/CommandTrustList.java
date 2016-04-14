package me.ryanhamshire.griefprevention.command;

import me.ryanhamshire.griefprevention.GriefPrevention;
import me.ryanhamshire.griefprevention.Messages;
import me.ryanhamshire.griefprevention.claim.Claim;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;

public class CommandTrustList implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext ctx) {
        Player player;
        try {
            player = GriefPrevention.checkPlayer(src);
        } catch (CommandException e) {
            src.sendMessage(e.getText());
            return CommandResult.success();
        }
        Claim claim = GriefPrevention.instance.dataStore.getClaimAt(player.getLocation(), true, null);

        // if no claim here, error message
        if (claim == null) {
            try {
                throw new CommandException(GriefPrevention.getMessage(Messages.TrustListNoClaim));
            } catch (CommandException e) {
                src.sendMessage(e.getText());
                return CommandResult.success();
            }
        }

        // TODO
        // if no permission to manage permissions, error message
        /*String errorMessage = claim.allowGrantPermission(player);
        if (errorMessage != null) {
            try {
                throw new CommandException(Text.of(errorMessage));
            } catch (CommandException e) {
                src.sendMessage(e.getText());
                return CommandResult.success();
            }
        }

        GriefPrevention.sendMessage(player, TextMode.Info, Messages.TrustListHeader);

        Builder permissions = Text.builder(">").color(TextColors.GOLD);

        if (managers.size() > 0) {
            for (int i = 0; i < managers.size(); i++) {
                permissions.append(SPACE_TEXT, Text.of(GriefPrevention.instance.trustEntryToPlayerName(managers.get(i))));
            }
        }

        player.sendMessage(permissions.build());
        permissions = Text.builder(">").color(TextColors.YELLOW);

        if (builders.size() > 0) {
            for (int i = 0; i < builders.size(); i++) {
                permissions.append(SPACE_TEXT, Text.of(GriefPrevention.instance.trustEntryToPlayerName(builders.get(i))));
            }
        }

        player.sendMessage(permissions.build());
        permissions = Text.builder(">").color(TextColors.GREEN);

        if (containers.size() > 0) {
            for (int i = 0; i < containers.size(); i++) {
                permissions.append(SPACE_TEXT, Text.of(GriefPrevention.instance.trustEntryToPlayerName(containers.get(i))));
            }
        }

        player.sendMessage(permissions.build());
        permissions = Text.builder(">").color(TextColors.BLUE);

        if (accessors.size() > 0) {
            for (int i = 0; i < accessors.size(); i++) {
                permissions.append(SPACE_TEXT, Text.of(GriefPrevention.instance.trustEntryToPlayerName(accessors.get(i))));
            }
        }

        player.sendMessage(permissions.build());

        player.sendMessage(Text.of(
                Text.of(TextColors.GOLD, GriefPrevention.instance.dataStore.getMessage(Messages.Manage)), SPACE_TEXT,
                Text.of(TextColors.YELLOW, GriefPrevention.instance.dataStore.getMessage(Messages.Build)), SPACE_TEXT,
                Text.of(TextColors.GREEN, GriefPrevention.instance.dataStore.getMessage(Messages.Containers)), SPACE_TEXT,
                Text.of(TextColors.BLUE, GriefPrevention.instance.dataStore.getMessage(Messages.Access))));
        */
        return CommandResult.success();

    }
}
