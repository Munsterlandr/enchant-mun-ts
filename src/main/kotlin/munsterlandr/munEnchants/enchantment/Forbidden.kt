package munsterlandr.munEnchants.enchantment

import munsterlandr.munEnchants.MunEnchants
import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentTarget
import net.minecraft.entity.Entity
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.LivingEntity
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.minecraft.world.explosion.Explosion

class Forbidden: Enchantment(
    Rarity.UNCOMMON,
    EnchantmentTarget.VANISHABLE,
    arrayOf(EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND)
) {
    companion object {
        val ID = Identifier(MunEnchants.MOD_ID, "forbidden")
        fun register() {
            Registry.register(Registry.ENCHANTMENT, ID, Forbidden())
        }

        fun explode(user: LivingEntity?) {
            user?.world!!.createExplosion(user, user.x, user.y, user.z, 5.0.toFloat(), true, Explosion.DestructionType.DESTROY)
            user.health = 0.0.toFloat() // just in case
        }
    }

    override fun isCursed(): Boolean {
        return true
    }

    override fun isTreasure(): Boolean {
        return false
    }

    override fun getMaxLevel(): Int {
        return 1
    }

    override fun getMinLevel(): Int {
        return 1
    }

    override fun onTargetDamaged(user: LivingEntity?, target: Entity?, level: Int) {
        explode(user)
    }




}