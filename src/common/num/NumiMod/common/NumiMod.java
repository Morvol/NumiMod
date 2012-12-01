//Package info
package num.NumiMod.common;

//Minecraft imports
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;

//Forge and FML imports
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

//NumiMod imports
import num.NumiMod.client.ClientProxy;


//Name, properities and version of the mod
@Mod(modid = "NumiMod", name = "NumiMod", version = "alpha 0.01")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class NumiMod {
		
	//Item definitions
	public static Item SquidMeat;
	public static Item SheepMeat;
	public static Item BoneWithMeat;	

    //Other definitions
	public static BlockMachine machineBlock;
	
	//Creative Tabs
	public static CreativeTabs tabNumiMod = new CreativeTabNumiMod(CreativeTabs.getNextID(), "NumiModTab");

	//Creating instance
	@Instance("NumiMod")
	public static NumiMod instance;

	//Server and Client sided proxy
	@SidedProxy(clientSide="num.NumiMod.client.ClientProxy", serverSide="num.NumiMod.common.CommonProxy")
	public static CommonProxy proxy;
	
	//Booting up the mod
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		//Config loading/creating
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		SquidMeatID = config.getItem("Squid Meat ID", config.CATEGORY_ITEM, 16000).getInt();
		SheepMeatID = config.getItem("Sheep Meat ID", config.CATEGORY_ITEM, 16001).getInt();
		BoneWithMeatID = config.getItem("Bone with Meat ID", config.CATEGORY_ITEM, 16002).getInt();
		MachineID = config.getBlock("Machine ID", config.CATEGORY_BLOCK, 200).getInt();
		config.save();
	}
	
	@Init
	public void init(FMLInitializationEvent event) {
		//Rendering
		proxy.registerRenderThings();
		
		//Items and Blocks properities
		SquidMeat = new ItemNewFood(SquidMeatID, 4, false).setIconIndex(0).setItemName("SquidMeat");
		SheepMeat = new ItemNewFood(SheepMeatID, 6, false).setIconIndex(1).setItemName("SheepMeat");
		BoneWithMeat = new Item(BoneWithMeatID) .setTextureFile(ClientProxy.ITEMS_PNG) .setIconIndex(2).setItemName("BoneWithMeat").setCreativeTab(tabNumiMod);		
		
		//Adding names to Items and Blocks
		LanguageRegistry.addName(SquidMeat, "Squid Meat");
		LanguageRegistry.addName(SheepMeat, "Sheep Meat");
		LanguageRegistry.addName(BoneWithMeat, "Bone with Meat");

		machineBlock = new BlockMachine(MachineID);
		GameRegistry.registerBlock(machineBlock, ItemMachine.class);
		for (MachineType type : MachineType.values()) {
			GameRegistry.registerTileEntity(type.clazz, type.name());
			LanguageRegistry.instance().addStringLocalization(type.name() + ".name", "en_US", type.friendlyName);
		}
}

	@PostInit
	public static void postInit(FMLPostInitializationEvent event) {
		
	}
	//Saving IDs
	public static int SquidMeatID;
	public static int SheepMeatID;
	public static int BoneWithMeatID;
	public static int MachineID;

}