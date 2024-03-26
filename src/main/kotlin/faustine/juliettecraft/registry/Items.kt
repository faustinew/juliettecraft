package faustine.juliettecraft.registry

import faustine.juliettecraft.JulietteCraft
import xyz.xenondevs.nova.addon.registry.ItemRegistry
import xyz.xenondevs.nova.initialize.Init
import xyz.xenondevs.nova.initialize.InitStage

@Init(stage = InitStage.PRE_PACK)
object Items : ItemRegistry by JulietteCraft.registry {
    
    val RUBY = registerItem("ruby")
    
    val SUPER_DIRT = registerItem(Blocks.SUPER_DIRT)
    val JULIETTE_BLOCK = registerItem(Blocks.JULIETTE_BLOCK)
    val SNAKE_STATUE = registerItem(Blocks.SNAKE_STATUE)
}