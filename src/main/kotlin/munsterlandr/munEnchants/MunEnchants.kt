package munsterlandr.munEnchants

import munsterlandr.munEnchants.enchantment.Concealed
import munsterlandr.munEnchants.enchantment.Forbidden
import munsterlandr.munEnchants.listener.OnPlayerBreakBlock
import munsterlandr.munEnchants.listener.OnPlayerUseItem
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.player.AttackBlockCallback
import net.fabricmc.fabric.api.event.player.UseItemCallback

object MunEnchants : ModInitializer {
    val MOD_ID = "mun_enchants"


    override fun onInitialize() {
        Concealed.register()
        Forbidden.register()

        UseItemCallback.EVENT.register(OnPlayerUseItem)
        AttackBlockCallback.EVENT.register(OnPlayerBreakBlock)

    }
}