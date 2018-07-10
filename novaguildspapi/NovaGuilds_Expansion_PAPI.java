// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   GTACops_Expansion_PAPI.java

package novaguildspapi;

import co.marcin.novaguilds.api.basic.NovaPlayer;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import co.marcin.novaguilds.api.storage.Resource;
import co.marcin.novaguilds.api.util.RegionSelection;
import co.marcin.novaguilds.enums.ChatMode;
import co.marcin.novaguilds.enums.GuildPermission;
import co.marcin.novaguilds.enums.RegionMode;
import co.marcin.novaguilds.manager.PlayerManager;

public class NovaGuilds_Expansion_PAPI extends PlaceholderExpansion
{

	public NovaGuilds_Expansion_PAPI()
	{
	}

	public String getAuthor()
	{
		return "Marcin Wieczorek";
	}

	public String getIdentifier()
	{
		return "novaguilds";
	}

	public String getPlugin()
	{
		return "NovaGuilds";
	}

	public String getVersion()
	{
		return "3.9";
	}

	public String onPlaceholderRequest(Player p, String identifier)
	{
		if (p == null)
			return "";
                NovaPlayer np = PlayerManager.getPlayer(p.getName());
                if (np.hasGuild()==false) 
                        return "";
		switch (identifier.toLowerCase())
		{
		case "guild":
                        return String.valueOf(np.getGuild().getName());
                    
		case "guild_rank":
			return String.valueOf(np.getGuildRank().getName());
		case "guild_leader":
                    Player leader = np.getGuild().getLeader().getPlayer();
			return String.valueOf(leader.getName());
		case "is_leader":
                    if (np.isLeader()==true) {
			return "♔";   
                    }
                    else
                    {
                        return "♙"; 
                    }
		case "point":
			return String.valueOf(np.getPoints());
		case "guild_point":
			return String.valueOf(np.getGuild().getPoints());
		case "guild_tag":
			return String.valueOf(np.getGuild().getTag());
		case "guild_live":
			return String.valueOf(np.getGuild().getLives());
		case "guild_money":
			return String.valueOf(np.getGuild().getMoney());
		}  
		return null;
	}
}
