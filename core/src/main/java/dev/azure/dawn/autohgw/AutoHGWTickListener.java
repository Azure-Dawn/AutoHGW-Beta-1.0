package dev.azure.dawn.autohgw;

import net.labymod.api.event.Phase;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.lifecycle.GameTickEvent;

public class AutoHGWTickListener {

  private final AutoHGWAddon addon;

  public AutoHGWTickListener(AutoHGWAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onGameTick(GameTickEvent event) {
    if (event.phase() != Phase.PRE || !this.addon.configuration().enabled().get()) {
      return;
    }

    // AutoHGW runtime logic belongs here.
  }
}
