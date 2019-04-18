package novaguildspapi;

import co.marcin.novaguilds.api.basic.NovaPlayer;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import co.marcin.novaguilds.manager.PlayerManager;

public class NovaGuilds_Expansion_PAPI extends PlaceholderExpansion
{

	public NovaGuilds_Expansion_PAPI()
	{
	}

        @Override
	public String getAuthor()
	{
		return "Marcin Wieczorek";
	}

        @Override
	public String getIdentifier()
	{
		return "novaguilds";
	}

        @Override
	public String getPlugin()
	{
		return "NovaGuilds";
	}

        @Override
	public String getVersion()
	{
		return "40";
	}

        @Override
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
                    if (leader == null)
			return "";
                    else
			return String.valueOf(leader.getName());
		case "is_leader":
                    if (np.isLeader()==true) 
			return "♔";   
                    else
                        return "♙"; 
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
