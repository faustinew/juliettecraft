package faustine.juliettecraft.registry

import faustine.juliettecraft.JulietteCraft
import org.bukkit.Material
import xyz.xenondevs.nova.addon.registry.BlockRegistry
import xyz.xenondevs.nova.initialize.Init
import xyz.xenondevs.nova.initialize.InitStage
import xyz.xenondevs.nova.item.options.BlockOptions
import xyz.xenondevs.nova.item.tool.VanillaToolCategories
import xyz.xenondevs.nova.item.tool.VanillaToolTiers
import xyz.xenondevs.nova.world.block.sound.SoundGroup

@Init(stage = InitStage.PRE_PACK)
object Blocks : BlockRegistry by JulietteCraft.registry {
    
    private val HARD_DIRT = BlockOptions(0.6, VanillaToolCategories.SHOVEL, VanillaToolTiers.STONE, false, SoundGroup.GRASS, Material.DIRT)
    private val HARD_STONE = BlockOptions(4.0, VanillaToolCategories.PICKAXE, VanillaToolTiers.IRON, true, SoundGroup.STONE, Material.PINK_CONCRETE_POWDER)
    
    val SUPER_DIRT = block("super_dirt").blockOptions(HARD_DIRT).register()
    val JULIETTE_BLOCK = block("juliette_block").blockOptions(HARD_STONE).register()
}