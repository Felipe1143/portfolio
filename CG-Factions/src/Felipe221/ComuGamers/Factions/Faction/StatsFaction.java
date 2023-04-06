package Felipe221.ComuGamers.Factions.Faction;

import com.massivecraft.factions.Faction;

public class StatsFaction {
	
	public enum StatType{
		KILLS, DEATHS, POWER, CLAIM, FOUNDER, ELO;
	}
	
	public int getStat(Faction faction, StatType type) {
		int stat = 0;
		
		if (type == StatType.CLAIM) {
			faction.getAllClaims().size();
		}

		if (type == StatType.CLAIM) {
			faction.getAllClaims().size();
		}
		
		return stat;		
	}
}
