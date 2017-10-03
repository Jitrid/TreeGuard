package com.Jitrid.HandBreaker;

import java.util.Arrays;
import java.util.List;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.init.Blocks;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.world.BlockEvent;
//import scala.actors.threadpool.Arrays;

public class EventHandlerCommon {
	@SubscribeEvent (priority = EventPriority.NORMAL)
    public void handleBlockDestruction(BlockEvent.BreakEvent event) {	
		
		
	EntityPlayer Player = event.getPlayer();
	
	Object Gebroken = Block.getIdFromBlock(event.world.getBlock(event.x,event.y, event.z));
	
	//ItemStack Item = new ItemStack(Items.golden_axe);
			
	Object[] Tools = {5254 , 4915, 5241, 5255, 6268, 5066, 5275, 5325, 5330, 6503, 6640, 4197, 6688, 4183, 6712, 6465};
	
	Object[] Hout = {17 , 162 , 751 , 757 , 620 , 656 , 5 , 1512 , 752 , 758 , 622, 1395 , 1396 , 1397 , 1398  };
	
	List<Object> Wood = Arrays.asList(Hout);
	List<Object> Bijl = Arrays.asList(Tools);
	
	
	if(Player.getCurrentEquippedItem() != null)
	{
			int Item = net.minecraft.item.Item.getIdFromItem(Player.getHeldItem().getItem());
			
			
	
		if(Wood.contains(Gebroken) && !Bijl.contains(Item)) {
			System.out.println(Item);
		event.setCanceled(true);
		Player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 9600 ,3));
		Player.addPotionEffect(new PotionEffect(Potion.weakness.id, 9600 ,3));
		Player.addChatMessage(new ChatComponentText("You broke your hand!"));
	
		
		}
	}
	else {
	
		if(Wood.contains(Gebroken)) {
		event.setCanceled(true);
		Player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 9600 ,3));
		Player.addPotionEffect(new PotionEffect(Potion.weakness.id, 9600 ,3));
		Player.addChatMessage(new ChatComponentText("You broke your hand!"));
	
	
}
	}
		}
			}
