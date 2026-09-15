package dev.azure.dawn.autohgw;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class AutoHGWAddon extends LabyAddon<AutoHGWConfiguration> {

  @Override
  protected void enable() {
    this.registerSettingCategory();
    this.registerListener(new AutoHGWTickListener(this));
    this.logger().info("AutoHGW enabled");
  }

  @Override
  protected Class<AutoHGWConfiguration> configurationClass() {
    return AutoHGWConfiguration.class;
  }
}
