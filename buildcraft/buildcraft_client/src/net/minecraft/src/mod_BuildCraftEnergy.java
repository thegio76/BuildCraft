package net.minecraft.src;

import net.minecraft.src.mod_BuildCraftCore.EntityRenderIndex;
import net.minecraft.src.buildcraft.core.PacketIds;
import net.minecraft.src.buildcraft.core.Utils;
import net.minecraft.src.buildcraft.energy.GuiCombustionEngine;
import net.minecraft.src.buildcraft.energy.RenderEngine;
import net.minecraft.src.buildcraft.energy.TextureOilFX;
import net.minecraft.src.buildcraft.energy.TextureOilFlowFX;
import net.minecraft.src.buildcraft.energy.TileEngine;

public class mod_BuildCraftEnergy extends BaseModMp {

	public static mod_BuildCraftEnergy instance;
	
	public void ModsLoaded () {
		super.ModsLoaded();
		BuildCraftEnergy.ModsLoaded();	
		
		mod_BuildCraftCore.blockByEntityRenders.put(new EntityRenderIndex(
				BuildCraftEnergy.engineBlock, 0), new RenderEngine(
				"/net/minecraft/src/buildcraft/energy/gui/base_wood.png"));		
		mod_BuildCraftCore.blockByEntityRenders.put(new EntityRenderIndex(
				BuildCraftEnergy.engineBlock, 1), new RenderEngine(
				"/net/minecraft/src/buildcraft/energy/gui/base_stone.png"));
		mod_BuildCraftCore.blockByEntityRenders.put(new EntityRenderIndex(
				BuildCraftEnergy.engineBlock, 2), new RenderEngine(
				"/net/minecraft/src/buildcraft/energy/gui/base_iron.png"));
		
		ModLoader.getMinecraftInstance().renderEngine.registerTextureFX(new TextureOilFX());
		ModLoader.getMinecraftInstance().renderEngine.registerTextureFX(new TextureOilFlowFX());
		
		instance = this;
	}
	
	@Override
	public String Version() {
		return "1.6.6.4";
	}
	
	 public void HandlePacket(Packet230ModLoader packet) {
			switch (PacketIds.values()[packet.packetType]) {
			case EngineDescription:
				Utils.handleDescriptionPacket(packet);
			case EngineUpdate:
				Utils.handleUpdatePacket(packet);

			}		
		 }
		 
		public GuiScreen HandleGUI(int i) {		
			switch (PacketIds.values() [i]) {
			case EngineCombustionGUI: 
				return new GuiCombustionEngine(
						ModLoader.getMinecraftInstance().thePlayer.inventory,
						new TileEngine());
			default:
				return null;
			}
		}

}
