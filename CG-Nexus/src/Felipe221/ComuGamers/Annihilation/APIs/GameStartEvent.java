/*******************************************************************************
 * Copyright 2014 stuntguy3000 (Luke Anderson) and coasterman10.
 *  
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 ******************************************************************************/
package Felipe221.ComuGamers.Annihilation.APIs;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import Felipe221.ComuGamers.Annihilation.Maps.GameMap;

public class GameStartEvent extends Event {
    
    private static final HandlerList handlers = new HandlerList();

    private GameMap m;
    
    public GameStartEvent(GameMap m) {
        this.m = m;
    }
    
    public HandlerList getHandlers() {
        return handlers;
    }
    
    public static HandlerList getHandlerList() {
        return handlers;
    }

    public GameMap getMap() {
        return m;
    }
}
