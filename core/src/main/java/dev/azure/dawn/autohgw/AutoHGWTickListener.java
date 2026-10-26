package dev.azure.dawn.autohgw;

import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.input.KeyEvent;
import net.labymod.api.event.client.input.KeyEvent.State;

public class AutoHGWTickListener {

  private final AutoHGWAddon addon;

  public AutoHGWTickListener(AutoHGWAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onKeyPress(KeyEvent event) {
    if (event.state() != State.PRESS) {
      return;
    }

    AutoHGWConfiguration configuration = this.addon.configuration();
    if (!configuration.enabled().get()) {
      return;
    }

    // Do not send the hotkey while a menu or chat screen is open.
    if (this.addon.labyAPI().minecraft().minecraftWindow().isScreenOpened()) {
      return;
    }

    // Compare the configured key safely in case the setting is temporarily unset.
    if (configuration.hgwKey().get() == null
        || !configuration.hgwKey().get().equals(event.key())) {
      return;
    }

    if (this.addon.labyAPI().minecraft().chatExecutor() != null) {
      this.addon.labyAPI().minecraft().chatExecutor().chat("HGW");
    }
  }
}
