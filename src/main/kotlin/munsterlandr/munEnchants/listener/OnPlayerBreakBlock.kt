package munsterlandr.munEnchants.listener

import munsterlandr.munEnchants.enchantment.Forbidden
import net.fabricmc.fabric.api.event.player.AttackBlockCallback
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion

object OnPlayerBreakBlock: AttackBlockCallback {
    override fun interact(
        player: PlayerEntity?,
        world: World?,
        hand: Hand?,
        pos: BlockPos?,
        direction: Direction?
    ): ActionResult {
        println(EnchantmentHelper.createNbt(Forbidden.ID, 1).asString())
        if (!player!!.isSpectator) {
            for (item in player!!.itemsHand) {
                //println(item)
                for (enchant in item.enchantments) {
                    println(enchant.asString())
                    if (enchant.asString() == EnchantmentHelper.createNbt(Forbidden.ID, 1).asString()) {
                        Forbidden.explode(player)
                    }
                }
            }
        }
        return ActionResult.PASS
    }

}