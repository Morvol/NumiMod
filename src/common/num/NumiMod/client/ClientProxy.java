//Package info
package num.NumiMod.client;

//Forge and FML imports
import net.minecraftforge.client.MinecraftForgeClient;

//NumiMod imports
import num.NumiMod.common.CommonProxy;


public class ClientProxy extends CommonProxy{
	//Render things
	@Override
	public void registerRenderThings()
	{
		//Pre-loading the textures
		MinecraftForgeClient.preloadTexture(CommonProxy.ITEMS_PNG);
		MinecraftForgeClient.preloadTexture(CommonProxy.BLOCKS_PNG);
	}
}
