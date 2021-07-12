package me.splatboydev.bedwarsaddons;

import me.splatboydev.bedwarsaddons.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class BedwarsAddons {
	
	private static long startupTime;
	
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.Instance(Reference.MOD_NAME)
	public static BedwarsAddons instance;
	
	public static void preInit(FMLPreInitializationEvent e) {
		
		startupTime = System.currentTimeMillis();
		
	}
	
	public static void init(FMLInitializationEvent e) {
		
		System.out.println("Loading " + Reference.MOD_NAME + " v" + Reference.VERSION);
		
		proxy.registerRenders();
		
		int endTime = (int) (startupTime - System.currentTimeMillis());
		
		System.out.println("Startup took " + endTime);
		
	}

	public static void postInit(FMLPostInitializationEvent e) {
	
	}
	
}
