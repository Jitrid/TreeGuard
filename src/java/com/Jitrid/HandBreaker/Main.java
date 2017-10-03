package com.Jitrid.HandBreaker;



import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {
	
		
	@SidedProxy(clientSide="com.Jitrid.HandBreaker.ClientProxy", serverSide="com.Jitrid.HandBreaker.ServerProxy")
	public static CommonProxy proxy;
	
    public static final String MODID = "TreeGuard";
    public static final String MODNAME = "Treeguard Mod";
    public static final String VERSION = "1.0.0";
        
    @Instance
    public static Main instance = new Main();
    
    
       	
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	proxy.preInit(e);
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent e) {
    	proxy.init(e);
    	MinecraftForge.EVENT_BUS.register(new EventHandlerCommon());
    }
        
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	proxy.postInit(e);       
    }
}